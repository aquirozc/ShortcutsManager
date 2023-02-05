package com.aquirozc.shorcutsmanager.util;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.plist.XMLPropertyListConfiguration;

import javax.swing.ImageIcon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


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
        findIconBundle();
    }

    @SuppressWarnings("unchecked")
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

                File resourcesFolder = new File(applicationPackage, "Contents/Resources");
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

            System.out.println(applicationPackage.getName() + " : " + iconBundle.getName());

        } catch (ConfigurationException | FileNotFoundException | NullPointerException e) {

        }
        return null;
    }

    public ImageIcon getIconAt(int i){
        return applicationIcon[i];
    }

    public boolean getLinkPolicy(){
        return linkPolicy;
    }

    public void setLinkPolicy(Boolean val){
        linkPolicy = val;
    }
}
