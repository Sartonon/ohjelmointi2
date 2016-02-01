/**
 * 
 */
package d6;

/**
 * @author Santeri Rusila
 * @version 18.2.2013
 *
 */
public class Laiva extends Kulkuneuvo {
    
    private String nimi;

    /**
     * @param matkustajienMaara
     * @param nopeus
     */
    public Laiva(int matkustajienMaara, int nopeus) {
        super(matkustajienMaara, nopeus);
    }

    /**
     * @param matkustajienMaara 
     * @param nopeus 
     * @param nimi
     */
    public Laiva(int matkustajienMaara, int nopeus, String nimi) {
        super(matkustajienMaara, nopeus);
        this.nimi = nimi;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Laiva lv = new Laiva(2000, 25,"Baltic Princess");
        System.out.println(lv);
        System.out.println(lv.getNopeus());

    }
    
    public String toString() {
        return super.toString() + " " + nimi;
    }
    
    /**
     * @return nimen
     */
    public String getNimi() {
        return nimi;
    }

}
