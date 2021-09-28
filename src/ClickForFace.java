
import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
/**
 * @program: JavaProgromming
 * @description: This program displays a face in every location the user  clicks on. It is an example of an event-driven program.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-28 10:53
 */
public class ClickForFace extends GraphicsProgram {
    /* Private constants */
    private static final double FACE_DIAM = 30;

    //Note:no run() method is this program
    //init() method is called when program starts
    public void init() {
        // Must call this method to be able to get mouse events
        addMouseListeners();

    }

    // This method is called everytime user clicks mouse
    public void  mouseClicked(MouseEvent e) {
        print("test");
        GFace face = new GFace(FACE_DIAM, FACE_DIAM);
        add(face, e.getX(),e.getY());
    }
}


