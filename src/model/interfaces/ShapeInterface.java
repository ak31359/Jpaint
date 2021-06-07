package model.interfaces;

import java.awt.*;
import java.util.List;

public interface ShapeInterface {
    void paintShapeOnCanvas();

    void setGraphics2d(Graphics2D graphics2d);

    void highlightShape();

    boolean detectCollision(Shape otherShape);

    void deleteShape();

    Shape getBoundingBox();

    ShapeInterface copyShape();

    ShapeInterface pasteShape();

    void create();

    void moveShape(int transformOffsetX, int transformOffsetY);

    List<ShapeInterface> getNodeList();


}

