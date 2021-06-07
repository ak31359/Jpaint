package main;

import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    Point startPoint;
    Point endPoint;
 private PaintCanvasBase paintCanvas;

    public MouseHandler(PaintCanvasBase paintCanvas) {
        this.paintCanvas= paintCanvas;
    }

    // to assign starting points where you click
    @Override
    public void mousePressed(MouseEvent e) {
        startPoint= new Point(e.getX(),e.getY());
    }

    //to assign final points where you release
    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = new Point(e.getX(),e.getY());


        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.BLUE);
        // to draw the rectangle
        graphics2d.fillRect(startPoint.getX(),startPoint.getY(),(endPoint.getX()- startPoint.getX()),(endPoint.getY()-startPoint.getY()));
    }
}
