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
//        while (true) {
//            String digits = readLine("Enter a numeric string:");
//            if (digits.length() == 0) break;
//            println(addCommasToNumericString(digits));
//        }

        println(removeAllOccurrences("This is a test", 't'));
        println(removeAllOccurrences("Summer is here!", 'e'));
        println(removeAllOccurrences("---0---", '-'));

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

    private String addCommasToNumericString(String digits) {
        String result = "";
        int len = digits.length();
        int nDigits = 0;
        for (int i = len - 1; i >= 0; i--) {
            result = digits.charAt(i) + result;
            nDigits++;
            if (((nDigits % 3) == 0) && (i > 0)) {
                result = "," + result;
            }
        }
        return result;
    }

    private String removeAllOccurrences(String str, char ch) {
        String result = "";
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) != ch) {
                result = result + str.charAt(i);
            }
        }
        return result;
    }

    private String removeAllOccurrences2(String str, char ch) {
        while (true) {
            int pos = str.indexOf(ch);
            if (pos >= 0) {
                str = str.substring(0, pos)
                        + str.substring(pos + 1);
            } else break;
        }
        return str;
    }
}
