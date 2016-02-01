/**
 * 
 */
package d7;

/**
 * @author Santeri
 *
 */
public class RajaArvot {

    /**
     * @param args
     */
    public static void main(String[] args) {
        double[] taulukko = new double[]{19.5, 17.0, 18.5, 15.0, 20.0, 19.0};
        
        tulosta(taulukko);
        
        double a = huonoin(taulukko);
        System.out.println(a);
        double b = paras(taulukko);
        System.out.println(b);
        double summa = summaHuonoinJaParasPois(taulukko);
        System.out.println(summa);

    }

    /**
     * @param taulukko
     */
    public static void tulosta(double[] taulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }
        
        System.out.println();
    }
    

    /**
     * @param taulukko
     * @return taulukon summa
     */
    public static double summaHuonoinJaParasPois(double[] taulukko) {
        double summa = 0;
        for (int i = 0; i < taulukko.length; i++) {
            summa += taulukko[i];
        }
        summa = summa - huonoin(taulukko) - paras(taulukko);
        return summa;
    }

    /**
     * @param taulukko
     * @return parhaan
     */
    public static double paras(double[] taulukko) {
        double paras = 0;
        for (int i = 0; i<taulukko.length; i++) {
            if (taulukko[i] > paras) paras = taulukko[i];
        }
        return paras;
    }

    /**
     * @param taulukko
     * @return huonoimman
     */
    public static double huonoin(double[] taulukko) {
        double huonoin = Integer.MAX_VALUE;
        for (int i = 0; i<taulukko.length; i++) {
            if (taulukko[i] < huonoin) huonoin = taulukko[i];
        }
        return huonoin;
    }

}
