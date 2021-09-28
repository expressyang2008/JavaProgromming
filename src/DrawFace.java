import acm.program.GraphicsProgram;
import acm.program.*;

/**
 * @program: JavaProgromming
 * @description: Draw a face
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-26 21:35
 */
public class DrawFace extends GraphicsProgram {

    private static final  int FACE_WIDTH = 100;
    private static final  int FACE_HEIGHT = 200;
    public void run() {
        GFace face = new GFace(FACE_WIDTH,FACE_HEIGHT);
        add(face,(getWidth()-FACE_WIDTH)/2,(getHeight()-FACE_HEIGHT)/2);
    }

}
