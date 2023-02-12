package com.aquirozc.shorcutsmanager.util;

import java.io.File;
import javax.swing.ImageIcon;

public class Application {

    private boolean willCreateShorcut;
    private File applicationPackage;
    private ImageIcon [] applicationIconPack;
    private String applicationPackageName;
    private String applicationPackagePath;




    public Application(File applicationPackage){

        BufferedIcnsImageFactory icnsFactory = new BufferedIcnsImageFactory();
        Helper applicationHelper = new Helper();

        this.applicationPackage = applicationPackage;
        this.applicationPackagePath = applicationPackage.getAbsolutePath();
        this.applicationPackageName = applicationPackage.getName();
        this.applicationIconPack = icnsFactory.getIconPack(applicationHelper.findIconBundleFile(applicationPackage));
        this.willCreateShorcut = false;

    }

    public ImageIcon[] getApplicationIconPack() {
        return applicationIconPack;
    }
    public String getApplicationPackageName(){
        return applicationPackageName;
    }
    public String getApplicationPackagePath(){
        return applicationPackagePath;
    }
    public ImageIcon getIconAt(int i){
        return applicationIconPack[i];
    }
    public void setWillCreateShorcutStatus(boolean value){
        willCreateShorcut = value;
    }
    public boolean getWillCreateSchorcutStatus(){
        return willCreateShorcut;
    }

    public void updateWillCreateSchorcutStatus(){
        willCreateShorcut = !willCreateShorcut;
    }
}
