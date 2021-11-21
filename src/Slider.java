import acm.graphics.GRect;

/**
 * @program: JavaProgromming
 * @description: This class is an example of a runnable class that animates a square sliding acrooss the screen
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-16 10:25
 */

import java.awt.*;
public class Slider extends GRect implements Runnable {
    public Slider(int size, Color color) {
        super(size, size);
        setFilled(true);
        setColor(color);
    }

    @Override
    public void run() {
        //animate a slide across the screen.
        for (int i = 0; i < 1000 / STEP; i++) {
            pause(40);
            move(STEP, 0);
        }
    }

    private static final double STEP = 5;
}
