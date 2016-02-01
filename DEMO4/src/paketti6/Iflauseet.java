package paketti6;

/**
 * @author Santeri Rusila
 * @version 1.2.2013
 */
public class Iflauseet {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        /* 1 */
        int a = 4; int b = 2; int c = 0;
        if ( a - b != 0 )
            c++;
        a = 1;
        b = 3;
        // a = 1, b = 3, c = 1
        
        
        /* 2 */
        a = 4; b = 2; c = 0;
        if ( c != 0 ) c--;
        else b = 1;
        a = b-2;
        // a = -1, c = 0, b = 1;
        
        /* 3 */
        a = 4;
        b = 2;
        c = 0;
        
        if (a > 0 && b > 1)c = 9;
        else if (c == 1);
        else b = 0;
        // a = 4, b = 2, c = 9
        
        /* 4 */
        a = 4; b = 2; c = 0;
        if (c++ == 0) b = 3; 
        if (a-- != 0) c = 8;
       // else b = 3; else c = 8;
        // a = 3, b = 3, c = 8
        
    }

}
