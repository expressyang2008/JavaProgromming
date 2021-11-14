/**
 * @program: I devote my life to guess a word.
 * @description:
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-09 09:51
 */
import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GImage;
import acm.graphics.GPolygon;

import java.awt.*;


public class GuessWordCanvas extends GCanvas {
    /**
     * Resets the display so that only the scaffold appears
     */
    public void reset() {
        removeAll();
        GLine beam = new GLine(getWidth() / 2 - 144, 18, getWidth() / 2, 18);
        GLine rope = new GLine(getWidth() / 2, 18, getWidth() / 2, 36);
        GLine scaffold = new GLine(getWidth() / 2 - 144, 18, getWidth() / 2 - 144, 378);
        add(scaffold);
        add(rope);
        add(beam);

        image = new GImage("0.png");
        image.scale(0.3, 0.3);
        add(image, getWidth() / 2- image.getWidth()/2, 300);

        ironball = new GOval(getWidth() / 2 - BALL_RADIUS, 36, 2 * BALL_RADIUS, 2 * BALL_RADIUS);
        ironball.setFilled(true);
        add(ironball);
    }

    private void oneStepFall() {
        ironball.move(0, 24);
        image.setImage("images/1.png");
        image.scale(0.3, 0.3);
        add(image, getWidth() / 2- image.getWidth()/2, 300);
    }

    private void twoStepFall() {
        ironball.move(0, 24);
        image.setImage("2.png");
        image.scale(0.3, 0.3);
        add(image, getWidth() / 2- image.getWidth()/2, 300);
    }

    private void threeStepFall() {
        ironball.move(0, 24);
        image.setImage("3.png");
        image.scale(0.3, 0.3);
        add(image, getWidth() / 2- image.getWidth()/2, 300);
    }

    private void fourStepFall() {
        ironball.move(0, FALL_DISTANCE);
        image.setImage("4.png");
        image.scale(0.3, 0.3);
        add(image, getWidth() / 2- image.getWidth()/2, 300);
    }

    private void fiveStepFall() {
        ironball.move(0, FALL_DISTANCE);
        image.setImage("5.png");
        image.scale(0.3, 0.3);
        add(image, getWidth() / 2- image.getWidth()/2, 300);
    }

    private void sixStepFall() {
        ironball.move(0, FALL_DISTANCE);
        image.setImage("6.png");
        image.scale(0.3, 0.3);
        add(image, getWidth() / 2- image.getWidth()/2, 300);
    }

    private void sevenStepFall() {
        ironball.move(0, FALL_DISTANCE);
        image.setImage("7.png");
        image.scale(0.3, 0.3);
        add(image, getWidth() / 2- image.getWidth()/2, 300);
    }

    private void eightStepFall() {
        image.setImage("8.png");
        image.scale(0.3, 0.3);
        add(image, getWidth() / 2- image.getWidth()/2, 300);
        ironball.move(0, FALL_DISTANCE);

        GPolygon blood = new GPolygon();
        blood.addVertex(20, 0);
        blood.addEdge(-50, 50);
        blood.addEdge(50, 0);
        blood.addEdge(-50, 50);
        blood.setFilled(true);
        blood.setFillColor(Color.red);
        add(blood, getWidth() / 2, getHeight() / 2);
    }

    /**
     * Updates the word on the screen to correspond to the current
     * state of the game.  The argument string shows what letters have
     * been guessed so far; unguessed letters are indicated by hyphens.
     */
    public void displayWord(String word) {
        current.setLabel(word);
        current.setFont("SansSerif-30");
        current.setColor(Color.BLUE);
        add(current, getWidth() / 2 - 144, getHeight() - 40);
    }

    /**
     * Updates the display to correspond to an incorrect guess by the
     * user.  Calling this method causes the next body part to appear
     * on the scaffold and adds the letter to the list of incorrect
     * guesses that appears at the bottom of the window.
     */
    public void noteIncorrectGuess(char letter, int guesscount) {
        if (guesscount == 7) {
            oneStepFall();
        }
        if (guesscount == 6) {
            twoStepFall();
        }
        if (guesscount == 5) {
            threeStepFall();
        }
        if (guesscount == 4) {
            fourStepFall();
        }
        if (guesscount == 3) {
            fiveStepFall();
        }
        if (guesscount == 2) {
            sixStepFall();
        }
        if (guesscount == 1) {
            sevenStepFall();
        }
        if (guesscount == 0) {
            eightStepFall();
        }
        incorrectguess.setLabel(incorrectguess.getLabel() + letter);
        incorrectguess.setFont("SansSerif-20");
        incorrectguess.setColor(Color.red);

        add(incorrectguess, getWidth() / 2 - 144, getHeight() - 18);
    }
    /* Constants for the simple version of the picture (in pixels) */
    private GLabel current = new GLabel("");
    private GLabel incorrectguess = new GLabel("");
    private GOval ironball;
    private GImage image;
    private static final int FALL_DISTANCE = 24;
    private static final int BALL_RADIUS = 36;
}
