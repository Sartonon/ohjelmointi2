package erottaminen;

import java.util.ArrayList;
import java.util.List;

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
 * Toteutettu peli-luokaksi, jossa k�ytet��n hyv�ksi Astia2-luokkaa.
 * Tarkistaa my�s pelin aikana l�ydetyt kombinaatiot
 * Valitettavasti AstiaPeliin piti lis�t� metodit getTilavuus ja getMaara
 * @author  Vesa Lappalainen
 * @version 1.0, 09.02.2003
 * @version 1.1, 14.02.2003
 * @version 1.2, 15.02.2003
 * @version 1.3, 13.02.2011
 */
public class AstiaPeli {
    // #import fi.jyu.mit.ohj2.Suuntaaja;

    /**
     * 
     */
    private ArrayList<Astia> astiat = new ArrayList<Astia>();
    /**
     * @return astiat
     */
    public ArrayList<Astia> getAstiat() {
        return astiat;
    }


    private Esiintymat esiintymat;


    /**
     * @return esiintymat
     */
    public Esiintymat getEsiintymat() {
        return esiintymat;
    }


    /**
     * Astiapelin alustus.  Laitetaan aina �mp�ri mukaan.
     * @example
     * <pre name="test">
     *    AstiaPeli peli = new AstiaPeli();
     *    peli.etsi("�").getTilavuus() ~~~ 100.0;
     * </pre>
     */
    public AstiaPeli() {
        lisaaYksiAstia("�", 100);
        getAmpari().tayta();
    }


    /**
     * Palauttaa �mp�rin
     * @return viite �mp�riin
     * @example
     * <pre name="test">
     *    AstiaPeli peli = new AstiaPeli();
     *    peli.getAmpari().getTilavuus() ~~~ 100.0;
     * </pre>
     */
    public final Astia getAmpari() {
        return anna(0);
    }
    
    
    /**
     * Palautetaan astioiden lukum��r� peliss�
     * @return astioiden lukum��r�
     * @example
     * <pre name="test">
     *    AstiaPeli peli = new AstiaPeli();
     *    peli.getLkm() === 1;
     * </pre>
     */
    public int getLkm() {
        return astiat.size();
    }


    /**
     * Lis�t��n uusi astia peliin.  Luodaan t�t� varten uusi astia.
     * Apumetodi muodostajasta kutsuttavaksi koska muodostajasta saa kutsua
     * vain final metodeja.
     * @param nimi lis�tt�v�n astian nimi
     * @param tilavuus lis�tt�v�n astian tilavuus
     * @return lis�tty astia
     */
    private final Astia lisaaYksiAstia(String nimi, double tilavuus) {
        Astia astia = new Astia(nimi, tilavuus); 
        astiat.add(astia);
        return astia;
    }


    /**
     * Lis�t��n uusi astia peliin.  Luodaan t�t� varten uusi astia.
     * @param nimi lis�tt�v�n astian nimi
     * @param tilavuus lis�tt�v�n astian tilavuus
     * @return lis�tty astia
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.getLkm() === 1;
     *  peli.lisaaAstia("5",5);
     *  peli.getLkm() === 2;
     *  peli.lisaaAstia("8",8);
     *  peli.getLkm() === 3;
     * </pre>
     */
    public Astia lisaaAstia(String nimi, double tilavuus) {
        Astia astia = lisaaYksiAstia(nimi, tilavuus); 
        alusta();
        return astia;
    }


    /**
     * Palautetaan i:s astia joukosta
     * @param i monesko astia
     * @return i's astia
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.anna(0).getNimi() === "�";
     *  peli.lisaaAstia("5",5);
     *  peli.anna(1).getNimi() === "5";
     * </pre>
     */
    public Astia anna(int i) {
        return astiat.get(i);
    }



    /**
     * Palautetaan astioissa olevat nestem��r�t �mp�ri� lukuunottamatta
     * @return astioissa olevat nestem��r�t merkkijonona
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();  peli.lisaaAstia("5",5);  peli.lisaaAstia("8",8);
     *  peli.getMaarat() === "0.0 0.0";
     *  peli.kaada(peli.etsi("�"),peli.etsi("8")); peli.getMaarat() === "0.0 8.0";
     *  peli.kaada(peli.etsi("8"),peli.etsi("5")); peli.getMaarat() === "5.0 3.0";
     * </pre>
     */
    public String getMaarat() {
        StringBuilder tulos = new StringBuilder();
        for (int i = 1; i < getLkm(); i++)
            tulos.append(anna(i).getMaara() + " ");
        return tulos.toString().trim();
    }


