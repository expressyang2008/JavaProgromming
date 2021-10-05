import acm.program.ConsoleProgram;
import acm.util.ErrorException;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: JavaProgromming
 * @description: This is a example that how to write to a file.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-04 22:04
 */
public class WriteFileExample extends ConsoleProgram {
    public void run() {
        setFont("Courier-24");
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("copy.txt"));
            while (true) {
                String line = readLine("Enter a string:");
                if (line.length() == 0) break;
                pw.println(line);
            }
            pw.close();
            println("finish!");
        } catch (IOException ex) {
            throw new ErrorException(ex);
        }
    }
}
