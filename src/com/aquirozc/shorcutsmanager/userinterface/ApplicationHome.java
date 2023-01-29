package com.aquirozc.shorcutsmanager.userinterface;

import javax.swing.*;
import java.awt.*;

public class ApplicationHome extends JPanel {

    private GridBagConstraints layoutConstraints;

    private JLabel spanner;
    private JLabel sidebarBackground;

    private JLabel titleTagRegular;
    private JLabel titleTagLarge;
    private JLabel currentDirHeader;
    private JLabel currentDirLabel;
    private JLabel currentDirPath;
    private JLabel currentDirIcon;

    private JButton zoomOut;
    private JButton zoomIn;

    private JButton createShorcuts;
    private JButton deleteShorcuts;
    private JButton selectAll;
    private JButton clearSelection;

    private JPanel appList;



    public ApplicationHome(){

        layoutConstraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        titleTagRegular = new JLabel("Shorcuts");
        titleTagRegular.setFont(DesignPallete.FONT_TITLE_A);

        titleTagLarge = new JLabel("Manager");
        titleTagLarge.setFont(DesignPallete.FONT_TITLE_B);

        createShorcuts = new JButton("Create shorcuts for selected");
        createShorcuts.setFont(DesignPallete.FONT_BUTTON_A);
        createShorcuts.setPreferredSize(new Dimension(250,40));

        deleteShorcuts = new JButton("Delete shorcuts for selected");
        deleteShorcuts.setFont(DesignPallete.FONT_BUTTON_A);
        deleteShorcuts.setPreferredSize(new Dimension(250,40));
        
        sidebarBackground = new JLabel();

        currentDirHeader = new JLabel("Working directory");
        currentDirHeader.setFont(DesignPallete.FONT_HEADER_A);
        currentDirLabel = new JLabel("MyApps");
        currentDirLabel.setFont(DesignPallete.FONT_HEADER_B);
        currentDirPath = new JLabel("File:///Volumes/Elements/MyApps");
        currentDirPath.setFont(DesignPallete.FONT_PATH_A);

        currentDirIcon = new JLabel();
        currentDirIcon.setPreferredSize(new Dimension(75,75));
        currentDirIcon.setVisible(true);
        currentDirIcon.setOpaque(true);
        currentDirIcon.setBackground(DesignPallete.COLOR_DARK_TEXT_FOREGROUND_A);

        zoomOut = new JButton("-");
        zoomOut.setPreferredSize(new Dimension(35,35));
        zoomIn = new JButton("+");
        zoomIn.setPreferredSize(new Dimension(35,35));

        appList = new JPanel();
        appList.setPreferredSize(new Dimension(606,303));
        appList.setBackground(DesignPallete.COLOR_DARK_COMPONENT_BACKGROUND_C);

        selectAll = new JButton("Select all");
        selectAll.setPreferredSize(new Dimension(75,35));
        selectAll.setFont(DesignPallete.FONT_BUTTON_B);

        clearSelection = new JButton("Clear");
        clearSelection.setPreferredSize(new Dimension(75,35));
        clearSelection.setFont(DesignPallete.FONT_BUTTON_B);

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

        spanner = new JLabel();
        spanner.setPreferredSize(new Dimension(222,35));
        layoutConstraints.gridx= 7;
        layoutConstraints.gridy = 4;
        add(spanner,layoutConstraints);

        layoutConstraints.gridx= 8;
        layoutConstraints.gridy = 4;
        add(zoomOut,layoutConstraints);

        layoutConstraints.gridx= 8;
        layoutConstraints.gridy = 4;
        layoutConstraints.anchor = GridBagConstraints.LINE_END;
        add(zoomIn,layoutConstraints);
        normalizeLayoutConstraints();

        layoutConstraints.gridx = 4;
        layoutConstraints.gridy = 5;
        layoutConstraints.gridwidth =5;
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
        layoutConstraints.gridx = 9;
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


}