    /**
     * Etsii sen astian, jolla on annettu nimi.
     * @param nimi etsitt�v�n astian nimi
     * @return astian viite tai null jos ei l�ydy
     * 
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();  peli.lisaaAstia("5",5);  peli.lisaaAstia("8",8);
     *  peli.etsi("�").oletko("�") === true;
     *  peli.etsi("�").oletko("�") === true;
     *  peli.etsi("5").getTilavuus() ~~~ 5.0;
     *  peli.etsi("8").getTilavuus() ~~~ 8.0;
     *  peli.etsi("9") === null;
     * </pre>
     */
    public Astia etsi(String nimi) {
        for (Astia astia : astiat)
            if ( astia.oletko(nimi) ) return astia;
        return null;
    }



    
    /**
     * Kaataa astiasta toiseen
     * @param mista mist� astiasta kaadetaan
     * @param mihin mihin astiaan kaadetaan.
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();  peli.lisaaAstia("5",5);  peli.lisaaAstia("8",8);
     *  peli.getMaarat() === "0.0 0.0";
     *  peli.kaada(peli.etsi("�"),peli.etsi("8")); peli.getMaarat() === "0.0 8.0";
     *  peli.kaada(peli.etsi("8"),peli.etsi("5")); peli.getMaarat() === "5.0 3.0";
     * </pre>
     */
    public void kaada(Astia mista, Astia mihin) {
        mista.kaada(mihin);
        lisaaEsiintymat(); // ver.1.2
    }
    
    
    
    /**
     * Alustetaan peli astioiden m��r�n mukaan.
     */
    private void alusta() {
        int yla = (int)(astioidenSumma()); // ver.1.2
        esiintymat = new Esiintymat(1, yla); // ver.1.2
    }


    /**
     * @param i mink� astia m��r� halutaan
     * @return i:n astian m��r�n
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.getMaara(0) ~~~ 100;
     *  Astia a5 = peli.lisaaAstia("5",5);
     *  peli.getMaara(1) ~~~ 0;
     *  peli.kaada(peli.getAmpari(),a5); peli.getMaara(1) ~~~ 5;
     * </pre>
     */
    public double getMaara(int i) {
        return anna(i).getMaara();
    }


    /**
     * @param i mink� astian tilavuus
     * @return i:n astian tilavuus
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.getTilavuus(0) ~~~ 100;
     *  peli.lisaaAstia("5",5);
     *  peli.getTilavuus(1) ~~~ 5;
     * </pre>
     */
    public double getTilavuus(int i) {
        return anna(i).getTilavuus();
    }


    /* Version 1.2 tarvitsemat lis�ykset */

    /**
     * Laskee kaikkien k�yt�ss� olevien astioiden yhteistilavuuden
     * lukuunottamatta �mp�ri�
     * @return yhteistilavuus
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.astioidenSumma() ~~~ 0;
     *  peli.lisaaAstia("5",5); peli.astioidenSumma() ~~~ 5;
     *  peli.lisaaAstia("8",8); peli.astioidenSumma() ~~~ 13;
     * </pre>
     */
    public double astioidenSumma() {
        double summa = 0;
        for (int i = 1; i < getLkm(); i++)
            summa += getTilavuus(i);
        return summa;
    }


    /**
     * Lis�� esiintymat-taulukkoon kaikki ne astioiden summakombinaatiot,
     * joita niist� saa t�ll� hetkell�.
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  Astia ampari = peli.getAmpari();
     *  Astia a1 = peli.lisaaAstia("1",1); 
     *  Astia a2 = peli.lisaaAstia("2",2);
     *  peli.lisaaEsiintymat();  
     *  peli.getLoydetyt().toString() === "[]";
     *  ampari.kaada(a1); peli.lisaaEsiintymat();
     *  peli.getLoydetyt().toString() === "[1]";
     *  ampari.kaada(a2); peli.lisaaEsiintymat();
     *  peli.getLoydetyt().toString() === "[1, 2, 3]";
     * </pre>
     */
    public void lisaaEsiintymat() {
        Kombinaatiot kombi = new Kombinaatiot();
        for (int i = 1; i < getLkm(); i++)
            kombi.lisaa((int)(Math.round(getMaara(i))));

        for (int summa : kombi)
            esiintymat.lisaa(summa);
    }


    /**
     * Palautetaan tieto siit�, onko peli mennyt l�pi.
     * @return true jos peli on mennyt l�pi.
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  Astia ampari = peli.getAmpari();
     *  Astia a1 = peli.lisaaAstia("1",1); 
     *  Astia a2 = peli.lisaaAstia("2",2);
     *  peli.kaada(ampari,a1); peli.lapi() === false;
     *  peli.kaada(ampari,a2); peli.lapi() === true;
     * </pre>
     */
    public boolean lapi() {
        return esiintymat.onkoKaikki(); 
    }
    
    
    /**
     * Palautetaan l�ydettyjen lista.
     * @return l�ydetyjen tilavuuksien lista
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  Astia ampari = peli.getAmpari();
     *  Astia a1 = peli.lisaaAstia("1",1); 
     *  Astia a2 = peli.lisaaAstia("2",2);
     *  peli.getLoydetyt().toString() === "[]";
     *  peli.kaada(ampari,a1); peli.getLoydetyt().toString() === "[1]";
     *  peli.kaada(ampari,a2); peli.getLoydetyt().toString() === "[1, 2, 3]";
     * </pre>
     */
    public List<Integer> getLoydetyt() {
        return esiintymat.getLoydetyt();
    }
    
    
    /**
     * Testataan astiapeli�
     * @param args ei k�yt�ss�
     */
    public static void main(String[] args) {
    }

}