package model;


import model.collection.CollectionRepo;
import model.interfaces.ShapeInterface;
import model.interfaces.UndoInterface;
import model.util.BBUtility;
import model.util.CollisionUtility;
import view.interfaces.PCanvasFoundation;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class CollectionGrouping implements ShapeInterface, UndoInterface {

    List<ShapeInterface> groupedShapes = new ArrayList<>();
    private PCanvasFoundation paintCanvas;
    private Graphics2D graphics2d;
    private Shape boundingBox;

    public CollectionGrouping(CollectionGrouping groupShape) {
        this.paintCanvas = groupShape.paintCanvas;
        this.graphics2d = groupShape.paintCanvas.getGraphics2D();

        for (ShapeInterface groupedShapes : groupShape.getList()) {
            this.add(groupedShapes.copyShape());
        }
        this.createBoundingBox();
    }

    public CollectionGrouping(PCanvasFoundation paintCanvas) {
        this.paintCanvas = paintCanvas;
        this.graphics2d = paintCanvas.getGraphics2D();
    }

    public void add(ShapeInterface ShapeInterface) {
        if (!groupedShapes.contains(ShapeInterface)) {
            groupedShapes.add(ShapeInterface);

            this.createBoundingBox();
        }
    }

    public void remove(ShapeInterface ShapeInterface) {
        groupedShapes.add(ShapeInterface);
        this.createBoundingBox();
    }

    public List<ShapeInterface> getList() {
        return groupedShapes;
    }

    public void group() {
        SelectBoundingBox selectBoundingBox = SelectBoundingBox.getInstance();

        List<ShapeInterface> selectedCollectionList = CollectionRepo.selectedCollection.getList();

        if (selectedCollectionList != null) {
            for (ShapeInterface ShapeInterface : selectedCollectionList) {
                this.add(ShapeInterface);
            }
            CollectionRepo.selectedCollection.removeAll(this.groupedShapes);
            CollectionRepo.selectedCollection.add(this);
            create();
            selectBoundingBox.drawBoundingBox(graphics2d);
            drawBoundingBox();
        }
    }

    public void drawBoundingBox() {
        graphics2d.setStroke(new BasicStroke(10.0f));
        graphics2d.setPaint(Color.MAGENTA);
        graphics2d.draw(this.getBoundingBox());
        graphics2d.setColor(Color.black);
        graphics2d.setFont(new Font("default", Font.BOLD, 16));
        graphics2d.drawString(" (Group bounding box)", this.getBoundingBox().getBounds().x, this.getBoundingBox().getBounds().y);
    }

    public void unGroup() {
        for (ShapeInterface ShapeInterface : groupedShapes) {
            CollectionRepo.shapeCollection.add(ShapeInterface);
        }
        CollectionRepo.shapeCollection.remove(this);
        CollectionRepo.selectedCollection.remove(this);
    }

    @Override
    public List<ShapeInterface> getNodeList() {
        List<ShapeInterface> newList = new ArrayList<>();

        for (ShapeInterface ShapeInterface : groupedShapes) {
            newList.addAll(ShapeInterface.getNodeList());
        }
        return newList;
    }


    @Override
    public void create() {
        CollectionRepo.shapeCollection.add(this);

        for (ShapeInterface ShapeInterface : this.groupedShapes) {
            CollectionRepo.shapeCollection.remove(ShapeInterface);
        }

        this.createBoundingBox();
    }


    private void createBoundingBox() {
        List<Shape> groupShapeBounds = new ArrayList<>();

        for (ShapeInterface group : groupedShapes) {
            Shape rect = group.getBoundingBox();
            if (!groupShapeBounds.contains(rect)) {
                groupShapeBounds.add(group.getBoundingBox());
            }
        }

        BBUtility BBUtility = new BBUtility(groupShapeBounds);
        this.boundingBox = BBUtility.getBoundingBox();
    }

    @Override
    public Shape getBoundingBox() {
        return boundingBox;
    }

    @Override
    public void setGraphics2d(Graphics2D graphics2d) {
        this.graphics2d = graphics2d;
    }

    @Override
    public void paintShapeOnCanvas() {
        for (ShapeInterface ShapeInterface : groupedShapes) {
            ShapeInterface.setGraphics2d(graphics2d);
            ShapeInterface.paintShapeOnCanvas();
        }
    }

    @Override
    public void highlightShape() {
        for (ShapeInterface ShapeInterface : groupedShapes) {
            ShapeInterface.highlightShape();
        }
    }

    @Override
    public boolean detectCollision(Shape otherShape) {

        createBoundingBox();
        boolean collisionDetected = CollisionUtility.detect(boundingBox, otherShape);
        return collisionDetected;
    }


    @Override
    public ShapeInterface copyShape() {
        CollectionGrouping gs = new CollectionGrouping(this);
        return gs;
    }

    @Override
    public ShapeInterface pasteShape() {
        CollectionGrouping gs = new CollectionGrouping(paintCanvas);
        for (ShapeInterface ShapeInterface : groupedShapes) {
            gs.add(ShapeInterface.pasteShape());
        }
        gs.create();
        return gs;
    }

    @Override
    public void deleteShape() {
        unGroup();
        for (ShapeInterface ShapeInterface : groupedShapes) {
            ShapeInterface.deleteShape();
        }
    }

    @Override
    public void moveShape(int transformOffsetX, int transformOffsetY) {
        AffineTransform transform = new AffineTransform();

        transform.translate(transformOffsetX, transformOffsetY);

        boundingBox = transform.createTransformedShape(boundingBox);

        for (ShapeInterface ShapeInterface : groupedShapes) {
            ShapeInterface.moveShape(transformOffsetX, transformOffsetY);
        }
    }

    @Override
    public void undo() {
        unGroup();
    }

    @Override
    public void redo() {
        create();
    }

    @Override
    public String toString() {
        return "GroupShape{" +
                "\n\t, boundingBox=" + boundingBox +
                "\n\t, groupedShapes=\n\t" + groupedShapes.toString() +
                '}';
    }
}
