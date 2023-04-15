package com.aquirozc.shorcutsmanager.util;

import com.aquirozc.shorcutsmanager.init.ShortcutsManager;
import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListFormatException;
import com.dd.plist.PropertyListParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {

    public Helper(){
        super();
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

        try{

            File file = new File(applicationPackage,"Contents/Info.plist");
            NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(file);
            String iconBundleFileName = rootDict.objectForKey("CFBundleIconFile").toString();

            if (!iconBundleFileName.endsWith(".icns")) iconBundleFileName += ".icns";

            iconBundle = new File(applicationPackage, "Contents/Resources/" + iconBundleFileName);


        }catch (IOException | PropertyListFormatException | ParseException | ParserConfigurationException | SAXException e){

            Logger.getLogger(ShortcutsManager.LOG_TAG).log(Level.SEVERE,"Failed to parse Info.plist from "  + applicationPackage.getName() + " package. Could not locale CFBundleIconFile");

        }

        return iconBundle;

    }

}
