/**
 * @program: JavaProgromming
 * @description: This program allows users to create lines on the graphics * canvas by clicking and dragging with the mouse. The line * is redrawn from the original point to the new endpoint, which * makes it look as if it is connected with a rubber band.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-20 00:35
 */

import acm.graphics.*;
import acm.program.*;

import java.awt.event.*;

/**
 * This class allows users to drag lines on the canvas
 */
public class RubberBanding extends GraphicsProgram {
    public void run() {
        addMouseListeners();
    }

    /**
     * Called on mouse press to create a new line
     */
    public void mousePressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        line = new GLine(x, y, x, y);
        add(line);
    }

    /**
     * Called on mouse drag to reset the endpoint
     */
    public void mouseDragged(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        line.setEndPoint(x, y);
    }

    /* Private instance variables */
    private GLine line;
}