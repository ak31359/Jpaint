package model;


import model.collection.CollectionRepo;
import model.interfaces.ShapeInterface;
import view.interfaces.PCanvasFoundation;

import java.util.List;

public class CopyShape {

    List<ShapeInterface> selectedShapes = CollectionRepo.selectedCollection.getList();
    List<ShapeInterface> CBList = CollectionRepo.clipboardShapeCollection.getList();
    @SuppressWarnings("unused")
	private PCanvasFoundation paintCanvas;


    public CopyShape(PCanvasFoundation paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void copy() {
        CBList.clear();

        for (ShapeInterface selectedShape : selectedShapes) {
            ShapeInterface copiedShape = selectedShape.copyShape();
            CBList.add(copiedShape);
        }
    }
}