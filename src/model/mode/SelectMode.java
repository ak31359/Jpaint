package model.mode;

import model.Select;
import model.commands.SelectCmd;
import model.interfaces.AppState;
import model.interfaces.Mode;
import view.interfaces.PCanvasFoundation;

import java.awt.*;

public class SelectMode implements Mode {

    private Point startPoint;
    private Point endPoint;

    private PCanvasFoundation paintCanvas;
    private AppState appState;

    public SelectMode(Point startPoint, Point endPoint, PCanvasFoundation paintCanvas, AppState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;

        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public void operate() {
        Select selectShape = new Select(startPoint, endPoint, paintCanvas, appState);
        SelectCmd selectShapeCommand = new SelectCmd(selectShape);
        selectShapeCommand.run();
    }
}
