package model.dialogs;

import model.ShapeColor;
import model.ShadingType;
import model.ShapeType;
import model.MouseMode;
import model.interfaces.AppState;
import model.interfaces.DProvider;
import view.interfaces.DChoiceInterface;

public class DialogProvider implements DProvider {
    private final DChoiceInterface<ShapeType> chooseShapeDialog;
    private final DChoiceInterface<ShapeColor> choosePrimaryColorDialog;
    private final DChoiceInterface<ShapeColor> chooseSecondaryColorDialog;
    private final DChoiceInterface<ShadingType> chooseShadingTypeDialog;
    private final DChoiceInterface<MouseMode> chooseStartAndEndPointModeDialog;
    private final AppState applicationState;

    public DialogProvider(AppState applicationState) {
        this.applicationState = applicationState;
        chooseShapeDialog = new DialogShape(this.applicationState);
        choosePrimaryColorDialog = new DialogPrimaryC(this.applicationState);
        chooseSecondaryColorDialog = new DialogSecondaryC(this.applicationState);
        chooseShadingTypeDialog = new DialogShadingType(this.applicationState);
        chooseStartAndEndPointModeDialog = new DialogPointer(this.applicationState);
    }

    @Override
    public DChoiceInterface<ShapeType> getChooseShapeDialog() {
        return chooseShapeDialog;
    }

    @Override
    public DChoiceInterface<ShapeColor> getChoosePrimaryColorDialog() {
        return choosePrimaryColorDialog;
    }

    @Override
    public DChoiceInterface<ShapeColor> getChooseSecondaryColorDialog() {
        return chooseSecondaryColorDialog;
    }

    @Override
    public DChoiceInterface<ShadingType> getChooseShadingTypeDialog() {
        return chooseShadingTypeDialog;
    }

    @Override
    public DChoiceInterface<MouseMode> getChooseStartAndEndPointModeDialog() {
        return chooseStartAndEndPointModeDialog;
    }
}
