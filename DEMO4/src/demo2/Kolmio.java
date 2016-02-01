package demo2;

/**
 * @author Santeri Rusila
 * @version 1.2.2013
 */
public class Kolmio {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        int a = 10;
        int b = 8;
        double c = hypotenuusa(a,b);
        System.out.println(c);
        
        double ala = kolmionAla(a,b);
        System.out.println(ala);

    }

    /**
     * @param a kateetti1
     * @param b kateetti2
     * @return kolmion ala
     * @example
     * <pre name="test">
     *    kolmionAla(5,5) ~~~ 12.5;
     * </pre>
     * 
     */
    public static double kolmionAla(int a, int b) {
        
        return (a*b)/2.0;
    }

    /**
     * @param a kateetti1
     * @param b kateetti2
     * @return hypotenuusan pituus
     * @example
     * <pre name="test">
     *#TOLERANCE=0.01
     *hypotenuusa(10,5) ~~~ 11.18;
     *hypotenuusa(10,5) ~~~ 11.18;
     *hypotenuusa(10,5) ~~~ 11.18;
     * </pre>
     */
    public static double hypotenuusa(int a, int b) {
        int n = (a*a + b*b);
        double hypotenuusa = Math.sqrt(n);
        
        return hypotenuusa;
        
    }

}
