import acm.program.ConsoleProgram;

/**
 * @program: JavaProgromming
 * @description: A example that using array.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-07 17:36
 */
public class ArrayExample extends ConsoleProgram {
    private static final int SENTINEL = -1;
    private static final int MAX_SIZE = 100;

    public void run() {
        /*example1*/
//        int[] quiz = new int[MAX_SIZE];
//        int numScore = 0;
//        while (true) {
//            int score = readInt("One score of a student:");
//            if (score == SENTINEL) break;
//            quiz[numScore++] = score;
//        }
        /*example2*/
        int maxLength = readInt("The number of the array");
        int[] quiz = new int[maxLength];
        int numScore = 0;
        for (int i = 0; i < maxLength; i++) {
            quiz[i] = readInt("The score of "+i+1+"th student:");
            if (quiz[i] == SENTINEL) break;
            numScore++;
        }
        println("The average score of this quiz is:" + computeAverage(quiz, numScore));
    }

    private double computeAverage(int[] arr, int numScore) {
        double result = 0.0;
        int sum = 0;
        for (int i = 0; i < numScore; i++) {
            sum = sum + arr[i];
        }
        result = (double) sum / numScore;
        return result;
    }

    private void swapElementsHappy(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    private void swapElementsBuggy(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
}
