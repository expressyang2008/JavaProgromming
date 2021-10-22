/**
 * @program: JavaProgromming
 * @description: 该程序对多个按钮进行了处理，并分别添加到了控制栏中
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-21 22:48
 */
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPress extends ConsoleProgram{
    public void init(){
        setFont("Courier-24");

        add(new JButton("欢迎"),NORTH);
        add(new JButton("JAVA"),SOUTH);
        add(new JButton("编程"),SOUTH);
        addActionListeners();
    }

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        if (cmd.equals("欢迎")){
            println("欢迎来到这里,");
        } else if (cmd.equals("JAVA")){
            println("学习JAVA语言！");
        } else if (cmd.equals("编程")){
            println("一起编程，加油！");
        }
    }
}
