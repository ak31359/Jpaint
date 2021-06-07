package model.commands;

import model.DeleteShape;
import model.interfaces.Cmd;
import model.interfaces.UndoInterface;

public class DeleteCmd implements Cmd, UndoInterface {
    DeleteShape deleteShape;

    public DeleteCmd(DeleteShape deleteShape) {
        this.deleteShape = deleteShape;
    }

    @Override
    public void run() {
        deleteShape.delete();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        deleteShape.undo();
    }

    @Override
    public void redo() {
        deleteShape.redo();
    }
}
