package model.util;

import java.awt.*;

public class CollisionUtility {

    public static boolean detect(Shape shape, Shape otherShape) {
        Rectangle rect1 = shape.getBounds();
        Rectangle rect2 = otherShape.getBounds();

        boolean collisionDetected = false;

        if (rect1.x < rect2.x + rect2.width &&
                rect1.x + rect1.width > rect2.x &&
                rect1.y < rect2.y + rect2.height &&
                rect1.y + rect1.height > rect2.y) {

            collisionDetected = true;
        }

        return collisionDetected;
    }
}
