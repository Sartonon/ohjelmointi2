package d12;

import java.util.Random;

/**
 * @author Santeri Rusila
 * @version 20.3.2013
 *
 */
public class Hyppely {
    static int[] move_x = { 1, 2, 2, 1,-1,-2,-2,-1}; // possible moves (x-axis)
    static int[] move_y = {-2,-1, 1, 2, 2, 1,-1,-2}; // possible moves (y-axis)
    static long laskuri = 0;
    private static boolean valmis = false;
	private static int seuraava = 1;
	/*private static int[][] lauta = {{ -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		                            { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		                            { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
		                            { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
		                            { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
		                            { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
		                            { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
		                            { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
		                            { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
		                            { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
		                            { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
		                            { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
		                            { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		                            { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};*/
	private static int[][] lauta = {
	    { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        };

	/**
	 * @param args ei käytössä
	 */
	public static void main(String[] args) {
	    Random rand = new Random();
	    int a, b = 0;
	    a = rand.nextInt(5) + 2;
	    b = rand.nextInt(7) + 2;	
	    hypi(a, b);
	    tulosta();
	    System.out.println(laskuri);

	}
	
	private static void hypi(int rivi, int sarake) {
	    laskuri++;
	    lauta[rivi][sarake] = seuraava;
		seuraava++;
		
		if (seuraava == 36) {
            //tulosta();
            valmis = true;
            return;
        }

		for (int i = 0; i < move_x.length; i++) {
		    if (lauta[rivi + move_x[i]][sarake + move_y[i]] == 0)
		        hypi(rivi + move_x[i], sarake + move_y[i]);
		}
		
		if(!valmis){
            lauta[rivi][sarake] = 0;
            seuraava--;
        }
		return;
	}

	/**
	 * Tulostaa laudan
	 */
	public static void tulosta(){
		for (int i = 2; i < (lauta[1].length-4); i++){
			for (int j = 2; j < (lauta[0].length-2); j++) {
				System.out.format("%3d ",lauta[i][j]);
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------------------");
	}
	

}
