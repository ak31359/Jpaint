package model;

import model.interfaces.Drawable;

import java.awt.*;


public class Filled implements Drawable {
    Color colour;
    Shape shape;
    private Graphics2D graphics2d;


    public Filled(Color color, Shape shape, Graphics2D graphics2d) {
        this.colour = color;
        this.shape = shape;
        this.graphics2d = graphics2d;
    }

    @Override
    public void paintShape() {
        graphics2d.setPaint(colour);
        graphics2d.fill(shape);
    }

    @Override
    public String toString() {
        return "DrawShapeCommand{" +
                "graphics2d=" + graphics2d +
                ", color=" + colour.toString() +
                ", shape=" + shape.toString() +
                '}';
    }
}
