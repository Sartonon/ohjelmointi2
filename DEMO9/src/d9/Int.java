/**
 * 
 */
package d9;

/**
 * @author Santeri Rusila
 * @version 6.3.2013
 *
 */
public class Int {
    
    private int luku;
    
    /**
     * @param luku
     */
    public Int(int luku) {
        this.luku = luku;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //Int luku = luvut.get(1);
        //luku.set(4);

    }

    /**
     * @param luku
     */
    public void set(int luku) {
        this.luku = luku;
        
    }
    
    /**
     * @param luku
     * @return luku
     */
    public int get(int luku) {
        return this.luku;
    }

}
