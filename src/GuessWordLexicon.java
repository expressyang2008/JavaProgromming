/**
 * File:GuessWordLexicon.java
 * @program: GuessWord
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-08 16:13
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class GuessWordLexicon {
    // This is the GuessWordLexicon constructor
    public GuessWordLexicon() {
        try {
            rd = new BufferedReader(new FileReader("files/ShorterLexicon.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        while(true){
            String line=null;
            try {
                line = rd.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(line==null) break;
            strlist.add(line);
        }

    }
    // rest of GuessWordLexicon class...

    /** Returns the number of words in the lexicon. */
    public int getWordCount() {
//        return strlist.size();
        return 10;
    }

    /** Returns the word at the specified index. */
    public String getWord(int index) {
//        return strlist.get(index);
        switch(index){
            case 0: return "BUOY";
            case 1: return "COMPUTER";
            case 2: return "CONNOISSEUR";
            case 3: return "DEHYDRATE";
            case 4: return "FUZZY";
            case 5: return "HUBBUB";
            case 6: return "KEYHOLE";
            case 7: return "QUAGMIRE";
            case 8: return "SLITHER";
            case 9: return "ZIRCON";
//            default: throw new ErrorException("getWord: Illegal index");

        }
        return "Test";

    }
    private BufferedReader rd;
    private ArrayList<String> strlist=new ArrayList<String>();
}
