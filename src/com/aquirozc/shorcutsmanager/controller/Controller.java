package com.aquirozc.shorcutsmanager.controller;

import com.aquirozc.shorcutsmanager.userinterface.DesignPallete;
import com.aquirozc.shorcutsmanager.userinterface.HomeMenu;
import com.aquirozc.shorcutsmanager.userinterface.ScrollableAppGrid;
import com.aquirozc.shorcutsmanager.util.Application;
import com.aquirozc.shorcutsmanager.util.Helper;
import com.aquirozc.shorcutsmanager.util.Linker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Controller implements ActionListener {

    public static final String CLEAR_SELECTION = "Clear selection";
    public static final String CREATE_SHORTCUTS = "Create shortcuts for selected items";
    public static final String DELETE_SHORTCUTS = "Delete shortcuts for selected items";
    public static final String SELECT_ALL = "Select all entries";
    public static final String PICK_NEW_DIR = "Change working directory";
    public static final String ZOOM_IN = "Zoom In";
    public static final String ZOOM_OUT = "Zoom Out";

    private ArrayList<Application> applicationIndex;
    private int noSelectedItems;
    private HomeMenu homeMenuPane;
    private JFrame homeMenuFrame;
    private Linker linkManager;
    private ScrollableAppGrid itemGallery;


    public Controller(){

        itemGallery = new ScrollableAppGrid(this);
        noSelectedItems = 0;

        linkManager = new Linker();

        homeMenuPane = new HomeMenu(this, itemGallery);
        homeMenuFrame = new JFrame("Shortcuts Manager (Milestone 1)");
        
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

        String selectedAction = e.getActionCommand();

        switch (selectedAction){

            case CLEAR_SELECTION:

                itemGallery.updateAllItems(false, DesignPallete.COLOR_DARK_ITEM_UNCHECKED);
                noSelectedItems = 0;
                updateShortcutButtons();

            break;

            case CREATE_SHORTCUTS:

                for (Application applicationItem : applicationIndex){

                    linkManager.createShortcut(applicationItem);

                }

                actionPerformed(new ActionEvent(this,-1,CLEAR_SELECTION));

            break;

            case DELETE_SHORTCUTS:

                for (Application applicationItem : applicationIndex){

                    linkManager.deleteShortcut(applicationItem);

                }

                actionPerformed(new ActionEvent(this,-1,CLEAR_SELECTION));

            break;

            case SELECT_ALL:

                itemGallery.updateAllItems(true, DesignPallete.COLOR_DARK_ITEM_CHECKED);
                noSelectedItems = applicationIndex.size();
                updateShortcutButtons();

            break;

            case PICK_NEW_DIR:

                System.setProperty("apple.awt.fileDialogForDirectories", "true");

                FileDialog filePicker = new FileDialog(homeMenuFrame);
                filePicker.setVisible(true);

                if(filePicker.getFile() != null){

                    File workingDirectory = new File(filePicker.getDirectory() + filePicker.getFile());
                    homeMenuPane.setCurrentDirLabel(workingDirectory.getName());
                    homeMenuPane.setCurrentDirPath(workingDirectory.getPath());
                    applicationIndex = new Helper().getApplicationIndex(workingDirectory);

                    if (applicationIndex.size() != 0){
                        itemGallery.generateGrid(applicationIndex);
                        homeMenuPane.setAppGalleryButtonsEnabled(true);
                    }else {
                        itemGallery.showBlankPage();
                        homeMenuPane.setAppGalleryButtonsEnabled(false);
                    }
                }

                System.setProperty("apple.awt.fileDialogForDirectories", "false");

            break;

            case ZOOM_IN:

                int nextLevel = itemGallery.getCurrentZoomLevel() + 1;

                if(nextLevel == itemGallery.getMaximumZoomLevel()){
                    homeMenuPane.updateZoomInButtonStatus(false);
                }

                homeMenuPane.updateZoomOutButtonStatus(true);
                itemGallery.updateZoomLevel(nextLevel);

            break;

            case ZOOM_OUT:

                 int previousLevel = itemGallery.getCurrentZoomLevel() - 1;

                if(previousLevel == 0){
                    homeMenuPane.updateZoomOutButtonStatus(false);
                }
                homeMenuPane.updateZoomInButtonStatus(true);
                itemGallery.updateZoomLevel(previousLevel);

            break;

            default:

                if(selectedAction.startsWith("ITEM")){

                    int id = Integer.parseInt(selectedAction.substring(7));
                    JButton pressedButton = ((JButton) e.getSource());
                    Color bgColor;
                    if (applicationIndex.get(id).willCreateShortcut()){
                        bgColor =  DesignPallete.COLOR_DARK_ITEM_UNCHECKED;
                        noSelectedItems--;
                        updateShortcutButtons();
                    }else{
                        bgColor = DesignPallete.COLOR_DARK_ITEM_CHECKED;
                        noSelectedItems++;
                        updateShortcutButtons();
                    }

                    pressedButton.setBackground(bgColor);
                    applicationIndex.get(id).toggleWillCreateShortcutFlag();

                }


        }

    }

    private void updateShortcutButtons(){
        if (noSelectedItems != 0){
            homeMenuPane.setShorcutsButtonsEnabled(true);
        }else {
            homeMenuPane.setShorcutsButtonsEnabled(false);
        }
    }
}
