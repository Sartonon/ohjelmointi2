package d6;

import fi.jyu.mit.ohj2.*;

/**
 *  John McLane (Bruce Willis) joutui elokuvassa Die Hard 3 ongelman eteen,
 *  jossa piti kahdella vesikanisterilla mitata jonkin muun suuruinen
 *  vesimäärä "tarkasti" ja näin estää pommin räjähtäminen.
 *  Koska aika meni varsin tiukalle, on vastaavien tilanteiden harjoittelemiseksi
 *  nyt tehty uusi menestysohjelma "Astia".
 *<br>
 *  Pelillä demonstroidaan/harjoitellaan miten voidaan kahdella astialla,
 *  5 l ja 8 l,  muodostaa kaikki mahdolliset tilavuudet 1-13 l.
 *  Pelissä on kaksi varsinaista astiaa: a5 ja a8, sekä kolmas apuastia
 *  ampari.  Nestettä voidaan kerrallaan kaataa yhdestä astiasta toiseen
 *  joko siten, että astian koko sisältö tyhjennetään jos se mahtuu
 *  tai astista kaadetaan sen verran että toinen astia tulee täyteen.
 *<br>
 *  Tee ohjelma jota voitasiin käyttää seuraavasti:
 *<br>
 *<pre>
 *  Käytössäsi on 8 ja 5 litran astia ja Ämpäri (100 l)
 *
 *  8 litran astiassa on 0 litraa
 *  5 litran astiassa on 0 litraa
 *  Mistä kaadetaan ja mihin >ä 8[ret]
 *  8 litran astiassa on 8 litraa
 *  5 litran astiassa on 0 litraa
 *  Mistä kaadetaan ja mihin >8 5[ret]
 *  8 litran astiassa on 3 litraa
 *  5 litran astiassa on 5 litraa
 *  Mistä kaadetaan ja mihin >5 ä[ret]
 *  8 litran astiassa on 3 litraa
 *  5 litran astiassa on 0 litraa
 *  Mistä kaadetaan ja mihin >8 5[ret]
 *  8 litran astiassa on 0 litraa
 *  5 litran astiassa on 3 litraa
 *  Mistä kaadetaan ja mihin >[ret]
 *</pre>
 * @author  Vesa Lappalainen
 * @version 1.0, 09.02.2003
 */
public class AstiaPeli {
    // #PACKAGEIMPORT    
    // #import fi.jyu.mit.ohj2.Suuntaaja;
    private static int[] maarat = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    
    /**
     * 
     */
    public AstiaPeli() {
        
    }
    


    /**
     * Tulostaa tiedot asioista
     * @param astiat taulukko josta tulostetaan
     * @example
     * <pre name="test">
     *  Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     *  Astia astiat[] = { new Astia("ä",100), new Astia("5",5), new Astia("8",8) };
     *  tulostaOhje(astiat);
     *  so.ero("Käytössäsi on 5.0 sekä 8.0 litran astiat ja Ämpari (100.0 l)\n") === null;
     *  so.palauta();
     * </pre>
     */
    public static void tulostaOhje(Astia astiat[]) {
        if ( astiat.length <= 0 ) return;
        String ja = "";
        System.out.print("Käytössäsi on ");
        for (int i = 1; i < astiat.length; i++) {
            System.out.print(ja + astiat[i].getTilavuus());
            ja = " sekä ";
        }
        System.out.println(" litran astiat ja Ämpari (" +
                       astiat[0].getTilavuus() + " l)");
    }


    /**
     * Etsii sen astian, jolla on annettu nimi.
     * @param astiat taulukko astoista, joista etsitään
     * @param nimi etsittävän astian nimi
     * @return astian indeksi taulukossa tai -1 jos ei löydy
     * @example
     * <pre name="test">
     *  Astia astiat[] = { new Astia("ä",100), new Astia("5",5), new Astia("8",8) };
     *  etsi(astiat,"ä") === 0;
     *  etsi(astiat,"Ä") === 0;
     *  etsi(astiat,"5") === 1;
     *  etsi(astiat,"8") === 2;
     *  etsi(astiat,"9") === -1;
     * </pre>
     */
    public static int etsi(Astia astiat[], String nimi) {
        for (int i = 0; i < astiat.length; i++)
            if ( astiat[i].oletko(nimi) ) return i;
        return -1;
    }


