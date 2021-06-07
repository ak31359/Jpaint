package model;

import model.interfaces.Drawable;

import java.awt.*;


public class Outline implements Drawable {
    BasicStroke BStroke = new BasicStroke(5.0f);
    Shape shape;
    Color colour;
    private Graphics2D graphics2d;

    public Outline(Color color, Shape shape, Graphics2D graphics2d) {
        this.shape = shape;
        this.graphics2d = graphics2d;
        this.colour = color;
    }

    @Override
    public void paintShape() {
        graphics2d.setStroke(BStroke);
        graphics2d.setPaint(colour);
        graphics2d.draw(shape);
    }

    public void setStroke(BasicStroke stroke) {
        this.BStroke = stroke;
    }

    @Override
    public String toString() {
        return "OutlineShapeStrategy{" +
                "graphics2d=" + graphics2d +
                ", shape=" + shape.toString() +
                ", color=" + colour.toString() +
                '}';
    }


}
