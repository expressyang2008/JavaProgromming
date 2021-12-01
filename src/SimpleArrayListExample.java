/**
 * @program: JavaProgromming
 * @description: 该程序建立了字符型ArrayList后，向ArrayList添加元素，并输出
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-13 12:13
 */

import java.util.*;
import acm.program.*;

public class SimpleArrayListExample extends ConsoleProgram {

    public void run() {
        //ArrayList<String> list = new ArrayList<String>();

        ArrayList<Integer> iList = new ArrayList<Integer>();

        readList(iList);
        printArrayList(iList);

        readList(iList);
        printArrayList(iList);
    }
    /*String List*/
    private void readList(ArrayList list) {
        while (true) {
            String line = readLine("请输入元素，当输入空格时结束：");
            if (line.equals("")) break;
            list.add(line);
        }
    }
    /*Integer List*/
    private void readIntList(ArrayList list) {
        while (true) {
            int num = readInt("请输入元素，当输入空格时结束：");
            if (num == 0) break;
            list.add(num);
        }
    }
    /*Print List*/
    private void printArrayList(ArrayList list) {
        println("数组元素个数是" + list.size());
        for (int i = 0; i < list.size(); i++)
            println(list.get(i));
    }
}
