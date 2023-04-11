package com.aquirozc.shorcutsmanager.util;

import com.aquirozc.shorcutsmanager.init.ShortcutsManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Linker {


    private String symLinkTarget = "/Applications/";

    public Linker(){
        super();
    }

    public void createShortcut (Application application){

        String applicationPackageName = application.getApplicationPackageName();

        if (application.willCreateShortcut()){

            try {

                Path itemPath = Paths.get(application.getApplicationPackagePath());
                Path targetPath = Paths.get(symLinkTarget + applicationPackageName);

                Files.createSymbolicLink(targetPath,itemPath);

            } catch (IOException e){

                Logger.getLogger(ShortcutsManager.LOG_TAG).log(Level.SEVERE,"Failed to create shortcut for " + applicationPackageName + " on " + symLinkTarget);

            }
        }

    }

    public void deleteShortcut(Application application){

        String applicationPackageName = application.getApplicationPackageName();

        if (application.willCreateShortcut()){

            try {

                File link = new File(symLinkTarget + application.getApplicationPackageName());

                if(link.exists()){

                    link.delete();

                }else{

                    throw new FileNotFoundException();

                }


            } catch (SecurityException e){

                Logger.getLogger(ShortcutsManager.LOG_TAG).log(Level.SEVERE,"Failed to delete existing shortcut on " + symLinkTarget +". Access denied.");

            } catch (FileNotFoundException e){

                Logger.getLogger(ShortcutsManager.LOG_TAG).log(Level.SEVERE,"Failed to delete existing shortcut. Shortcut for " + applicationPackageName + " does not exist.");

            }
        }

    }

}
