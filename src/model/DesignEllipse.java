package model;

import model.interfaces.ShapeTypeInterface;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class DesignEllipse implements ShapeTypeInterface {

    Integer CoordinateX;
    Integer CoordinateY;
    Integer width;
    Integer height;

    public DesignEllipse(Integer CoordinateX, Integer CoordinateY, Integer width, Integer height) {
        this.CoordinateX = CoordinateX;
        this.CoordinateY = CoordinateY;
        this.width = width;
        this.height = height;
    }

    @Override
    public Shape design() {
        return new Ellipse2D.Double(CoordinateX, CoordinateY, width, height);
    }
}