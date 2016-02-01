package teht2;

/**
 * @author Santeri Rusila
 * @version 26.1.2013
 */
public class Merkkijono {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        
        boolean a = onkoSamatKysymysmerkilla("Kissa","K?ss?");
        System.out.println(a);
        a = onkoSamatKysymysmerkilla("Kiss","K?ss?");
        System.out.println(a);
        a = onkoSamatKysymysmerkilla("Kissa","??ss?");
        System.out.println(a);
        a = onkoSamatKysymysmerkilla("Kissa","Kassa");
        System.out.println(a);
    }

    /**
     * Aliohjelma joka tarkistaa onko merkijono ja maski samat
     * @param string merkkijono
     * @param string2 maski
     * @return onko samat
     * @example
     * <pre name="test">
     *    onkoSamatKysymysmerkilla("Kissa","K?ss?") === true;
     *    onkoSamatKysymysmerkilla("Kissa","K????") === true;
     *    onkoSamatKysymysmerkilla("Kissa","Kissa") === true;
     *    onkoSamatKysymysmerkilla("Kassa","K?ssi") === false;
     * </pre>
     */
    public static boolean onkoSamatKysymysmerkilla(String string,String string2) {
        int a = string.length();
        int b = string2.length();
        if (a != b) return false;

        for (int i = 0; i < a; i = i + 1){
            char char1 = string.charAt(i);
            char char2 = string2.charAt(i);
            if (char1 != char2){
                if (string2.charAt(i) == '?') continue;
                else return false;
            }
        }
        
        return true;
    }

}
