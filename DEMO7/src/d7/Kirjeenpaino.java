package d7;

/**
 * @author Santeri Rusila
 * @version 24.2.2013
 *
 */
public class Kirjeenpaino {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        int a = suurinKirjeenPaino(2.10);
        System.out.println(a);

    }

    /**
     * @param d
     * @return paino
     * @example
     * <pre name="test">
     *   suurinKirjeenPaino(0.60) === 50;
     *   suurinKirjeenPaino(0.70) === 50;
     *   suurinKirjeenPaino(0.90) === 100;
     *   suurinKirjeenPaino(0.20) === 0;
     *   suurinKirjeenPaino(10.0) === 2000;
     *   suurinKirjeenPaino(2.20) === 500;
     * </pre>
     */
    public static int suurinKirjeenPaino(double d) {
        if (d >= 0.60 && d < 0.90) return 50;
        if (d >= 0.90 && d < 1.30) return 100;
        if (d >= 1.30 && d < 2.10) return 250;
        if (d >= 2.10 && d < 3.50) return 500;
        if (d >= 3.50 && d < 5.50) return 1000;
        if (d >= 5.50) return 2000;
        
        return 0;
        
    }

}
