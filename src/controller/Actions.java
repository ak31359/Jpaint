package controller;

import model.*;
import model.commands.*;
import view.EventName;
import view.interfaces.UIModuleInterface;
import view.interfaces.PCanvasFoundation;

public class Actions implements PaintControllerInterface {
    private final UIModuleInterface uiModule;
    PaintObservable paintObservable;
    private PCanvasFoundation paintCanvas;

    public Actions(UIModuleInterface uiModule, PCanvasFoundation paintCanvas, PaintObservable paintObservable) {
        this.uiModule = uiModule;
        this.paintCanvas = paintCanvas;
        this.paintObservable = paintObservable;
    }

    @Override
    public void setup() {
        setupEvents();
    }


    private void setupEvents() {
        uiModule.addEvent(EventName.UNDO, () -> UndoProcess());
        uiModule.addEvent(EventName.REDO, () -> RedoProcess());
        uiModule.addEvent(EventName.COPY, () -> CopyProcess());
        uiModule.addEvent(EventName.PASTE, () -> PasteProcess());
        uiModule.addEvent(EventName.DELETE, () -> DeleteProcess());
        uiModule.addEvent(EventName.GROUP, () -> GroupProcess());
        uiModule.addEvent(EventName.UNGROUP, () -> UngroupProcess());
    }


    public void UndoProcess() {

        Undo undo = new Undo(paintObservable);
        UndoCmd undoCommand = new UndoCmd(undo);
        undoCommand.run();

    }

    public void RedoProcess() {

        Redo redo = new Redo(paintObservable);
        RedoCmd redoCommand = new RedoCmd(redo);
        redoCommand.run();
    }

    public void CopyProcess() {

        CopyShape copyShape = new CopyShape(paintCanvas);
        CopyCmd copyShapeCommand = new CopyCmd(copyShape);
        copyShapeCommand.run();
    }

    public void PasteProcess() {

        Paste pasteShape = new Paste(paintCanvas);
        PasteCmd pasteShapeCommand = new PasteCmd(pasteShape);
        pasteShapeCommand.run();
    }

    public void DeleteProcess() {

        DeleteShape deleteShape = new DeleteShape(paintCanvas);
        DeleteCmd deleteShapeCommand = new DeleteCmd(deleteShape);
        deleteShapeCommand.run();
    }


    public void GroupProcess() {
        CollectionGrouping groupShape = new CollectionGrouping(paintCanvas);
        GroupCmd groupShapeCommand = new GroupCmd(groupShape);
        groupShapeCommand.run();
    }
    public void UngroupProcess() {
        CollectionUngrouping ungroupShape = new CollectionUngrouping(paintCanvas);
        UngroupCmd ungroupShapeCommand = new UngroupCmd(ungroupShape);
        ungroupShapeCommand.run();

    }
}
