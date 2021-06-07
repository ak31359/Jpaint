package model.commands;

import model.CopyShape;
import model.interfaces.Cmd;

public class CopyCmd implements Cmd {
    CopyShape copyShape;

    public CopyCmd(CopyShape copyShape) {
        this.copyShape = copyShape;
    }

    @Override
    public void run() {
        copyShape.copy();
    }
}
