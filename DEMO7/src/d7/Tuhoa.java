package d7;

/**
 * @author Santeri Rusila
 * @version 24.2.2013
 */
public class Tuhoa {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s="Kissa istuu";
        s = tuhoaLopusta(s,3); // => s = "Kissa is"
        System.out.println(s);
        StringBuilder sb = new StringBuilder("Kissa istuu");
        String a = tuhoaLopusta(sb,3); // => sb= "Kissa is"
        System.out.println(a);

    }

    /**
     * @param sb
     * @param i
     * @return lol
     * @example
     * <pre name="test">
     *    StringBuilder s = new StringBuilder("Kissa naukuu");
     *    tuhoaLopusta(s,5) === "Kissa n"
     *    tuhoaLopusta(s,3) === "Kiss"
     *    tuhoaLopusta(s,3) === "K"
     *    
     * </pre>
     */
    public static String tuhoaLopusta(StringBuilder sb, int i) {
        int a = sb.length();
        sb.delete(a-i, a);
        System.out.println(sb);
        String s = sb.toString();
        return s;
        
    }

    /**
     * @param s
     * @param i
     * @return tuhottu
     * @example
     * <pre name="test">
     *    String s = "Miten menee?";
     *    tuhoaLopusta(s,2) === "Miten mene"
     *    tuhoaLopusta(s,6) === "Miten "
     *    tuhoaLopusta(s,1) === "Miten menee"
     * </pre>
     */
    public static String tuhoaLopusta(String s, int i) {
        int a = s.length();
        
        String muutettu = s.substring(0, a-i);
        
        return muutettu;
    }

}
