import acm.graphics.*;
import acm.program.*;

import java.awt.*;
/**
 * @program: JavaProgromming
 * @description: A GCompound example.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-26 21:32
 */
public class GFace extends GCompound {
    private static final double EYE_WIDTH = 0.15;
    private static final double EYE_HEIGHT = 0.15;
    private static final double NOSE_WIDTH = 0.15;
    private static final double NOSE_HEIGHT = 0.10;
    private static final double MOUTH_WIDTH = 0.50;
    private static final double MOUTH_HEIGHT = 0.03;

    private GOval head;
    private GOval leftEye, rightEye;
    private GPolygon nose;
    private GRect mouth;

    public GFace(double width, double height) {
        head = new GOval(width, height);
        leftEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
        rightEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
        nose = createNose(NOSE_WIDTH * width, NOSE_HEIGHT * height);
        mouth = new GRect(MOUTH_WIDTH * width, MOUTH_HEIGHT * height);
       //将头及五官加入到GCompound对象中
        add(head, 0, 0);
        add(leftEye, (0.25 * width) - (EYE_WIDTH * width) / 2, (0.25 * height) - (EYE_HEIGHT * height) / 2);
        add(rightEye, (0.75 * width) - (EYE_WIDTH * width) / 2, (0.25 * height) - (EYE_HEIGHT * height) / 2);
        add(nose, 0.50 * width, 0.50 * height);
        add(mouth, (0.50 * width) - (MOUTH_WIDTH * width) / 2, (0.75 * height) - (MOUTH_HEIGHT * height) / 2);
    }

    private GPolygon createNose(double width, double height) {
        GPolygon nose = new GPolygon();
        nose.addVertex(0, -height / 2);
        nose.addVertex(width / 2, height / 2);
        nose.addVertex(-width / 2, height / 2);
        return nose;
    }


}
