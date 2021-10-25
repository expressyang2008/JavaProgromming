/**
 * @program: JavaProgromming
 * @description: 使用二维数组将GImage中的图片处理成灰色
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-14 18:06
 */

import acm.graphics.*;
import acm.program.*;

public class GrayImage extends GraphicsProgram {
    public void init() {
        GImage image = new GImage("vangogh.png");

        GImage grayImage = createGrayscaleImage(image);
//        GImage grayImage = flipHorizontal(image);


        image.scale(2.0);
        add(image, 10, 10);

        grayImage.scale(2.0);
        add(grayImage, 400, 10);


    }

    private static GImage createGrayscaleImage(GImage image) {
        int[][] array = image.getPixelArray();

        int height = array.length;
        int width = array[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                int pixel = array[i][j];

                int r = GImage.getRed(pixel);
                int g = GImage.getGreen(pixel);
                int b = GImage.getBlue(pixel);

                int gray = floatChangeGray(r, g, b);

                array[i][j] = GImage.createRGBPixel(gray, gray, gray);
            }
        }

        return new GImage(array);
    }

    private static int floatChangeGray(int r, int g, int b) {
        return (int) Math.round(0.299 * r + 0.587 * g + 0.114 * b);
    }

    private GImage flipHorizontal(GImage image) {
        int[][] array = image.getPixelArray();
        int width = array[0].length;
        int height = array.length;
        for (int row = 0; row < height; row++) {
            for (int p1 = 0; p1 < width / 2; p1++) {
                int p2 = width - p1 - 1;
                int temp = array[row][p1];
                array[row][p1] = array[row][p2];
                array[row][p2] = temp;
            }
        }
        return new GImage(array);
    }
}
