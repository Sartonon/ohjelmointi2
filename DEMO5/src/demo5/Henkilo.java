package demo5;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Henkilo-luokka.  Henkilöllä on nimi ja syntymävuosi.
 * @author Vesa Lappalainen ja Santeri Rusila
 * @version 1.0, 10.02.2013
 */
public class Henkilo {
    private String etunimi;
    private String sukunimi;
    private int syntymavuosi;


    /**
     * Alustetaan henkilön tiedot annetuilla arvoilla
     * @param etunimi henkilön uusi etunimi
     * @param sukunimi henkilön uusi sukunimi
     * @param syntymavuosi henkilön uusi syntymävuosi
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
     * Palautetaan henkilön koko nimi    
     * @return henkilön nimi muodossa etunimi sukunimi
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
     * @return henkilön syntymävuosi
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
     * Testataan henkilöluokkaa
     * @param args ei käytössä
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