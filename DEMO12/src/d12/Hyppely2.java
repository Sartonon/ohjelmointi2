package d12;

import java.util.Vector;

/**
 * @author Santeri
 *
 */
public class Hyppely2 {
    
    private static int seuraava = 1;
    private static boolean valmis = false;
    private static int[][] lauta = {
        { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1,-1},
        { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        };

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        /*lauta[6][2] = 1;
        for (int i = 0; i < (lauta[1].length-2); i++){
            for (int j = 0; j < lauta[0].length; j++) {
                System.out.format("%02d ",lauta[i][j]);
            }
            System.out.println();
        }*/
        
        hypi(6, 2);
        //System.out.println("Ei toimi");
        tulosta();

    }
    
    private static void hypi(int rivi, int sarake) {
        lauta[rivi][sarake] = seuraava;
        seuraava++;
        if (seuraava == 65) {
            //tulosta();
            valmis = true;
            return;
        }
                
        if(lauta[rivi+2][sarake+1] == 0) hypi(rivi+2, sarake+1);
        if(lauta[rivi-2][sarake-1] == 0) hypi(rivi-2, sarake-1);
        if(lauta[rivi+1][sarake+2] == 0) hypi(rivi+1, sarake+2);
        if(lauta[rivi-1][sarake-2] == 0) hypi(rivi-1, sarake-2);
        
        if(lauta[rivi+2][sarake-1] == 0) hypi(rivi+2, sarake-1);
        if(lauta[rivi-2][sarake+1] == 0) hypi(rivi-2, sarake+1);
        if(lauta[rivi+1][sarake-2] == 0) hypi(rivi+1, sarake-2);
        if(lauta[rivi-1][sarake+2] == 0) hypi(rivi-1, sarake+2);
        
        if(!valmis){
            lauta[rivi][sarake] = 0;
            seuraava--;
        }
        return;
    }

    /**
     * 
     */
    public static void tulosta(){
        for (int i = 2; i < (lauta[1].length-2); i++){
            for (int j = 2; j < (lauta[0].length-2); j++) {
                System.out.format("%02d ",lauta[i][j]);
            }
            System.out.println();
        }
    }
    

}
