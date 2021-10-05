import acm.program.ConsoleProgram;
import acm.util.ErrorException;

import java.io.*;

/**
 * @program: JavaProgromming
 * @description: This is a example for demostrate how to copy a file.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-05 10:55
 */
public class CopyFileExample extends ConsoleProgram {
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

    public void run(){
            BufferedReader br = openFIle();
            try {
                PrintWriter pw = new PrintWriter(new FileWriter("copy.txt",true));
                while(true){
                    String line = br.readLine();
                    if(line==null) break;
                    pw.println(line);
                    println("["+line+"] has copied.");
                }
                pw.flush();
                pw.close();
                br.close();
            }
            catch (IOException ex){
                throw new ErrorException(ex);
            }
    }
}
