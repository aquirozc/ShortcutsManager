package com.aquirozc.shorcutsmanager.init;

import com.aquirozc.shorcutsmanager.controller.Controller;
import com.aquirozc.shorcutsmanager.userinterface.HomeMenu;

import javax.swing.*;
import java.awt.*;

public class iShorcutsManager2023 {

    public static void main(String[] args) {

        System.setProperty( "apple.awt.application.appearance", "system" );
        Controller controller = new Controller();
        controller.onCreate();
    }
}
