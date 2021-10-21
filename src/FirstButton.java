import acm.program.ConsoleProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @program: JavaProgromming
 * @description: 该程序添加了确定按钮，并添加了监听器来响应actionPerformed事件
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-21 22:16
 */
public class FirstButton extends ConsoleProgram {
    public void init(){
        setFont("Courier-24");
        add(new JButton("确定"),SOUTH);
        addActionListeners();
    }

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        if(cmd.equals("确定")){
            println("你点击了确认按钮。");
        }
    }
}
