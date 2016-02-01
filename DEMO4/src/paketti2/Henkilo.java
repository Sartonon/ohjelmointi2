package paketti2;

/**
 * @author Santeri Rusila
 * @version 1.2.2013
 */
public class Henkilo {
    
    private String etunimi;
    private String sukunimi;
    private int syntymavuosi;
    
    /**
     * Alustetaan henkil�n nimi ja syntym�vuosi
     * @param etunimi
     * @param sukunimi
     * @param syntymavuosi
     */
    public Henkilo(String etunimi, String sukunimi, int syntymavuosi) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymavuosi = syntymavuosi;
    }
    
    /**
     * @return etunimen ja sukunimen
     */
    public String getNimi() {
        return etunimi + " " + sukunimi;
    }
    
    /**
     * @return syntym�vuoden
     */
    public int getSyntymavuosi() {
        return syntymavuosi;
    }
    
    /**
     * @return henkil�n tiedot
     */
    @Override
    public String toString() {
        return etunimi + "|" + sukunimi + "|" + syntymavuosi;
    }

    /**
     * Testataan henkil�-luokkaa
     * @param args
     */
    public static void main(String[] args) {
        
        Henkilo aku = new Henkilo("Aku", "Ankka", 1934);
        System.out.println(aku.getNimi());  // tulostaa Aku Ankka
        System.out.println(aku.getSyntymavuosi());  // tulostaa 1934
        System.out.println(aku.toString()); // tulostaa Aku|Ankka|1934
        

    }

}
