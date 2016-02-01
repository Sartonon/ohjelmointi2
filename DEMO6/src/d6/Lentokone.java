/**
 * 
 */
package d6;

/**
 * @author Santeri Rusila
 * @version 18.2.2013
 *
 */
public class Lentokone extends Kulkuneuvo {
    
    private double siipienVali;
    private String nimi;

    /**
     * @param matkustajienMaara
     * @param nopeus
     */
    public Lentokone(int matkustajienMaara, int nopeus) {
        super(matkustajienMaara, nopeus);

    }

    /**
     * @param matkustajienMaara
     * @param nopeus
     * @param siipienVali
     * @param nimi
     */
    public Lentokone(int matkustajienMaara, int nopeus, double siipienVali, String nimi) {
        super(matkustajienMaara, nopeus);
        this.siipienVali = siipienVali;
        this.nimi = nimi;
    }

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Lentokone kone = new Lentokone(200,200, 25, "Joku");
        System.out.println(kone);
        System.out.println(kone.getNopeus());
        System.out.println(kone.getMatkustajat());

    }
    
    public String toString() {
        return super.toString() + " " + siipienVali + " " + nimi;
    }
    
    /**
     * @return siipien väli
     */
    public double getSiipienVali() {
        return siipienVali;
    }
    
    /**
     * @return nimi
     */
    public String getNimi() {
        return nimi;
    }

}
