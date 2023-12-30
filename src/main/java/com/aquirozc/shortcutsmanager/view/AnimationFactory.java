package com.aquirozc.shortcutsmanager.view;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.util.Duration;

public class AnimationFactory {
	
	private static final Duration DEFAULT_DURATION = Duration.millis(200);
	
	public static Timeline getResizeTimeline(GlassButton button, double size) {
		
		ImageView view = button.getView();
		Region decoration = button.getDecoration();
		
		KeyValue[] initialValues = {
				new KeyValue(decoration.minWidthProperty(), decoration.getWidth()),
				new KeyValue(decoration.minHeightProperty(), decoration.getHeight()),
				new KeyValue(view.fitWidthProperty(), view.getFitWidth()),
				new KeyValue(view.fitHeightProperty(), view.getFitHeight())
		};
		
		KeyValue[] finalValues = {
				new KeyValue(decoration.minWidthProperty(), size),
				new KeyValue(decoration.minHeightProperty(), size),
				new KeyValue(view.fitWidthProperty(), size - 20),
				new KeyValue(view.fitHeightProperty(), size - 20)
		};
		
		return new Timeline(new KeyFrame(Duration.ZERO,initialValues), 
							new KeyFrame(Duration.millis(200), finalValues));
	}

	public static Transition getScaleTransition(GlassButton button, Duration delay) {
		
		ScaleTransition transition = new ScaleTransition(DEFAULT_DURATION, button);
		
		transition.setFromX(0);
		transition.setFromY(0);
		transition.setToX(1);
		transition.setToY(1);
		
		transition.setDelay(delay);
		
		return transition;
		
	}
	
	public static Transition getFadeTransition(GlassButton button, Duration delay) {
		
		FadeTransition transition = new FadeTransition(DEFAULT_DURATION, button);
		
		transition.setFromValue(0);
		transition.setFromValue(1);
		
		transition.setDelay(delay);
		
		return transition;
		
	}
}
