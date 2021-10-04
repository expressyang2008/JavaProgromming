import acm.program.ConsoleProgram;

/**
 * @program: JavaProgromming
 * @description: This is a program that replace the first occurrence word in string.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-02 09:59
 */
public class ReplaceFirstOccurrence extends ConsoleProgram {
    public void run() {
        String str = "I like you";
        String orig = "like";
        String repl = "love";
        println(replaceFirstOccurrence(str, orig, repl));
    }

    private String replaceFirstOccurrence(String str, String orig, String repl) {
        int index = str.indexOf(orig);
        if (index != -1) {
            str = str.substring(0, index) + repl + str.substring(index + orig.length());
        }
        return str;
    }
}
