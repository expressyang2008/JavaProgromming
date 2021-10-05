import java.awt.Font;
import acm.program.ConsoleProgram;
/*文件: UseBank.java
 * 该程序是Bank类的使用，该类中定义了修改密码和显示信息的方法
 */
public class UseBank extends ConsoleProgram{
    public void run() {
        setSize(500, 500);
        setFont(new Font("Times New Roman", Font.BOLD, 30));
        Bank Dean = new Bank("6", "Dean", "123456", 100);
        Dean.deposit(100);
        Dean.withdraw(20);
        display(Dean);
    }

    //修改user密码方法
    public void changePWD(Bank user) {
        String new_pwd, choice;
        println("请输入新密码");
        //输入new_pwd，请补充完整

        println("是否确认修改？（y/n）");
        //输入是否确认修改，是y还是n，请补充完整

        //判断用户的选择，如果是y,则将密码设置为new_pwd，请补充完整。

    }

    //显示user的基本信息
    public void display(Bank user) {
        //输出用户的账号，姓名，余额，密码，请补充完整。
    }
}

