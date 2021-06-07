package model.mode;

import model.Move;
import model.PaintObservable;
import model.commands.MoveCmd;
import model.interfaces.AppState;
import model.interfaces.Mode;
import view.interfaces.PCanvasFoundation;

import java.awt.*;


public class MoveMode implements Mode {
    Move moveShape;
    PaintObservable paintObservable = new PaintObservable();
    private Point startPoint;
    @SuppressWarnings("unused")
	private Point endPoint;
    private Point transformPos;
    private PCanvasFoundation paintCanvas;
    private AppState appState;


    public MoveMode(Point startPoint, Point transformPos, PCanvasFoundation paintCanvas, AppState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;

        this.transformPos = transformPos;
        this.startPoint = startPoint;
    }

    public void operate() {
        moveShape = new Move(startPoint, transformPos, paintCanvas, appState, paintObservable);
        moveShape.move();
    }

    public void lockMovement(Point endPoint) {
        moveShape.setEndPoint(endPoint);
        MoveCmd moveShapeCommand = new MoveCmd(moveShape);
        moveShapeCommand.run();
    }
}