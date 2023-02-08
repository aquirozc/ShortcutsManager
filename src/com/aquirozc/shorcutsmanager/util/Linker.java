package com.aquirozc.shorcutsmanager.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Linker {

    private File workingDirectory;
    private ArrayList<Application> applicationIndex;
    private String linkTaget = "/Applications";

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

    public void createShorcut (Application application){

        if (application.getLinkPolicy()){

            try {
                ProcessBuilder linkProcess = new ProcessBuilder("/bin/zsh","-c", "ln -s \"" + application.getFilePath() + "\" \"" + linkTaget + "\"");
                linkProcess.start();
                System.out.println("Done");
            } catch (IOException e){

            }
        }

    }

}
