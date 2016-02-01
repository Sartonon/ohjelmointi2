
/**
 * @author Santeri
 *
 */
public class Kertoma {

	/**
	 * @author Santeri Rusila
	 * @version 17.1..2013
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10;
		
		Kertoma1(a);
	}

	/**
	 * 10! = 10*9*8*7*6*5*4*3*2*1  = 3628800
	 * 9!  = 9*8*7*6*5*4*3*2*1     = 362880
	 * 8!  = 8*7*6*5*4*3*2*1       = 40320
	 * 7!  = 7*6*5*4*3*2*1         = 5040
	 * 6!  = 6*5*4*3*2*1           = 720
	 * 5!  = 5*4*3*2*1             = 120
	 * 4!  = 4*3*2*1               = 24
	 * 3!  = 3*2*1                 = 6
	 * 2!  = 2*1                   = 2
	 * 1!  = 1                     = 1
	 * 0!  = 1                     = 1 
	 * Aliohjelma joka suorittaa kertoman ja tulostaa
	 * @param a = kertoma
	 */
	public static void Kertoma1(int a) {
		int b = a;
		int tulos = 1;
		
		// while
		while (b>=1){
			tulos *= b;
			b--;
		}
	    System.out.println(tulos);
	    b = a;
	    tulos = 1;
	    
	    // do-while
	    do {
	    tulos *= a;
	    a--;
	    
	    } while (a>=1);
	    
	    System.out.println(tulos);
	}
}
