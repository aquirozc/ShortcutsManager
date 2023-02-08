package com.aquirozc.shorcutsmanager.userinterface;

import com.aquirozc.shorcutsmanager.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeMenu extends JPanel {

    private GridBagConstraints layoutConstraints;

    private JLabel spanner;
    private JLabel sidebarBackground;

    private JLabel titleTagRegular;
    private JLabel titleTagLarge;
    private JLabel currentDirHeader;
    private JLabel currentDirLabel;
    private JLabel currentDirPath;
    private JLabel currentDirIcon;

    private JButton currentDirUpdateButton;
    private JButton zoomOut;
    private JButton zoomIn;

    private JButton createShorcuts;
    private JButton deleteShorcuts;
    private JButton selectAll;
    private JButton clearSelection;

    private ScrollableAppGrid appList;



    public HomeMenu(ActionListener listener, ScrollableAppGrid appGallery){

        layoutConstraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        titleTagRegular = new JLabel("Shorcuts");
        titleTagRegular.setFont(DesignPallete.FONT_TITLE_A);

        titleTagLarge = new JLabel("Manager");
        titleTagLarge.setFont(DesignPallete.FONT_TITLE_B);

        createShorcuts = new JButton("Create shorcuts for selected");
        createShorcuts.setFont(DesignPallete.FONT_BUTTON_A);
        createShorcuts.setPreferredSize(new Dimension(250,40));
        createShorcuts.setEnabled(false);

        deleteShorcuts = new JButton("Delete shorcuts for selected");
        deleteShorcuts.setFont(DesignPallete.FONT_BUTTON_A);
        deleteShorcuts.setPreferredSize(new Dimension(250,40));
        deleteShorcuts.setEnabled(false);
        
        sidebarBackground = new JLabel();

        currentDirHeader = new JLabel("Working directory");
        currentDirHeader.setFont(DesignPallete.FONT_HEADER_A);
        currentDirLabel = new JLabel();
        currentDirLabel.setFont(DesignPallete.FONT_HEADER_B);
        currentDirPath = new JLabel();
        currentDirPath.setFont(DesignPallete.FONT_PATH_A);
        currentDirUpdateButton = new JButton("Change");
        currentDirUpdateButton.setFont(DesignPallete.FONT_BUTTON_B);
        currentDirUpdateButton.setPreferredSize(new Dimension(75,35));
        currentDirUpdateButton.setActionCommand(Controller.PICK_NEW_DIR);
        currentDirUpdateButton.addActionListener(listener);

        currentDirIcon = new JLabel();
        currentDirIcon.setPreferredSize(new Dimension(75,75));
        currentDirIcon.setVisible(true);
        currentDirIcon.setOpaque(true);
        currentDirIcon.setBackground(DesignPallete.COLOR_DARK_TEXT_FOREGROUND_A);

        zoomOut = new JButton("-");
        zoomOut.setPreferredSize(new Dimension(35,35));
        zoomOut.setActionCommand(Controller.ZOOM_OUT);
        zoomOut.addActionListener(listener);
        zoomIn = new JButton("+");
        zoomIn.setPreferredSize(new Dimension(35,35));
        zoomIn.setActionCommand(Controller.ZOOM_IN);
        zoomIn.addActionListener(listener);

        appList = appGallery;
        appList.setPreferredSize(new Dimension(606,303));


        selectAll = new JButton("Select all");
        selectAll.setPreferredSize(new Dimension(75,35));
        selectAll.setFont(DesignPallete.FONT_BUTTON_B);
        selectAll.setActionCommand(Controller.SELECT_ALL);
        selectAll.addActionListener(listener);

        clearSelection = new JButton("Clear");
        clearSelection.setPreferredSize(new Dimension(75,35));
        clearSelection.setFont(DesignPallete.FONT_BUTTON_B);
        clearSelection.setActionCommand(Controller.CLEAR_SELECTION);
        clearSelection.addActionListener(listener);

        layoutConstraints.anchor = GridBagConstraints.LINE_START;

        spanner = new JLabel();
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weighty = 1;
        layoutConstraints.gridwidth = 3;
        add(spanner,layoutConstraints);
        normalizeLayoutConstraints();

        spanner = new JLabel();
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        layoutConstraints.weightx = 1;
        layoutConstraints.gridheight = 6;
        add(spanner,layoutConstraints);
        normalizeLayoutConstraints();

        spanner = new JLabel();
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 7;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weighty = 1;
        layoutConstraints.gridwidth = 3;
        add(spanner,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 1;
        add(titleTagRegular,layoutConstraints);

        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 2;
        layoutConstraints.gridheight = 2;
        layoutConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        add(titleTagLarge,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 5;
        layoutConstraints.anchor = GridBagConstraints.LAST_LINE_START;
        add(deleteShorcuts,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 6;
        add(createShorcuts,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.gridwidth = 3;
        layoutConstraints.gridheight = 8;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        add(sidebarBackground,layoutConstraints);
        normalizeLayoutConstraints();

        spanner = new JLabel();
        layoutConstraints.gridx = 2;
        layoutConstraints.gridy = 1;
        layoutConstraints.weightx = 1;
        layoutConstraints.gridheight = 6;
        add(spanner,layoutConstraints);
        normalizeLayoutConstraints();

        spanner = new JLabel();
        layoutConstraints.gridx = 3;
        layoutConstraints.gridy = 1;
        layoutConstraints.weightx = 1;
        layoutConstraints.gridheight = 6;
        add(spanner,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx = 4;
        layoutConstraints.gridy = 1;
        layoutConstraints.gridwidth = 3;
        add(currentDirHeader,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx = 4;
        layoutConstraints.gridy = 2;
        layoutConstraints.gridheight = 2;
        layoutConstraints.gridwidth =2;
        layoutConstraints.insets = new Insets(0,0,0,15);
        add(currentDirIcon,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx = 6;
        layoutConstraints.gridy = 2;
        add(currentDirLabel,layoutConstraints);

        layoutConstraints.gridx = 6;
        layoutConstraints.gridy = 3;
        add(currentDirPath,layoutConstraints);

        layoutConstraints.gridx = 4;
        layoutConstraints.gridy = 4;
        add(currentDirUpdateButton,layoutConstraints);
        normalizeLayoutConstraints();

        spanner = new JLabel();
        layoutConstraints.gridx= 7;
        layoutConstraints.gridy = 4;
        layoutConstraints.weightx = 1;
        add(spanner,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx= 8;
        layoutConstraints.gridy = 4;
        add(zoomOut,layoutConstraints);


        layoutConstraints.gridx= 9;
        layoutConstraints.gridy = 4;
        add(zoomIn,layoutConstraints);


        layoutConstraints.gridx = 4;
        layoutConstraints.gridy = 5;
        layoutConstraints.gridwidth = 6;
        layoutConstraints.weightx = 1;
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(appList,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx = 4;
        layoutConstraints.gridy = 6;
        layoutConstraints.gridwidth =2;
        add(selectAll,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx = 6;
        layoutConstraints.gridy = 6;
        add(clearSelection,layoutConstraints);

        spanner = new JLabel();
        layoutConstraints.gridx = 11;
        layoutConstraints.gridy = 1;
        layoutConstraints.weightx = 1;
        layoutConstraints.gridheight = 6;
        add(spanner,layoutConstraints);
        normalizeLayoutConstraints();

    }

    private void normalizeLayoutConstraints(){

        layoutConstraints.anchor = GridBagConstraints.LINE_START;
        layoutConstraints.insets = new Insets(0,0,0,0);
        layoutConstraints.fill = GridBagConstraints.NONE;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.gridheight = 1;
        layoutConstraints.weighty = 0;
        layoutConstraints.weightx = 0;

    }

    public void setButtonsEnabled(boolean val){
        createShorcuts.setEnabled(val);
        deleteShorcuts.setEnabled(val);
    }

    public void setCurrentDirLabel(String name){
        currentDirLabel.setText(name);
    }

    public void setCurrentDirPath(String path){
        currentDirPath.setText("File://" + path);
    }

    public void updateZoomInButtonStatus(boolean value){
        zoomIn.setEnabled(value);
    }

    public void updateZoomOutButtonStatus(boolean value){
        zoomOut.setEnabled(value);
    }


}
