package model.commands;

import model.Move;
import model.collection.CollectionRepo;
import model.interfaces.Cmd;
import model.interfaces.UndoInterface;

public class MoveCmd implements Cmd, UndoInterface {
    Move moveShape;

    public MoveCmd(Move moveShape) {
        this.moveShape = moveShape;

    }

    @Override
    public void run() {
        boolean result = !CollectionRepo.selectedCollection.getList().isEmpty();
        if (result) {
            moveShape.move();
            CommandHistory.add(this);
        }
    }

    @Override
    public void undo() {
        moveShape.undo();
    }

    @Override
    public void redo() {
        moveShape.redo();
    }
}
