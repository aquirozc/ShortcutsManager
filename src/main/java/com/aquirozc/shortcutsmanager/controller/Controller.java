package com.aquirozc.shortcutsmanager.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.aquirozc.shortcutsmanager.helper.Indexer;
import com.aquirozc.shortcutsmanager.helper.Linker;
import com.aquirozc.shortcutsmanager.view.GlassButton;
import com.aquirozc.shortcutsmanager.view.ResizePolicy;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
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
	private GridPane grid = new GridPane();
	private Stage stage;
	
	private DirectoryChooser chooser = new DirectoryChooser();
	
	private ResizePolicy[] zoom = ResizePolicy.values();
	private int level = 2;
	private int size = zoom[2].size;
	private int gap = zoom[2].gap;
	
	private List<GlassButton> index = new ArrayList<GlassButton>();
	
	public Controller (Stage stage) {
		
		System.out.println(pane);
		
		this.stage = stage;
		
		Scene scene = new Scene(parent,1000,600);
		stage.setTitle("iShortcuts Manager 2023");
		stage.setScene(scene);
		
		openButton.setOnMouseClicked(this::openDirectory);
		
		zoomOutButton.setOnMouseClicked(e -> {
			updateZoom(false);
		});		
		
		createButton.setOnMouseClicked(this::createShortcuts);
		deleteButton.setOnMouseClicked(this::deleteShortcuts);
		
		zoomInButton.setOnMouseClicked( e -> updateZoom(true));
		selectButton.setOnMouseClicked(e -> updateSelection(true));
		clearButton.setOnMouseClicked(e -> updateSelection(false));
		
		returnButton.setOnMouseClicked(e -> System.exit(0));
		
		stage.widthProperty().addListener(this::resize);
	}
	
	public void onCreate() {
		stage.show();
	}
	
	public void openDirectory(MouseEvent event) {
		
		File file = chooser.showDialog(stage);
		
		if(file == null) {
			return;
		}
		
		nameLabel.setText(file.getName());
		pathLabel.setText("File:/" + file.getPath());
		
		level = 2;
		gap = zoom[level].gap;
		size = zoom[level].size;		
		grid.getChildren().clear();
		grid.setHgap(gap);
		grid.setVgap(gap);
		
		box.getChildren().clear();
		box.getChildren().add(grid);
		
		long l = System.currentTimeMillis();
		
		index.clear();
		index.addAll(Indexer.listApps(file).stream().parallel().map(GlassButton::new).toList());
		Iterator<GlassButton> list = index.iterator();
		
		int noColumnas = calcularColumnas();
		
		for (int i = 0; i > -1 ;i++) {
			
			for (int j = 0; j < noColumnas; j++) {
				
				if(!list.hasNext()) {
					System.out.println(System.currentTimeMillis() - l);
					return;
				}
				
				grid.add(list.next(), j, i);
				
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
		
		resize(null, null, null);
	}
	
	public void updateSelection(boolean value) {
		index.stream().forEach(b -> b.setFlag(value));
	}
	
	public int calcularColumnas() {
		//Satisfies HBox.width - 20 = noColumns * size + (noColumns-1) * gap
		return (int) Math.floor((pane.getWidth() - 20)/(size + gap) + 1/(size*gap+1));
	}
	
	public void createShortcuts(MouseEvent event) {
		index.stream().filter(b -> b.getApplication().getFlag()).map(b -> b.getApplication()).forEach(Linker::createShortcut);
		updateSelection(false);
	}
	
	public void deleteShortcuts(MouseEvent event) {
		index.stream().filter(b -> b.getApplication().getFlag()).map(b -> b.getApplication()).forEach(Linker::deleteShortcut);
		updateSelection(false);
	}
	
	public void resize(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		
		grid.setHgap(gap);
		grid.setVgap(gap);
		
		Iterator<GlassButton> list = index.iterator();
		int noColumnas = calcularColumnas();
		
		for (int i = 0; i < Math.ceil(index.size()/noColumnas)+ 1 ; i++) {
			
			for (int j = 0; j < noColumnas; j++) {
				
				if(!list.hasNext()) {
					return;
				}
				
				
				
				GlassButton button = list.next();
				
				final int x = j;
				final int y = i;
				
				final int xx = -5 +y *(size + gap);
				final int yy = -3 +x *(size + gap);
				
				
			
				

				
				
				Timeline timeline = new Timeline(
						new KeyFrame(Duration.ZERO, new KeyValue(button.decoration.minWidthProperty(), button.decoration.getWidth()), new KeyValue(button.decoration.minHeightProperty(), button.decoration.getHeight())),
						new KeyFrame(Duration.millis(500), new KeyValue(button.decoration.minWidthProperty(), size), new KeyValue(button.decoration.minHeightProperty(), size))
					
						);		
				
				if(size <= button.size) {
					GridPane.setColumnIndex(button ,x);
					GridPane.setRowIndex(button, y);
					button.resize(size);
				}else {
					timeline.setOnFinished(e -> {
						GridPane.setColumnIndex(button ,x);
						GridPane.setRowIndex(button, y);
						button.resize(size);
						
					});
				}
				
				
				
				
				timeline.play();		
			}
			
		}
		
	}
	
}
