package com.aquirozc.shortcutsmanager.util;

import java.util.function.Consumer;

import com.aquirozc.shortcutsmanager.model.Application;

public enum LinkerAction {
	
	CREATE(Linker::createShortcut),
	DELETE(Linker::deleteShortcut);

	public final Consumer<Application> consumer;
	
	private LinkerAction(Consumer<Application> consumer) {
		this.consumer = consumer;
	}
	
}
