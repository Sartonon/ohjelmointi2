package demo5;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * Alustava luokka p�iv�m��r�� varten
 * @author Vesa Lappalainen ja Santeri Rusila
 * @version 1.0, 07.02.2003
 * @version 1.1, 10.02.2013
 */
public class Pvm {
    private int pv, kk, vv;


    /**
     * Palauttaa t�m�nhetkisen p�iv�yksen.
     * TODO: muutettava toimimaan oikein.
     */
    public void paivays() {
        pv = 30;
        kk = 1;
        vv = 2012;
    }


    /**
     * Alustetaan p�iv�m��r�. 0-arvot eiv�t muuta vastaavaa attribuuttia  
     * TODO: oikeellisuustarkitukset
     * @param ipv p�iv�n alustus
     * @param ikk kuukauden alustus
     * @param iivv vuoden alustus
     */
    public final void alusta(final int ipv, final int ikk, final int iivv) {
        if (ipv > 0)        this.pv = ipv;
        if (ikk > 0)        this.kk = ikk;
        if (iivv > 0)        this.vv = iivv;
        if (this.vv < 50)  this.vv += 2000;
        if (this.vv < 100) this.vv += 1900;
    }


    /** Alustetaan kaikki attribuutit oletusarvoon */
    public Pvm() {
        this(0, 0, 0);
    }


    /** 
     * Alustetaan kuukausi ja vuosi oletusarvoon
     * @param pv p�iv�n alustusarvo
     */
    public Pvm(int pv) {
        this(pv, 0, 0);
    }


    /**
     * Alustetaan vuosi oletusarvoon
     * @param pv p�iv�n alustusarvo
     * @param kk kuukauden oletusarvo
     */
    public Pvm(int pv, int kk) {
        this(pv, kk, 0);
    }


    /**
     * Alustetaan vuosi oletusarvoon
     * @param pv p�iv�n alustusarvo
     * @param kk kuukauden oletusarvo
     * @param vv vuoden alustusarvo
     */
    public Pvm(int pv, int kk, int vv) {
        paivays();
        alusta(pv, kk, vv);
    }


    /**
     * Palautetaan p�iv�ys merkkijonona
     * @return p�iv�ys merkkijonoja
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(10,2,2008);
     * pvm.toString() === "10.2.2008";
     * </pre>
     */
    @Override
    public String toString() {
        return pv + "." + kk + "." + vv;
    }


    /**
     * Alustetaan p�iv�n arvon merkkijonosta
     * @param s jono josta pvm otetaan
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm();
     * pvm.parse("11.05.02");  pvm.toString() === "11.5.2002";
     * pvm.parse("11.05.97");  pvm.toString() === "11.5.1997";
     * pvm.parse("17.3");      pvm.toString() === "17.3.1997";
     * pvm.parse("19");        pvm.toString() === "19.3.1997";
     * </pre>
     */
    public void parse(String s) {
        StringBuffer sb = new StringBuffer(s);
        int p = Mjonot.erota(sb, '.', 0);
        int k = Mjonot.erota(sb, '.', 0);
        int v = Mjonot.erota(sb, '.', 0);
        alusta(p, k, v);
    }


    /**
     * Testataan p�iv�m��r�luokkaa
     * @param args ei k�yt�ss�
     */
    public static void main(String[] args) {

        Pvm pvm = new Pvm(1,2,2012);
        
        System.out.println(pvm);

        pvm.parse("12.1.1995");    System.out.println(pvm);
        
        
        System.out.println(pvm.getPv()); // tulostaa 3
        System.out.println(pvm.getKk()); // tulostaa 1
        System.out.println(pvm.getV());  // tulostaa 1995
    }


    /**
     * @return p�iv�n
     * @example
     * <pre name="test">
     *  Pvm pvm = new Pvm();
     *  pvm.parse("12.1.1995");
     *  pvm.getPv() === 12;
     * </pre>
     */
    public int getPv() {
        return pv;
    }
    
    /**
     * @return kuukauden
     * @example
     * <pre name="test">
     *    Pvm pvm = new Pvm();
     *    pvm.parse("12.1.1995");
     *    pvm.getKk() === 1;
     * </pre>
     */
    public int getKk() {
        return kk;
    }
    
    /**
     * @return vuoden
     * @example
     * <pre name="test">
     *    Pvm pvm = new Pvm();
     *    pvm.parse("12.1.1995");
     *    pvm.getV() === 1995;
     * </pre>
     */
    public int getV() {
        return vv;
    }

}