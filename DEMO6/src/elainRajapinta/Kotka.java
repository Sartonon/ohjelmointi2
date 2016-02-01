/**
 * 
 */
package elainRajapinta;

/**
 * @author Santeri Rusila
 * @version 18.2.2013
 */
public class Kotka implements Rajapinta {

    private double paino;
    private String nimi;

    /**
     * @param nimi 
     * @param paino 
     */
    public Kotka(String nimi, int paino) {
        this.nimi = nimi;
        this.paino = paino;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    @Override
    public void aantele() {
        System.out.println("Kotkot");
        
    }
    
    public String toString() {
        return nimi + " " + paino;
                
    }

}
