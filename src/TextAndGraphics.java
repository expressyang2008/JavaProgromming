/**
 * @program: JavaProgromming
 * @description:
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-27 15:19
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import acm.graphics.GCanvas;
import acm.graphics.GRect;
import acm.program.ConsoleProgram;

public class TextAndGraphics extends ConsoleProgram {
    public void init() {
        setLayout(new GridLayout(1, 3));
        //Note: console is first element of our layout
        leftCanvas = new GCanvas();
        add(leftCanvas);

        rightCanvas = new GCanvas();
        add(rightCanvas);

        textField = new JTextField(10);
        add(new JLabel("Some text"), SOUTH);
        add(textField, SOUTH);
        textField.addActionListener(this);

        add(new JButton("Draw Left"), SOUTH);
        add(new JButton("Draw Right"), SOUTH);

        addActionListeners();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == textField) {
            println("You typed: " + textField.getText());
        }
        String cmd = e.getActionCommand();
        if (cmd.equals("Draw Left")) {
            leftCanvas.add(createFilledRect(), 20, leftY);
            leftY += SPACER;
        } else if (cmd.equals("Draw Right")) {
            rightCanvas.add(createFilledRect(), 20, rightY);
            rightY += SPACER;

        }
    }

    private GRect createFilledRect() {
        GRect rect = new GRect(50, 20);
        rect.setFilled(true);
        return rect;
    }

    /*Constant variable*/
    private static final int SPACER = 30;
    /*Private instance variables*/
    private GCanvas leftCanvas;
    private GCanvas rightCanvas;
    private JTextField textField;
    private double leftY = 10;
    private double rightY = 10;
}
