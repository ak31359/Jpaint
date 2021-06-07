package view.gui;

import model.collection.CollectionRepo;
import model.interfaces.Observer;
import model.interfaces.ShapeInterface;
import view.interfaces.PCanvasFoundation;

import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class CanvasPaint extends PCanvasFoundation implements Observer {


    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        List<ShapeInterface> shapeCollectionList = CollectionRepo.shapeCollection.getList();
        List<ShapeInterface> selectedCollectionList = CollectionRepo.selectedCollection.getList();


        for (ShapeInterface shapeItem : shapeCollectionList) {
            shapeItem.setGraphics2d(g2);
            shapeItem.paintShapeOnCanvas();
            if (selectedCollectionList.contains(shapeItem)) {
                shapeItem.highlightShape();
            }
        }
    }

    @Override
    public void update() {
        this.repaint();
    }
}
