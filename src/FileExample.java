import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @program: JavaProgromming
 * @description: This is a file  example.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-04 20:59
 */
public class FileExample extends ConsoleProgram {
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                println(line);
            }
            br.close();
        } catch (IOException ex) {
            println("The file doesn't exist!");
        }
    }
}
