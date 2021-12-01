/**
 * @program: JavaProgromming
 * @description: This programs shows an example of threads to simulate running a race.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-20 16:45
 */

import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class ThreadsExample extends GraphicsProgram {
    public void run() {
        racers = new RacingSquare[NUM_RACERS];
        finished = new boolean[NUM_RACERS];
        threads = new Thread[NUM_RACERS];
        //finish line
        add(new GLine(510, 0, 510, 400));
        add(new JButton("Start"), SOUTH);
        addActionListeners();
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Start")) {

            for (int i = 0; i < NUM_RACERS; i++) {
                if (racers[i] != null) {
                    remove(racers[i]);
                }
                // create new racer
                racers[i] = new RacingSquare(i, finished);
                add(racers[i], 10, 10 + (40 * i));
                // send the new racer along its way
                // (on a separate thread)
                threads[i] = new Thread(racers[i]);
                threads[i].start();
            }
        }

    }

    /*private instance variables*/
    private Thread[] threads;
    private RacingSquare[] racers;
    private boolean[] finished;

    /*constants*/
    private static final int NUM_RACERS = 2;
}
