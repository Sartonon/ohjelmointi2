/**
 * 
 */
package d9;

/**
 * @author Santeri Rusila
 * @version 6.3.2013
 *
 */
public class Ehdokas {
    
    private double raha = 0;
    private int aanet = 0;
    
    /**
     * @param raha 
     * @param aanet 
     * 
     */
    public Ehdokas(double raha, int aanet) {
        this.raha = raha;
        this.aanet = aanet;
    }

    /**
     * @return raha
     */
    public double getRaha() {
        return raha;
    }

    /**
     * @param raha
     */
    public void setRaha(double raha) {
        this.raha = raha;
    }

    /**
     * @param aanet
     */
    public void setAanet(int aanet) {
        this.aanet = aanet;
    }

    /**
     * @return äänet
     */
    public int getAanet() {
        return aanet;
    }
    
    public String toString() {
        return "Rahaa " + this.raha + "," + " ääniä " + this.aanet;
    }

    /**
     * @param ehdokas
     * @return aanet
     */
    public int compareTo(Ehdokas ehdokas) {
        return (this.getAanet() - ehdokas.getAanet());
    }

    /**
     * @param aania
     * @param hinta
     * @return onnistuiko
     */
    public boolean osta(int aania, double hinta) {
        double kokonaishinta = aania*hinta;
        
        if (this.raha < kokonaishinta) return false;
        
        this.raha = this.raha - kokonaishinta;
        this.aanet = this.aanet + aania;

        return true;
    }
    
    /**
     * @param args ei käytössä
     * @example
     * <pre name="test">
     *   Ehdokas ehd3 = new Ehdokas(100.0, 0);
     *   ehd3.getRaha() ~~~ 100.0
     *   ehd3.getAanet() === 0
     *   ehd3.setRaha(10000.0);
     *   ehd3.getRaha() ~~~ 10000.0
     *   ehd3.setAanet(5000);
     *   ehd3.getAanet() === 5000
     *   Ehdokas ehd4 = new Ehdokas(1000.0, 100000);
     *   ehd4.compareTo(ehd3) === 95000
     * </pre>
     */
    public static void main(String[] args) {
        Ehdokas ehd1 = new Ehdokas(100000.0, 0);
        Ehdokas ehd2 = new Ehdokas(20000.0, 300);
        System.out.println(ehd1); // Tulostaa: Rahaa 100000, ääniä 0
        System.out.println(ehd2); // Tulostaa: Rahaa 20000, ääniä 300
        ehd1.osta(200, 100.0); // Ostaa 200 ääntä, 100 mk/kpl
        System.out.println(ehd1); // Tulostaa: Rahaa 80000, ääniä 200
        boolean onnistui = ehd2.osta(300, 100);
        if (!onnistui) System.out.println("Rahat ei riitä :-)");
        System.out.println(ehd2); // Tulostaa: Rahaa 20000, ääniä 300
        if (ehd1.compareTo(ehd2) > 0) System.out.println("Ehdokas 1 voitti!");
        if (ehd1.compareTo(ehd2) < 0) System.out.println("Ehdokas 2 voitti!");
        if (ehd1.compareTo(ehd2) == 0) System.out.println("Taspeli!");
        // Vertailu tehdään äänimäärien perusteella.
        // Esimerkissä tulostuu : Ehdokas 2 voitti!

    }

}
