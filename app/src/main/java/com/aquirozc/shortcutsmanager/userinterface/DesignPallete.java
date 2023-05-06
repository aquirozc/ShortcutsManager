package com.aquirozc.shortcutsmanager.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DesignPallete {

    //Used colors

    public static final Color COLOR_DARK_COMPONENT_BACKGROUND_A = new Color(32, 32, 32);
    public static final Color COLOR_DARK_COMPONENT_BACKGROUND_B = new Color(55, 55, 55);
    public static final Color COLOR_DARK_COMPONENT_BACKGROUND_C = new Color(127, 127, 127);
    public static final Color COLOR_DARK_ITEM_UNCHECKED = new Color(96,96,96);
    public static final Color COLOR_DARK_ITEM_CHECKED = new Color (124,201,231);;
    public static final Color COLOR_DARK_BUTTON_BACKGROUND_A = new Color(55, 55, 55);
    public static final Color COLOR_DARK_BUTTON_BACKGROUND_B = new Color(32, 32, 32);
    public static final Color COLOR_DARK_TEXT_FOREGROUND_A = new Color(255,255,255);

    //Used fonts

    private static final Font BASE_FONT = loadFont();
    public static final Font FONT_TITLE_A = BASE_FONT.deriveFont(32f);
    public static final Font FONT_TITLE_B = BASE_FONT.deriveFont(48f);
    public static final Font FONT_BUTTON_A =BASE_FONT.deriveFont(18f);
    public static final Font FONT_BUTTON_B = BASE_FONT.deriveFont(15f);
    public static final Font FONT_HEADER_A = BASE_FONT.deriveFont(26f);
    public static final Font FONT_HEADER_B = BASE_FONT.deriveFont(24f);
    public static final Font FONT_PATH_A = BASE_FONT.deriveFont(16f);

    //Theme IDs

    public static final String THEME_AQUA_DEFAULT = "Use Apple Aqua built-in theme";
    public static final String THEME_METRO_DARK = "Use Metro-inspired dark theme";
    

    private static Font loadFont(){

            Font baseFont = null;

            try{

                baseFont = Font.createFont(Font.TRUETYPE_FONT, DesignPallete.class.getClassLoader().getResourceAsStream("Khula-Light.ttf"));
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(baseFont);

            }catch (FontFormatException| IOException fontError){

                Logger.getLogger("com.aquirozc.shorcutsmanager").log(Level.SEVERE,"Couldn't load font resource");

            }

            return baseFont;
    }
}
