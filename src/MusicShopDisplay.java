import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GRect;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * @program: JavaProgromming
 * @description:
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-28 21:26
 */
public class MusicShopDisplay extends GCanvas
        implements ComponentListener {
    //Constructor
    public MusicShopDisplay() {
        addComponentListener(this);
        lastAlbum = null;
    }

    public void displayInventory(Album album) {
        removeAll();
        lastAlbum = album;
        if (album != null) {
            int numStocked = album.getNumStocked();
            add(new GLabel("Album[" + album.getAlbumName()
                            + "] by [" + album.getBandName() + "]"), 10,
                    (getHeight() - BAR_HEIGHT / 2 - SPACER));

            //Display square s in dicating how many inventory
            double nextX = SPACER;
            for (int i = 0; i < numStocked; i++) {
                double barLength = (getWidth() / (double) MAX_INVENTORY) - SPACER;
                GRect rect = new GRect(nextX, (getHeight() - BAR_HEIGHT) / 2, barLength, BAR_HEIGHT);
                rect.setFilled(true);
                add(rect);
                nextX += barLength + SPACER;
            }
            GLabel label = new GLabel(numStocked + "in stock");
            add(label, 10, (getHeight() + BAR_HEIGHT) / 2 + SPACER + label.getAscent());
        }
    }


    public void update() {
        displayInventory(lastAlbum);
    }

    public void componentResized(ComponentEvent e) {
        update();
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    /*constants*/
    private static final double BAR_HEIGHT = 20;
    private static final double SPACER = 10;
    private static final double MAX_INVENTORY = 20;

    /*private instance variables*/
    private Album lastAlbum;

}
