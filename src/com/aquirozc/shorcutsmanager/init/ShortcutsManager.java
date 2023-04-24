package com.aquirozc.shorcutsmanager.init;

import com.aquirozc.shorcutsmanager.controller.Controller;
import com.aquirozc.shorcutsmanager.userinterface.IncompatiblePlatformAlert;

public class ShortcutsManager {

    public static final String LOG_TAG = "com.aquirozc.shortcutsmanager";
    public static void main(String[] args) {

        if(!System.getProperty("os.name").startsWith("Mac OS X")){
            new IncompatiblePlatformAlert().displayAlert();
            return;
        }

        System.setProperty( "apple.awt.application.appearance", "system" );
        System.setProperty( "apple.laf.useScreenMenuBar", "true" );
        System.setProperty("apple.awt.application.name", "Shortcuts Manager Alpha");

        Controller controller = new Controller();
        controller.onCreate();
    }
}
