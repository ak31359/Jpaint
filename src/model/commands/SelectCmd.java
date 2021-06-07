package model.commands;

import model.Select;
import model.interfaces.Cmd;

public class SelectCmd implements Cmd {
    Select selectShape;

    public SelectCmd(Select selectShape) {
        this.selectShape = selectShape;
    }

    @Override
    public void run() {
        selectShape.operate();
    }

}
