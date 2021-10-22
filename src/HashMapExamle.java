/**
 * @program: JavaProgromming
 * @description: 该程序使用HashMap去实现接口Map
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-20 13:26
 */


import java.util.*;
import acm.program.*;
public class HashMapExamle extends ConsoleProgram {
    public void run() {
        setFont("Courier-24");
        println("录入电话号码：");
        readPhoneNumbers();
        println("查询电话号码：");
        lookupPhoneNumbers();
        println("所有记录");
        displayAllPhoneNumbers1();
    }

    private void readPhoneNumbers() {
        while (true) {
            String name = readLine("name:");
            if (name.equals("")) break;
            Integer number = readInt("number:");
            phoneBook.put(name, number);
        }
    }

    private void displayAllPhoneNumbers() {
        Iterator<String> it = phoneBook.keySet().iterator();
        while (it.hasNext()) {
            String name = it.next();
            Integer number = phoneBook.get(name);
            println(name + ":" + number);
        }
    }

    private void displayAllPhoneNumbers1() {
        for (String name : phoneBook.keySet()) {
            Integer number = phoneBook.get(name);
            println(name + ":" + number);
        }
    }

    private void lookupPhoneNumbers() {
        String name = readLine("输入姓名:");
        Integer number = phoneBook.get(name);
        if (number != null) {
            println(name + ":" + number);
        } else {
            println("没有找到");
        }
    }
    private HashMap<String, Integer> phoneBook = new HashMap<String, Integer>();
}
