package model.interfaces;

import model.util.PropertyUtility;

import java.awt.*;

public interface ShapeDraw {
    void designShape();

    void draw();

    Shape getShape();

    void setShape(Shape shape);

    PropertyUtility getShapeProperty();

    void updateShapeProperty(Shape newShape);

}

