package model;

import model.collection.CollectionRepo;
import model.interfaces.AppState;
import model.interfaces.ShapeInterface;
import model.interfaces.UndoInterface;
import view.interfaces.PCanvasFoundation;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Select implements UndoInterface {

    private Point startingPoint, endingPoint;


    private Graphics2D graphics2d;
    private PCanvasFoundation paintCanvas;
    @SuppressWarnings("unused")
	private AppState appState;

    public Select(Point startingPoint, Point endingPoint, PCanvasFoundation paintCanvas, AppState appState) {
        this.graphics2d = paintCanvas.getGraphics2D();
        this.paintCanvas = paintCanvas;
        this.appState = appState;

        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }


    public void operate() {
        CollectionRepo.selectedCollection.clear();

        List<ShapeInterface> shapeList = CollectionRepo.shapeCollection.getList();
        @SuppressWarnings("unused")
		ArrayList<ShapeInterface> tempList = new ArrayList<>(shapeList);

        SelectBoundingBox selectBoundingBox = SelectBoundingBox.getInstance();
        selectBoundingBox.generateFromPoints(startingPoint, endingPoint);
        selectBoundingBox.drawBoundingBox(graphics2d);

        Shape selectBoundingBoxShape = selectBoundingBox.getBoundingBox();

        for (ShapeInterface shape : shapeList) {
            if (shape.detectCollision(selectBoundingBoxShape)) {
                CollectionRepo.selectedCollection.add(shape);
            }
        }        
        paintCanvas.repaint();
    }

    public void undo() {
        CollectionRepo.selectedCollection.clear();
        paintCanvas.repaint();
    }

    public void redo() {
        operate();
        paintCanvas.repaint();
    }
}
