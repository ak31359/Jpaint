package model.dialogs;

import model.ShadingType;
import model.interfaces.AppState;
import view.interfaces.DChoiceInterface;

public class DialogShadingType implements DChoiceInterface<ShadingType> {
    private final AppState applicationState;

    public DialogShadingType(AppState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Shading Type";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public ShadingType[] getDialogOptions() {
        return ShadingType.values();
    }

    @Override
    public ShadingType getCurrentSelection() {
        return applicationState.getActiveShapeShadingType();
    }
}
