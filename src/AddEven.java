/**
 * @program: JavaProgromming
 * @description: 该程序实现的是向动态数组中输入值，然后将动态数组中所有偶数加起
 * 来，将偶数和进行输出该程序含有错误，使用Debugger调试器方式运行调试程序
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-19 15:35
 */
import java.util.ArrayList;
import acm.program.*;


public class AddEven extends ConsoleProgram{
    public void run(){
        ArrayList <Integer> list = new ArrayList <Integer>();
        setFont("Courier-24");
        readList(list);
        println(addList(list));
    }

    private void readList(ArrayList list){
        for(int i = 0; i < 1000 ; i++){
            int item = readInt("请输入数组元素，当输入0时结束：");
            if(item == 0)  break;
            list.add(item);
            println("第" + i+1 + "个值是" +list.get(i));

        }
    }

    private int addList(ArrayList list){
        int sum = 0 ;
        Integer num = 0;
        for(int i = 0; i < list.size(); i++){
            num = (Integer) list.get(i);
        if ((num % 2) == 0) sum += num;}
        return sum;
    }
}
