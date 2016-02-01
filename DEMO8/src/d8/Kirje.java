package d8;

/**
 * Ohjelmalla tutkitaan postimaksun suuruutta
 * @author Vesa Lappalainen
 * @version 1.0, 21.02.2003
 */
public class Kirje {

    private static int painot[]    = {   50 , 100,  250,  500, 1000, 2000, 0 };
    private static double hinnat[] = { 0.60, 0.90, 1.30, 2.10, 3.50, 5.50, 0 };


    /**
     * Palautetaan suurin kirjeen paino, joka voidaan raham‰‰r‰ll‰ l‰hett‰‰<br>
     * Toteutus if-lauseiden avulla.
     * @param rahaa k‰ytˆss‰ oleva raham‰‰r‰
     * @return suurin kirjeen paino joka voidaan l‰hett‰‰
     * @example
     * <pre name="test">
     * suurinKirjeenPainoIf($rahaa) ~~~ $paino;
     * 
     *   $rahaa | $paino
     * -------------------
     *    10.00 | 2000
     *     3.60 | 1000
     *     3.50 | 1000
     *     3.40 |  500
     *     0.50 |    0
     * </pre>
     */
    public static int suurinKirjeenPainoIf(double rahaa) {
        if (5.50 <= rahaa) return 2000;
        if (3.50 <= rahaa) return 1000;
        if (2.10 <= rahaa) return 500;
        if (1.30 <= rahaa) return 250;
        if (0.90 <= rahaa) return 100;
        if (0.60 <= rahaa) return 50;
        return 0;
    }


    /**
     * Palautetaan suurin kirjeen paino, joka voidaan raham‰‰r‰ll‰ l‰hett‰‰<br>
     * Toteutus taulukoiden avulla.
     * @param rahaa k‰ytˆss‰ oleva raham‰‰r‰
     * @return suurin kirjeen paino joka voidaan l‰hett‰‰
     * 
     * @example
     * <pre name="test">
     * suurinKirjeenPaino($rahaa) ~~~ $paino;
     * suurinKirjeenPaino2($rahaa) ~~~ $paino;
     * suurinKirjeenPainoIf($rahaa) ~~~ $paino;
     * 
     *   $rahaa | $paino
     * -------------------
     *    10.00 | 2000
     *     5.50 | 2000
     *     5.49 | 1000
     *     3.50 | 1000
     *     3.49 |  500
     *     2.10 |  500
     *     2.09 |  250  
     *     1.30 |  250
     *     1.29 |  100
     *     0.90 |  100
     *     0.89 |   50
     *     0.60 |   50
     *     0.59 |    0
     *     0.50 |    0
     * </pre>
     */
    public static int suurinKirjeenPaino(double rahaa) {
        int i;
        int paino = 0;

        for (i = hinnat.length - 2; i >= 0; i--)
            if (hinnat[i] <= rahaa) return painot[i];
        return paino;
    }


    /**
     * Palautetaan suurin kirjeen paino, joka voidaan raham‰‰r‰ll‰ l‰hett‰‰<br>
     * Toteutus taulukoiden avulla joissa loppumerkki.
     * @param rahaa k‰ytˆss‰ oleva raham‰‰r‰
     * @return suurin kirjeen paino joka voidaan l‰hett‰‰
     */
    public static int suurinKirjeenPaino2(double rahaa) {
        int i;
        int paino = 0;

        for (i = 0; hinnat[i] > 0; i++)
            if (hinnat[i] <= rahaa) paino = painot[i];
        return paino;
    }

}
