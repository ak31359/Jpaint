package model.interfaces;

import model.ShapeColor;
import model.ShadingType;
import model.ShapeType;
import model.MouseMode;

public interface AppState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShadingType getActiveShapeShadingType();

    MouseMode getActiveMouseMode();
}
