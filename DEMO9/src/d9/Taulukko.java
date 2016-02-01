package d9;

/**
 * Esimerkki dynaamisesta taulukosta
 * @author Vesa Lappalainen @version 1.0, 02.03.2002
 * @author Santtu Viitanen @version 1.1, 21.07.2011
 * @example
 * <pre name="test">
 *  #THROWS Taulukko.TaulukkoTaysiException
 *  Taulukko luvut = new Taulukko();
 *  luvut.lisaa(0); luvut.lisaa(2); luvut.lisaa(99);
 *  luvut.toString() === "0,2,99"; 
 *  luvut.set(1,4); luvut.toString() === "0,4,99"; 
 *  int luku = luvut.get(2);
 *  luku === 99;
 *  luvut.get(2) === 99;
 *  luvut.set(21, 4); #THROWS IndexOutOfBoundsException 
 *  luvut.lisaa(0); luvut.lisaa(0); //taulukko täyteen
 *  luvut.lisaa(0);  #THROWS Taulukko.TaulukkoTaysiException
 * </pre>
 */
public class Taulukko {
    /** Luokka täyden taulukon poikkeusta varten  */
    public static class TaulukkoTaysiException extends Exception {
        private static final long serialVersionUID = 1L;


        TaulukkoTaysiException(String viesti) {
            super(viesti);
        }
    }

    private int alkiot[];
    private int lkm;


    /**
     * Alustetaan 5 kokoinen taulukko 
     */
    public Taulukko() {
        alkiot = new int[5];
    }


    /**
     * Alutetaan valitun kokoinen taulukko
     * @param koko taulukon koko
     */
    public Taulukko(int koko) {
        alkiot = new int[koko];
    }


    /**
     * Lisätään taulukkoon yksi alkio
     * @param luku lisättävä alkio
     * @throws TaulukkoTaysiException jos taulukko täysi
     */
    public void lisaa(int luku) throws TaulukkoTaysiException {
        if (lkm >= alkiot.length) throw new TaulukkoTaysiException("Tila loppu");
        alkiot[lkm++] = luku;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        String erotin = "";
        for (int i = 0; i < lkm; i++) {
            s.append(erotin + alkiot[i]);
            erotin = ",";
        }
        return s.toString();
    }


    /**
     * Asetetaan taulukon i's alkio
     * @param i mihin paikkaan astetaan
     * @param luku mikä arvo laitetaan
     * @throws IndexOutOfBoundsException jos väärä indeksi
     */
    public void set(int i, int luku) throws IndexOutOfBoundsException {
        if ((i < 0) || (lkm <= i)) throw new IndexOutOfBoundsException("i = " + i);
        alkiot[i] = luku;
    }


    /**
     * Palautetana paikasssa i oleva luku
     * @param i mistä paikasta luku otetaan
     * @return paikassa i olevan luvun arvo
     * @throws IndexOutOfBoundsException jos indeksi väärin
     */
    public int get(int i) throws IndexOutOfBoundsException {
        if ((i < 0) || (lkm <= i)) throw new IndexOutOfBoundsException("i = " + i);
        return alkiot[i];
    }
    
    
    public Taulukko clone() {
        Taulukko kopio = new Taulukko(this.alkiot.length);
        for (int i = 0; i < this.lkm; i++) {
            try {
                kopio.lisaa(this.get(i));
            } catch (IndexOutOfBoundsException | TaulukkoTaysiException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        } 
        return kopio; 
    }
    
    /**
     * @param args
     * @throws TaulukkoTaysiException
     * @example
     * <pre name="test">
     *   #THROWS Taulukko.TaulukkoTaysiException
     *   Taulukko lukuja = new Taulukko(10);
     *   lukuja.lisaa(5);
     *   lukuja.lisaa(6);
     *   Taulukko lukuja1 = lukuja.clone();
     *   lukuja.lisaa(7);
     *   lukuja1.toString() === "5,6"
     *   Taulukko luvut1 = new Taulukko(10);
     *   luvut1.lisaa(1);
     *   luvut1.lisaa(2);
     *   luvut1.lisaa(3);
     *   luvut1.lisaa(3);
     *   luvut1.lisaa(6);
     *   luvut1.lisaa(6);
     *   luvut1.lisaa(8);
     *   luvut1.lisaa(9);
     *   luvut1.poista(1);
     *   luvut1.toString() === "2,3,3,6,6,8,9";
     *   luvut1.poista(6);
     *   luvut1.toString() === "2,3,3,8,9"
     *   
     * </pre>
     */
    public static void main(String[] args) throws TaulukkoTaysiException {
        Taulukko luvut = new Taulukko(7);
        luvut.lisaa(0); luvut.lisaa(2);
        System.out.println(luvut); // Tulostaa " 0 2" 
        Taulukko taul = luvut.clone();
        luvut.lisaa(77);
        luvut.lisaa(22);
        luvut.lisaa(33);
        luvut.lisaa(45);
        luvut.lisaa(4);
        System.out.println(taul);  // tulostaa saman kuin edellä " 0 2"
        System.out.println(luvut);
        luvut.poista(2);
        System.out.println(luvut);
        luvut.poista(77);
        System.out.println(luvut);
        luvut.poista(4);
        System.out.println(luvut);
    }


    /**
     * @param i
     */
    public void poista1(int i) {
        
    }


    /**
     * @param poistettava
     */
    public void poista(int poistettava) {
        int poistetut = 0;
        for (int i = 0; i < this.lkm; i++) {
            if (this.get(i) == poistettava) {
                poistetut++;
                this.set(i, -1); 
            }
        }
        
        for (int i = 0; i < this.lkm; i++) {
            if (this.get(i) == -1) {
                for (int b = i; b < this.lkm-1; b++) {
                    if (this.get(b+1) != -1){
                        this.set(b, this.get(b+1));
                        this.set(b+1, -1);
                    }
                }
            }
        }
        lkm = lkm-poistetut;
    }
}
