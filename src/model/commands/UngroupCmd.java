package model.commands;

import model.CollectionUngrouping;
import model.interfaces.Cmd;
import model.interfaces.UndoInterface;

public class UngroupCmd implements Cmd, UndoInterface {
    CollectionUngrouping ungroupShape;

    public UngroupCmd(CollectionUngrouping groupShape) {
        this.ungroupShape = groupShape;
    }

    @Override
    public void run() {

        ungroupShape.ungroup();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        ungroupShape.undo();
    }

    @Override
    public void redo() {
        ungroupShape.redo();
    }
}
