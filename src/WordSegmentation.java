import acm.program.ConsoleProgram;

import java.util.StringTokenizer;

/**
 * @program: JavaProgromming
 * @description: A example of word segmentation
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-02 16:00
 */
public class WordSegmentation extends ConsoleProgram {
    public void run() {
        String str = new String("Hi, This is a string for test!");
        StringTokenizer st = new StringTokenizer(str, " ,.!");
        //StringTokenizer st = new StringTokenizer(str, " ");
        println("Token Total:" + st.countTokens());
        while (st.hasMoreElements()) {
            println(st.nextToken());
        }
    }

}
