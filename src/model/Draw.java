package model;

import model.collection.CollectionRepo;
import model.interfaces.*;
import model.util.CollisionUtility;
import model.util.PropertyUtility;
import view.interfaces.PCanvasFoundation;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Draw implements ShapeInterface, ShapeDraw, UndoInterface {

    Shape shape = null;
    ShapeTypeInterface shapeTypeStrategy = null;
    private PCanvasFoundation paintCanvas;
    private PropertyUtility shapeProperty;
    private Graphics2D graphics2d;

 
    public Draw(ShapeDraw ds, PCanvasFoundation paintCanvas) {
        PropertyUtility dsShapeProp = ds.getShapeProperty();

        this.shapeProperty = new PropertyUtility(dsShapeProp.getStartPoint(), dsShapeProp.getEndPoint());

        shapeProperty
                .setShapeType(dsShapeProp.getShapeType())
                .setShadingType(dsShapeProp.getShadingType())
                .setPrimaryColor(dsShapeProp.getPrimaryColor())
                .setSecondaryColor(dsShapeProp.getSecondaryColor());


        this.paintCanvas = paintCanvas;
        this.graphics2d = paintCanvas.getGraphics2D();
        designShape();
    }


    public Draw(PCanvasFoundation paintCanvas, PropertyUtility shapeProperty) {
        this.paintCanvas = paintCanvas;
        this.graphics2d = paintCanvas.getGraphics2D();
        this.shapeProperty = shapeProperty;

        designShape();
    }

    public void designShape() {

        shape = ShapeTypeFactory.build(shapeProperty);
    }

    public void paintShapeOnCanvas() {

        ShadingType shapeShadingType = shapeProperty.getShadingType();
        Color primaryColor = shapeProperty.getPrimaryColor();
        Color secondaryColor = shapeProperty.getSecondaryColor();

        Drawable drawableShape = new Null();

        switch (shapeShadingType) {
            case OUTLINE_AND_FILLED_IN:
                drawableShape = DrawableFactory.outLineAndFilledShape(primaryColor, secondaryColor, shape, graphics2d);
                break;
            case FILLED_IN:
                drawableShape = DrawableFactory.filledShape(primaryColor, shape, graphics2d);
                break;
            case OUTLINE:
                drawableShape = DrawableFactory.outlineShape(primaryColor, shape, graphics2d);
                break;
        }

        drawableShape.paintShape();
    }


    public void draw() {
        create();
        paintCanvas.repaint();
    }


    @Override
    public void create() {
        CollectionRepo.selectedCollection.clear();

        paintShapeOnCanvas();
        CollectionRepo.shapeCollection.add(this);
    }

    @Override
    public ShapeInterface copyShape() {
        ShapeInterface copiedShape = new Draw(this, paintCanvas);

        return copiedShape;
    }


    @Override
    public ShapeInterface pasteShape() {

        Draw pastedShape = new Draw(this, paintCanvas);

        AffineTransform transform = new AffineTransform();

        transform.translate(80, 80);

        Shape offsetCopiedShape = transform.createTransformedShape(this.getShape());

        pastedShape.setShape(offsetCopiedShape);

        return (Draw)pastedShape;
    }

    @Override
    public void moveShape(int transformOffsetX, int transformOffsetY) {

        @SuppressWarnings("unused")
		ShapeInterface moveShape = new Draw(this, paintCanvas);

        AffineTransform transform = new AffineTransform();

        transform.translate(transformOffsetX, transformOffsetY);

        Shape offsetShape = transform.createTransformedShape(this.getShape());

        this.setShape(offsetShape);

    }

    public boolean detectCollision(Shape otherShape) {
        return CollisionUtility.detect(shape, otherShape);
    }

    public void highlightShape() {
        float[] dash = {7.0f, 7.0f};
        BasicStroke stroke = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10f, dash, 0.0f);


        Outline drawableShape = new Outline(Color.yellow, shape, graphics2d);
        drawableShape.setStroke(stroke);
        drawableShape.paintShape();
    }

    public List<ShapeInterface> getNodeList() {
        List<ShapeInterface> newList = new ArrayList<>();
        newList.add(this);
        return newList;
    }

    public void setGraphics2d(Graphics2D graphics2d) {
        this.graphics2d = graphics2d;
    }

    public PropertyUtility getShapeProperty() {
        return shapeProperty;
    }

    public void setShapeProperty(PropertyUtility shapeProperty) {
        this.shapeProperty = shapeProperty;
    }

    public Shape getBoundingBox() {
        return shape.getBounds();
    }

    public Shape getShape() {
        return shape;
    }



    public void setShape(Shape shape) {
        this.shape = shape;

        updateShapeProperty(shape);
    }


    public void updateShapeProperty(Shape shp) {
        Rectangle rect = shp.getBounds();
        Point startPoint1 = new Point(rect.x, rect.y);
        Point endPoint1 = new Point((rect.width + rect.x), (rect.height + rect.y));

        this.shapeProperty.setStartPoint(startPoint1);
        this.shapeProperty.setEndPoint(endPoint1);
    }

    @Override
    public void deleteShape() {
        CollectionRepo.shapeCollection.remove(this);
    }

    @Override
    public void undo() {
        deleteShape();
    }

    @Override
    public void redo() {
        create();
    }


    @Override
    public String toString() {
        return "DrawShape{" +
                "\n\t, paintCanvas=" + paintCanvas +
                "\n\t, shapeProperty=" + shapeProperty.toString() +
                "\n\t, shape=" + shape +
                "\n\t, shape bounds =" + shape.getBounds() +
                "\n}\n";
    }
}
