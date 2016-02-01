/**
 * 
 */
package d6;

/**
 * @author Santeri Rusila
 * @version 18.2.2013
 */
public class Kulkuneuvo {
    
    private int matkustajienMaara;
    private double nopeus;

    /**
     * @param matkustajienMaara
     * @param nopeus
     */
    public Kulkuneuvo(int matkustajienMaara, int nopeus) {
        this.matkustajienMaara = matkustajienMaara;
        this.nopeus = nopeus;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Kulkuneuvo pk = new Kulkuneuvo(12,100);
        System.out.println(pk);
        System.out.println(pk.getNopeus());
        System.out.println(pk.getMatkustajat());
        
        Laiva laiva1 = new Laiva(200,200,"baltiv");
        System.out.println(laiva1);
        System.out.println(laiva1.getNimi());
        
        Lentokone lento = new Lentokone(200,200,200, "nimi®");
        System.out.println(lento);
        System.out.println(lento.getNimi());
        System.out.println(lento.getSiipienVali());

    }
    
    /**
     * @return nopeus
     */
    public double getNopeus() {
        return nopeus;
    }
    
    /**
     * @return Matkustajien m‰‰r‰n
     */
    public int getMatkustajat() {
        return matkustajienMaara;
    }
    
    @Override
    public String toString() {
        return matkustajienMaara + " " + nopeus;
    }

}
