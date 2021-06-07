package model;

import model.interfaces.Drawable;

import java.awt.*;

public class OutLineAndFilled implements Drawable {
    BasicStroke stroke = new BasicStroke(5.0f);
    Shape shape;
    Color mainColour;
    Color otherColour;
    private Graphics2D graphics2d;


    public OutLineAndFilled(Color mainColour, Color otherColour, Shape shape, Graphics2D graphics2d) {
        this.mainColour = mainColour;
        this.otherColour = otherColour;
        this.shape = shape;
        this.graphics2d = graphics2d;
    }


    @Override
    public void paintShape() {
        graphics2d.setStroke(stroke);
        graphics2d.setPaint(otherColour);
        graphics2d.draw(shape);

        graphics2d.setPaint(mainColour);
        graphics2d.fill(shape);
    }

    public void setStoke(BasicStroke stroke) {
        this.stroke = stroke;
    }

    @Override
    public String toString() {
        return "OutlineAndFilledShape{" +
                "graphics2d=" + graphics2d +
                ", shape=" + shape.toString() +
                ", mainColour=" + mainColour.toString() +
                ", otherColour=" + otherColour.toString() +
                '}';
    }
}