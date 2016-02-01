package d8;

/**
 * @author Santeri Rusila
 * @version 27.2.2013
 *
 */
public class MatriisinSumma {

    /**
     * @param args
     */
    public static void main(String[] args) {
        double[][] matriisi = new double[][]{ {1,2,3,4,5},
                                        {6,7,8,9,10}};

        double summa = matriisinSumma(matriisi);
        System.out.println(summa);
        

    }

    /**
     * @param matriisi
     * @return matriisin Summa
     * @example
     * <pre name="test">
     *    double[][] matriisi1 = new double[][]{ {1,6,3,4,8}, {6,7,8,9,10}};
     *    matriisinSumma(matriisi1) ~~~ 62
     *    double[][] matriisi2 = new double[][]{ {1,6,3,4,8}, {6,7,8,9,0}};
     *    matriisinSumma(matriisi2) ~~~ 52
     *    double[][] matriisi3 = new double[][]{ {1,100,3,4,8}, {6,7,8,9,10}};
     *    matriisinSumma(matriisi3) ~~~ 156
     *    double[][] matriisi4 = new double[][]{ {0.5,6,3,4,8}, {6,7,8,9,10}};
     *    matriisinSumma(matriisi4) ~~~ 61.5
     * </pre>
     */
    public static double matriisinSumma(double[][] matriisi) {
        double summa = 0;
        for (int i = 0; i<matriisi.length; i++) {
            summa += summa(matriisi[i]);
        }
        return summa;
    }

    /**
     * @param taulukko 
     * @return summa
     * @example
     * <pre name="test">
     *    double[] taulukko1 = new double[]{1,2,3,4,5,6};
     *    summa(taulukko1) ~~~ 21
     *    double[] taulukko2 = new double[]{1,2,3,4,5,3.5};
     *    summa(taulukko2) ~~~ 18.5
     *    double[] taulukko3 = new double[]{0,2,3,4,5,6};
     *    summa(taulukko3) ~~~ 20
     *    double[] taulukko4 = new double[]{1,2,3,100,5,6};
     *    summa(taulukko4) ~~~ 117
     *    
     * </pre>
     */
    public static double summa(double[] taulukko) {
        double summa = 0;
        for (int i = 0; i<taulukko.length; i++) {
            summa += taulukko[i];
        }
        return summa;
    }

}
