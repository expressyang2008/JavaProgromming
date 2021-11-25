/**
 * @program: JavaProgromming
 * @description: This is a Standard Java program that prompts the user for their name  and what week number it is, and outputs how many weeks are left   until break.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-25 14:43
 */
import java.util.*;
public class UserInputSJ {
    private static final int WEEKS_PER_QUARTER = 11;

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);

        System.out.print("What's your name? ");
        String name = consoleScanner.nextLine();

        System.out.print("What week number is it? ");
        int weekNum = consoleScanner.nextInt();

        int weeksLeft = WEEKS_PER_QUARTER - weekNum;
        System.out.println(name + ", you have " + weeksLeft +
                " weeks left until break!");

        consoleScanner.close();
    }
}
