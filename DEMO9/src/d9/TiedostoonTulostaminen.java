/**
 * 
 */
package d9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author Santeri Rusila
 * @version 6.3.2013
 *
 */
public class TiedostoonTulostaminen {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String tiedNimi = "tiedosto.txt";
        
        
        try (PrintStream fo = new PrintStream(new FileOutputStream(tiedNimi, false))) {
            for (int i = 0; i < 100; i++) {
                fo.printf("%2d", i);
                fo.println(" En enää turhaan kirjoita!");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Tiedosto ei aukea: " + ex.getMessage());
        }
    }

}
