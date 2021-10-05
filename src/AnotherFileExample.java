import acm.program.ConsoleProgram;
import acm.util.ErrorException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @program: JavaProgromming
 * @description: This is a file example
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-04 20:23
 */
public class AnotherFileExample extends ConsoleProgram {
    private BufferedReader openFIle() {
        BufferedReader rd = null;
        while (rd == null) {
            try {
                String filename = readLine("prompt:");
                rd = new BufferedReader(new FileReader(filename));
            } catch (IOException ex) {
                println("The file doesn't exist.");
            }
        }
        return rd;
    }

    public void run() {
        setFont("Courier-24");
        BufferedReader rd = openFIle();
        try {
            while (true) {
                String line = rd.readLine();
                if (line == null) break;
                println("Read line:[" + line + "]");
            }
            rd.close();
        } catch (IOException ex) {
            throw new ErrorException(ex);
        }
    }
}
