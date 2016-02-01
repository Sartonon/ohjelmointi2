package demo5;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Henkilo-luokka.  Henkil�ll� on nimi ja syntym�vuosi.
 * @author Vesa Lappalainen ja Santeri Rusila
 * @version 1.0, 10.02.2013
 */
public class Henkilo {
    private String etunimi;
    private String sukunimi;
    private int syntymavuosi;


    /**
     * Alustetaan henkil�n tiedot annetuilla arvoilla
     * @param etunimi henkil�n uusi etunimi
     * @param sukunimi henkil�n uusi sukunimi
     * @param syntymavuosi henkil�n uusi syntym�vuosi
     */
    public Henkilo(String etunimi, String sukunimi, int syntymavuosi) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymavuosi = syntymavuosi;
    }
    
    /**
     * 
     */
    public Henkilo() {
        // this.etunimi = "";
        // this.sukunimi = "";
        // this.syntymavuosi = 0;
        this("","",0);
    }
    
    /**
     * @param a
     */
    public Henkilo(String a) {
        parse(a);
    }

    
    /**
     * @return tiedot | erotetussa muodossa
     * @example
     * <pre name="test">
     *   Henkilo aku = new Henkilo("Aku","Ankka",1934);
     *   aku.toString() === "Aku|Ankka|1934";
     *   Henkilo pele = new Henkilo("Pele","",1940);
     *   pele.toString() === "Pele||1940";
     * </pre>
     */
    @Override
    public String toString() {
        return etunimi + "|" + sukunimi + "|" + syntymavuosi;
    }
    

    /**
     * Palautetaan henkil�n koko nimi    
     * @return henkil�n nimi muodossa etunimi sukunimi
     * @example
     * <pre name="test">
     *   Henkilo aku = new Henkilo("Aku","Ankka",1934);
     *   aku.getNimi() === "Aku Ankka";
     *   Henkilo pele = new Henkilo("Pele","",1940);
     *   pele.getNimi() === "Pele";
     * </pre>
     */
    public String getNimi() {
        return (etunimi + " " + sukunimi).trim();
    }

    
    /**
     * @return henkil�n syntym�vuosi
     * @example
     * <pre name="test">
     *   Henkilo aku = new Henkilo("Aku","Ankka",1934);
     *   aku.getSyntymavuosi() === 1934;
     * </pre>
     */
    public int getSyntymavuosi() {
        return syntymavuosi;
    }
    
    
    /**
     * Testataan henkil�luokkaa
     * @param args ei k�yt�ss�
     */
    public static void main(String[] args) {
        Henkilo hlo = new Henkilo();
        Henkilo aku = new Henkilo("Aku", "Ankka", 1934);
        System.out.println(hlo);  // tulostaa ||0
        // System.out.println(aku);
        hlo.parse("Sepe|Susi|1933");
        hlo.tulosta(System.out); // Sepe Susi 1933
        aku.tulosta(System.out); // Aku Ankka 1934
        Henkilo mikki = new Henkilo("Mikki|Hiiri");
        System.out.println(mikki); // Mikki|Hiiri|0
    }

    /**
     * @param os 
     * @param out
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream(os);
        out.println(etunimi + " " + sukunimi + " " + syntymavuosi);
    }

    /**
     * @param string
     */
    public void parse(String string) {
        String[] sanat = string.split("\\|");
        if(sanat.length >=1) etunimi = sanat[0];
        if(sanat.length >= 2) sukunimi = sanat[1];
        if(sanat.length >= 3) syntymavuosi = Integer.parseInt(sanat[2]);
        
    }
}