package com.aquirozc.shortcutsmanager.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.aquirozc.shortcutsmanager.model.Application;
import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListFormatException;
import com.dd.plist.PropertyListParser;
import com.github.gino0631.icns.IcnsIcons;
import com.github.gino0631.icns.IcnsIcons.Entry;

import javafx.scene.image.Image;

public class IconFinder {
	
	public static Image getIcon(Application application) {
		
		Image img = null;
		
		try {
			
			NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(new File(application.getBundle(), "Contents/Info.plist"));
            String url = rootDict.objectForKey("CFBundleIconFile").toString();
            url = url.endsWith(".icns") ? url : url + ".icns";
            
            try (IcnsIcons icons = IcnsIcons.load(new File(application.getBundle(), "Contents/Resources/" + url).toPath())){
            	
            	Entry icon = findBestIcon(icons.getEntries()).get();
            	
            	try (InputStream is = icon.newInputStream()) {
					img = new Image(is);
            	}
              
            }
            
		} catch (IOException | PropertyListFormatException | ParseException | ParserConfigurationException | SAXException | NullPointerException e) {
			System.out.println("Oops");
		}
		
		return img;
		
	}
	
	private static Optional<Entry> findBestIcon(List<IcnsIcons.Entry> entries) {
		return Optional.ofNullable(entries.stream()
				.filter(IconFinder::canBeReaded)
				.max(IconFinder::sizeComparator)
				.get());
	}
	
	private static int sizeComparator(IcnsIcons.Entry e1, IcnsIcons.Entry e2) {
		return Integer.compare(e1.getSize(), e2.getSize());
	}
	
	private static boolean canBeReaded(IcnsIcons.Entry entry) {
		return !(entry.getType() == null);
	}

}
