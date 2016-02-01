package demo5;

import fi.jyu.mit.ohj2.Mjonot;
import fi.jyu.mit.ohj2.Syotto;

/**
 *  John McLane (Bruce Willis) joutui elokuvassa Die Hard 3 ongelman eteen,
 *  jossa piti kahdella vesikanisterilla mitata jonkin muun suuruinen
 *  vesim��r� "tarkasti" ja n�in est�� pommin r�j�ht�minen.
 *  Koska aika meni varsin tiukalle, on vastaavien tilanteiden harjoittelemiseksi
 *  nyt tehty uusi menestysohjelma "Astia".
 *<br>
 *  Pelill� demonstroidaan/harjoitellaan miten voidaan kahdella astialla,
 *  5 l ja 8 l,  muodostaa kaikki mahdolliset tilavuudet 1-13 l.
 *  Peliss� on kaksi varsinaista astiaa: a5 ja a8, sek� kolmas apuastia
 *  ampari.  Nestett� voidaan kerrallaan kaataa yhdest� astiasta toiseen
 *  joko siten, ett� astian koko sis�lt� tyhjennet��n jos se mahtuu
 *  tai astista kaadetaan sen verran ett� toinen astia tulee t�yteen.
 *<br>
 *  Tee ohjelma jota voitasiin k�ytt�� seuraavasti:
 *<br>
 *<pre>
 *  K�yt�ss�si on 8 ja 5 litran astia ja �mp�ri (100 l)
 *
 *  8 litran astiassa on 0 litraa
 *  5 litran astiassa on 0 litraa
 *  Mist� kaadetaan ja mihin >� 8[ret]
 *  8 litran astiassa on 8 litraa
 *  5 litran astiassa on 0 litraa
 *  Mist� kaadetaan ja mihin >8 5[ret]
 *  8 litran astiassa on 3 litraa
 *  5 litran astiassa on 5 litraa
 *  Mist� kaadetaan ja mihin >5 �[ret]
 *  8 litran astiassa on 3 litraa
 *  5 litran astiassa on 0 litraa
 *  Mist� kaadetaan ja mihin >8 5[ret]
 *  8 litran astiassa on 0 litraa
 *  5 litran astiassa on 3 litraa
 *  Mist� kaadetaan ja mihin >[ret]
 *</pre>
 * @author  Vesa Lappalainen Santeri Rusila
 * @version 1.0, 10.02.2013
 */
public class Astia {
    private final String nimi;
    private final double tilavuus;
    private double maara;


    /**
     * Alustaa uuden astian tietyn kokoiseksi ja luonnollisetsi tyhj�ksi
     * @param nimi uuden astian nimi
     * @param tilavuus uuden astian tilavuus
     * @example
     * <pre name="test">
     * Astia astia5l = new Astia("5l",5);
     * astia5l.getNimi()     === "5l";
     * astia5l.getMaara()    ~~~ 0;
     * astia5l.getTilavuus() ~~~ 5;
     * </pre>
     */
    public Astia(String nimi, double tilavuus) {
        this.nimi = nimi;
        this.tilavuus = tilavuus;
        this.maara = 0;
    }


    /**
     * T�ytt�� astian piripintaan asti
     * @example
     * <pre name="test">
     * Astia astia5l = new Astia("5l",5);
     * astia5l.getMaara()    ~~~ 0;
     * astia5l.tayta();
     * astia5l.getMaara()    ~~~ 5;
     * </pre>
     */
    public void tayta() {
        maara = tilavuus;
    }


    /**
     * Kaataa astiaan joko lis�� tai v�hent��, yli ei saa menn� eik�
     * pakkasen puolelle
     * @param lisa paljonko nestett� laitetaan
     * @return paljonko j�i mahtumatta
     * @example
     * <pre name="test">
     *    Astia a5 = new Astia("5",5);
     *    a5.kaada(3) ~~~ 0.0;     a5.getMaara() ~~~ 3.0;
     *    a5.kaada(5) ~~~ 3.0;     a5.getMaara() ~~~ 5.0;
     *    a5.kaada(-3) ~~~ 0.0;    a5.getMaara() ~~~ 2.0;
     *    a5.kaada(-3) ~~~ -1.0;   a5.getMaara() ~~~ 0.0;
     * </pre>
     */
    public double kaada(double lisa) {
        if ( lisa < 0 ) {
            double eiRiita = getMaara() + lisa;
            if ( eiRiita < 0 ) maara = 0;
            else { maara += lisa; eiRiita = 0; }
            return eiRiita;
        }
        
        double eiMahu = lisa - getTyhjaa();
        if ( eiMahu < 0 ) { maara += lisa; eiMahu = 0; }
        else { maara = tilavuus; }
        return eiMahu;
        
    }


