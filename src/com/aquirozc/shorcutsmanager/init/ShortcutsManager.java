package com.aquirozc.shorcutsmanager.init;

import com.aquirozc.shorcutsmanager.controller.Controller;

public class ShortcutsManager {

    public static final String LOG_TAG = "com.aquirozc.shortcutsmanager";
    public static void main(String[] args) {

        System.setProperty( "apple.awt.application.appearance", "system" );
        Controller controller = new Controller();
        controller.onCreate();
    }
}
