package model;

import model.collection.CollectionRepo;
import model.interfaces.ShapeInterface;
import model.interfaces.UndoInterface;
import view.interfaces.PCanvasFoundation;

import java.util.ArrayList;
import java.util.List;


public class Paste implements UndoInterface {

    List<ShapeInterface> shapeList = CollectionRepo.shapeCollection.getList();
    List<ShapeInterface> clipBoardList = CollectionRepo.clipboardShapeCollection.getList();
    List<ShapeInterface> pastedShapes = new ArrayList<>();
    private PCanvasFoundation paintCanvas;


    public Paste(PCanvasFoundation paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void paste() {
        pastedShapes.clear();
        for (ShapeInterface iShape : clipBoardList) {

            ShapeInterface pastedShape = iShape.pasteShape();

            shapeList.add(pastedShape);
            pastedShapes.add(pastedShape);
        }
        paintCanvas.repaint();
    }

    @Override
    public void undo() {
        for (ShapeInterface pastedShape : pastedShapes) {
            shapeList.removeAll(pastedShape.getNodeList());
        }
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        for (ShapeInterface pastedShape : pastedShapes) {
            shapeList.add(pastedShape);
        }
        paintCanvas.repaint();
    }
}
