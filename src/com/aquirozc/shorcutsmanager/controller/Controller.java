package com.aquirozc.shorcutsmanager.controller;

import com.aquirozc.shorcutsmanager.userinterface.HomeMenu;
import com.aquirozc.shorcutsmanager.userinterface.ScrollableAppGrid;
import com.aquirozc.shorcutsmanager.util.Application;
import com.aquirozc.shorcutsmanager.util.Linker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Controller implements ActionListener {

    public static String ZOOM_IN = "Zoom In";
    public static String ZOOM_OUT = "Zoom Out";
    public static String PICK_NEW_DIR = "Change working directory";
    public static String CLEAR_SELECTION = "Clear selection";
    public static String SELECT_ALL = "Select all";

    private Application[] applicationIndex;
    private int noSelectedItems;
    private HomeMenu homeMenuPane;
    private JFrame homeMenuFrame;
    private Linker linkManager;
    private ScrollableAppGrid appGallery;


    public Controller(){

        appGallery = new ScrollableAppGrid(this);
        noSelectedItems = 0;

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

    private void updateButtons(){
        if (noSelectedItems != 0){
            homeMenuPane.setButtonsEnabled(true);
        }else {
            homeMenuPane.setButtonsEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if(action == PICK_NEW_DIR){

            System.setProperty("apple.awt.fileDialogForDirectories", "true");
            FileDialog filePicker = new FileDialog(homeMenuFrame);
            filePicker.setVisible(true);

            String fullPath = filePicker.getDirectory() + filePicker.getFile();

            homeMenuPane.setCurrentDirLabel(filePicker.getFile());
            homeMenuPane.setCurrentDirPath(fullPath);
            linkManager = new Linker(new File(fullPath));

            applicationIndex = linkManager.getApplicationIndex();
            appGallery.generateGrid(applicationIndex);


        }else if (action == ZOOM_IN){

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

        } else if (action.startsWith("ITEM")) {

            int id = Integer.parseInt(action.substring(7));
            JButton pressedButton = ((JButton) e.getSource());
            Color bgColor;
            if (applicationIndex[id].getLinkPolicy()){
                bgColor =  new Color(96,96,96);
                noSelectedItems--;
                updateButtons();
            }else{
                bgColor = new Color(124,201,231);
                noSelectedItems++;
                updateButtons();
            }

            pressedButton.setBackground(bgColor);
            applicationIndex[id].updateLinkPolicy();

        } else if (action == SELECT_ALL) {

            for (JButton button : appGallery.getApplicationItem()) {
                button.setBackground(new Color(124,201,231));
                applicationIndex[Integer.parseInt(button.getActionCommand().substring(7))].setLinkPolicy(true);
            }
            noSelectedItems = applicationIndex.length;
            updateButtons();

        } else if (action == CLEAR_SELECTION){
            for (JButton button : appGallery.getApplicationItem()) {
                button.setBackground(new Color(96,96,96));
                applicationIndex[Integer.parseInt(button.getActionCommand().substring(7))].setLinkPolicy(false);
            }
            noSelectedItems = 0;
            updateButtons();
        }

    }
}
