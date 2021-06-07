package view.gui;

import javax.swing.*;

import view.EventName;
import view.interfaces.DChoiceInterface;
import view.interfaces.CallbackInterface;
import view.interfaces.WindoeGUIInterface;
import view.interfaces.UIModuleInterface;

public class GUI implements UIModuleInterface {

    private final WindoeGUIInterface gui;

    public GUI(WindoeGUIInterface gui) {
        this.gui = gui;
    }
    
	@Override
	public void addEvent(EventName eventName, CallbackInterface callback) {
		JButton button = gui.getButton(eventName);
		button.addActionListener((ActionEvent) -> callback.run());
	}

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public <T> T getDialogResponse(DChoiceInterface dialogSettings) {
        Object selectedValue = JOptionPane.showInputDialog(null,
                dialogSettings.getDialogText(),
                dialogSettings.getDialogTitle(),
                JOptionPane.PLAIN_MESSAGE,
                null,
                dialogSettings.getDialogOptions(),
                dialogSettings.getCurrentSelection());
        return selectedValue == null
                ? (T)dialogSettings.getCurrentSelection()
                : (T)selectedValue;
    }
}
