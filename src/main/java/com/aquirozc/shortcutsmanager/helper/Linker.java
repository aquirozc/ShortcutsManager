package com.aquirozc.shortcutsmanager.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.aquirozc.shortcutsmanager.model.Application;

public class Linker {
	
	private static String target = "/Applications/";
	
	public static void createShortcut(Application application) {
		
		try {

            Path itemPath = Paths.get(application.getBundle().getAbsolutePath());
            Path targetPath = Paths.get(target + application.getBundle().getName());

            Files.createSymbolicLink(targetPath,itemPath);

        } catch (IOException e){
        	System.out.println("Oops");
        }
		
	}
	
	
	public static void deleteShortcut(Application application) {
		
		try {

            File link = new File(target + application.getBundle().getName());

            if(!link.exists()) {
            	throw new FileNotFoundException();
            }
            
            link.delete();


        } catch (SecurityException e){

            //Logger.getLogger(ShortcutsManager.LOG_TAG).log(Level.SEVERE,"Failed to delete existing shortcut on " + symLinkTarget +". Access denied.");

        } catch (FileNotFoundException e){

            //Logger.getLogger(ShortcutsManager.LOG_TAG).log(Level.SEVERE,"Failed to delete existing shortcut. Shortcut for " + applicationPackageName + " does not exist.");

        }
		
	}

}
