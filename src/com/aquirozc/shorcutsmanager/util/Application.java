package com.aquirozc.shorcutsmanager.util;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.plist.XMLPropertyListConfiguration;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.formats.icns.IcnsImageParser;
import org.apache.commons.imaging.formats.icns.IcnsImagingParameters;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;


public class Application {

    private boolean linkPolicy;
    private File applicationPackage;
    private String  fileName;
    private String  filePath;
    private ImageIcon [] applicationIcon;

    public Application(File appPkg){

        applicationPackage = appPkg;
        fileName = applicationPackage.getName();
        filePath = applicationPackage.getAbsolutePath();
        applicationIcon = new ImageIcon[5];
        linkPolicy = false;
        applicationIcon = generateApplicationIcon(findIconBundle());

    }


    private File findIconBundle() {

        File iconBundle = null;

        try {

            String iconBundleName;
            XMLPropertyListConfiguration plist= new XMLPropertyListConfiguration();
            plist.read(new BufferedReader(new FileReader(new File(applicationPackage,"Contents/Info.plist"))));
            iconBundleName = plist.getString("CFBundleIconFile");

            if (iconBundleName != null){
                
                if(!iconBundleName.endsWith(".icns")){
                    iconBundleName += ".icns";
                }
                
                iconBundle = new File(applicationPackage, "Contents/Resources/" + iconBundleName);
                
            }else {

                File resourcesFolder = new File(applicationPackage, "Contents/Resources/");
                File [] innerChilds = resourcesFolder.listFiles();
                
                for(File file : innerChilds){
                    if (file.isFile()){
                        if(file.getName().endsWith(".icns")){
                            iconBundle = file;
                            break;
                        }
                    }
                }
            }


        } catch (ConfigurationException | FileNotFoundException | NullPointerException e) {

        }

        return iconBundle;
    }

    public ImageIcon[] generateApplicationIcon(File file){

        File bundle = file;
        IcnsImageParser icnsParser = new IcnsImageParser();
        IcnsImagingParameters icnsParams = icnsParser.getDefaultParameters();
        BufferedImage maxRes = new BufferedImage(1,1,BufferedImage.TYPE_4BYTE_ABGR);
        ImageIcon [] iconPack = new ImageIcon[5];

        try{

            icnsParams.setBufferedImageFactory(new BufferedIcnsImageFactory());
            List <BufferedImage> bufferedImageList= icnsParser.getAllBufferedImages(bundle);

                for(BufferedImage image : bufferedImageList){

                    if(image.getHeight() >= maxRes.getHeight()){
                        if(!isBlank(image)){
                            maxRes = image;
                        }
                    }

                }


            iconPack[0] = new ImageIcon(resize(maxRes,64,64));
            iconPack[1] = new ImageIcon(resize(maxRes,72,72));
            iconPack[2] = new ImageIcon(resize(maxRes,88,88));
            iconPack[3] = new ImageIcon(resize(maxRes,111,111));
            iconPack[4] = new ImageIcon(resize(maxRes,135,135));

        }catch (ImageReadException | IOException |NullPointerException e){

        }

        return  iconPack;
    }

    public Boolean isBlank(BufferedImage bufferedImage){
        boolean isBlank = true;
        for (int i = 0; i < bufferedImage.getWidth() ;i++){

            for (int j = 0; j < bufferedImage.getHeight() ;j++){
                if (bufferedImage.getRGB(i,j) != 0){
                    isBlank = false;
                    break;
                }
            }
        }
        return isBlank;
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public ImageIcon getIconAt(int i){
        return applicationIcon[i];
    }

    public boolean getLinkPolicy(){
        return linkPolicy;
    }

    public void updateLinkPolicy(){

        linkPolicy = !linkPolicy;

    }
}
