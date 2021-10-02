import acm.program.ConsoleProgram;

/**
 * @program: JavaProgromming
 * @description: A program that count Upper Case in string.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-02 09:45
 */
public class CountUpperCase extends ConsoleProgram {
    public void run(){
        println(countUpperCase("I come from SiChuan"));
        println(countUpperCase("My College located in Chengdu China"));

    }

    private int countUpperCase(String str){
        int number = 0;
        for(int i = 0; i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isUpperCase(ch)){
                number++;
            }
        }
        return number;
    }

}
