/**
 * @program: JavaProgromming
 * @description: This is a subclass of JComponent that represents a label that redraws itself to wherever the user clicks the mouse.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-25 14:34
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MovingLabel extends JComponent implements MouseListener{
    public MovingLabel(String labelText, int startX, int startY) {
        text = labelText;
        x = startX;
        y = startY;
        addMouseListener(this);
    }

    public static void main(String[] args){
        new MovingLabel("text",50,50);

    }

    public void paintComponent(Graphics g) {
        g.setFont(new Font("Times New Roman", Font.BOLD, 24));
        g.drawString(text, x, y);
    }

    /* Implementing the MouseListener interface */
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }

    /* Private instance variables */
    private String text;
    private int x;
    private int y;
}
