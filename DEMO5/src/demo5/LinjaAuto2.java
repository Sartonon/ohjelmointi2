/**
 * 
 */
package demo5;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Linja-auto -luokka. Linja-autolla on mahdollisesti vapaita paikkoja ja paikkojen m��r�
 * @author Santeri Rusila
 * @version 10.2.2013
 */
public class LinjaAuto2 {
    
    private int paikkojenMaara;
    private int vapaatPaikat;
    
    /**
     * Aluestaan Linja-auton tiedot
     * @param paikkojenMaara
     * @param vapaatPaikat
     */
    public LinjaAuto2(int paikkojenMaara, int vapaatPaikat) {
        this.paikkojenMaara = paikkojenMaara;
        this.vapaatPaikat = vapaatPaikat;
    }
    
    /**
     * @param paikkojenMaara 
     */
    public LinjaAuto2(int paikkojenMaara) {
        this.paikkojenMaara = paikkojenMaara;
        this.vapaatPaikat = paikkojenMaara;
    }
    
    /**
     * @param os
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream(os);
        int varattu = paikkojenMaara - vapaatPaikat;
        out.println("Paikkojen m��r� " + paikkojenMaara + " paikkoja varattu " + varattu + " paikkoja vapaana " + vapaatPaikat);
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        LinjaAuto2 pikkubussi = new LinjaAuto2(10);
        LinjaAuto2 isobussi = new LinjaAuto2(45);
        pikkubussi.lisaa(4);    pikkubussi.tulosta(System.out); // 10,4,6
        isobussi.lisaa(30);     isobussi.tulosta(System.out);   // 45,30,15
        int yli = pikkubussi.lisaa(15);
        isobussi.lisaa(yli);    
        pikkubussi.tulosta(System.out);                         // 10,10,0
        isobussi.tulosta(System.out);                           // 45,39,6
        if ( pikkubussi.getTilaa() > 0 )
            System.out.println("Pieneen bussiin mahtuu!");   // ei tulosta
        if ( isobussi.tilaa() )
            System.out.println("Isoon bussiin mahtuu!");     // tulostaa
        int vajaa = pikkubussi.vahenna(12);                  // vajaa = -2
        if ( vajaa < 0 )                                      
            System.out.println("Pikkubussissa ei edes ole n�in montaa!");
        pikkubussi.tulosta(System.out);                         // 10,0,10

    }

    /**
     * @param vahennys v�hennett�v� m��r� 
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
     * @param lisays lis�tt�v� m��r�
     * @return vapaiden paikkojen m��r� tai yli menneiden m��r�
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
     * @return vapaitten paikkojen m��r�
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