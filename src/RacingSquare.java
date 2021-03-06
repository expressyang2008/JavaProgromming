/**
 * @program: JavaProgromming
 * @description:This class is an example of a runnable class that animates
 * a square running a race.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-20 15:41
 */

import acm.graphics.*;
import acm.util.*;

import java.awt.*;

public class RacingSquare extends GRect implements Runnable {
    public RacingSquare(int index, boolean[] finished) {
        super(SIZE, SIZE);
        setFilled(true);
        myIndex = index;
        finishers = finished;
    }

    @Override
    public void run() {
        //have not finished when we start
        finishers[myIndex] = false;

        // run the race
        for (int i = 0; i < 100; i++) {
            //pause(rgen.nextInt(50, 150));
            pause(40);
            move(STEP, 0);
        }

        // count how many others finished before me
        int count = 0;
        for (int i = 0; i < finishers.length; i++) {
            if (finishers[i]) count++;
        }
        // perhaps do a victory dance
        //pause(50);

        //mark myself as having dance
        finishers[myIndex] = true;

        //if no one finished before me,then i win!(turn red)
        if (count == 0) {
            setColor(Color.RED);
        }
    }

    /* constants */
    private static final double SIZE = 20;
    private static final double STEP = 5;

    /* private instance variables*/
    private int myIndex;
    private boolean[] finishers;
    private RandomGenerator rgen = RandomGenerator.getInstance();
}
