package model;

import model.collection.CollectionRepo;
import model.interfaces.AppState;
import model.interfaces.Observer;
import model.interfaces.ShapeInterface;
import model.interfaces.UndoInterface;
import view.interfaces.PCanvasFoundation;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Move implements UndoInterface {

    PaintObservable paintObservable;
    private Point startPoint;
    private Point endPoint = new Point();
    private Point transformOffset;
    @SuppressWarnings("unused")
	private Graphics2D graphics2d;
    @SuppressWarnings("unused")
	private PCanvasFoundation paintCanvas;
    @SuppressWarnings("unused")
	private AppState appState;

    public Move(Point startPoint, Point transformOffset, PCanvasFoundation paintCanvas, AppState appState, PaintObservable paintObservable) {
        this.graphics2d = paintCanvas.getGraphics2D();
        this.paintCanvas = paintCanvas;
        this.appState = appState;

        this.transformOffset = transformOffset;
        this.startPoint = startPoint;

        this.paintObservable = paintObservable;
        paintObservable.addObserver((Observer) paintCanvas);
    }


    public void move() {
        translate(transformOffset.x, transformOffset.y);
    }

    public void translate(int x, int y) {
        AffineTransform transform = new AffineTransform();


        transform.translate(x, y);

        for (ShapeInterface selectedShape : CollectionRepo.selectedCollection.getList()) {
            selectedShape.moveShape(x, y);
        }

        paintObservable.notifyUpdate();
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }



    @Override
    public void undo() {
        int offsetXX = startPoint.x - endPoint.x;
        int offsetYY = startPoint.y - endPoint.y;

        translate(offsetXX, offsetYY);
    }

    @Override
    public void redo() {
        int translateXX = endPoint.x - startPoint.x;
        int translateYY = endPoint.y - startPoint.y;

        translate(translateXX, translateYY);
    }
}