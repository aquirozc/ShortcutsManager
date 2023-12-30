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
	
	public String getName() {
		return bundle.getName();
	}
	
	public String getPath() {
		return bundle.getAbsolutePath();
	}
	
	public boolean getFlag() {
		return isSelected;
	}
	
	public void setFlag(boolean value) {
		isSelected = value;
	}
	
	public boolean toggleFlag() {
		return isSelected = !isSelected;
	}
	

}
