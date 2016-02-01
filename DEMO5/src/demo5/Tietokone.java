/**
 * 
 */
package demo5;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Santeri Rusila
 * @version 10.2.2013
 *
 */
public class Tietokone {
    
    private int muistinMaara;
    private int kiintolevynKoko;
    private String prosessori;
    private String muistinNopeus;
    private String kayttojarjestelma;
    
    /**
     * @param muistinMaara 
     * @param muistinMaata
     * @param kiintolevynKoko
     * @param prosessori
     * @param muistinNopeus
     * @param kayttojarjestelma 
     */
    public Tietokone (int muistinMaara, int kiintolevynKoko, String prosessori,
            String muistinNopeus, String kayttojarjestelma) {
        this.muistinMaara = muistinMaara;
        this.kiintolevynKoko = kiintolevynKoko;
        this.prosessori = prosessori;
        this.muistinNopeus = muistinNopeus;
        this.kayttojarjestelma = kayttojarjestelma;
        
    }
    
    /**
     * 
     */
    public Tietokone() {
        this(0,0,"?","?","?");
    }
    
    
    /**
     * @param os
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream(os);
        out.println("Muistin m‰‰r‰: " + muistinMaara + "Gb" + "\n" + "Kiintolevy: " + kiintolevynKoko + "Gb"
                + "\n" + "Prosessori: " + prosessori + "\n" + "Muistin nopeus: " + muistinNopeus + "\n" +
                "K‰yttˆj‰rjestelm‰: " + kayttojarjestelma + "\n");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Tietokone pc = new Tietokone(8,1000,"Intel Core i5 3570k","16000Mhz","Windows 7");
        
        // int muisti = pc.getMuisti();
        
        System.out.println(pc.getMuisti());
        System.out.println(pc.getKiintolevy());
        System.out.println(pc.getProssu());
        System.out.println(pc.getMuistinNopeus());
        System.out.println(pc.getKayttis());
        
        System.out.println();
        
        pc.tulosta(System.out);
        
        Tietokone pc2 = new Tietokone();
        pc2.tulosta(System.out);
        
        pc2.lisaaKayttis("Windows 7");
        
        pc2.tulosta(System.out);
        

    }

    /**
     * @param kayttis
     */
    public void lisaaKayttis(String kayttis) {
        kayttojarjestelma = kayttis;
        
    }

    /**
     * @return k‰yttis
     */
    public String getKayttis() {
        return kayttojarjestelma;
    }

    /**
     * @return prosessori
     */
    public String getProssu() {
        return prosessori;
    }

    /**
     * @return muistin nopeus
     */
    public String getMuistinNopeus() {
        return muistinNopeus;
    }

    /**
     * @return kiintolevyn koko
     */
    public int getKiintolevy() {
        return kiintolevynKoko;
        
    }

    /**
     * @return muistin m‰‰‰r‰n
     */
    public int getMuisti() {
        return muistinMaara;
    }

}
