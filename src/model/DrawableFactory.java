package model;

import model.interfaces.Drawable;

import java.awt.*;

public class DrawableFactory {

    public static Drawable outLineAndFilledShape(Color primaryColor, Color secondaryColor, Shape shape, Graphics2D g2) {
        return new OutLineAndFilled(primaryColor, secondaryColor, shape, g2);
    }

    public static Drawable filledShape(Color primaryColor, Shape shape, Graphics2D g2) {
        return new Filled(primaryColor, shape, g2);
    }

    public static Drawable outlineShape(Color primaryColor, Shape shape, Graphics2D g2) {
        return new Outline(primaryColor, shape, g2);
    }
}