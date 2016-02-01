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
public class KirjaintenEsiintymat {

    /**
     * @param args ei käytössä
     * @example
     * <pre name="test">
     *   #THROWS IOException
     * #import fi.jyu.mit.ohj2.Suuntaaja;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     * #import java.io.IOException;
     * 
     *  VertaaTiedosto.kirjoitaTiedosto("kirjaimet.txt",
     *      "aaaaa\n"+
     *      "bbbbb\n"+
     *      "ccccc\n"+
     *      "kkkkk\n");
     *  String tulos =
     *      "a: 5\n"+
     *      "b: 5\n"+
     *      "c: 5\n"+
     *      "k: 5\n";
     *  VertaaTiedosto.tuhoaTiedosto("tulos.txt"); 
     *  main(new String[]{"hiljaa.txt","tulos.txt"});
     *  VertaaTiedosto.vertaaFileString("tulos.txt",tulos) === null;
     *  VertaaTiedosto.tuhoaTiedosto("tulos.txt");
     *  VertaaTiedosto.tuhoaTiedosto("hiljaa.txt");
     * </pre>
     */
    public static void main(String[] args) {
        
        long t1 = System.currentTimeMillis();
        String tiedNimi = "sanat.txt";
        String tiedNimi2 = "kirjain.txt";
        StringBuilder s = new StringBuilder();
        String b;
        long kokonais = 0;
        try (BufferedReader fi = new BufferedReader(new FileReader(tiedNimi)); 
                PrintStream fo = new PrintStream(new FileOutputStream(tiedNimi2, false))) {
            while ((b = fi.readLine()) != null) {
                s.append(b);
            }
            
            b = s.toString();
            int maara = 0;
            for(char i = 'a'; i < 'ö' + 1; i++) {
                maara = 0;
                for(int j = 0; j < b.length(); j++) {
                    if (b.charAt(j) == i)
                        maara++;
                    kokonais++;
                }
                kokonais += maara;
                if (maara > 0) System.out.println("" + i + ": " + maara);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Tiedosto ei aukea! " + ex.getMessage());
            return;
        } catch (IOException ex) {
            System.err.println("Virhe tiedostoa luettaessa! " + ex.getMessage());
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println(kokonais);

    }

}
