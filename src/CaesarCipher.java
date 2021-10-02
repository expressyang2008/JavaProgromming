import acm.program.ConsoleProgram;

/**
 * @program: JavaProgromming
 * @description: This program uses a Caesar cipher for encryption.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-02 16:31
 */
public class CaesarCipher extends ConsoleProgram {
    private char encryptChar(char ch, int key) {
        if (Character.isUpperCase(ch)) {
            return (char) ((ch + key - 'A') % 26 + 'A');
        }
        if (Character.isLowerCase(ch)) {
            return (char) ((ch + key - 'a') % 26 + 'a');
        }
        return ch;
    }

    private String encryptCaesar(String plainText, int key) {
        if (key < 0) {
            key = 26 - (-key % 26);
            println(key);
        }
        String result = "";
        for (int i = 0; i < plainText.length(); i++) {
            char ch = encryptChar(plainText.charAt(i), key);
            result = result + ch;
        }
        return result;
    }

    public void run() {
        println("This program uses a Caesar cipher for encryption.");
        String plainText = readLine("Plaintext:");
        int key = readInt("Enter encryption key:");
        println("Ciphertext:" + encryptCaesar(plainText, key));
        println("Ciphertext:" + encryptCaesar(plainText, -key));
    }
}
