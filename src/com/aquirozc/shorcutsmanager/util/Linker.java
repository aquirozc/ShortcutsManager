package com.aquirozc.shorcutsmanager.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Linker {

    private File workingDirectory;
    private ArrayList<Application> applicationIndex;
    private boolean[] willShorcutBeCreated;

    public Linker(File file){
        workingDirectory = file;
        applicationIndexer();
    }

    private void applicationIndexer(){

        applicationIndex = new ArrayList<Application>();

        File [] innerChilds = workingDirectory.listFiles();
        //Length may be zero
        Arrays.sort(innerChilds);

        for (int i = 0; i < innerChilds.length;i++){

            if(innerChilds[i].isDirectory()){
                String name = innerChilds[i].getName();
                if (name.endsWith(".app")){
                    applicationIndex.add(new Application(innerChilds[i]));
                }
            }

        }

    }

    public Application[] getApplicationIndex(){
        int listSize = applicationIndex.size();
        Application[] appIndex = new Application[listSize];
        for (int i = 0; i < listSize;i++){
            appIndex[i] = applicationIndex.get(i);
        }
        return appIndex;
    }

    public void clearSelection (){
        willShorcutBeCreated = new boolean[applicationIndex.size()];
        for (int i = 0; i < willShorcutBeCreated.length ; i++) {
            willShorcutBeCreated[i] = false;
        }
    }
}