    /**
     * Tulostaa ohjeet astioiden nimistä.
     * @param astiat tulostettava tunnetuujen astioiden taulukko
     * @param mista mistä yritettiin kaataa
     * @param mihin mihin yritettiin kaataa
     * @example
     * <pre name="test">
     *  Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     *  Astia astiat[] = { new Astia("ä",100), new Astia("5",5), new Astia("8",8) };
     *  nimiOhje(astiat,"4","6");
     *  String tulos = "Nimeä ei tunneta: 4 tai 6\n" +
     *                 "Tunnetaan nimet: \n"         +
     *                 "ä 5 8 \n";
     *  so.ero(tulos) === null;             
     *  so.palauta();
     * </pre>
     */
    public static void nimiOhje(Astia astiat[], String mista, String mihin) {
        if ( !"?".equals(mista) )
            System.out.println("Nimeä ei tunneta: " + mista + " tai " + mihin);
        System.out.println("Tunnetaan nimet: ");
        for (int i = 0; i < astiat.length; i++)
            System.out.print(astiat[i].getNimi() + " ");
        System.out.println("");
    }


    /**
     * Testataan AstiaPeli-luokkaa
     * @param args ei käytössä
     * @example
     * <pre name="test">
     * Suuntaaja.StringInput si = new Suuntaaja.StringInput("");  
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * 
     * si.input("ä 8\n8 5\n4 5\n\n");  
     * main(null);
     * String tulos =
     *   "Käytössäsi on 5.0 sekä 8.0 litran astiat ja Ämpari (100.0 l)\n"+
     *   "5.0 litran astiassa on 0.0 litraa nestettä\n" +
     *   "8.0 litran astiassa on 0.0 litraa nestettä\n" +
     *   "Mistä kaadetaan ja mihin >"                   + // NOPMD
     *   "5.0 litran astiassa on 0.0 litraa nestettä\n" +
     *   "8.0 litran astiassa on 8.0 litraa nestettä\n" +
     *   "Mistä kaadetaan ja mihin >"                   +
     *   "5.0 litran astiassa on 5.0 litraa nestettä\n" +
     *   "8.0 litran astiassa on 3.0 litraa nestettä\n" +
     *   "Mistä kaadetaan ja mihin >"                   +
     *   "Nimeä ei tunneta: 4 tai 5\n"                  +
     *   "Tunnetaan nimet: \n"                          + 
     *   "ä 5 8 \n"                                     +
     *   "5.0 litran astiassa on 5.0 litraa nestettä\n" +
     *   "8.0 litran astiassa on 3.0 litraa nestettä\n" +
     *   "Mistä kaadetaan ja mihin >";
     * 
     * so.ero(tulos) === null; 
     * si.palauta(); so.palauta();
     * </pre>
     */
    public static void main(String[] args) {
        
        Astia astiat[] = { new Astia("ä", 100), new Astia("5", 5), new Astia("8", 8) };
        Astia ampari = astiat[0];
        ampari.tayta();

        tulostaOhje(astiat);

        while ( true ) {
            for (int i = 1; i < astiat.length; i++)
                System.out.println(astiat[i].getTilavuus() + " litran astiassa on " +
                           astiat[i].getMaara() + " litraa nestettä");
            String rivi = Syotto.kysy("Mistä kaadetaan ja mihin");
            if ( rivi.length() == 0 ) break;
            
            StringBuilder sb = new StringBuilder(rivi); // NOPMD
            String mista = Mjonot.erota(sb);
            String mihin = Mjonot.erota(sb);
            int imista = etsi(astiat, mista);
            int imihin = etsi(astiat, mihin);

            if ( (imista < 0) || (imihin < 0) )
                nimiOhje(astiat, mista, mihin);
            else astiat[imista].kaada(astiat[imihin]);
            onko(astiat);
            tulosta();
            if (onkoKaikki()) break;
        }
        
        System.out.println("Ratkaisit kaikki tilavuudet, peli päättyi");
    }


    private static boolean onkoKaikki() {
        int maara = 0;
        for(int i = 0; i<maarat.length; i++) {
            if(maarat[i] != 0) maara++;
        }
        if (maara == 13) return true;
        return false;
    }


    /**
     * 
     */
    public static void tulosta() {
        System.out.println();
        System.out.print("Olet ratkaissut tilavuudet:");
        for (int i = 0; i<maarat.length; i++) {
            if (maarat[i] != 0) System.out.print(" " + maarat[i]);
        }
        System.out.println();
        System.out.print("Ratkaisematta on");
        for (int a = 0; a<maarat.length; a++) {
            if (maarat[a] == 0) System.out.print(" " + (a+1));
        }
        System.out.println(".");
    }


    /**
     * @param astiat
     */
    public static void onko(Astia[] astiat) {
        for (int i = 1; i<astiat.length; i++) {
            int o = astiat[i].getMaara();
            if (o == 0) continue;
            maarat[o-1] = o;  
        }
        int yhteensa = 0;
        int toinen = 0;
        for (int a = 1; a<astiat.length; a++) {
            toinen = astiat[a].getMaara();
            yhteensa += toinen;
        }
        if (yhteensa != 0) maarat[yhteensa-1] = yhteensa;
        
    }


}