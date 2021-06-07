package model;

import model.commands.CommandHistory;
import view.interfaces.PCanvasFoundation;

public class Redo {
    PaintObservable paintObservable;
    @SuppressWarnings("unused")
	private PCanvasFoundation paintCanvas;

    public Redo(PaintObservable paintObservable) {
        this.paintObservable = paintObservable;
    }

    public void operate() {
        CommandHistory.redo();
        paintObservable.notifyUpdate();
    }
}
