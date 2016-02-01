/**
 * 
 */
package d9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Santeri Rusila
 * @version 7.3.2013
 */
public class Tiedosto {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String tiedNimi = "teksti.txt";
        String tiedNimi2 = "kopio.txt";
        if (args.length > 0 ) tiedNimi = args[0];

        try (BufferedReader fi = new BufferedReader(new FileReader(tiedNimi));
                PrintStream fo = new PrintStream(new FileOutputStream(tiedNimi2, false))) {
            String s;
            while ((s = fi.readLine()) != null) {
                try {
                    String[] parts = s.split(" ");
                    int luku = Integer.parseInt(parts[0]);
                    if (luku > 30) {
                        fo.println(s);
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("Joku muu kuin kokonaisluku " + ex.getMessage());
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Tiedosto ei aukea! " + ex.getMessage());
            return;
        } catch (IOException ex) {
            System.err.println("Virhe tiedostoa luettaessa! " + ex.getMessage());
        }

    }

}