    /**
     * Kaataa t�st� astiasta (this) toiseen astiaan niin paljon kuin toiseen
     * mahtuu tai t�st� astiasta on antaa.
     * @param astia astia johon kaadetaan
     * 
     * @example
     * <pre name="test">
     *  Astia ampari = new Astia("�",100);
     *  Astia a8     = new Astia("8",8);
     *  Astia a5     = new Astia("5",5);
     *  
     *  ampari.kaada(a8);  a8.getMaara() ~~~ 0;     ampari.getMaara() ~~~ 0.0;
     *  ampari.tayta();
     *  ampari.kaada(a8);  a8.getMaara() ~~~ 8.0;   ampari.getMaara() ~~~ 92.0;
     *  
     *  a8.kaada(a5);      a8.getMaara() ~~~ 3.0;   a5.getMaara() ~~~ 5.0;
     *  a5.kaada(ampari);  a5.getMaara() ~~~ 0.0;   ampari.getMaara() ~~~ 97.0;
     *  a8.kaada(a5);      a8.getMaara() ~~~ 0.0;   a5.getMaara() ~~~ 3.0;
     *  ampari.kaada(a8);
     *  a8.kaada(a5);      a8.getMaara() ~~~ 6.0;   a5.getMaara() ~~~ 5.0;
     * </pre>
     */
    public void kaada(Astia astia) {
        double siirrettava = astia.getTyhjaa();
        if ( getMaara() < siirrettava ) siirrettava = getMaara();
        astia.kaada(siirrettava);
        kaada(-siirrettava);
    }


    /**
     * Palautetaan nsteen m��r� astiassa 
     * @return nesteen m��r�
     * @example
     * <pre name="test">
     * Astia astia5l = new Astia("5l",5);
     * astia5l.getMaara()    ~~~ 0;
     * astia5l.tayta();
     * astia5l.getMaara()    ~~~ 5;
     * </pre>
     */
    public double getMaara() {
        return maara;
    }


    /**
     * Palautetaan astion tilavuus
     * @return astian tilavuus
     * @example
     * <pre name="test">
     * Astia astia5l = new Astia("5l",5);
     * astia5l.getTilavuus() ~~~ 5;
     * </pre>
     */
    public double getTilavuus() {
        return tilavuus;
    }


    /**
     * Palautetaan astiossa olevan vapaan tilan m��r�.
     * @return vapaan tilan m��r�.
     * @example
     * <pre name="test">
     * Astia astia5l = new Astia("5l",5);
     * astia5l.getTyhjaa()   ~~~ 5;
     * astia5l.tayta();
     * astia5l.getTyhjaa()   ~~~ 0;
     * </pre>
     */
    public double getTyhjaa() {
        return getTilavuus() - getMaara();
    }


    /**
     * Palautetaan astian nimi
     * @return astian nimi
     * @example
     * <pre name="test">
     * Astia astia5l = new Astia("5l",5);
     * astia5l.getNimi()     === "5l";
     * </pre>
     */
    public String getNimi() {
        return nimi;
    }


    /**
     * Tutkitaan onko astian nimi etsitty
     * @param mika verrattava nimi
     * @return true jos on samat, false muuten
     * 
     * @example
     * <pre name="test">
     * Astia ampari  = new Astia("�mp�ri",100);
     * ampari.oletko("�") === false;
     * ampari.oletko("�mp�ri") === true;
     * ampari.oletko("�MP�RI") === true;
     * </pre>
     */
    public boolean oletko(String mika) {
        return getNimi().equalsIgnoreCase(mika);
    }


    /**
     * Testaan astioita
     * @param args ei k�yt�ss�
     */
    public static void main(String[] args) { 
        Astia astiat[] = { new Astia("�", 100), 
                new Astia("5", 5), new Astia("8", 8) };
        Astia ampari = astiat[0];
        Astia a5 = astiat[1];
        Astia a8 = astiat[2];
        ampari.tayta();
        
        while ( true ) {
            for (int i = 1; i < astiat.length; i++)
                System.out.println(astiat[i].getTilavuus()+" litran astiassa on "+
                                   astiat[i].getMaara() + " litraa nestett�");
            String rivi = Syotto.kysy("Mist� kaadetaan ja mihin");
            StringBuilder sb = new StringBuilder(rivi); 
            String mista = Mjonot.erota(sb);
            String mihin = Mjonot.erota(sb);
            if ((mista.equals("�")) && (mihin.equals("8"))) ampari.kaada(a8);
            if ((mista.equals("8")) && (mihin.equals("5"))) a8.kaada(a5);
            if ((mista.equals("5")) && (mihin.equals("8"))) a5.kaada(a8);
            if ((mista.equals("8")) && (mihin.equals("�"))) a8.kaada(ampari);
            if ((mista.equals("�")) && (mihin.equals("5"))) ampari.kaada(a5);
            if ((mista.equals("5")) && (mihin.equals("�"))) a5.kaada(ampari);
            if ( rivi.length() == 0 ) break;
            
            // StringBuilder sb = new StringBuilder(rivi); 
            // String mista = Mjonot.erota(sb);
            // String mihin = Mjonot.erota(sb);
            
        }
        
    }
    
}
