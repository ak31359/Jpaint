package model.mode;

import model.Draw;
import model.AwtColor;
import model.ShadingType;
import model.ShapeType;
import model.commands.DrawCmd;
import model.interfaces.AppState;
import model.interfaces.Mode;
import model.util.PropertyUtility;
import view.interfaces.PCanvasFoundation;

import java.awt.*;

public class DrawMode implements Mode {

    PropertyUtility shapeProperty;
    private Point startPoint;
    private Point endPoint;
    private PCanvasFoundation paintCanvas;
    @SuppressWarnings("unused")
	private AppState appState;

    public DrawMode(Point startPoint, Point endPoint, PCanvasFoundation paintCanvas, AppState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;

        this.startPoint = startPoint;
        this.endPoint = endPoint;

        ShapeType shapeType = appState.getActiveShapeType();
        ShadingType shadingType = appState.getActiveShapeShadingType();
        Color primaryColor = AwtColor.getColor(appState.getActivePrimaryColor());
        Color secondaryColor = AwtColor.getColor(appState.getActiveSecondaryColor());

        shapeProperty = new PropertyUtility(startPoint, endPoint);
        shapeProperty
                .setShapeType(shapeType)
                .setShadingType(shadingType)
                .setPrimaryColor(primaryColor)
                .setSecondaryColor(secondaryColor);
    }

    public void operate() {
        if (!startPoint.equals(endPoint)) {
            Draw drawShape = new Draw(paintCanvas, shapeProperty);
            DrawCmd drawShapeCommand = new DrawCmd(drawShape);
            drawShapeCommand.run();
        }
    }
}
