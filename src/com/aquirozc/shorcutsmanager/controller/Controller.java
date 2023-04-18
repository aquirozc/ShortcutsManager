package com.aquirozc.shorcutsmanager.controller;

import com.aquirozc.shorcutsmanager.userinterface.DesignPallete;
import com.aquirozc.shorcutsmanager.userinterface.HomeMenu;
import com.aquirozc.shorcutsmanager.userinterface.ProgramMenuBar;
import com.aquirozc.shorcutsmanager.userinterface.ScrollableAppGrid;
import com.aquirozc.shorcutsmanager.util.Application;
import com.aquirozc.shorcutsmanager.util.Helper;
import com.aquirozc.shorcutsmanager.util.Linker;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Controller implements ActionListener {

    public static final String CHECK_FOR_UPDATES = "Look for latest software updates";
    public static final String CLEAR_SELECTION = "Clear selection";
    public static final String CLOSE_CURRENT_DIR = "Close current working directory";
    public static final String CREATE_SHORTCUTS = "Create shortcuts for selected items";
    public static final String DELETE_SHORTCUTS = "Delete shortcuts for selected items";
    public static final String MAXIMIZE_MAIN_WINDOW = "Maximize main window";
    public static final String RESTORE_MAIN_WINDOW = "Restore main window";
    public static final String MINIMIZE_ALL_WINDOWS = "Minimize all active windows to dock";
    public static final String OPEN_EXT_APP_FOLDER = "Open current working directory in Finder";
    public static final String OPEN_ROOT_APP_FOLDER = "Open Applications folder in Finder";
    public static final String PICK_NEW_DIR = "Change working directory";
    public static final String RELOAD_APPLICATION_INDEX = "Look for recently added applications in the current working directory";
    public static final String SELECT_ALL = "Select all entries";
    public static final String SUBMIT_BUGREPORT = "Send feedback";
    public static final String ZOOM_IN = "Zoom In";
    public static final String ZOOM_OUT = "Zoom Out";

    private ArrayList<Application> applicationIndex;
    private int noSelectedItems;
    private File workingDirectory;
    private HomeMenu homeMenuPane;
    private JFrame homeMenuFrame;
    private Linker linkManager;
    private ProgramMenuBar menuBar;
    private ScrollableAppGrid itemGallery;


    public Controller(){

        itemGallery = new ScrollableAppGrid(this);
        noSelectedItems = 0;

        linkManager = new Linker();
        menuBar = new ProgramMenuBar(this);

        homeMenuPane = new HomeMenu(this, itemGallery);
        homeMenuFrame = new JFrame("Shortcuts Manager (Milestone 1)");
        homeMenuFrame.setJMenuBar(menuBar);

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

            case CHECK_FOR_UPDATES:

                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/aquirozc/ShortcutsManager/releases"));
                } catch (Exception ex){}

                break;

            case CLEAR_SELECTION:

                itemGallery.updateAllItems(false, DesignPallete.COLOR_DARK_ITEM_UNCHECKED);
                noSelectedItems = 0;
                updateShortcutButtons();

            break;

            case CLOSE_CURRENT_DIR:

                    updateWorkingDirectory(null);

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

            case MAXIMIZE_MAIN_WINDOW:

                homeMenuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            break;

            case MINIMIZE_ALL_WINDOWS:

                homeMenuFrame.setExtendedState(JFrame.ICONIFIED);

            break;

            case OPEN_EXT_APP_FOLDER:

                try{

                    new ProcessBuilder("/bin/zsh","-c","open " + workingDirectory.getPath()).start();

                }catch (Exception ex){}

            break;

            case OPEN_ROOT_APP_FOLDER:

                try{

                    new ProcessBuilder("/bin/zsh","-c","open /Applications").start();

                }catch (Exception ex){}

            break;

            case PICK_NEW_DIR:

                System.setProperty("apple.awt.fileDialogForDirectories", "true");

                FileDialog filePicker = new FileDialog(homeMenuFrame);
                filePicker.setVisible(true);

                if(filePicker.getFile() != null){

                    updateWorkingDirectory(new File(filePicker.getDirectory() + filePicker.getFile()));

                }

                System.setProperty("apple.awt.fileDialogForDirectories", "false");

            break;

            case RELOAD_APPLICATION_INDEX:

                updateWorkingDirectory(workingDirectory);

            break;

            case RESTORE_MAIN_WINDOW:

                homeMenuFrame.setExtendedState(JFrame.NORMAL);

            break;

            case SELECT_ALL:

                itemGallery.updateAllItems(true, DesignPallete.COLOR_DARK_ITEM_CHECKED);
                noSelectedItems = applicationIndex.size();
                updateShortcutButtons();

            break;

            case SUBMIT_BUGREPORT:

                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/aquirozc/ShortcutsManager/issues"));
                } catch (Exception ex){}

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

    private void updateWorkingDirectory(File file){

        workingDirectory = file;

        if(workingDirectory == null){

            menuBar.updateFileMenuItems(false);

            homeMenuPane.setCurrentDirLabel("");
            homeMenuPane.setCurrentDirPath("");
            applicationIndex = null;

            itemGallery.showBlankPage();
            homeMenuPane.setAppGalleryButtonsEnabled(false);
            return;

        }

        menuBar.updateFileMenuItems(true);

        homeMenuPane.setCurrentDirLabel(workingDirectory.getName());
        homeMenuPane.setCurrentDirPath("File:/" + workingDirectory.getPath());
        applicationIndex = new Helper().getApplicationIndex(workingDirectory);

        if (applicationIndex.isEmpty()){
            itemGallery.showBlankPage();
            homeMenuPane.setAppGalleryButtonsEnabled(false);
            return;
        }

        itemGallery.generateGrid(applicationIndex);
        homeMenuPane.setAppGalleryButtonsEnabled(true);



    }
}
