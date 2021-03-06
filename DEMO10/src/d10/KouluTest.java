package d10;
// Generated by ComTest BEGIN
import java.io.ByteArrayOutputStream;
import d10.Koulu;
import static org.junit.Assert.*;
import org.junit.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2013.03.14 13:42:02 // Generated by ComTest
 *
 */
public class KouluTest {



  // Generated by ComTest BEGIN
  /** testLisaa62 */
  @Test
  public void testLisaa62() {    // Koulu: 62
    ByteArrayOutputStream bs  = new ByteArrayOutputStream(); 
    String alku =  "%n%nLuokka: 1b oppilaita: %d%n" +
    "==========================================%n"; 
    String loppu = "==========================================%n"; 
    String t = ""; 
    Koulu luokka = new Koulu("1b"); 
    ; 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 79", String.format(alku+(t="")+loppu,0), bs.toString()); bs.reset();  
    luokka.lisaa(new Koulu.Oppilas("Ankka Aku",5.0)); 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 80", String.format(alku+(t+="Ankka Aku              keskiarvo:  5.00%n")+loppu,1), bs.toString()); bs.reset();  
    luokka.lisaa(new Koulu.Oppilas("Ankka Tupu",7.0)); 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 81", String.format(alku+(t+="Ankka Tupu             keskiarvo:  7.00%n")+loppu,2), bs.toString()); bs.reset();  
    luokka.lisaa(new Koulu.Oppilas("Hiiri Mikki",9.0)); 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 82", String.format(alku+(t+="Hiiri Mikki            keskiarvo:  9.00%n")+loppu,3), bs.toString()); bs.reset();  
    luokka.poistaKaikki(); 
    ; 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 93", String.format(alku+(t="")+loppu,0), bs.toString()); bs.reset();  
    luokka.lisaa(new Koulu.Oppilas("Hiiri Mikki",9.0)); 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 94", String.format(alku+(t+="Hiiri Mikki            keskiarvo:  9.00%n")+loppu,1), bs.toString()); bs.reset();  
  } // Generated by ComTest END
}