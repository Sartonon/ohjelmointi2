/**
 * 
 */
package d9;

/**
 * @author Santeri Rusila
 * @version 6.3.2013
 *
 */
public class PoistoTaulukosta {

    /**
     * @param args
     * @example
     * <pre name="test">
     *   int h[] = {1,2,3,4,5,6,7,7};
     *   int lkm = 8;
     *   poista(h,lkm,7) === 6;
     *   poista(h,lkm,1) === 7;
     * </pre>
     */
    public static void main(String[] args) {
        int t[]={4,7,9,3,9,2};
        int lkm=6;

        lkm = poista(t,lkm,9);  /* => t = {4,7,3,2,?,?}, lkm = 4  */
        System.out.println(lkm);
        tulosta(t);
        lkm = poista(t,lkm,2);  /* => t = {4,7,3,?,?,?}, lkm = 3  */
        System.out.println(lkm);
        tulosta(t);
        lkm = poista(t,lkm,4);  /* => t = {7,3,?,?,?,?}, lkm = 2  */
        System.out.println(lkm);
        tulosta(t);

    }

    /**
     * @param t
     */
    public static void tulosta(int[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    /**
     * @param t
     * @param lkm
     * @param poistettava
     * @return taulukko
     */
    public static int poista(int[] t, int lkm, int poistettava) {
        int poistetut = 0;
        for (int i = 0; i < lkm;  i++) {
            if (t[i] == poistettava) {
                t[i] = -1;
                poistetut++;
            }
        }
        
        for (int i = 0; i < lkm; i++) {
            if (t[i] == -1) {
                for (int b = i; b < lkm-1; b++) {
                    if (t[b+1] != -1){
                        t[b] = t[b+1];
                        t[b+1] = -1;
                    }
                }
            }
        }
        
        lkm = lkm - poistetut;
        
        return lkm;
    }

}
