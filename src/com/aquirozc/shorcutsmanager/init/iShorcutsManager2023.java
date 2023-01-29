package com.aquirozc.shorcutsmanager.init;

import com.aquirozc.shorcutsmanager.userinterface.Home;

import javax.swing.*;

public class iShorcutsManager2023 {

    public static void main(String[] args) {

        Home home = new Home();
        JFrame testWindow = new JFrame("iShorcuts Manager 2023 (Under development)");
        testWindow.setContentPane(home);
        testWindow.setSize(1000,600);
        testWindow.setLocationRelativeTo(null);
        testWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testWindow.setVisible(true);

    }
}
