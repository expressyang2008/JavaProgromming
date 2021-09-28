/**
 * @program: JavaProgromming
 * @description: This is a assignment.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-25 14:32
 */

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;


public class BreakBricks extends GraphicsProgram {
    /* 窗口大小*/
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /*游戏界面大小（通常与窗口一致）*/
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /*挡板大小*/
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /*挡板距离底部高度*/
    private static final int PADDLE_Y_OFFSET = 30;

    /*每一行的砖块数*/
    private static final int NBRICKS_PER_ROW = 10;

    /*砖块的行数*/
    private static final int NBRICK_ROWS = 10;

    /*每个砖块之间的距离*/
    private static final int BRICK_SEP = 4;

    /*砖块的宽度*/
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /*砖块的高度*/
    private static final int BRICK_HEIGHT = 8;

    /* 小球的半径*/
    private static final int BALL_RADIUS = 10;

    /*砖块距离顶部的高度*/
    private static final int BRICK_Y_OFFSET = 70;

    /*游戏的机会数*/
    private static final int NTURNS = 3;

    /*初始化时小球的速度范围*/
    private static final double VMAX = 3.0;
    private static final double VMIN = 1.0;

    /*动画延迟*/
    private static final int DELAY = 10;


    /*运行游戏*/
    public void run() {

        addMouseListeners();
        setup();
        play();
    }

    /*初始化游戏设置: 砖块和挡板*/
    private void setup() {
        setupBricks();
        setupPaddle();
    }

    /* 开始游戏*/
    private void play() {


    }

    /*建立挡板*/
    private void setupPaddle() {

    }

    /*建立砖块*/
    private void setupBricks() {

    }

    /*创建小球*/
    private void createBall() {

    }

    /*移动小球*/
    private void moveBall() {

    }


    /* 当鼠标移动时重置挡板当前的位置为鼠标当前位置*/
    public void mouseMoved(MouseEvent e) {

    }

    /* 获取程序中小球碰撞到的对象*/
    private GObject getCollidingObject(){
        //完善此部分代码

        return null;
    }

    /*定义挡板，砖块，小球*/
    private GRect paddle;
    private GRect brick;
    private GOval ball;

    private double xVel, yVel;//小球的速度

    private int score; //分数
    private int turnNum; //记录游戏次数

    /* 实例化随机数生成器*/
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private GLabel scoreBoard;//分数标签
    private GLabel liveBoard;//生命标签
}
