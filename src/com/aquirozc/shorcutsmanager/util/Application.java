package com.aquirozc.shorcutsmanager.util;

import java.io.File;
import javax.swing.ImageIcon;

public class Application {

    private boolean willCreateShortcutFlag;
    private ImageIcon [] applicationIconPack;
    private String applicationPackageName;
    private String applicationPackagePath;




    public Application(File applicationPackage){

        this.applicationPackagePath = applicationPackage.getAbsolutePath();
        this.applicationPackageName = applicationPackage.getName();
        this.applicationIconPack = new BufferedIcnsImageFactory().getIconPack(applicationPackage);
        this.willCreateShortcutFlag = false;

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
    public void setWillCreateShortcutFlag(boolean value){

        willCreateShortcutFlag = value;

    }
    public boolean willCreateShortcut(){

        return willCreateShortcutFlag;

    }

    public void toggleWillCreateShortcutFlag(){

        willCreateShortcutFlag = !willCreateShortcutFlag;

    }
}
