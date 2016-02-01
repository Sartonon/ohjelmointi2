/**
 * 
 */
package d6;

/**
 * @author Santeri Rusila
 * @version 18.2.2013
 *
 */
public class Taulukot {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        int kPituudet[] = {30,28,14,30,30,30,31,31,30,31,30,31};
        int i; int n;
        i = pienimmanPaikka(kPituudet);
        System.out.println(i);
        
        n = pienin(kPituudet);
        System.out.println(n);

    }

    /**
     * @param kPituudet
     * @return pienimmän alkio
     * @example
     * <pre name="test">
     *    int kPituudet[] = {30,28,30,30,30,30,31,31,30,31,30,31};
     *    pienin(kPituudet) === 28
     *    int kPituudet1[] = {1,28,14,30,30,30,31,31,30,31,30,31};
     *    pienin(kPituudet1) === 1
     *    int kPituudet2[] = {30,8,14,30,30,30,31,31,30,31,30,31};
     *    pienin(kPituudet2) === 8
     *    int kPituudet3[] = {30,28,14,30,30,30,31,31,13,31,30,31};
     *    pienin(kPituudet3) === 13
     *    int kPituudet4[] = {30,28,30,30,30,15,31,31,30,31,30,31};
     *    pienin(kPituudet4) === 15
     * </pre>
     */
    public static int pienin(int[] kPituudet) {
        int indeksi;
        indeksi = pienimmanPaikka(kPituudet);
        return kPituudet[indeksi];
    }

    /**
     * @param kPituudet
     * @return lol
     * @example
     * <pre name="test">
     *    int kPituudet[] = {30,28,31,30,30,30,31,31,30,31,30,31};
     *    pienimmanPaikka(kPituudet) === 1
     *    int kPituudet1[] = {30,28,14,30,30,30,31,31,30,31,30,31};
     *    pienimmanPaikka(kPituudet1) === 2
     *    int kPituudet2[] = {30,28,14,30,30,30,31,31,30,31,30,1};
     *    pienimmanPaikka(kPituudet2) === 11
     *    
     * </pre>
     */
    public static int pienimmanPaikka(int[] kPituudet) {
        int indeksi = 0;
        int pienin = 10000000;
        for (int i = 0; i <kPituudet.length; i++) {
            if (kPituudet[i] < pienin) {
                pienin = kPituudet[i];
                indeksi = i;
            }
        }
        return indeksi;
    }

}
