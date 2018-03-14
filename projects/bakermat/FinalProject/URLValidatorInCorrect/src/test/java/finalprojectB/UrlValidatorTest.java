//Matt Baker and Lorenzo Ayala
package finalprojectB;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import java.util.Random;
import java.util.Calendar;

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
       long beginTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - beginTime;

        String[] testSchemes = { //total of 8 schemes
            "http://",
            "h3t://",
            "3ht://", //false scheme
            "http:/",//false scheme
            "http:",//false scheme
            "http/",//false scheme
            "://",//false scheme
            ""
        };

        String[] testAuthorities = {//total of 10 Authorities
          "www.google.com",
          "go.com",
          "go.au",
          "0.0.0.0",
          "255.255.255.255",
          "256.256.256.256", //false testAuthority
          "255.com",
          "1.2.3.4.5", //false testAuthority
          "go.1aa", //false testAuthority
          ""//false testAuthority
        };

        String[] testPorts = {
          ":80",
          ":65535",
          ":0",
          "",
          ":-1",//false testPort
          ":65636",//false testPort
          ":65a" //false testPort
        };

        String[] testPaths = {
          "/test1",
          "/t123",
          "/$23",
          "/..", //false path
          "/../",//false path
          "/test1/",
          "",
          "/test1/file",
          "/..//file",//false path
          "/test1//file" //false path
        };

        String[] testQuery = {
          "?action=view",
          "?action=edit&mode=up",
          ""
        };

        System.out.println("testing the isValid method now...");

        for(int iteration = 0; elapsed < testTimeout; iteration++)
        {
             Random rand = new Random();
             int randomScheme;
             int randomAuthority;
             int randomPort;
             int randomPath;
             int randomQuery;

                for(int i = 0; i < 999; i++)
                {
                  int randomCase = (int)(Math.random()*7 +1);
                  UrlValidator uV = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

                  if(randomCase == 1)
                  {
                      randomScheme = (int)(Math.random() * 7);
                      String testScheme = testSchemes[randomScheme];
                      uV.isValid(testScheme);
                  }
                  else if(randomCase == 2)
                  {
                      randomAuthority = (int)(Math.random() * 9);
                      String testAuths = testAuthorities[randomAuthority];
                      uV.isValid(testAuths);
                  }
                  else if(randomCase == 3)
                  {
                      randomPort = (int)(Math.random() * 6);
                      String testPrt = testPorts[randomPort];
                      uV.isValid(testPrt);
                  }
                  else if(randomCase == 4)
                  {
                      randomPath = (int)(Math.random() * 9);
                      String testPths = testPaths[randomPath];
                      uV.isValid(testPths);
                  }
                  else if(randomCase == 5)
                  {
                      randomQuery = (int)(Math.random() * 2);
                      String testQrs = testQuery[randomQuery];
                      uV.isValid(testQrs);
                  }
                  else if(randomCase == 6)
                  {
                      randomScheme = (int)(Math.random() * 7);
                      randomAuthority = (int)(Math.random() * 9);
                      randomPath = (int)(Math.random() * 9);
                      randomQuery = (int)(Math.random() * 2);

                      String testURL = testSchemes[randomScheme] + testAuthorities[randomAuthority] + testPaths[randomPath] + testQuery[randomQuery];
                      uV.isValid(testURL);
                  }
                  else if(randomCase == 7)
                  {
                      randomScheme = (int)(Math.random() * 7);
                      randomAuthority = (int)(Math.random() * 9);
                      randomPort = (int)(Math.random() * 6);
                      randomPath = (int)(Math.random() * 9);
                      randomQuery = (int)(Math.random() * 2);

                      String testCompleteURL = testSchemes[randomScheme] + testAuthorities[randomAuthority] + testPorts[randomPort] + testPaths[randomPath] + testQuery[randomQuery];
                      uV.isValid(testCompleteURL);
                  }


                }

                elapsed = (Calendar.getInstance().getTimeInMillis() - beginTime);
                if((iteration % 10000) == 0 && iteration != 0)
                  System.out.println("elapsed time: " + elapsed + " of " + testTimeout);

        }
   }
}
