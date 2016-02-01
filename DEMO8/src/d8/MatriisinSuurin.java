package d8;

/**
 * @author Santeri Rusila
 * @version 27.2.3013
 *
 */
public class MatriisinSuurin {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = new int[][]{ {1,201,200,4},{10,6,7,8} };
        
        int suurin =  matriisinSuurin(a);
        System.out.println(suurin);
                                 
                
        }

    /**
     * @param a
     * @return suurin
     * @example
     * <pre name="test">
     *    int[][] a = new int[][]{ {1,2,3,4},{5,6,7,8} };
     *    matriisinSuurin(a) === 8;
     *    int[][] b = new int[][]{ {1,2,200,4},{5,6,7,8} };
     *    matriisinSuurin(b) === 200;
     *    int[][] c = new int[][]{ {1,2,200,4},{5,6,7,800} };
     *    matriisinSuurin(c) === 800;
     * </pre>
     */
    public static int matriisinSuurin(int[][] a) {
        int suurin = Integer.MIN_VALUE;; 
        for (int i = 0; i<a.length; i++) {
            for (int j = 0; j<a[i].length; j++) {
                if (a[i][j] > suurin) suurin = a[i][j];
            }
        }
        return suurin;
    }
}
