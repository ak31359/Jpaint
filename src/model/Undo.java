package model;

import model.commands.CommandHistory;
import view.interfaces.PCanvasFoundation;

public class Undo {
    PaintObservable paintObservable;
    @SuppressWarnings("unused")
	private PCanvasFoundation paintCanvas;

    public Undo(PaintObservable paintObservable) {
        this.paintObservable = paintObservable;
    }

    public void operate() {
        CommandHistory.undo();
        paintObservable.notifyUpdate();
    }
}
