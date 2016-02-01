package paivamaara;

/**
 * Luokka Paivamaara
 * @author Santeri
 * @version 26.1.2013
 */
public class Paivamaara {
    
    private int kk;
    private int p;
    private int v;
    
    /**
     * @param kk kuukaudet
     * @param p päivät
     * @param v vuosi
     */
    public Paivamaara(int p, int kk, int v){
        this.kk = kk;
        this.p = p;
        this.v = v;
    }
    
    @Override
    public String toString() {
        return String.format("%01d.%01d.%01d", p, kk, v);
    }

    /**
     * Pääohjelma luo Paivamaaraolion ja muuttaa sen
     * stringiksi ja tulostaa
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Paivamaara p1 = new Paivamaara(12,12,2013);
        String s = p1.toString();
        System.out.println(s);

    }

}
