package com.aquirozc.shortcutsmanager.view;

import com.aquirozc.shortcutsmanager.util.IconFinder;
import com.aquirozc.shortcutsmanager.init.ShortcutsManager;
import com.aquirozc.shortcutsmanager.model.Application;

import javafx.css.PseudoClass;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GlassButton extends Button{
	
	private Region decoration = new Region();
	private StackPane graphic = new StackPane(decoration);
	private Application application;
	private ImageView view;
	
	public GlassButton(Application application) {
		
		this.application = application;
		this.getStylesheets().add(ShortcutsManager.class.getClassLoader().getResource("FrutigerRedmond.css").toString());
		this.getStyleClass().add("no-style");
		
		DropShadow d1 = new DropShadow(6,0,2,new Color(0, 0, 0, 0.5));
		InnerShadow i1 = new InnerShadow(0,0,1,new Color(1, 1, 1, 0.2));
		InnerShadow i2 = new InnerShadow(0,0,15,new Color(1, 1, 1, 0.15));
		//InnerShadow i3 = new InnerShadow(20,0,10,new Color(1, 1, 1, 0.15));
		//InnerShadow i4 = new InnerShadow(30,0,-15, new Color(0, 0, 0, 1));
		//i3.setInput(i4);
		//i2.setInput(i3);
		i1.setInput(i2);
		d1.setInput(i1);
		
		view = new ImageView(IconFinder.getIcon(application));
		view.setFitWidth(90);
		view.setFitHeight(90);
		
		decoration.setMinWidth(110);
		decoration.setMinHeight(110);
		decoration.getStyleClass().add("glass-box");
		decoration.setEffect(d1);
		
		this.setOpacity(0);
		graphic.getChildren().add(view);
		this.setGraphic(graphic);
		
		this.setOnMousePressed(this::onPressed);
		
	}
	
	private void onPressed(MouseEvent event) {
		setFlag(application.toggleFlag());
		
	}
	
	public void resetFlag() {
		setFlag(false);
	}
	
	public void setFlag(boolean value) {
		application.setFlag(value);
		updateDecoration(value);
	}
	
	public boolean getFlag() {
		return application.getFlag();
	}
	
	private void updateDecoration(Boolean isSelected) {
		decoration.pseudoClassStateChanged(PseudoClass.getPseudoClass("selected"), isSelected);
	}
	
	public Application getApplication() {
		return application;
	}
	
	public ImageView getView() {
		return view;
	}
	
	public Region getDecoration() {
		return decoration;
	}

}
