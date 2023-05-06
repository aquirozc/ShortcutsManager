package com.aquirozc.shortcutsmanager.userinterface;

import java.awt.*;
import javax.swing.*;


public class IncompatiblePlatformAlert extends JFrame {

    private GridBagConstraints layoutConstraints;
    private JLabel errorTittle;
    private JLabel errorMessage;
    private JLabel osInfo;
    public IncompatiblePlatformAlert(){

        super("Operating system not soported");

        layoutConstraints = new GridBagConstraints();

        errorTittle = new JLabel("Incompatible platform");
        errorTittle.setFont(DesignPallete.FONT_TITLE_B);
        errorTittle.setForeground(Color.WHITE);

        errorMessage = new JLabel("<html>Sorry this program is mean to be<br/>executed on devices running<br/>Mac OS X (10.7.5 or later). Please close<br/>the program.<br/><br/></html>");
        errorMessage.setFont(DesignPallete.FONT_HEADER_A);
        errorMessage.setForeground(Color.WHITE);

        osInfo = new JLabel("Your system is running " + System.getProperty("os.name") + " [" + System.getProperty("os.version")+"]");
        osInfo.setFont(DesignPallete.FONT_BUTTON_A);
        osInfo.setForeground(Color.WHITE);

        getContentPane().setBackground(DesignPallete.COLOR_DARK_BUTTON_BACKGROUND_B);
        getContentPane().setLayout(new GridBagLayout());

        layoutConstraints.gridx = 0;
        layoutConstraints.anchor= GridBagConstraints.LINE_START;

        layoutConstraints.gridy = 0;
        getContentPane().add(errorTittle,layoutConstraints);

        layoutConstraints.gridy = 1;
        getContentPane().add(errorMessage,layoutConstraints);

        layoutConstraints.gridy = 2;
        getContentPane().add(osInfo,layoutConstraints);

    }

    public void displayAlert(){

        this.setSize(550,450);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }


}
