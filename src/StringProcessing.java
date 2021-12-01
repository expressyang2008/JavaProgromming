import acm.program.ConsoleProgram;

/**
 * @program: JavaProgromming
 * @description: There are some method that process a String.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-05 12:14
 */
public class StringProcessing extends ConsoleProgram {
    public void run() {
       int [][] matrix = new int[2][3];
       for (int i = 0; i<2;i++){
           for(int j=0;j<3;j++){
               matrix[i][j]=1;
           }
       }
       print(matrix[0][1]);
    }

    // Return ture if str is a palindrome,false otherwise
    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if ((str.charAt(i) != str.charAt(str.length() - (i + 1)))) {
                return false;
            }
        }
        return true;
    }

    // Return ture if str is a palindrome,false otherwise
    private boolean simplePalindrome(String str) {
        return str.equals(reverseString(str));
    }

    private String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result = result + str.charAt(i);
        }
        return result;
    }
}
