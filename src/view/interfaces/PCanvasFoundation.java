package view.interfaces;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public abstract class PCanvasFoundation extends JComponent {
    public abstract Graphics2D getGraphics2D();

}

