package paketti5;

/**
 * @author Santeri Rusila
 * @version 1.2.2013
 */
public class Demopisteet {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        int demot = 80;
        
        int a = hyvityspisteet(demot);
        
        System.out.println(a);

    }

    /**
     * @param demot
     * @return hyvityspisteet
     * @example
     * <pre name="test">
     *     hyvityspisteet(96) === 6;
     *     hyvityspisteet(80) === 5;
     *     hyvityspisteet(50) === 2;
     *     hyvityspisteet(60) === 3;
     *     hyvityspisteet(10) === 0;
     *     hyvityspisteet(85) === 5;
     *     hyvityspisteet(76) === 4;
     * </pre>
     */
    public static int hyvityspisteet(int demot) {
        double max = 12*8;
        double a = demot/max;
        if (a<0.4) return 0;
        if (a>0.4 && a<0.5) return 1;
        if (a>0.5 && a<0.6) return 2;
        if (a>0.6 && a<0.7) return 3;
        if (a>0.7 && a<0.8) return 4;
        if (a>0.8 && a<0.9) return 5;
        if (a>0.9) return 6;
        return 0;
    }

}
