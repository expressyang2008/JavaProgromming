import acm.program.ConsoleProgram;

/**
 * @program: Example of caculate factorial
 * @description: Caculate factorial of n
 * @author Shawn Yang
 * @create 2021-09-18 00:46
 **/
public class Factorials extends ConsoleProgram {

    private static final int MAX_NUM = 5;
    public void run() {
        for (int i = 0; i < MAX_NUM; i++) {
            println(i + "!=" + factorial(i));
        }
    }
    
    /**
     * factorial
     * @param n
     * @version 0.1.0
     * @return int resutl
     * @author Shawn Yang
     * @since 0.1.0
     */
    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
