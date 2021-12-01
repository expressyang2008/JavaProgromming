/**
 * @program: JavaProgromming
 * @description: This is a Standard Java program that adds buttons at the bottom for   changing the center panel's background color to either red or blue.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-25 14:31
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class InteractorColorsSJ implements ActionListener {
    public static void main(String[] args) {
        new InteractorColorsSJ().init();
    }

    private JPanel centerPanel;

    public void init() {
        // Create our containing frame, and add interactors
        JFrame frame = new JFrame("InteractorColorsSJ");
        frame.setSize(500, 300);

        // Create a JPanel to contain our buttons
        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Red");
        button1.addActionListener(this);
        buttonPanel.add(button1);
        JButton button2 = new JButton("Blue");
        button2.addActionListener(this);
        buttonPanel.add(button2);

        frame.add(buttonPanel, "South");

        // Create a JPanel to represent our center "window"
        centerPanel = new JPanel();
        frame.add(centerPanel, "Center");

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Red")) {
            centerPanel.setBackground(Color.BLUE);
        } else if (e.getActionCommand().equals("Blue")){
            centerPanel.setBackground(Color.RED);
        }
    }

}
