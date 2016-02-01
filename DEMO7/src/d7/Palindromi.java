/**
 * 
 */
package d7;

import java.util.Scanner;

/**
 * @author Santeri Rusila
 * @version 24.2.2013
 */
public class Palindromi {

    /**
     * @param args
     */
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner lol = new Scanner(System.in);
        
        /* boolean a = palindromi("apua");
        
        if (a == true) System.out.println("On palindromi");
        if (a == false) System.out.println("Ei ole palindromi"); */
        
        while(true) {
            System.out.print("Anna syöte >");
            String b = lol.nextLine();
            if (b.equals("")) break;
            boolean c = palindromi(b);
            if (c == true) System.out.println("\"" + b + "\"" + " On palindromi");
            if (c == false) System.out.println("\"" + b + "\"" + " Ei ole palindromi");
        }
        System.out.println("Kiitos!");
    }

    /**
     * @param k 
     * @param string
     * @return true tai false
     * @example
     * <pre name="test">
     *   palindromi("maoam")  === true
     *   palindromi("lol")    === true
     *   palindromi("ammma")  === true
     *   palindromi("apua")   === false
     *   palindromi("")       === true
     *   palindromi("pelle")  === false
     *   palindromi("gogog")  === true
     *   palindromi("MaoAm")  === true
     * </pre>
     */
    public static boolean palindromi(String k) {
        if (k.length() == 0) return true;
        String b = k.toLowerCase();
        int a = k.length();
        for (int i = 0; i<=(a/2); i++) {
            if (b.charAt(i) == b.charAt(a-1-i)) {
                if (i == a/2) return true;
                continue;
            }
            else break;
        }
        return false;
    }

}
