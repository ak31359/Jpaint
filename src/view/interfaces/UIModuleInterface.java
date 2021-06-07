package view.interfaces;

import view.EventName;

public interface UIModuleInterface {
    void addEvent(EventName eventName, CallbackInterface command);
    <T> T getDialogResponse(@SuppressWarnings("rawtypes") DChoiceInterface dialogChoice);
}
