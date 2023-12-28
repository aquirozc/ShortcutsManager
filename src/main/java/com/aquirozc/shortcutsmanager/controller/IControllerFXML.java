package com.aquirozc.shortcutsmanager.controller;

import com.aquirozc.shortcutsmanager.init.ShortcutsManager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public interface IControllerFXML {
	
	default Parent getActivity(String n) {
		
		Parent parent = null;
		
		try {
			parent = new FXMLLoader(ShortcutsManager.class.getClassLoader().getResource(n)).load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return parent;
	}

}
