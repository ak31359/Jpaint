package model.commands;

import model.Undo;
import model.interfaces.Cmd;

public class UndoCmd implements Cmd {
    Undo undo;

    public UndoCmd(Undo undo) {
        this.undo = undo;
    }

    @Override
    public void run() {
        undo.operate();
    }
}
