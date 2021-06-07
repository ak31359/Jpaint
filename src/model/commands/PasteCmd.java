package model.commands;

import model.Paste;
import model.collection.CollectionRepo;
import model.interfaces.Cmd;
import model.interfaces.UndoInterface;

public class PasteCmd implements Cmd, UndoInterface {
    Paste pasteShape;

    public PasteCmd(Paste pasteShape) {
        this.pasteShape = pasteShape;
    }

    @Override
    public void run() {


        boolean result = !CollectionRepo.clipboardShapeCollection.getList().isEmpty();
        if (result) {
            pasteShape.paste();
            CommandHistory.add(this);
        }
    }

    @Override
    public void undo() {
        pasteShape.undo();
    }

    @Override
    public void redo() {
        pasteShape.redo();
    }
}
