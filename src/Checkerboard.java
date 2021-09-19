/* * File: Checkerboard.java
 * -----------------------
 * 绘制棋盘的实例.
 * */
import acm.graphics.*;
import acm.program.*;
public class Checkerboard extends GraphicsProgram {
    /* 行数 */
    private static final int NROWS = 8;
    /* 列数 */
    private static final int NCOLUMNS = 8;
    /* 程序入口 */
    public void run() {
        int sqSize = getHeight() / NROWS;//计算方块边长
        for (int i = 0; i < NROWS; i++) {
            for (int j = 0; j < NCOLUMNS; j++) {
                int x = j * sqSize;
                int y = i * sqSize;
                GRect sq = new GRect(x, y, sqSize, sqSize);
                sq.setFilled(((i + j) % 2) != 0);
                add(sq);
            }
        }
    }
}