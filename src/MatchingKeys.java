/**
 * @program: JavaProgromming
 * @description: * This program prints out the keys/value pairs in a HashMap
 * where the value in the pair is the same as _any_ one of the
 * keys in the HashMap.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-21 09:46
 */
import acm.program.*;
import java.util.*;
public class MatchingKeys extends ConsoleProgram{
    public void run() {
        setFont("Courier New-Bold-28");

        // initialize the map
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Alice", "Bob");
        map.put("Bob", "Jeff");
        map.put("Mary", "Pat");
        map.put("Pat", "Ethel");

        PrintMatchingKeys(map);
    }

    private void PrintMatchingKeys(HashMap<String,String> map) {

        // Store all keys from keySet in an array list
        ArrayList<String> keys = new ArrayList<String>();

        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            keys.add(it.next());
        }

        // Reset "it" to be a new iterator over keys
        it = map.keySet().iterator();

        // Check all key/values to see if value is contained
        // in ArrayList of keys
        while (it.hasNext()) {
            String key = it.next();
            String value = map.get(key);
            if (keys.contains(value)) {
                println(key + ": " + value);
            }
        }
    }

}
