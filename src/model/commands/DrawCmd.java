package model.commands;

import model.interfaces.Cmd;
import model.interfaces.ShapeDraw;
import model.interfaces.UndoInterface;

public class DrawCmd implements Cmd, UndoInterface {

    ShapeDraw drawShape;

    public DrawCmd(ShapeDraw shapeCreator) {
        this.drawShape = shapeCreator;
    }

    @Override
    public void run() {
        drawShape.draw();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        ((UndoInterface) drawShape).undo();
    }

    @Override
    public void redo() {
        ((UndoInterface) drawShape).redo();
    }
}
