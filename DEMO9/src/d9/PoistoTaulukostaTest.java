package d9;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static d9.PoistoTaulukosta.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2013.03.07 08:27:20 // Generated by ComTest
 *
 */
public class PoistoTaulukostaTest {



  // Generated by ComTest BEGIN
  /** testMain16 */
  @Test
  public void testMain16() {    // PoistoTaulukosta: 16
    int h[] = { 1,2,3,4,5,6,7,7} ; 
    int lkm = 8; 
    assertEquals("From: PoistoTaulukosta line: 19", 6, poista(h,lkm,7)); 
    assertEquals("From: PoistoTaulukosta line: 20", 7, poista(h,lkm,1)); 
  } // Generated by ComTest END
}