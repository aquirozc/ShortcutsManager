package com.aquirozc.shortcutsmanager.view;

public enum ResizePolicy {
	
	MINI(70,5),
	SMALL(90,10),
	NORMAL(110,15),
	BIG(130,20),
	LARGE(150,25);
	
	public final int size;
	public final int gap;
	
	private ResizePolicy(int size, int gap) {
		this.size = size;
		this.gap = gap;
	}
}
