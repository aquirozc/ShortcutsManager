package com.aquirozc.shorcutsmanager.util;

import java.io.IOException;

public class Linker {


    private String linkTaget = "/Applications/";

    public Linker(){

    }

    public void createShorcuts (Application application){

        if (application.getWillCreateSchorcutStatus()){

            try {
                ProcessBuilder linkProcess = new ProcessBuilder("/bin/zsh","-c", "ln -s \"" + application.getApplicationPackagePath() + "\" \"" + linkTaget + "\"");
                linkProcess.start();
                System.out.println("Done");

            } catch (IOException e){

            }
        }

    }

    public void deleteShorcuts (Application application){

        if (application.getWillCreateSchorcutStatus()){

            try {
                ProcessBuilder linkProcess = new ProcessBuilder("/bin/zsh","-c", "rm \"" + linkTaget + application.getApplicationPackageName() + "\"");
                linkProcess.start();
                System.out.println("Done");

            } catch (IOException e){

            }
        }

    }

}
