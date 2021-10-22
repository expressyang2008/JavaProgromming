/**
 * @program: JavaProgromming
 * @description: 该程序建立了GLabel型ArrayList后，当点击鼠标时向ArrayList添加数据，并输出
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-14 18:03
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import acm.graphics.*;
import acm.program.*;

public class GraphicNumbers extends GraphicsProgram{
    private static final double START_X = 50;
    private static final double START_Y = 100;

    private ArrayList <GLabel> labels = new ArrayList<GLabel>();

    public void run(){
        addMouseListeners();
    }

    public void mouseClicked(MouseEvent e){
        GLabel lab = new GLabel("# " + labels.size() );
        lab.setFont("Courier-18");

        double dy = lab.getHeight();

//        for(int i = 0; i < labels.size(); i++){
//            labels.get(i).move(0, dy);
//        }

        for(GLabel lab2:labels){
            lab2.move(0, dy);
        }

        add(lab , START_X , START_Y);
        labels.add(lab);
    }
}
