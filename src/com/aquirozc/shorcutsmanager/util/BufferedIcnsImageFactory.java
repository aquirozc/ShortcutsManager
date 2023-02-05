package com.aquirozc.shorcutsmanager.util;

import org.apache.commons.imaging.common.BufferedImageFactory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BufferedIcnsImageFactory implements BufferedImageFactory {

    @Override
    public BufferedImage getColorBufferedImage(int width, int height, boolean hasAlpha) {
        final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice gd = ge.getDefaultScreenDevice();
        final GraphicsConfiguration gc = gd.getDefaultConfiguration();
        return gc.createCompatibleImage(width, height,Transparency.TRANSLUCENT);
    }

    @Override
    public BufferedImage getGrayscaleBufferedImage(int width, int height, boolean hasAlpha) {
        return getColorBufferedImage(width, height, hasAlpha);
    }

}
