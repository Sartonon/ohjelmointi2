/**
 * 
 */
package demo5;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Linja-auto -luokka. Linja-autolla on mahdollisesti vapaita paikkoja ja paikkojen määrä
 * @author Santeri Rusila
 * @version 10.2.2013
 */
public class LinjaAuto {
    
    private int paikkojenMaara;
    private int vapaatPaikat;
    
    /**
     * Aluestaan Linja-auton tiedot
     * @param paikkojenMaara
     * @param vapaatPaikat
     */
    public LinjaAuto(int paikkojenMaara, int vapaatPaikat) {
        this.paikkojenMaara = paikkojenMaara;
        this.vapaatPaikat = vapaatPaikat;
    }
    
    /**
     * @param paikkojenMaara 
     */
    public LinjaAuto(int paikkojenMaara) {
        this.paikkojenMaara = paikkojenMaara;
        this.vapaatPaikat = paikkojenMaara;
    }
    
    /**
     * @param os
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream(os);
        int varattu = paikkojenMaara - vapaatPaikat;
        out.println("Paikkojen määrä " + paikkojenMaara + " paikkoja varattu " + varattu + " paikkoja vapaana " + vapaatPaikat);
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        LinjaAuto linkki = new LinjaAuto(100, 20);
        LinjaAuto linkki2 = new LinjaAuto(80);
        
        linkki.lisaa(20);
        linkki.vahenna(100);
        
        linkki2.lisaa(20);
        linkki2.vahenna(10);
        
        linkki.tulosta(System.out); // Paikkojen määrä 100 ja vapaita paikkoja 100
        linkki2.tulosta(System.out); // Paikkojen määrä 80 ja vapaita paikkoja 70

    }

    /**
     * @param vahennys vähennettävä määrä 
     * @return vapaat paikat
     *
     */
    public int vahenna(int vahennys) {
        if (vahennys > (paikkojenMaara - vapaatPaikat)) {
            int ali = ((paikkojenMaara - vapaatPaikat) - vahennys);
            vapaatPaikat = paikkojenMaara;
            return ali;
        }
        
        return vapaatPaikat = vapaatPaikat + vahennys;
    }

    /**
     * @param lisays lisättävä määrä
     * @return vapaiden paikkojen määrä tai yli menneiden määrä
     */
    public int lisaa(int lisays) {
        if (lisays > vapaatPaikat) {
            int yli = lisays - vapaatPaikat;
            vapaatPaikat = 0;
            return yli;
        }
        return vapaatPaikat = vapaatPaikat - lisays;
    }

    /**
     * @return vapaitten paikkojen määrä
     */
    public int getTilaa() {
        return vapaatPaikat;
    }

    /**
     * @return onko tilaa, false tai true
     */
    public boolean tilaa() {
        if (vapaatPaikat > 0) return true;
        return false;
    }

}
