package com.aquirozc.shorcutsmanager.userinterface;

import com.aquirozc.shorcutsmanager.util.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ScrollableAppGrid extends JScrollPane {

    private ActionListener buttonListener;
    private Application[] applicationIndex;
    private int currentZoomLevel;
    private int [][] measures;
    private int totalItems;
    private JButton[] applicationItem;
    private JPanel viewContext;
    private JPanel topLevelContainer;
    private GridLayout viewContextLayout;

    public ScrollableAppGrid(ActionListener listener){

        buttonListener = listener;

    }

    public void generateGrid(Application [] index){

        applicationIndex = index;
        totalItems = applicationIndex.length;
        currentZoomLevel = 0;

        populateMeasures();
        populateViewContex();

        topLevelContainer = new JPanel();
        topLevelContainer.setLayout(new GridBagLayout());
        topLevelContainer.add(viewContext);

        this.setViewportView(topLevelContainer);
        this.setBorder(BorderFactory.createLineBorder(new Color(200,200,200),1));

        setViewContextBackground(new Color(212,212,212));

    }

    public void populateMeasures(){

        measures = new int [2][5];

        //Item size

        measures [0][0] = 70;
        measures [0][1] = 82;
        measures [0][2] = 100;
        measures [0][3] = 125;
        measures [0][4] = 165;

        //Gap size

        measures [1][0] = 8;
        measures [1][1] = 10;
        measures [1][2] = 12;
        measures [1][3] = 14;
        measures [1][4] = 18;

    }

    public void populateViewContex(){

        viewContextLayout = new GridLayout(Math.ceilDiv(totalItems, 7- currentZoomLevel),7-currentZoomLevel);
        viewContextLayout.setHgap(measures[1][currentZoomLevel]);
        viewContextLayout.setVgap(measures[1][currentZoomLevel]);

        viewContext = new JPanel();
        viewContext.setLayout(viewContextLayout);

        applicationItem = new JButton[totalItems];

        int individualItemSize = measures[0][currentZoomLevel];

            for (int i = 0; i < totalItems; i++){

                applicationItem[i] = new JButton(applicationIndex[i].getIconAt(currentZoomLevel));
                applicationItem[i].setPreferredSize(new Dimension(individualItemSize,individualItemSize));
                applicationItem[i].setBorderPainted(false);
                applicationItem[i].setFocusPainted(false);
                applicationItem[i].setBorder(BorderFactory.createEmptyBorder());
                applicationItem[i].setOpaque(true);
                applicationItem[i].setBackground(new Color(96,96,96));
                applicationItem[i].setForeground(Color.WHITE);
                applicationItem[i].setActionCommand("ITEM");
                applicationItem[i].addActionListener(buttonListener);

                viewContext.add(applicationItem[i]);
            }

    }

    public void setViewContextBackground(Color backgroundColor){

        viewContext.setBackground(backgroundColor);
        topLevelContainer.setBackground(backgroundColor);

    }

    public int getCurrentZoomLevel() {
        return currentZoomLevel;
    }

    public int getTotalZoomLevels (){
        return  measures[0].length;
    }

    public void updateZoomLevel(int nextLevel){

        currentZoomLevel = nextLevel;

        viewContextLayout = new GridLayout(Math.ceilDiv(totalItems, 7- currentZoomLevel),7 - currentZoomLevel);
        viewContextLayout.setHgap(measures[1][currentZoomLevel]);
        viewContextLayout.setVgap(measures[1][currentZoomLevel]);

        viewContext = new JPanel();
        viewContext.setLayout(viewContextLayout);

        int individualItemSize = measures[0][currentZoomLevel];

        for (int i = 0; i < totalItems; i++){

            applicationItem[i].setPreferredSize(new Dimension(individualItemSize,individualItemSize));
            applicationItem[i].setIcon(applicationIndex[i].getIconAt(nextLevel));
            viewContext.add(applicationItem[i]);
        }
        topLevelContainer.add(viewContext);
        setViewportView(topLevelContainer);
        System.out.println(7-currentZoomLevel);

    }

}
