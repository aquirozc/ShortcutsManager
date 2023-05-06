package com.aquirozc.shortcutsmanager.userinterface;

import com.aquirozc.shortcutsmanager.init.ShortcutsManager;
import com.aquirozc.shortcutsmanager.util.BufferedIcnsImageFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


public class IncompatiblePlatformAlert extends JFrame {

    private GridBagConstraints layoutConstraints;
    private JLabel errorTittle;
    private JLabel errorMessage;
    private JLabel imageBanner;
    private JLabel osInfo;
    public IncompatiblePlatformAlert(){

        super("Operating system not supported");

        layoutConstraints = new GridBagConstraints();
        getContentPane().setBackground(DesignPallete.COLOR_DARK_BUTTON_BACKGROUND_B);
        getContentPane().setLayout(new GridBagLayout());

        errorTittle = new JLabel("Incompatible platform");
        errorTittle.setFont(DesignPallete.FONT_TITLE_B);
        errorTittle.setForeground(Color.WHITE);

        errorMessage = new JLabel("<html>Sorry this program is mean to be<br/>executed on devices running<br/>Mac OS X (10.7.5 or later). Please close<br/>the program.<br/><br/></html>");
        errorMessage.setFont(DesignPallete.FONT_HEADER_A);
        errorMessage.setForeground(Color.WHITE);

        osInfo = new JLabel("Your system is running " + System.getProperty("os.name") + " [" + System.getProperty("os.version")+"]");
        osInfo.setFont(DesignPallete.FONT_BUTTON_A);
        osInfo.setForeground(Color.WHITE);

        BufferedImage ogImage = null;

        try {
            ogImage = new BufferedIcnsImageFactory().getResizedBufferedImage(ImageIO.read(getClass().getClassLoader().getResource("SupportedPlatforms.png")),384,210);
        } catch (IOException e) {

            Logger.getLogger(ShortcutsManager.LOG_TAG).log(Level.SEVERE,"Failed to load image banner from resources folder");

        }

        imageBanner = new JLabel(new ImageIcon(ogImage));

        layoutConstraints.gridx = 0;
        layoutConstraints.anchor= GridBagConstraints.LINE_START;

        layoutConstraints.gridy = 0;
        getContentPane().add(errorTittle,layoutConstraints);

        layoutConstraints.gridy = 1;
        getContentPane().add(errorMessage,layoutConstraints);

        layoutConstraints.gridy = 2;
        getContentPane().add(osInfo,layoutConstraints);

        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 1;
        layoutConstraints.gridheight = 2;
        getContentPane().add(imageBanner,layoutConstraints);

    }

    public void displayAlert(){

        this.setSize(900,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
