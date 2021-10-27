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

    public void run() {

        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        for (int i = 0; i < array.length; i++) {
            println(array[i]);
        }

        swap(array,1,3);

        for (int i = 0; i < array.length; i++) {
            println(array[i]);
        }



    }

    private void swap(int[] arr, int a, int b) {
        int temp = 0;
        temp = arr[a];
        arr[a]=arr[b];
        arr[b] = temp;
    }
}
