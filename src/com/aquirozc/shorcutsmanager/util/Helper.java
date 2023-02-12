package com.aquirozc.shorcutsmanager.util;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.plist.XMLPropertyListConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Helper {

    public Helper(){

    }

    public ArrayList <Application> getApplicationIndex(File workingDirectory){

        ArrayList <Application> applicationIndex = null;

        File [] files = workingDirectory.listFiles();

        if(files.length != 0){

            applicationIndex = new ArrayList<Application>();
            Arrays.sort(files);

            for (File file : files){

                if(file.isDirectory() & file.getName().endsWith(".app")){
                    applicationIndex.add(new Application(file));
                }

            }

        }

        return applicationIndex;

    }

    public File findIconBundleFile(File applicationPackage){

        File iconBundle = null;

        try {

            String iconBundleFileName;
            XMLPropertyListConfiguration plist= new XMLPropertyListConfiguration();
            plist.read(new BufferedReader(new FileReader(new File(applicationPackage,"Contents/Info.plist"))));
            iconBundleFileName = plist.getString("CFBundleIconFile");

            if (iconBundleFileName != null){

                if(!iconBundleFileName.endsWith(".icns")){
                    iconBundleFileName += ".icns";
                }

                iconBundle = new File(applicationPackage, "Contents/Resources/" + iconBundleFileName);

            }else {

                File resourcesFolder = new File(applicationPackage, "Contents/Resources/");
                File [] resourceFiles = resourcesFolder.listFiles();

                for(File file : resourceFiles){

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
}
