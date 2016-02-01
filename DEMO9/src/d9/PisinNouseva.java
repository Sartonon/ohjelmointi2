package d9;

/**
 * @author Santeri Rusila
 * @version 6.3.2013
 * 
 * a) 1. Verrataan ensimm‰ist‰ ja toista kirjainta, jos toinen on suurempi, lis‰t‰‰n apumuuttujaan 1
 *       ja tarkistetaan onko se pisin t‰h‰n menness‰ nousevista jonoista, ja sijoitetaan muuttujaan jos on.
 *       Jos ei ole suurempi, ei lis‰t‰.
 *    2. Verrataan toista ja kolmatta ja jos kolmas on suurempi, lis‰t‰‰n apumuuttujaan 1 ja verrataan
 *       taas onko se t‰m‰n hetken pisin nouseva jono.
 *    3. Jatketaan merkkijonon loppuun asti 1. ja 2. askeleen mukaan ja palauteaan pisin nouseva jono.
 *    
 * 
 */
public class PisinNouseva {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String merkkijono = "abajiuxac";
  
        int a = pisinNouseva(merkkijono);
        
        System.out.println(a);
    }

    /**
     * @param a pisin nouseva merkkijono
     * @return pisin nouseva merkkijono
     * @example
     * <pre name="test">
     *   String a1 = "abajiuxac";
     *   pisinNouseva(a1) === 3
     *   String a2 = "kissa";
     *   pisinNouseva(a2) === 3
     *   String a3 = "abcdefg";
     *   pisinNouseva(a3) === 7
     * </pre>
     */
    public static int pisinNouseva(String a) {
        
        int pisin = 1;
        int paras = 0;
        
        for (int i = 0; i < a.length()-1; i++) {
            char c = a.charAt(i);
            char b = a.charAt(i+1);
            
            if (c <= b) {
                pisin++;
                if (pisin > paras) paras = pisin;
            }
            else pisin = 1; 
        }
        return paras;
    }

}
