package d8;

/**
 * Luokkien alut mäkihyppyä varten.  Huom!  jotakin voi vielä puuttua :-)
 * Poista rivit @SuppressWarnings("unused")
 * @author Vesa Lappalainen
 * @version 1.0, 21.02.2003
 */
public class Makihyppy {

    /**
     * Luokka yhtä mäkihypyn kierrosta varten
     */
    public static class Kierros {
        private final static int TUOMAREITA = 5;
        private double pituus; // hyppyjen pituudet metreinä
        private final double tuomarit[] = new double[TUOMAREITA];// tuomaripisteet
        /** Kierroksen alustaminen   */
        public Kierros() {
            pituus = 0;
        }
        
        public String toString() {
            StringBuilder merkkijono = new StringBuilder(pituus + "m ; ");
            for (int i = 0; i < TUOMAREITA; i++) {
                merkkijono.append(tuomarit[i]);
                merkkijono.append(" ");
            }
            return merkkijono.toString(); 
        }
    }
 

    /**
     * Luokka mäkihypyn yhden kilpailijan tulosta varten.
     * Sisältää monta kierosta.
     */
    public static class Tulos {
        private final static int KIERROKSIA = 2;
        private final Kierros kierros[] = new Kierros[KIERROKSIA];

        /** Tuloksen alustaminen */
        public Tulos() {
            for(int i = 0; i < kierros.length; i++) {
              kierros[i] = new Kierros();
            }
            
        }
    }


    /**
     * Luokka yhtä mäkihypyn kilpailijaa varten.
     * Sisältää mm. tuloksen.
     */
    public static class Kilpailija {
        private String nimi;
        private int nro;
        private final Tulos tulos = new Tulos();

        /**
         * Kilpailijan alustaminen
         * @param nimi kilpailijan nimi
         * @param nro kilpailijan kilpailunumero
         */
        public Kilpailija(String nimi,int nro) {
            this.nimi = nimi;
            this.nro = nro;
        }

        /** Tulostaa kilpailijan tiedot */
        @SuppressWarnings("static-method")
        public void tulosta() {
            System.out.println("Kilpailijan nimi: " + this.nimi);
            System.out.println("Kilpailijan numero: " + this.nro);
            if (this.tulos.kierros[0].pituus != 0) {
                for (int i = 0; i< 2; i++) {
                    System.out.print("Kierros " + (i+1) + ": ");
                    System.out.println(this.tulos.kierros[i]);
                }
            }
            
            System.out.println();
        }

        /**
         * @param kierros 
         * @param pituus 
         */
        public void setPituus(int kierros, int pituus) {
            this.tulos.kierros[kierros-1].pituus = pituus; 
        }

        /**
         * @param kierros 
         * @param tuomari 
         * @param pisteet 
         */
        public void setTuomari(int kierros, int tuomari, double pisteet) {
            this.tulos.kierros[kierros-1].tuomarit[tuomari-1] = pisteet;
        }

    }

    /**
     * Tyhjä aliohjelma kilpailua varten
     */
    @SuppressWarnings("static-method")
    public void kisa() {
        Kilpailija toni = new Kilpailija("Toni",3); 
        Kilpailija matti = new Kilpailija("Matti",7); 
        toni.tulosta(); 
        matti.tulosta(); 

        toni.setPituus(1,107);       // 1. kierros, 107 m
        toni.setPituus(2,100);       // 2. kierros, 100 m
        toni.setTuomari(2,1,19.0);   // 2. kierros, 1. tuomari, 19 p 
        toni.setTuomari(2,2,18.0);   // 2. kierros, 2. tuomari, 18 p
        toni.setTuomari(2,3,19.5); 
        toni.setTuomari(2,4,18.0); 
        toni.setTuomari(2,5,20.0); 

        matti.setPituus(1,125); 
        matti.setTuomari(1,1,20.0);
        matti.setTuomari(1,2,20.0);
        matti.setTuomari(1,3,20.0);
        matti.setTuomari(1,4,20.0);
        matti.setPituus(2,109);
        matti.setTuomari(2,1,20.0);
        matti.setTuomari(2,2,20.0);
        matti.setTuomari(2,3,20.0);
        matti.setTuomari(2,4,20.0);

        toni.tulosta(); 
        matti.tulosta();
    }

    /**
     * Testataan luokan kääntymistä
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Makihyppy kisa = new Makihyppy();
        kisa.kisa();
    }


}