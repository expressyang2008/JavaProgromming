import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * @program: JavaProgromming
 * @description:
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-29 16:24
 */
public class SearchExample extends ConsoleProgram {
    public void run() {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rgen.nextInt(1, 100);
        }
//        display(arr);
//        println(seqSearch(arr, 5));
        int[] arr2 = {12,22,33,42,53,61,72,83,94};
        display(arr2);
        println(binarySearch(arr2, 42));

    }

    private int seqSearch(int st[], int key) {
        for (int i = 0; i < st.length; i++) {
            if (key == st[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    private int binarySearch(int array[], int key) {
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        while (high >= low) {
            mid = (low + high) / 2;
            if (key == array[mid]) {
                return mid;
            } else if (key > array[mid]) {
                low = mid + 1;

            } else if (key < array[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }

    private void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            println(array[i]);
        }
    }

    private RandomGenerator rgen = RandomGenerator.getInstance();

}
