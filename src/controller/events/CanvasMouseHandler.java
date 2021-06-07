package controller.events;

import model.interfaces.AppState;
import model.interfaces.Mode;
import model.mode.DrawMode;
import model.mode.MoveMode;
import model.mode.SelectMode;
import view.interfaces.PCanvasFoundation;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasMouseHandler extends MouseAdapter {

    private PCanvasFoundation paintCanvas;
    private Point start, end;
    private AppState appState;
    private int dragX = 0;
    private int dragY = 0;
    private MoveMode moveMode = null;
    private boolean mouseDragged = false;

    public CanvasMouseHandler(PCanvasFoundation paintCanvas, AppState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        start = e.getPoint();
        end = e.getPoint();


        dragX = e.getX();
        dragY = e.getY();

        mouseDragged = false;

    }



    @SuppressWarnings("incomplete-switch")
	public void mouseDragged(MouseEvent e) {

        mouseDragged = true;

        int currX = e.getX();
        int currY = e.getY();

        switch (appState.getActiveMouseMode()) {
            case MOVE:

                int translateXX = currX - dragX;
                int translateYY = currY - dragY;
                Point transformPos = new Point(translateXX, translateYY);


                dragX = currX;
                dragY = currY;


                moveMode = new MoveMode(start, transformPos, paintCanvas, appState);
                moveMode.operate();

                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        end = e.getPoint();


        Mode mode = null;

        switch (appState.getActiveMouseMode()) {
            case DRAW:
                mode = new DrawMode(start, end, paintCanvas, appState);
                break;
            case SELECT:
                mode = new SelectMode(start, end, paintCanvas, appState);
                break;
            case MOVE:
                if (mouseDragged && moveMode != null) {
                    moveMode.lockMovement(end);
                }

                break;
        }

        if (mode != null) {
            mode.operate();
        }
    }
}
