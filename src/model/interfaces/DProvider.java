package model.interfaces;

import model.ShapeColor;
import model.ShadingType;
import model.ShapeType;
import model.MouseMode;
import view.interfaces.DChoiceInterface;

public interface DProvider {

    DChoiceInterface<ShapeType> getChooseShapeDialog();

    DChoiceInterface<ShapeColor> getChoosePrimaryColorDialog();

    DChoiceInterface<ShapeColor> getChooseSecondaryColorDialog();

    DChoiceInterface<ShadingType> getChooseShadingTypeDialog();

    DChoiceInterface<MouseMode> getChooseStartAndEndPointModeDialog();
}
