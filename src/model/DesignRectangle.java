package model;

import model.interfaces.ShapeTypeInterface;

import java.awt.*;
import java.awt.geom.Rectangle2D;



public class DesignRectangle implements ShapeTypeInterface {

    Integer CoordinateX;
    Integer CoordinateY;
    Integer width;
    Integer height;

    public DesignRectangle(Integer CoordinateX, Integer CoordinateY, Integer width, Integer height) {
        this.CoordinateX = CoordinateX;
        this.CoordinateY = CoordinateY;
        this.width = width;
        this.height = height;
    }

    @Override
    public Shape design() {
        return new Rectangle2D.Double(CoordinateX, CoordinateY, width, height);
    }
}