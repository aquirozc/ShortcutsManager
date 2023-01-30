package com.aquirozc.shorcutsmanager.controller;

import com.aquirozc.shorcutsmanager.userinterface.HomeMenu;
import com.aquirozc.shorcutsmanager.userinterface.ScrollableAppGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    public static String ZOOM_IN = "Zoom In";
    public static String ZOOM_OUT = "Zoom Out";

    private HomeMenu homeMenuPane;
    private JFrame homeMenuFrame;
    private ScrollableAppGrid appGallery;

    public Controller(){

        appGallery = new ScrollableAppGrid(this);
        
        homeMenuPane = new HomeMenu(this,appGallery);
        homeMenuFrame = new JFrame("iShorcutsManager 2023 (Under developement)");
        
        homeMenuFrame.setContentPane(homeMenuPane);
        homeMenuFrame.setMinimumSize(new Dimension(900,550));
        homeMenuFrame.setSize(1000,600);
        homeMenuFrame.setLocationRelativeTo(null);
        homeMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void onCreate(){
        homeMenuFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if (action == ZOOM_IN){

            int nextLevel = appGallery.getCurrentZoomLevel() + 1;

            if(nextLevel == appGallery.getTotalZoomLevels() -1 ){
                homeMenuPane.updateZoomInButtonStatus(false);
            }
            homeMenuPane.updateZoomOutButtonStatus(true);
            appGallery.updateZoomLevel(nextLevel);

        } else if (action == ZOOM_OUT) {

            int nextLevel = appGallery.getCurrentZoomLevel() - 1;
            if(nextLevel == 0){
                homeMenuPane.updateZoomOutButtonStatus(false);
            }
            homeMenuPane.updateZoomInButtonStatus(true);
            appGallery.updateZoomLevel(nextLevel);

        } else if (action == "ITEM") {

            JButton pressedButton = ((JButton) e.getSource());
            pressedButton.setBackground(Color.GREEN);

        }

    }
}
