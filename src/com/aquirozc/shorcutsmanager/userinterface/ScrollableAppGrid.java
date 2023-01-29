package com.aquirozc.shorcutsmanager.userinterface;

import javax.swing.*;
import java.awt.*;

public class ScrollableAppGrid extends JScrollPane {

    private JLabel applicationItem;
    private JPanel viewContext;
    private JPanel topLevelContainer;
    private GridLayout viewContextLayout;

    public ScrollableAppGrid(){

        viewContextLayout = new GridLayout(8,4);
        viewContextLayout.setHgap(9);
        viewContextLayout.setVgap(9);

        viewContext = new JPanel();
        viewContext.setLayout(viewContextLayout);

        for (int i = 0; i < 32 ; i++) {

            applicationItem = new JLabel("Item #" + (i+1));
            applicationItem.setPreferredSize(new Dimension(125,125));
            applicationItem.setOpaque(true);
            applicationItem.setBackground(new Color(96,96,96));
            applicationItem.setForeground(Color.WHITE);
            viewContext.add(applicationItem);

        }

        topLevelContainer = new JPanel();
        topLevelContainer.add(viewContext);

        this.setViewportView(topLevelContainer);
        this.setBorder(BorderFactory.createLineBorder(new Color(200,200,200),1));

        topLevelContainer.setBackground(new Color(212,212,212));

    }

    public void setViewContextBackground(Color backgroundColor){
        viewContext.setBackground(backgroundColor);
        topLevelContainer.setBackground(backgroundColor);
    }
}
