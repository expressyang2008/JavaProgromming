/**
 * @program: JavaProgromming
 * @description: This program displays the (x, y) location of the mouse.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-28 11:00
 */

import acm.program.*;
import acm.graphics.*;

import java.awt.event.*;

public class MouseTracker extends GraphicsProgram {
    public void run() {

        label = new GLabel("");
        label.setFont("Times New Roman-36");
        add(label, 50, 50);
        // Must call this method to be able to get mouse events
        addMouseListeners();
    }

    // This method is called everytime user moves mouse
    public void mouseMoved(MouseEvent e) {
        label.setLabel("Mouse: (" + e.getX() + ", " + e.getY() + ")");
    }

    /* Private instance variable */
    private GLabel label;

}
