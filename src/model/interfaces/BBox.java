package model.interfaces;

import java.awt.*;

public interface BBox {
    public Shape generateFromPoints(Point startPoint, Point endPoint);
    public Shape getBoundingBox();
}
