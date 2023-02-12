package com.aquirozc.shorcutsmanager.controller;

import com.aquirozc.shorcutsmanager.userinterface.HomeMenu;
import com.aquirozc.shorcutsmanager.userinterface.ScrollableAppGrid;
import com.aquirozc.shorcutsmanager.util.Application;
import com.aquirozc.shorcutsmanager.util.Helper;
import com.aquirozc.shorcutsmanager.util.Linker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Controller implements ActionListener {

    public static final String ZOOM_IN = "Zoom In";
    public static final String ZOOM_OUT = "Zoom Out";
    public static final String PICK_NEW_DIR = "Change working directory";
    public static final String CLEAR_SELECTION = "Clear selection";
    public static final String SELECT_ALL = "Select all";
    public static final String CREATE_SHOCUTS = "Create shorcuts for selected items";
    public static final String DELETE_SHORCUTS = "Delete shorcuts for selected items";

    private ArrayList<Application> applicationIndex;
    private int noSelectedItems;
    private HomeMenu homeMenuPane;
    private JFrame homeMenuFrame;
    private Linker linkManager;
    private ScrollableAppGrid appGallery;


    public Controller(){

        appGallery = new ScrollableAppGrid(this);
        noSelectedItems = 0;

        linkManager = new Linker();

        homeMenuPane = new HomeMenu(this,appGallery);
        homeMenuFrame = new JFrame("iShorcutsManager 2023 Preview (com.aquiroz.shorcutsmanager)");
        
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

        if(action == PICK_NEW_DIR){

            System.setProperty("apple.awt.fileDialogForDirectories", "true");

            FileDialog filePicker = new FileDialog(homeMenuFrame);
            filePicker.setVisible(true);

            if(filePicker.getFile() != null){
                File workingDirectory = new File(filePicker.getDirectory() + filePicker.getFile());
                homeMenuPane.setCurrentDirLabel(workingDirectory.getName());
                homeMenuPane.setCurrentDirPath(workingDirectory.getPath());
                applicationIndex = new Helper().getApplicationIndex(workingDirectory);
                if (applicationIndex.size() != 0){
                    appGallery.generateGrid(applicationIndex);
                    homeMenuPane.setAppGalleryButtonsEnabled(true);
                }else {
                    appGallery.showBlankPage();
                    homeMenuPane.setAppGalleryButtonsEnabled(false);
                }
            }else{
                System.out.println("Oops");
            }

            System.setProperty("apple.awt.fileDialogForDirectories", "false");


        }else if (action == ZOOM_IN){

            int nextLevel = appGallery.getCurrentZoomLevel() + 1;

            if(nextLevel == appGallery.getMaximumZoomLevel()){
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
            if (applicationIndex.get(id).getWillCreateSchorcutStatus()){
                bgColor =  new Color(96,96,96);
                noSelectedItems--;
                updateShorcutButtons();
            }else{
                bgColor = new Color(124,201,231);
                noSelectedItems++;
                updateShorcutButtons();
            }

            pressedButton.setBackground(bgColor);
            applicationIndex.get(id).updateWillCreateSchorcutStatus();

        } else if (action == SELECT_ALL) {

            updateAllApplicationItems(true,applicationIndex.size(),new Color(124,201,231));

        } else if (action == CLEAR_SELECTION){

            updateAllApplicationItems(false,0,new Color(96,96,96));

        } else if (action == CREATE_SHOCUTS) {

            for (Application application : applicationIndex){
                linkManager.createShorcuts(application);
            }

            updateAllApplicationItems(false,0,new Color(96,96,96));

        } else if (action == DELETE_SHORCUTS){

            for (Application application : applicationIndex){
                linkManager.deleteShorcuts(application);
            }

            updateAllApplicationItems(false,0,new Color(96,96,96));

        }

    }

    private void updateAllApplicationItems(boolean value, int length, Color bgColor){

        for (JButton button : appGallery.getApplicationItem() ){

            int index = Integer.parseInt(button.getActionCommand().substring(7));
            button.setBackground(bgColor);
            applicationIndex.get(index).setWillCreateShorcutStatus(value);
            noSelectedItems = length;

        }
        updateShorcutButtons();
    }

    private void updateShorcutButtons(){
        if (noSelectedItems != 0){
            homeMenuPane.setShorcutsButtonsEnabled(true);
        }else {
            homeMenuPane.setShorcutsButtonsEnabled(false);
        }
    }
}
