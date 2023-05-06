package com.aquirozc.shortcutsmanager.userinterface;

import com.aquirozc.shortcutsmanager.controller.Controller;

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

    private JMenuItem maximizeMainWindowOption;
    private JMenuItem restoreMainWindowOption;
    private JMenuItem minimizeAllWindowsOption;
    private JMenuItem bringAllWindowsToFocusOption;

    private JMenuItem openOnlineDocumentationOption;
    private JMenuItem checkForUpdatesOption;
    private JMenuItem sendBugReport;

    public ProgramMenuBar(ActionListener buttonListener){

        fileMenu = new JMenu("File");

        openWorkingDirectoryInFinderOption = new JMenuItem("Open working directory in Finder");
        openWorkingDirectoryInFinderOption.setActionCommand(Controller.OPEN_EXT_APP_FOLDER);
        openWorkingDirectoryInFinderOption.addActionListener(buttonListener);
        fileMenu.add(openWorkingDirectoryInFinderOption);

        openTargetInFinderOption = new JMenuItem("Open Applications folder in Finder");
        openTargetInFinderOption.setActionCommand(Controller.OPEN_ROOT_APP_FOLDER);
        openTargetInFinderOption.addActionListener(buttonListener);
        fileMenu.add(openTargetInFinderOption);

        fileMenu.addSeparator();

        chooseNewWorkingDirectoryOption = new JMenuItem("Choose a new working directory");
        chooseNewWorkingDirectoryOption.setActionCommand(Controller.PICK_NEW_DIR);
        chooseNewWorkingDirectoryOption.addActionListener(buttonListener);
        fileMenu.add(chooseNewWorkingDirectoryOption);

        closeCurrentWorkingDirectoryOption = new JMenuItem("Close current working directory");
        closeCurrentWorkingDirectoryOption.setActionCommand(Controller.CLOSE_CURRENT_DIR);
        closeCurrentWorkingDirectoryOption.addActionListener(buttonListener);
        fileMenu.add(closeCurrentWorkingDirectoryOption);

        fileMenu.addSeparator();

        reloadApplicationIndexOption = new JMenuItem("Look for recently added applications");
        reloadApplicationIndexOption.setActionCommand(Controller.RELOAD_APPLICATION_INDEX);
        reloadApplicationIndexOption.addActionListener(buttonListener);
        fileMenu.add(reloadApplicationIndexOption);

        this.add(fileMenu);

        windowMenu = new JMenu("Window");

        maximizeMainWindowOption = new JMenuItem("Maximize main window");
        maximizeMainWindowOption.setActionCommand(Controller.MAXIMIZE_MAIN_WINDOW);
        maximizeMainWindowOption.addActionListener(buttonListener);
        windowMenu.add(maximizeMainWindowOption);

        restoreMainWindowOption = new JMenuItem("Restore main window");
        restoreMainWindowOption.setActionCommand(Controller.RESTORE_MAIN_WINDOW);
        restoreMainWindowOption.addActionListener(buttonListener);
        windowMenu.add(restoreMainWindowOption);

        minimizeAllWindowsOption = new JMenuItem("Minimize all windows to Dock");
        minimizeAllWindowsOption.setActionCommand(Controller.MINIMIZE_ALL_WINDOWS);
        minimizeAllWindowsOption.addActionListener(buttonListener);
        windowMenu.add(minimizeAllWindowsOption);

        windowMenu.addSeparator();
        bringAllWindowsToFocusOption = new JMenuItem("Bring all windows to top");
        windowMenu.add(bringAllWindowsToFocusOption);

        this.add(windowMenu);

        helpMenu = new JMenu("Help");

        openOnlineDocumentationOption = new JMenuItem("Go online for documentation");
        helpMenu.add(openOnlineDocumentationOption);

        checkForUpdatesOption = new JMenuItem("Look for latest release");
        checkForUpdatesOption.setActionCommand(Controller.CHECK_FOR_UPDATES);
        checkForUpdatesOption.addActionListener(buttonListener);
        helpMenu.add(checkForUpdatesOption);

        sendBugReport = new JMenuItem("Submit bug report to developer");
        sendBugReport.setActionCommand(Controller.SUBMIT_BUGREPORT);
        sendBugReport.addActionListener(buttonListener);

        helpMenu.add(sendBugReport);

        this.add(helpMenu);

        updateFileMenuItems(false);

    }

    public void updateFileMenuItems(boolean val){

        openWorkingDirectoryInFinderOption.setEnabled(val);
        closeCurrentWorkingDirectoryOption.setEnabled(val);
        reloadApplicationIndexOption.setEnabled(val);

    }

}
