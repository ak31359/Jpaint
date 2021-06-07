package model.dialogs;

import model.MouseMode;
import model.interfaces.AppState;
import view.interfaces.DChoiceInterface;

public class DialogPointer implements DChoiceInterface<MouseMode> {
    private final AppState applicationState;

    public DialogPointer(AppState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Start and End Point Mode";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public MouseMode[] getDialogOptions() {
        return MouseMode.values();
    }

    @Override
    public MouseMode getCurrentSelection() {
        return applicationState.getActiveMouseMode();
    }
}
