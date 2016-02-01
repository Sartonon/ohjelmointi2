package d6;

import fi.jyu.mit.ohj2.*;

/**
 * Alustava luokka p‰iv‰m‰‰r‰‰ varten
 * @author Vesa Lappalainen
 * @version 1.0, 07.02.2003
 * @version 1.1, 14.02.2003
 * @version 1.2, 17.02.2003
 * @version 1.3, 11.02.2008
 */
public class Pvm {

    private int pv;
    private int kk;
    private int vv;
    /** Taulukko kuukausien pituuksista. Oma rivi  karkausvuosille */
    public static final int KPITUUDET[][] = {
            // 1  2  3  4  5  6  7  8  9 10 11 12
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }
    };


    /**
     *  Muuttaa p‰iv‰m‰‰r‰n nykyp‰iv‰lle.
     *  Todo: pit‰‰ vaihtaa hakemaan p‰iv‰m‰‰r‰ oikeasti. 
     *  Mutta perinn‰ss‰k‰‰n ei nyt saa k‰ytt‰‰ enemp‰‰ attribuutteja kuin t‰ss‰ on
     */
    public void paivays() {
        pv = 13;
        kk = 2;
        vv = 2012;
    }
    
    /**
     * @param vv
     * @return 0 tai 1
     */
    public static int karkausvuosi(int vv) {
        if ( vv % 400 == 0 ) return 1;
        if ( vv % 100 == 0 ) return 0;
        if ( vv % 4 == 0 ) return 1;
        return 0;
    }



    /**
     * Alustetaan p‰iv‰m‰‰r‰. 0-arvot eiv‰t muuta vastaavaa attribuuttia  
     * TODO: oikeellisuustarkistukset
     * @param ipv p‰iv‰n alustus
     * @param ikk kuukauden alustus
     * @param ivv vuoden alustus
     */
    public void alusta(int ipv, int ikk, int ivv) {
        if (ivv < 0) ivv = 0;
        if (ikk>12 || ikk<0) {
            ikk = 0;
            ipv = 0;
        }
        if ((karkausvuosi(ivv) == 1) && (ikk != 0)) {
            if (ipv > KPITUUDET[1][ikk-1] || ipv < 0) ipv = 0;
        }
        else if ((karkausvuosi(ivv) == 0)&& (ikk != 0)) {
            if (ipv > KPITUUDET[0][ikk-1] || ipv < 0) ipv = 0;
        }
        
        /* if (ipv > 31 || ipv < 0) ipv = 0;
        if (ikk > 12 || ikk < 0) ikk = 0;
        if (ivv < 0) ivv = 0; */
        
        if ( ipv > 0 ) this.pv = ipv;
        if ( ikk > 0 ) this.kk = ikk;
        if ( ivv > 0 ) this.vv = ivv;
        if ( this.vv < 50 ) this.vv += 2000;
        if ( this.vv < 100 ) this.vv += 1900;
    }
    
    



    /** Alustetaan kaikki attribuutit oletusarvoon */
    public Pvm() {
        this(0, 0, 0);
    }


    /** 
     * Alustetaan kuukausi ja vuosi oletusarvoon
     * @param pv p‰iv‰n alustusarvo
     */
    public Pvm(int pv) {
        this(pv, 0, 0);
    }


    /**
     * Alustetaan vuosi oletusarvoon
     * @param pv p‰iv‰n alustusarvo
     * @param kk kuukauden oletusarvo
     */
    public Pvm(int pv, int kk) {
        this(pv, kk, 0);
    }


    /**
     * Alustetaan vuosi oletusarvoon
     * @param pv p‰iv‰n alustusarvo
     * @param kk kuukauden oletusarvo
     * @param vv vuoden alustusarvo
     */
    public Pvm(int pv, int kk, int vv) {
        paivays();
        alusta(pv, kk, vv);
    } // NOPMD


    /**
     * Alustetaan p‰iv‰m‰‰r‰ merkkijonosta
     * @param s muotoa 12.3.2008 oleva merkkijono
     */
    public Pvm(String s) {
        paivays();
        pvmParse(s);
    } // NOPMD 


    /**
     * P‰iv‰m‰‰r‰ merkkijonona
     * @return p‰iv‰m‰‰r‰ muodossa 17.2.2007
     * @example
     * <pre name="test">
     *   Pvm tammi2011 = new Pvm(1,1,2011);
     *   tammi2011.toString() === "1.1.2011"
     *   Pvm helmi2011 = new Pvm(1,2,2011);
     *   helmi2011.toString() === "1.2.2011"
     *   Pvm tanaan = new Pvm(14,2,2011);
     *   tanaan.toString()    === "14.2.2011"
     *   Pvm maalis97 = new Pvm(1,3,1997);
     *   maalis97.toString()  === "1.3.1997"
     *   Pvm paiva = new Pvm(30,2,2012);
     *   paiva.toString() === "13.2.2012"
     *   Pvm paiva2 = new Pvm(30,2,0);
     *   paiva2.toString() === "13.2.2012"
     *   Pvm paiva3 = new Pvm(100,100,2013);
     *   paiva3.toString() === "13.2.2013"
     * </pre>
     */
    @Override
    public String toString() {
        return pv + "." + kk + "." + vv;
    }


    /**
     * Ottaa p‰iv‰m‰‰r‰n tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille k‰ytet‰‰n t‰m‰n p‰iv‰n arvoa oletuksena.
     * @param sb tutkittava merkkijono
     */
    protected final void pvmParse(StringBuilder sb) {
        int p = Mjonot.erota(sb, '.', 0);
        int k = Mjonot.erota(sb, '.', 0);
        int v = Mjonot.erota(sb, ' ', 0);
        alusta(p, k, v);
        // tai alusta(Mjonot.erota(sb,'.',0),Mjonot.erota(sb,'.',0),Mjonot.erota(sb,'.',0));
    }


    /**
     * Ottaa p‰iv‰m‰‰r‰n tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille k‰ytet‰‰n t‰m‰n p‰iv‰n arvoa oletuksena.
     * @param s tutkittava merkkijono
     */
    protected final void pvmParse(String s) {
        pvmParse(new StringBuilder(s));
    }


    /**
     * Ottaa p‰iv‰m‰‰r‰n tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille k‰ytet‰‰n t‰m‰n p‰iv‰n arvoa oletuksena.
     * @param s tutkittava merkkijono
     * 
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(11,3,2003);
     * pvm.parse("12");           pvm.toString() === "12.3.2003";
     * pvm.parse("..2001");       pvm.toString() === "12.3.2001";
     * pvm.parse("..2009 14:30"); pvm.toString() === "12.3.2009"; 
     * </pre>
     */
    public void parse(String s) {
        pvmParse(s);
    }


    /**
     * Ottaa p‰iv‰m‰‰r‰n tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille k‰ytet‰‰n t‰m‰n p‰iv‰n arvoa oletuksena.
     * Merkkijonosta otetaan pois vain se osa, jota tarvitaan.
     * @param sb tutkittava merkkijono
     * 
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(11,3,2003);
     * StringBuilder jono = new StringBuilder("12");
     * pvm.parse(jono); pvm.toString() === "12.3.2003"; jono.toString() === "";
     * jono = new StringBuilder("..2001");
     * pvm.parse(jono); pvm.toString() === "12.3.2001"; jono.toString() === "";
     * jono = new StringBuilder("..2009 14:30");
     * pvm.parse(jono); pvm.toString() === "12.3.2009"; jono.toString() === "14:30";
     * </pre>
     */
    public void parse(StringBuilder sb) {
        pvmParse(sb);
    }


    // Lis‰tty saantimetodit:

    /**
     * @return p‰iv‰n arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("14.2.2011");
     *   pv.getPv() === 14;
     * </pre>
     */
    public int getPv() {
        return pv;
    }


    /**
     * @return kuukauden arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("14.2.2011");
     *   pv.getKk() === 2;
     * </pre>
     */
    public int getKk() {
        return kk;
    }


    /**
     * @return vuoden arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("14.2.2011");
     *   pv.getVv() === 2011;
     * </pre>
     */
    public int getVv() {
        return vv;
    }


    /**
     * Testataan p‰iv‰m‰‰r‰-luokkaa
     * @param args ei k‰ytˆss‰
     */
    public static void main(String[] args) {
        Pvm p1 = new Pvm(1,10,1999);
        Pvm p2 = new Pvm(1,10,1998);
        int a = compareTo(p1,p2);
        System.out.println(a);
        
        int i = p1.compareTo(p2);
        System.out.println(i);
        
        boolean b = p1.equals(p2);
        System.out.println(b);
        

    }



    /**
     * @param p2
     * @return -1, 0 tai 1
     * @example
     * <pre name="test">
     *    Pvm p10 = new Pvm(21,2,1876);
     *    Pvm p11 = new Pvm(21,2,1875);
     *    p10.compareTo(p11) === 1
     *    Pvm p12 = new Pvm(20,2,1876);
     *    Pvm p13 = new Pvm(21,2,1876);
     *    p12.compareTo(p13) === -1
     *    Pvm p14 = new Pvm(21,2,1876);
     *    Pvm p15 = new Pvm(21,2,1876);
     *    p14.compareTo(p15) === 0
     *    Pvm p16 = new Pvm(21,3,2012);
     *    Pvm p17 = new Pvm(21,2,2012);
     *    p16.compareTo(p17) === 1
     * </pre>
     */
    public int compareTo(Pvm p2) {
        if (this.getPv() == p2.getPv() && this.getKk() == p2.getKk() && this.getVv() == p2.getVv())
            return 0;
        if (this.getVv() < p2.getVv()) return -1;
        if (this.getVv() == p2.getVv()) {
            if (this.getKk() < p2.getKk()) return -1;
            if (this.getKk() == p2.getKk()) {
                if (this.getPv() < p2.getPv()) return -1;
                else return 1;
            } 
        }
        return 1;
        
    }
    
    
    /**
     * @param p
     * @return lol
     * @example
     * <pre name="test">
     *    Pvm pp1 = new Pvm(21,2,1875);
     *    Pvm pp2 = new Pvm(21,2,1875);
     *    pp1.equals(pp2) === true
     *    Pvm pp3 = new Pvm(20,2,1876);
     *    Pvm pp4 = new Pvm(21,2,1876);
     *    pp3.equals(pp4) === false
     *    Pvm pp5 = new Pvm(21,2,1876);
     *    Pvm pp6 = new Pvm(21,2,1876);
     *    pp5.equals(pp6) === true
     *    Pvm pp7 = new Pvm(21,3,2012);
     *    Pvm pp8 = new Pvm(21,2,2012); 
     *    pp7.equals(pp8) === false
     * </pre>
     */
    public boolean equals(Pvm p) {
        if (this.getPv() == p.getPv() && this.getKk() == p.getKk() && this.getVv() == p.getVv())
            return true;
        return false;
    }

    /**
     * @param p1
     * @param p2
     * @return -1, 0, tai 1
     * @example
     * <pre name="test">
     *    Pvm p1 = new Pvm(21,2,1876);
     *    Pvm p2 = new Pvm(21,2,1875);
     *    compareTo(p1,p2) === 1
     *    Pvm p3 = new Pvm(20,2,1876);
     *    Pvm p4 = new Pvm(21,2,1876);
     *    compareTo(p3,p4) === -1
     *    Pvm p5 = new Pvm(21,2,1876);
     *    Pvm p6 = new Pvm(21,2,1876);
     *    compareTo(p5,p6) === 0
     *    Pvm p7 = new Pvm(21,3,2012);
     *    Pvm p8 = new Pvm(21,2,2012);
     *    compareTo(p7,p8) === 1
     * </pre>
     */
    public static int compareTo(Pvm p1, Pvm p2) {
       if (p1.getPv() == p2.getPv() && p1.getKk() == p2.getKk() && p1.getVv() == p2.getVv())
           return 0;
       if (p1.getVv() < p2.getVv()) return -1;
       if (p1.getVv() == p2.getVv()) {
           if (p1.getKk() < p2.getKk()) return -1;
           if (p1.getKk() == p2.getKk()) {
               if (p1.getPv() < p2.getPv()) return -1;
               else return 1;
           } 
       }
       return 1;
    }
}
