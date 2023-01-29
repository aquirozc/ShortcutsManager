package com.aquirozc.shorcutsmanager.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DesignPallete {

    //Used colors

    public static final Color COLOR_DARK_COMPONENT_BACKGROUND_A = new Color(32, 32, 32);
    public static final Color COLOR_DARK_COMPONENT_BACKGROUND_B = new Color(55, 55, 55);
    public static final Color COLOR_DARK_COMPONENT_BACKGROUND_C = new Color(127, 127, 127);
    public static final Color COLOR_ARK_BUTTON_BACKGROUND_A = new Color(55, 55, 55);
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
    

    private static Font loadFont(){

            Font baseFont = null;

            try{
                    baseFont = Font.createFont(Font.TRUETYPE_FONT, DesignPallete.class.getClassLoader().getResourceAsStream("Khula-Light.ttf"));
            }catch (FontFormatException| IOException fontError){
                    Logger.getLogger("com.aquirozc.shorcutsmanager").log(Level.SEVERE,"Cannot load font resource");
            }

            return baseFont;
    }
}
