package model;

import model.collection.CollectionRepo;
import model.interfaces.ShapeInterface;
import model.interfaces.UndoInterface;
import view.interfaces.PCanvasFoundation;

import java.util.ArrayList;
import java.util.List;


public class DeleteShape implements UndoInterface {

    private PCanvasFoundation paintCanvas;


    private List<ShapeInterface> binShapes = new ArrayList<ShapeInterface>();

    public DeleteShape(PCanvasFoundation paintCanvas) {
        this.paintCanvas = paintCanvas;

        binShapes.addAll(CollectionRepo.selectedCollection.getList());
    }

    public void delete() {
        for (ShapeInterface toBeDeletedShape : binShapes) {
            toBeDeletedShape.deleteShape();
        }
        paintCanvas.repaint();
    }

    @Override
    public void undo() {

        for (ShapeInterface deletedShape : binShapes) {
            deletedShape.create();
        }

        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        delete();
    }
}
