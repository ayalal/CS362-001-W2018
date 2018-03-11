//Matt Baker and Lorenzo Ayala
package finalprojectB;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class UrlValidatorTest extends TestCase {

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest()
   {
        UrlValidator uV = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertFalse(uV.isValid("http://gm[[[[[[[ail.com/re"));
        assertFalse(uV.isValid("http:/google.com"));
        assertFalse(uV.isValid("://google.com"));
        assertFalse(uV.isValid("0000tp://www.goggle.com"));
        assertFalse(uV.isValid("http://goggle.com/..../."));
        assertTrue(uV.isValid("https://www.goggle.com"));
        assertTrue(uV.isValid("http://www.12.com"));
        assertTrue(uV.isValid("http://www.goggle.com/!!"));
        assertTrue(uV.isValid("http://www.goggle.com:10"));
   }

   public void testYour1Partition()
   {
        UrlValidator uV = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertFalse(uV.isValid("h@ttp://www.goggle.com"));
        assertFalse(uV.isValid("0http://www.goggle.com"));
        assertTrue(uV.isValid("http://www.goggle.com"));
        assertTrue(uV.isValid("https://www.goggle.com"));
   }

   public void testYour2Partition(){
        UrlValidator uV = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertFalse(uV.isValid("http://www-this-is-wrong"));
        assertFalse(uV.isValid("http://.dotcheck"));
        assertFalse(uV.isValid("http://www.1:11:900:1330"));
        assertTrue(uV.isValid("http://www.goggle.edu"));
        assertTrue(uV.isValid("http://www.this-is-right.com"));
        assertTrue(uV.isValid("http://254.254.254.250"));
   }

   public void testYour3Partition(){
        UrlValidator uV = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertFalse(uV.isValid("http://www.goggle.com:***&&^"));
        assertFalse(uV.isValid("http://www.goggle.com:wrongport"));
        assertFalse(uV.isValid("http://www.goggle.com:-1"));
        assertFalse(uV.isValid("http://www.goggle.com:1034534530"));
        assertTrue(uV.isValid("http://www.goggle.com:0"));
        assertTrue(uV.isValid("http://www.goggle.com:1"));
        assertTrue(uV.isValid("http://www.goggle.com:8080"));
   }

   public void testYour4Partition(){
        UrlValidator uV = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertFalse(uV.isValid("http://www.goggle.com/ba//d//path"));
        assertFalse(uV.isValid("http://www.goggle.com/,,,,,/"));
        assertFalse(uV.isValid("http://www.goggle.com:::::"));
        assertFalse(uV.isValid("http://www.goggle.com//wrongformat"));
        assertTrue(uV.isValid("http://www.goggle.com/path/good"));
        assertTrue(uV.isValid("http://www.goggle.com"));
        assertTrue(uV.isValid("http://www.goggle.com/path/with/numbers"));
   }

   public void testYour5Partition(){
        UrlValidator uV = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertFalse(uV.isValid("http://www.goggle.com:qq=11"));
        assertFalse(uV.isValid("http://www.goggle.com!q=1"));
        assertFalse(uV.isValid("http://www.goggle.comq=1"));
        assertTrue(uV.isValid("http://www.goggle.com?query=GOOD"));
        assertTrue(uV.isValid("http://www.goggle.com?q=1"));
        assertTrue(uV.isValid("http://www.goggle.com?q=ALLGOOD"));
   }

   public void testIsValid()
   {
        // Lorenzo do this part
   }
}
