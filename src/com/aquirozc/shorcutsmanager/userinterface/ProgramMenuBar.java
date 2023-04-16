package com.aquirozc.shorcutsmanager.userinterface;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;

public class ProgramMenuBar extends JMenuBar {

    private JMenu fileMenu;
    private JMenu windowMenu;
    private JMenu helpMenu;

    private JMenuItem openTargetInFinderOption;
    private JMenuItem openWorkingDirectoryInFinderOption;
    private JMenuItem chooseNewWorkingDirectoryOption;
    private JMenuItem closeCurrentWorkingDirectoryOption;
    private JMenuItem reloadApplicationIndexOption;

    private JMenuItem enterFullScreenOption;
    private JMenuItem exitFullScreenOption;
    private JMenuItem maximizeMainWindowOption;
    private JMenuItem minimizeAllWindowsOption;
    private JMenuItem bringAllWindowsToFocusOption;

    private JMenuItem openOnlineDocumentationOption;
    private JMenuItem checkForUpdatesOption;
    private JMenuItem sendBugReport;

    public ProgramMenuBar(ActionListener buttonListener){

        fileMenu = new JMenu("File");

        openWorkingDirectoryInFinderOption = new JMenuItem("Open working directory in Finder");
        fileMenu.add(openWorkingDirectoryInFinderOption);
        openTargetInFinderOption = new JMenuItem("Open Applications folder in Finder");
        fileMenu.add(openTargetInFinderOption);
        fileMenu.addSeparator();
        chooseNewWorkingDirectoryOption = new JMenuItem("Choose a new working directory");
        fileMenu.add(chooseNewWorkingDirectoryOption);
        closeCurrentWorkingDirectoryOption = new JMenuItem("Close current working directory");
        fileMenu.add(closeCurrentWorkingDirectoryOption);
        fileMenu.addSeparator();
        reloadApplicationIndexOption = new JMenuItem("Look for recently added applications");
        fileMenu.add(reloadApplicationIndexOption);

        this.add(fileMenu);

        windowMenu = new JMenu("Window");

        enterFullScreenOption = new JMenuItem("Enter full screen mode");
        windowMenu.add(enterFullScreenOption);
        exitFullScreenOption = new JMenuItem("Leave full screen mode");
        windowMenu.add(exitFullScreenOption);
        windowMenu.addSeparator();
        maximizeMainWindowOption = new JMenuItem("Maximize main window");
        windowMenu.add(maximizeMainWindowOption);
        minimizeAllWindowsOption = new JMenuItem("Minimize all windows to Dock");
        windowMenu.add(minimizeAllWindowsOption);
        windowMenu.addSeparator();
        bringAllWindowsToFocusOption = new JMenuItem("Bring all windows to top");
        windowMenu.add(bringAllWindowsToFocusOption);

        this.add(windowMenu);

        helpMenu = new JMenu("Help");

        openOnlineDocumentationOption = new JMenuItem("Go online for documentation");
        helpMenu.add(openOnlineDocumentationOption);
        checkForUpdatesOption = new JMenuItem("Look for latest release");
        helpMenu.add(checkForUpdatesOption);
        sendBugReport = new JMenuItem("Submit bug report to developer");
        helpMenu.add(sendBugReport);

        this.add(helpMenu);

    }

}
