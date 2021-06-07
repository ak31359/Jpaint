package model.dialogs;

import model.ShapeColor;
import model.interfaces.AppState;
import view.interfaces.DChoiceInterface;

public class DialogSecondaryC implements DChoiceInterface<ShapeColor> {

    private final AppState applicationState;

    public DialogSecondaryC(AppState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Secondary Color";
    }

    @Override
    public String getDialogText() {
        return "Select a secondary color from the menu below:";
    }

    @Override
    public ShapeColor[] getDialogOptions() {
        return ShapeColor.values();
    }

    @Override
    public ShapeColor getCurrentSelection() {
        return applicationState.getActiveSecondaryColor();
    }
}
