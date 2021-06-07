package main;

import controller.Actions;
import controller.PaintControllerInterface;
import controller.PaintController;
import controller.events.CanvasMouseHandler;
import model.PaintObservable;
import model.interfaces.Observer;
import model.persistence.AppStatePersistence;
import view.gui.GUI;
import view.gui.WindowGUI;
import view.gui.CanvasPaint;
import view.interfaces.WindoeGUIInterface;
import view.interfaces.PCanvasFoundation;
import view.interfaces.UIModuleInterface;

public class Main {
    public static void main(String[] args){
    	 PCanvasFoundation paintCanvas = new CanvasPaint();
         WindoeGUIInterface guiWindow = new WindowGUI(paintCanvas);
         UIModuleInterface uiModule = new GUI(guiWindow);
         AppStatePersistence appState = new AppStatePersistence(uiModule);
         PaintControllerInterface controller = new PaintController(uiModule, appState);


         PaintObservable paintObservable = new PaintObservable();
         paintObservable.addObserver((Observer) paintCanvas);

         PaintControllerInterface buttonActions = new Actions(uiModule, paintCanvas, paintObservable);

         controller.setup();
         buttonActions.setup();

         CanvasMouseHandler paintCanvasMouseAdapter = new CanvasMouseHandler(paintCanvas, appState);
         paintCanvas.addMouseListener(paintCanvasMouseAdapter);
         paintCanvas.addMouseMotionListener(paintCanvasMouseAdapter);
    }}

