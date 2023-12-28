package com.aquirozc.shortcutsmanager.model;

import java.io.File;

public class Application {
	
	private boolean isSelected;
	private File bundle;
	
	public Application (File bundle) {
		this.bundle = bundle;
	}
	
	public File getBundle() {
		return bundle;
	}
	
	public boolean getFlag() {
		return isSelected;
	}
	
	public void setFlag(boolean value) {
		isSelected = value;
	}
	
	public void toggleFlag() {
		isSelected = !isSelected;
	}
	

}
