package com.aquirozc.shorcutsmanager.userinterface;

import com.aquirozc.shorcutsmanager.util.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ScrollableAppGrid extends JScrollPane {

    private ActionListener buttonListener;
    private Application[] applicationIndex;
    private int currentZoomLevel;
    private int[] cellDimensions;
    private int[] cellInsets;
    private int individualItemSize;
    private int totalItems;
    private GridLayout viewportContentLayout;
    private JButton[] applicationItem;
    private JPanel viewportContent;
    private JPanel viewportTopLayout;


    public ScrollableAppGrid(ActionListener listener){

        this.buttonListener = listener;
        this.getViewport().setBackground(new Color(212,212,212));
        this.setBorder(BorderFactory.createLineBorder(new Color(200,200,200),1));

        cellDimensions = new int[5];
        cellDimensions[0] = 70;
        cellDimensions[1] = 82;
        cellDimensions[2] = 100;
        cellDimensions[3] = 125;
        cellDimensions[4] = 165;

        cellInsets = new int[cellDimensions.length];
        cellInsets[0] = 8;
        cellInsets[1] = 10;
        cellInsets[2] = 12;
        cellInsets[3] = 14;
        cellInsets[4] = 18;

    }

    public void generateGrid(Application [] index){

        currentZoomLevel = 2;

        applicationIndex = index;
        totalItems = applicationIndex.length;


        for (int i = 0; i < totalItems; i++){

            applicationItem[i] = new JButton(applicationIndex[i].getIconAt(currentZoomLevel));
            applicationItem[i].setPreferredSize(new Dimension(individualItemSize,individualItemSize));
            applicationItem[i].setBorderPainted(false);
            applicationItem[i].setFocusPainted(false);
            applicationItem[i].setBorder(BorderFactory.createEmptyBorder());
            applicationItem[i].setOpaque(true);
            applicationItem[i].setBackground(new Color(96,96,96));
            applicationItem[i].setActionCommand("ITEM");
            applicationItem[i].addActionListener(buttonListener);

            viewportContent.add(applicationItem[i]);
        }

        refreshPage();

    }

    private void resetViewPortContent(){

        int gapSize = cellInsets[currentZoomLevel];

        viewportContentLayout = new GridLayout(0,7-currentZoomLevel);

        viewportContentLayout.setHgap(gapSize);
        viewportContentLayout.setVgap(gapSize);

        viewportContent = new JPanel();
        viewportContent.setLayout(viewportContentLayout);

        individualItemSize = cellDimensions[currentZoomLevel];

        applicationItem = new JButton[totalItems];

    }

    private void refreshPage(){

        viewportTopLayout = new JPanel();
        viewportTopLayout.setLayout(new GridBagLayout());
        viewportTopLayout.add(viewportContent);

        this.setViewportView(viewportTopLayout);

    }

    public int getCurrentZoomLevel() {
        return currentZoomLevel;
    }

    public int getTotalZoomLevels (){
        return  cellDimensions.length;
    }

    public void updateZoomLevel(int nextLevel){

        currentZoomLevel = nextLevel;

       resetViewPortContent();
        
        for (int i = 0; i < totalItems; i++){

            applicationItem[i].setPreferredSize(new Dimension(individualItemSize,individualItemSize));
            applicationItem[i].setIcon(applicationIndex[i].getIconAt(nextLevel));
            viewportContent.add(applicationItem[i]);
        }

        refreshPage();

    }

}
