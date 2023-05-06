package com.aquirozc.shortcutsmanager.userinterface;

import com.aquirozc.shortcutsmanager.util.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScrollableAppGrid extends JScrollPane {

    private ActionListener buttonListener;
    private ArrayList <Application> applicationIndex;
    private int currentZoomLevel;
    private int[] cellDimensions;
    private int[] cellInsets;
    private int individualItemSize;
    private int totalItems;
    private GridLayout viewportContentLayout;
    private JButton[] applicationItem;
    private JPanel viewportContent;
    private JPanel viewportTopLayer;
    private JPanel placeholder;


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

        JLabel placeholderLabel = new JLabel("There is nothing to show :(");
        placeholderLabel.setFont(DesignPallete.FONT_HEADER_B);
        placeholder = new JPanel();
        placeholder.setLayout(new GridBagLayout());
        placeholder.setBackground(new Color(212,212,212));
        placeholder.add(placeholderLabel);
        showBlankPage();


    }

    public void generateGrid(ArrayList <Application> index){

        currentZoomLevel = 2;

        applicationIndex = index;
        totalItems = applicationIndex.size();

        resetViewPortContent();
        applicationItem = new JButton[totalItems];

        for (int i = 0; i < totalItems; i++) {

            applicationItem[i] = new JButton(applicationIndex.get(i).getIconAt(currentZoomLevel));
            applicationItem[i].setPreferredSize(new Dimension(individualItemSize, individualItemSize));
            applicationItem[i].setBorderPainted(false);
            applicationItem[i].setFocusPainted(false);
            applicationItem[i].setBorder(BorderFactory.createEmptyBorder());
            applicationItem[i].setOpaque(true);
            applicationItem[i].setBackground(new Color(96, 96, 96));
            applicationItem[i].setActionCommand("ITEM_id" + i);
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


    }

    private void refreshPage(){

        viewportTopLayer = new JPanel();
        viewportTopLayer.setLayout(new GridBagLayout());
        viewportTopLayer.add(viewportContent);

        this.setViewportView(viewportTopLayer);
        viewportContent.setBackground(new Color(212,212,212));
        viewportTopLayer.setBackground(new Color(212,212,212));

    }

    public void showBlankPage(){
        setViewportView(placeholder);
    }


    public void updateZoomLevel(int nextLevel){

        currentZoomLevel = nextLevel;

       resetViewPortContent();
        
        for (int i = 0; i < totalItems; i++){

            applicationItem[i].setPreferredSize(new Dimension(individualItemSize,individualItemSize));
            applicationItem[i].setIcon(applicationIndex.get(i).getIconAt(nextLevel));
            viewportContent.add(applicationItem[i]);
        }

        refreshPage();

    }

    public void updateAllItems(boolean value, Color bgColor){

        for (JButton button : applicationItem){

            int index = Integer.parseInt(button.getActionCommand().substring(7));
            button.setBackground(bgColor);
            applicationIndex.get(index).setWillCreateShortcutFlag(value);

        }

    }

    public int getCurrentZoomLevel() {
        return currentZoomLevel;
    }

    public int getMaximumZoomLevel (){
        return  cellDimensions.length - 1;
    }

    public JButton[] getApplicationItem(){
        return applicationItem;
    }

}
