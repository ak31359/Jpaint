package model.util;

import model.ShadingType;
import model.ShapeType;

import java.awt.*;

public class PropertyUtility {
    private Point startPoint;
    private Point endPoint;

    private ShapeType shapeType;
    private ShadingType shadingType;
    private Color primaryColor;
    private Color secondaryColor;

    private Integer shapeXcoord;
    private Integer shapeYcoord;
    private Integer width;
    private Integer height;


    public PropertyUtility(Point startPoint, Point endPoint) {


        this.startPoint = startPoint;
        this.endPoint = endPoint;

        this.shapeType = ShapeType.RECTANGLE;
        this.shadingType = ShadingType.OUTLINE;
        this.primaryColor = Color.MAGENTA;
        this.secondaryColor = Color.red;

        calculateProperty();
    }

    public void calculateProperty() {
        this.shapeXcoord = Math.min(startPoint.x, endPoint.x);
        this.shapeYcoord = Math.min(startPoint.y, endPoint.y);

        this.width = (endPoint.x >= startPoint.x) ? endPoint.x - startPoint.x : startPoint.x - endPoint.x;

        this.height = (endPoint.y >= startPoint.y) ? endPoint.y - startPoint.y : startPoint.y - endPoint.y;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public PropertyUtility setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
        return this;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public PropertyUtility setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
        return this;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public PropertyUtility setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
        return this;
    }

    public ShadingType getShadingType() {
        return shadingType;
    }

    public PropertyUtility setShadingType(ShadingType shadingType) {
        this.shadingType = shadingType;
        return this;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public PropertyUtility setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
        return this;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public PropertyUtility setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
        return this;
    }

    public Integer getXCoordinate() {
        return shapeXcoord;
    }

    public PropertyUtility setShapeXcoord(Integer shapeXcoord) {
        this.shapeXcoord = shapeXcoord;
        return this;
    }

    public Integer getYCoordinate() {
        return shapeYcoord;
    }

    public PropertyUtility setShapeYcoord(Integer shapeYcoord) {
        this.shapeYcoord = shapeYcoord;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public PropertyUtility setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public PropertyUtility setHeight(Integer height) {
        this.height = height;
        return this;
    }


    @Override
    public String toString() {
        return "ShapeProperty{" +
                "shapeType=" + shapeType +
                ", startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", shadingType=" + shadingType +
                ", primaryColor=" + primaryColor +
                ", secondaryColor=" + secondaryColor +
                ", shapeXcoord=" + shapeXcoord +
                ", shapeYcoord=" + shapeYcoord +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
