package elainRajapinta;

/**
 * @author Santeri Rusila
 * @version 18.2.2013
 *
 */
public class Kotka2 extends Elain {

    /**
     * @param nimi
     * @param paino
     */
    public Kotka2(String nimi, double paino) {
        super(nimi, paino);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Kotka2 kot = new Kotka2("lol",500);
        kot.aantele();
        System.out.println(kot);

    }

}
