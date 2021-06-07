package model;

import model.collection.CollectionRepo;
import model.interfaces.ShapeInterface;
import model.interfaces.UndoInterface;
import view.interfaces.PCanvasFoundation;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUngrouping implements UndoInterface {

    PCanvasFoundation paintCanvas;
    List<CollectionGrouping> groupShapeCollectionList;


    public CollectionUngrouping(PCanvasFoundation paintCanvas) {
        this.paintCanvas = paintCanvas;

        List<ShapeInterface> shapeCollectionList = CollectionRepo.shapeCollection.getList();

        SelectBoundingBox selectBoundingBox = SelectBoundingBox.getInstance();
        Shape selectBoundingBoxShape = selectBoundingBox.getBoundingBox();

        groupShapeCollectionList = shapeCollectionList.stream()
                .filter(ShapeInterface -> ShapeInterface instanceof CollectionGrouping)
                .map(p -> (CollectionGrouping) p)
                .filter(gs -> gs.detectCollision(selectBoundingBoxShape))
                .collect(Collectors.toList());
    }

    public void ungroup() {
        for (CollectionGrouping groupShape : groupShapeCollectionList) {
            groupShape.unGroup();
        }

        paintCanvas.repaint();
    }

    @Override
    public void undo() {
        for (CollectionGrouping groupShape : groupShapeCollectionList) {
            groupShape.create();
        }
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        ungroup();
    }
}
