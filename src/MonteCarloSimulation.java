/**
 * @program: Program
 * @description: This program uses Monte Carlo method to simulate PI
 * @author: Shawn Yang
 * @create: 2021-09-17 23:06
 **/

import java.awt.*;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class MonteCarloSimulation extends GraphicsProgram {

    private static final int SENTINEL = 50000;

    public void run() {
        int screen_Width = getWidth();//获取窗口的宽度
        int screen_Height = getHeight();//获取窗口的高度
        int x = screen_Width / 2 - BOX_WIDTH / 2;//计算方框的x坐标
        int y = screen_Height / 2 - BOX_HEIGHT / 2; //计算方框y坐标

        //Draw a retangular
        drawRect(x, y, BOX_WIDTH, BOX_HEIGHT, Color.RED);

        //Draw a circle
        drawOval(x, y, BOX_WIDTH, BOX_HEIGHT, Color.RED, false);

        //Draw a label
        GLabel msg = new GLabel("PI:", 20, 30);
        msg.setFont("SansSerif-18");
        msg.setColor(Color.RED);
        add(msg);

        int inside = 0; //The number of inside
        int total = 0; //The number of total
        while (total != SENTINEL) {
            int x1 = rg.nextInt(x, x + BOX_WIDTH);
            int y1 = rg.nextInt(y, y + BOX_HEIGHT);
            drawOval(x1, y1, DOT_WIDTH, DOT_HEIGHT, Color.BLUE, true);
            total++;
            /*Judge whether the point falls outside the circle*/
            if (distance(x1, y1, x + BOX_WIDTH / 2, y + BOX_HEIGHT / 2) < BOX_WIDTH / 2) inside++;
            /*Caculate value of the PI*/
            String pi = "PI:" + ((double) inside / total) * 4;
            msg.setLabel(pi);
            pause(10);
        }
    }

   /**
   * @Description:
   * @param: px
   * @return:
   * @author: Shawn Yang
   * @DateTime: 2021/9/19 5:54 下午
   */
    private double distance(int px, int py, int x, int y) {
        return Math.sqrt(Math.pow(px - x, 2) + Math.pow(py - y, 2));
    }

    /**
     * @Description:
     * @param: [x, y, width, height, color, ifFilled]
     * @return: void
     * @author: Shawn Yang
     * @DateTime: 2021/9/19 6:00 下午
     */
    void drawOval(int x, int y, int width, int height, Color color, boolean ifFilled) {

        GOval oval = new GOval(x, y, width, height);
        oval.setColor(color);
        oval.setFilled(ifFilled);
        add(oval);
    }

    /**
     * @Description: Draw a Rectangular
     * @param: [x, y, width, height, color]
     * @return: void
     * @author: Shawn Yang
     * @DateTime: 2021/9/17 6:13 下午
     */
    private void drawRect(int x, int y, int width, int height, Color color) {
        GRect rect = new GRect(x, y, width, height);
        rect.setColor(color);
        add(rect);
    }


    private static final int BOX_WIDTH = 400;

    private static final int BOX_HEIGHT = 400;

    private static final int DOT_WIDTH = 5;

    private static final int DOT_HEIGHT = 5;

    private RandomGenerator rg = RandomGenerator.getInstance();
}