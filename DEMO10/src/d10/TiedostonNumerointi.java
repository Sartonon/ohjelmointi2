/**
 * 
 */
package d10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Santeri Rusila
 * @version 13.3.2013
 *
 */
public class TiedostonNumerointi {

    /**
     * @param args ei käytössä
     * @example
     * <pre name="test">
     *   #THROWS IOException
     * #import fi.jyu.mit.ohj2.Suuntaaja;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     * #import java.io.IOException;
     * 
     * VertaaTiedosto.kirjoitaTiedosto("hiljaa.txt",
     *      "33 hiljaa 1 hiipii\n"+
     *      "hyvä 33 tulee\n"+
     *      "36 1 3 5 55\n"+
     *      "nyt 33 riittää\n");
     *  String tulos =
     *      "33 hiljaa 1 hiipii\n"+
     *      "36 1 3 5 55\n";
     *  VertaaTiedosto.tuhoaTiedosto("tulos.txt"); 
     *  main(new String[]{"hiljaa.txt","tulos.txt"});
     *  VertaaTiedosto.vertaaFileString("tulos.txt",tulos) === null;
     *  VertaaTiedosto.tuhoaTiedosto("tulos.txt");
     *  VertaaTiedosto.tuhoaTiedosto("hiljaa.txt");
     * </pre>
     */
    public static void main(String[] args) {
        
        String tiedNimi = "tiedosto.txt";
        String tiedNimi2 = "kopio.txt";
        
        try (BufferedReader fi = new BufferedReader(new FileReader(tiedNimi));
                PrintStream fo = new PrintStream(new FileOutputStream(tiedNimi2, false))) {
            String s;
            int i = 1;
            while ((s = fi.readLine()) != null) {
                try {
                    fo.printf("/* " + "%02d" + " */ ", i);
                    if (s.length() > 40) {
                        fo.println(s.substring(0,40));
                    }
                    else fo.println(s);
                    i++;
                    
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
