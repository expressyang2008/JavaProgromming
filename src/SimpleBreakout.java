/**
 * @program: JavaProgromming
 * @description: This is a simple version of Breakout
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-25 01:37
 */

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;

public class SimpleBreakout extends GraphicsProgram {
    /**
     * 窗口大小
     */
    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 400;

    /**
     * 游戏界面大小
     */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;


    /**
     * 每一行的砖块数
     */
    private static final int NBRICKS_PER_ROW = 10;


    /**
     * 每个砖块之间的距离
     */
    private static final int BRICK_SEP = 4;

    /**
     * 砖块的宽度
     */
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /**
     * 砖块的高度
     */
    private static final int BRICK_HEIGHT = 12;

    /**
     * 小球的半径
     */
    private static final int BALL_RADIUS = 10;

    /**
     * 砖块距离顶部的高度
     */
    private static final int BRICK_Y_OFFSET = 70;


    private static final int DELAY = 100;


    public void run() {
        setup();
        play();
    }

    //enviroment init
    private void setup() {
        createWall();
        createBall();
        createMsg();
    }

    private void play() {
        xVel = 5;
        yVel = 5;
        while (counter != NBRICKS_PER_ROW) {
            moveBall();
            checkForMarginCollision();
            checkForBricksCollision();
            pause(DELAY);
        }

        updateMsg("Finished!");

    }

    /* 边缘碰撞检测*/
    private void checkForMarginCollision() {
        //check for bottom margin of application
        if (ball.getY() > HEIGHT - ball.getHeight()) {
            yVel = -1 * yVel;
        }
        //check for right margin of application
        else if (ball.getX() > WIDTH - ball.getWidth()) {
            xVel = -1 * xVel;
        }
        //check for left margin of application
        else if (ball.getX() < 0) {
            xVel = -1 * xVel;
        }
        //check for top margin of application
        else if (ball.getY() < 0) {
            yVel = -1 * yVel;
        }
    }

    //砖块碰撞检测
    private void checkForBricksCollision() {
        GObject obj = getCollidingObject();
        if (obj != null && obj != msg) {
            yVel = -1 * yVel;
            counter++;
            remove(obj);
            String msg = "Hit time:" + counter;
            updateMsg(msg);
        }
    }


    private void moveBall() {
        ball.move(xVel, yVel);
    }

    //Update message.
    private void updateMsg(String msg1) {
        msg.setLabel(msg1);
    }


    //Create a wall
    private void createWall() {
        double rowWidth = (NBRICKS_PER_ROW * BRICK_WIDTH) + ((NBRICKS_PER_ROW - 1) * BRICK_SEP);
        double xOffset = (WIDTH - rowWidth) / 2;
        for (int i = 0; i < NBRICKS_PER_ROW; i++) {
            double x = xOffset + i * (BRICK_WIDTH + BRICK_SEP);
            brick = new GRect(x, BRICK_Y_OFFSET, BRICK_WIDTH, BRICK_HEIGHT);
            brick.setFilled(true);
            brick.setColor(Color.GREEN);
            add(brick);
        }
    }

    /**
     * Checks the four corners of the rectangle binding the ball
     * for bricks
     *
     * @return returns colliding object or null
     */
    private GObject getCollidingObject() {
        // Coordinates of the top left corner of the bounding rectangle of the ball
        double x = ball.getX();
        double y = ball.getY();
        if (getElementAt(x, y) != null) {
            return getElementAt(ball.getX(), ball.getY());
        } else if (getElementAt(x + 2 * BALL_RADIUS, y) != null) {
            return getElementAt(x + 2 * BALL_RADIUS, ball.getY());
        } else if (getElementAt(x, y + 2 * BALL_RADIUS) != null) {
            return getElementAt(ball.getX(), y + 2 * BALL_RADIUS);
        } else if (getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS) != null) {
            return getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS);
        } else {
            return null;
        }
    }


    //Create a ball
    private void createBall() {
        ball = new GOval(getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS,
                BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        add(ball);
    }

    private void createMsg() {
        msg = new GLabel("Hit Times:");
        msg.setColor(Color.blue);
        msg.setFont("siri-36");
        add(msg, getWidth() / 2 - msg.getWidth() / 2, getHeight() / 2 - msg.getAscent() / 2);
    }


    private GRect brick;
    static private GOval ball;
    private GLabel msg;
    private int counter = 0;// hit times
    private double xVel, yVel; //velocity of ball
    private RandomGenerator rgen = RandomGenerator.getInstance();
}
