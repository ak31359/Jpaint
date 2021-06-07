package model;

import model.interfaces.ShapeTypeInterface;
import model.util.PropertyUtility;

import java.awt.*;

public class ShapeTypeFactory {


    public static Shape build(PropertyUtility shapeProperty) {
        @SuppressWarnings("unused")
		Shape shape = null;

        ShapeType shapeType = shapeProperty.getShapeType();
        Integer XCoordinate = shapeProperty.getXCoordinate();
        Integer YCoordinate = shapeProperty.getYCoordinate();
        Integer width = shapeProperty.getWidth();
        Integer height = shapeProperty.getHeight();
        Point startPoint = shapeProperty.getStartPoint();
        Point endPoint = shapeProperty.getEndPoint();


        ShapeTypeInterface shapeTypeStrategy = null;

        switch (shapeType) {
            case RECTANGLE:
                shapeTypeStrategy = new DesignRectangle(XCoordinate, YCoordinate, width, height);
                break;
            case ELLIPSE:
                shapeTypeStrategy = new DesignEllipse(XCoordinate, YCoordinate, width, height);
                break;
            case TRIANGLE:
                shapeTypeStrategy = new DesignRightTriangle(startPoint, endPoint);
                break;
        }
        return shapeTypeStrategy.design();
    }
}

