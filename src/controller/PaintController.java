package controller;

import model.interfaces.AppState;
import view.EventName;
import view.interfaces.UIModuleInterface;

public class PaintController implements PaintControllerInterface {
    private final UIModuleInterface uiModule;
    private final AppState applicationState;

    public PaintController(UIModuleInterface uiModule, AppState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.SHAPE_CHOOSE_EVENT, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.PRIMARY_COLOR_CHOOSE_EVENT, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.SECONDARY_COLOR_CHOOSE_EVENT, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.SHADING_TYPE_CHOOSE_EVENT, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.MOUSE_MODE_CHOOSE_EVENT, () -> applicationState.setActiveStartAndEndPointMode());
    }
}
