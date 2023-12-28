package com.aquirozc.shortcutsmanager.init;

import com.aquirozc.shortcutsmanager.controller.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ShortcutsManager extends Application {
	
    
    public static void main(String[] args){
       launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    	
    	Font.loadFont(ShortcutsManager.class.getClassLoader().getResourceAsStream("Khula-Light.ttf"),20);
		
    	new Controller(stage).onCreate();

    }

}
