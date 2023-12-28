package com.aquirozc.shortcutsmanager.helper;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;

import com.aquirozc.shortcutsmanager.model.Application;

public class Indexer {
	
	public static List<Application> listApps(File dir){
		return Stream.of(dir.listFiles())
				.filter(Indexer::isApp)
				.sorted()
				.map(Application::new)
				.toList();
	}
	
	private static boolean isApp(File app) {
		return app.getName().endsWith(".app") && (!app.getName().contains("Free") && !app.getName().contains("Open"));
	}

}
