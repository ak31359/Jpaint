package model.commands;

import model.interfaces.UndoInterface;

import java.util.Stack;

public class CommandHistory {
    private static final Stack<UndoInterface> undoStack = new Stack<UndoInterface>();
    private static final Stack<UndoInterface> redoStack = new Stack<UndoInterface>();

    public static void add(UndoInterface cmd) {
        undoStack.push(cmd);
        redoStack.clear();
    }

    public static boolean undo() {
        boolean result = !undoStack.empty();
        if (result) {
            UndoInterface c = undoStack.pop();
            redoStack.push(c);
            c.undo();
        }


        return result;
    }

    public static boolean redo() {
        boolean result = !redoStack.empty();
        if (result) {
            UndoInterface c = redoStack.pop();
            undoStack.push(c);
            c.redo();
        }

        return result;
    }

    public static Stack<UndoInterface> getUndoStack() {
        return undoStack;
    }

    public static Stack<UndoInterface> getRedoStack() {
        return redoStack;
    }
}
