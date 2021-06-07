package model.commands;

import model.CollectionGrouping;
import model.collection.CollectionRepo;
import model.interfaces.Cmd;
import model.interfaces.UndoInterface;

import java.awt.*;

@SuppressWarnings("unused")
public class GroupCmd implements Cmd, UndoInterface {
    CollectionGrouping groupShape;

    public GroupCmd(CollectionGrouping groupShape) {
        this.groupShape = groupShape;
    }

    @Override
    public void run() {
        boolean result = !CollectionRepo.selectedCollection.getList().isEmpty();
        if (result) {
            groupShape.group();
            CommandHistory.add(this);
        }
    }

    @Override
    public void undo() {
        groupShape.undo();
    }

    @Override
    public void redo() {
        groupShape.redo();
    }
}
