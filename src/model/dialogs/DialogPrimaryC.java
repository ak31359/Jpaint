package model.dialogs;

import model.ShapeColor;
import model.interfaces.AppState;
import view.interfaces.DChoiceInterface;

public class DialogPrimaryC implements DChoiceInterface<ShapeColor> {

    private final AppState applicationState;

    public DialogPrimaryC(AppState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Primary Color";
    }

    @Override
    public String getDialogText() {
        return "Select a primary color from the menu below:";
    }

    @Override
    public ShapeColor[] getDialogOptions() {
        return ShapeColor.values();
    }

    @Override
    public ShapeColor getCurrentSelection() {
        return applicationState.getActivePrimaryColor();
    }
}
