package view.interfaces;

import main.MouseHandler;

import javax.swing.*;
import java.awt.*;

public abstract class PaintCanvasBase extends JComponent {
    public abstract Graphics2D getGraphics2D();
    public abstract MouseHandler mouseHandler();
}
