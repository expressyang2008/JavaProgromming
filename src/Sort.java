import acm.program.ConsoleProgram;

/**
 * @program: JavaProgromming
 * @description:
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-03 08:58
 */
public class Sort extends ConsoleProgram {
    public void run() {
        int[] array = new int[]{24, 2, 43, 35, 13, 25, 37, 23, 16};
        selectionSort(array);
        printArr(array);
    }

    private void printArr(int[] array) {
        for (int i : array) {
            println(i);
        }

    }

    private void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}
