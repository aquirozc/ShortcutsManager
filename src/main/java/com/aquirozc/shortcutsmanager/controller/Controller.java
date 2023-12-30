package com.aquirozc.shortcutsmanager.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.aquirozc.shortcutsmanager.util.Indexer;
import com.aquirozc.shortcutsmanager.util.LinkerAction;
import com.aquirozc.shortcutsmanager.view.AnimationFactory;
import com.aquirozc.shortcutsmanager.view.GlassButton;
import com.aquirozc.shortcutsmanager.view.Grid;
import com.aquirozc.shortcutsmanager.view.ResizePolicy;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements IControllerFXML{
	
	private Parent parent = getActivity("ManualHomeInmersive.fxml");
	 
	private Button openButton = (Button) parent.lookup("#open_btn");
	private Button clearButton = (Button) parent.lookup("#clear_btn");
	private Button selectButton = (Button) parent.lookup("#select_btn");
	private Button zoomOutButton = (Button) parent.lookup("#zoomOut_btn");
	private Button zoomInButton = (Button) parent.lookup("#zoomIn_btn");
	private Button returnButton = (Button) parent.lookup("#return_btn");
	private Button createButton = (Button) parent.lookup("#create_btn");
	private Button deleteButton = (Button) parent.lookup("#delete_btn");
	
	private Text nameLabel = (Text) parent.lookup("#name_txt");
	private Text pathLabel = (Text) parent.lookup("#path_txt");
	
	private ScrollPane pane = (ScrollPane) parent.lookup("#target_pane");
	private HBox box = (HBox) pane.getContent();
	private Grid grid = new Grid();
	private Stage stage;
	
	private DirectoryChooser chooser = new DirectoryChooser();
	
	private ResizePolicy[] zoom = ResizePolicy.values();
	private int level = 2;
	private int size = zoom[level].size;
	private int gap = zoom[level].gap;
	
	private List<GlassButton> index = new ArrayList<GlassButton>();
	
	public Controller (Stage stage) {
		
		this.stage = stage;
		
		Scene scene = new Scene(parent,1000,600);
		stage.setTitle("Shortcuts Manager");
		stage.setScene(scene);
		
		openButton.setOnMouseClicked(this::changeDirectory);	
		
		createButton.setOnMouseClicked(e -> doLinkerOperation(LinkerAction.CREATE));
		deleteButton.setOnMouseClicked(e -> doLinkerOperation(LinkerAction.DELETE));
		
		zoomInButton.setOnMouseClicked( e -> updateZoom(true));
		zoomOutButton.setOnMouseClicked( e -> updateZoom(false));
		selectButton.setOnMouseClicked(e -> updateSelection(true));
		clearButton.setOnMouseClicked(e -> updateSelection(false));
		
		returnButton.setOnMouseClicked(e -> System.exit(0));
		
		stage.widthProperty().addListener(this::adjustGrid);
		
	}
	
	public void onCreate() {
		stage.show();
	}
	
	public void changeDirectory(MouseEvent event) {
		
		File file = chooser.showDialog(stage);
		
		if(file == null) {
			return;
		}
		
		nameLabel.setText(file.getName());
		pathLabel.setText("File:/" + file.getPath());
		
		long start = System.currentTimeMillis();
		resetGrid(Indexer.listApps(file).stream().parallel().map(GlassButton::new).toList());
		
		int noColumnas = calcularColumnas();
		int i = 0;
		int j = 0;
		long l =  0;
		
		for (GlassButton button : index) {
			
			grid.add(button, j, i);
			
			Duration delay = Duration.millis(l);
			
			AnimationFactory.getScaleTransition(button, delay).play();
			AnimationFactory.getFadeTransition(button, delay).play();
			
			j++;
			
			if(j == noColumnas) {
				j = 0;
				i++;
			}
			
			l += 100;
		}
		
		System.out.println(System.currentTimeMillis() - start);
		
	}
	
	private void adjustGrid(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		
		grid.setGap(gap);
		
		int noColumnas = calcularColumnas();
		int i = 0;
		int j = 0;
		
		for(GlassButton button : index) {
			
			GridPane.setColumnIndex(button ,j);
			GridPane.setRowIndex(button, i);
			
			AnimationFactory.getResizeTimeline(button, size).play();

			j++;
			
			if(j == noColumnas) {
				j = 0;
				i++;
			}
			
		}
		
	}
	
	public void updateZoom(boolean bool) {
		int i = bool ? 1 : -1;
		
		level += i;
		
		if (level == -1 || level == zoom.length) {
			level -= i;
			return;	
		}	
		
		size = zoom[level].size;
		gap = zoom[level].gap;
		
		adjustGrid(null, null, null);
	}
	
	public void resetGrid(List<GlassButton> list) {
		
		level = 2;
		gap = zoom[level].gap;
		size = zoom[level].size;
		
		grid.getChildren().clear();
		grid.setGap(gap);
		
		box.getChildren().clear();
		box.getChildren().add(grid);
		
		index.clear();
		index.addAll(list);
		
		
	}
	
	public int calcularColumnas() {
		//Satisfies HBox.width - 20 = noColumns * size + (noColumns-1) * gap
		return (int) Math.floor((pane.getWidth() - 20)/(size + gap) + 1/(size*gap+1));
	}
	
	private void doLinkerOperation(LinkerAction action) {
		index.stream()
			.filter(b -> b.getApplication().getFlag())
			.peek(b -> b.resetFlag())
			.map(b -> b.getApplication())
			.forEach(action.consumer);
	}
	
	public void updateSelection(boolean value) {
		index.stream().forEach(b -> b.setFlag(value));
	}
	
}
