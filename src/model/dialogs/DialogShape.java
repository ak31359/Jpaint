package model.dialogs;

import model.ShapeType;
import model.interfaces.AppState;
import view.interfaces.DChoiceInterface;

public class DialogShape implements DChoiceInterface<ShapeType> {
    private final AppState applicationState;

    public DialogShape(AppState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Shape";
    }

    @Override
    public String getDialogText() {
        return "Select a shape from the menu below:";
    }

    @Override
    public ShapeType[] getDialogOptions() {
        return ShapeType.values();
    }

    @Override
    public ShapeType getCurrentSelection() {
        return applicationState.getActiveShapeType();
    }
}
