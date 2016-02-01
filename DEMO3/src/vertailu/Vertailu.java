package vertailu;

import java.util.Scanner;

/**
 * @author Santeri Rusila
 * @version 26.1.2013
 */
public class Vertailu {

    /**
     * Pääohjelma joka kysyy merkkijonon ja tulostaa järjestetyn
     * tuloksen
     * @param args
     */
    public static void main(String[] args) {
        String rivi=""; 
        System.out.print("Anna rivi >");
        Scanner lukija = new java.util.Scanner(System.in);
        rivi = lukija.nextLine();
        lukija.close();
        rivi.trim();
        
        String jarjestetty = jarjesta1ja2(rivi);
        System.out.println(jarjestetty);

    }

    /**
     * Aliohjelma joka vaihtaa merkkijonon ensimmäisen ja toisen sanan
     * aakkosjärjestykseen
     * @param s
     * @return null
     */
    public static String jarjesta1ja2(String s) {
        String jarjestetty;
        String[] osat = s.split(" ");
        int tulos = osat[0].compareTo(osat[1]);
        if (tulos < 0){
            jarjestetty = osat[0] + " " + osat[1];
        }
        else jarjestetty = osat[1] + " " + osat[0];
        
         // System.out.println(tulos);
        jarjestetty.trim();
        return jarjestetty;
    }

}
