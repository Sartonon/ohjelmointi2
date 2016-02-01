package paketti4;

/**
 * @author Santeri Rusila
 * @version 1.2.2013
 */
public class Tarkkuus {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        double a = 0.01;
        
        int b = etumerkki(a, 0.0000001);
        
        System.out.println(b);

    }

    /**
     * @param a luku
     * @param eps epsilon
     * @return onko negatiivinen vai positiivinen
     * @example
     * <pre name="test">
     *    etumerkki(-1, 0.0000001) === -1;
     *    etumerkki(0, 0.0000001) === 0;
     *    etumerkki(-0.000003, 0.0000001) === -1;
     *    etumerkki(0.00001, 0.0000001) === 1;
     *    etumerkki(-0.0000000000001, 0.0000001) === 0;
     *    
     * </pre>
     */
    public static int etumerkki(double a, double eps) {
       
        if (a<-eps) return -1;
        if (-eps <= a && a <= eps) return 0;
        return 1;
         
    }

}
