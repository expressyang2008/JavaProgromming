import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @program: JavaProgromming
 * @description:
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-16 10:34
 */
public class SliderProgram extends GraphicsProgram {
    public void run(){
        add(new JButton("Slide"),SOUTH);
        addActionListeners();
    }

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        if(cmd.equals("Slide")){
            Slider slider = new Slider(SIZE, rgen.nextColor());
            add(slider,0,rgen.nextDouble(0,300));

            //run the slide on a new thread
            Thread sliderThread = new Thread(slider);
            sliderThread.start();
        }
    }

    /* constants */
    private static final int SIZE =20;

    /* private instance variavles*/
    private RandomGenerator rgen = RandomGenerator.getInstance();
}
