package d8;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static d8.MatriisinSuurin.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2013.02.27 08:48:41 // Generated by ComTest
 *
 */
public class MatriisinSuurinTest {



  // Generated by ComTest BEGIN
  /** testMatriisinSuurin26 */
  @Test
  public void testMatriisinSuurin26() {    // MatriisinSuurin: 26
    int[][] a = new int[][]{ { 1,2,3,4} ,{ 5,6,7,8} } ; 
    assertEquals("From: MatriisinSuurin line: 28", 8, matriisinSuurin(a)); 
    int[][] b = new int[][]{ { 1,2,200,4} ,{ 5,6,7,8} } ; 
    assertEquals("From: MatriisinSuurin line: 30", 200, matriisinSuurin(b)); 
    int[][] c = new int[][]{ { 1,2,200,4} ,{ 5,6,7,800} } ; 
    assertEquals("From: MatriisinSuurin line: 32", 800, matriisinSuurin(c)); 
  } // Generated by ComTest END
}