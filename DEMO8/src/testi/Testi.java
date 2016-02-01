package testi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Santeri
 *
 */
public class Testi {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DateFormat paiva = new SimpleDateFormat("dd");
        DateFormat kuukausi = new SimpleDateFormat("MM");
        DateFormat vuosi = new SimpleDateFormat("yyyy");
        Calendar cal = Calendar.getInstance();
        
        int a = Integer.parseInt(paiva.format(cal.getTime()));
        System.out.println(a);
        int b = Integer.parseInt(kuukausi.format(cal.getTime()));
        System.out.println(b);
        int c = Integer.parseInt(vuosi.format(cal.getTime()));
        System.out.println(c);

    }

}
