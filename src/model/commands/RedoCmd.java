package model.commands;

import model.Redo;
import model.interfaces.Cmd;

public class RedoCmd implements Cmd {
    Redo redo;

    public RedoCmd(Redo redo) {
        this.redo = redo;
    }

    @Override
    public void run() {
        redo.operate();
    }
}
