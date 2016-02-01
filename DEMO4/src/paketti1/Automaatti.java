package paketti1;


/**
 * @author Santeri Rusila
 * @version 1.2.2013
 */
public class Automaatti {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String a = "01001";
        
        boolean b = automaatti(a);
        
        System.out.println(b);

    }

    /**
     * @param a bittijono
     * @return true tai false
     * @example
     * <pre name="test">
     *     automaatti("010010")   === false;
     *     automaatti("01001")    === true;
     *     automaatti("01010101") === false;
     *     automaatti("")         === true;
     *     automaatti("01")       === false;
     *     automaatti("01000")    === false;
     *     automaatti("0100")     === true;
     *     automaatti("000000")   === true;
     *     automaatti("111110")   === false;
     * </pre>
     */
    public static boolean automaatti(String a) {
        int l = a.length();
        int lkm = 0;
        
        for (int b = 0; b < l; b++ ) {
            if (a.charAt(b) == '0') lkm++;
        }
        if (lkm % 3 == 0) return true;
        return false;
    }

}
