import acm.program.*;
/*文件: Bank.java
 * 该程序是一个银行账户类，可以实现模拟取钱、存钱的操作,
 * 类中定义了四个私有变量，分别表示账号，用户姓名，密码，余额,
 * 类中定义了类的四个变量的get和set方法，方便UseBank使用私有变量。
 * 类中定义了一个存钱的方法（deposit）和一个取钱的方法（withdraw）
 */
public class Bank{
    private String user_id;
    private String user_name;
    private String user_pwd;
    private int user_balance;
    public Bank(String id,String name,String pwd,int balance) {
        //初始化类的成员变量，请补充完整

    }
    public void setId(String id) {
        user_id = id;
    }
    public String getId() {
        return user_id;
    }
    public void setName(String name) {
        user_name = name;
    }
    public String getName() {
        return user_name;
    }
    public void setPWD(String pwd) {
        user_pwd = pwd;
    }
    public String getPWD() {
        return user_pwd;
    }
    public void setBalance(int balance) {
        user_balance = balance;
    }
    public int getBalance() {
        return user_balance;
    }
    //存钱方法
    public void deposit(int amount) {
        //当用户存入amount金额的钱时，余额随之增加，请补充完整。
    }
    //取钱方法
    public void withdraw(int amount) {
        //当用户取走amount金额的钱时，余额也随之减少，请补充完整。
    }
}

