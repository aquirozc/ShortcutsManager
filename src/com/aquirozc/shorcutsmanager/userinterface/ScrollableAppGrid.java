package com.aquirozc.shorcutsmanager.userinterface;

import javax.swing.*;
import java.awt.*;

public class ScrollableAppGrid extends JScrollPane {

    private int currentZoomLevel;
    private int [][] measures;
    private int totalItems;
    private JButton applicationItem;
    private JPanel[] viewContext;
    private JPanel topLevelContainer;
    private GridLayout viewContextLayout;

    public ScrollableAppGrid(){

        totalItems = 64;
        currentZoomLevel = 2;

        populateMeasures();
        populateViewContex();

        topLevelContainer = new JPanel();
        topLevelContainer.add(viewContext[currentZoomLevel]);

        this.setViewportView(topLevelContainer);
        this.setBorder(BorderFactory.createLineBorder(new Color(200,200,200),1));

        topLevelContainer.setBackground(new Color(212,212,212));

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

        measures [1][0] = 3;
        measures [1][1] = 6;
        measures [1][2] = 9;
        measures [1][3] = 12;
        measures [1][4] = 18;

    }

    public void populateViewContex(){

        viewContext = new JPanel[5];

        for (int i = 0; i < measures[0].length ; i++) {

            viewContextLayout = new GridLayout(Math.ceilDiv(totalItems, 7- i),7-i);
            viewContextLayout.setHgap(measures[1][i]);
            viewContextLayout.setVgap(measures[1][i]);

            viewContext[i] = new JPanel();
            viewContext[i].setLayout(viewContextLayout);

            for (int k = 0; k < totalItems; k++){
                int individualItemSize = measures[0][i];

                applicationItem = new JButton("Item #" + (k+1));
                applicationItem.setPreferredSize(new Dimension(individualItemSize,individualItemSize));
                applicationItem.setBorderPainted(false);
                applicationItem.setFocusPainted(false);
                applicationItem.setBorder(BorderFactory.createEmptyBorder());
                applicationItem.setOpaque(true);
                applicationItem.setBackground(new Color(96,96,96));
                applicationItem.setForeground(Color.WHITE);

                viewContext[i].add(applicationItem);
            }

        }

    }

    public void setViewContextBackground(Color backgroundColor){
        for (int i = 0; i < 5 ;i++){
            viewContext[i].setBackground(backgroundColor);
        }
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
        topLevelContainer.remove(0);
        topLevelContainer.add(viewContext[nextLevel]);
        setViewportView(topLevelContainer);

    }

}
