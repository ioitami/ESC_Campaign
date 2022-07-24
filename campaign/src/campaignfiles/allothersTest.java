package campaignfiles;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.lang.*;

import static org.junit.Assert.*;
import org.junit.*;

public class allothersTest {

    @Before
    public void runBeforeEachTest() {
        System.out.println("setting up");
    }

    @After
    public void runAfterEachTest() {
        System.out.println("setting down");
    }
	
    @Test
    public void ReadCSVfilesTest() {
        ArrayList<String[]> parsedlist = new ArrayList<>();

        allothers campaign = new allothers();
        // READ AND PARSE FILE
        parsedlist = campaign.readCSVfiles("testfiles/input_test_1.csv");
        assertEquals("1", parsedlist.get(0)[0]);
        assertEquals("2", parsedlist.get(0)[1]);
        assertEquals("3", parsedlist.get(0)[2]);
        assertEquals("a", parsedlist.get(1)[0]);
        assertEquals("b", parsedlist.get(1)[1]);
        assertEquals("c", parsedlist.get(1)[2]);
    }
    
    @Test
    public void popArrListTest() {
    	 ArrayList<String[]> parsedlist = new ArrayList<>();

         allothers campaign = new allothers();
         // READ AND PARSE FILE
         parsedlist = campaign.readCSVfiles("testfiles/input_test_1.csv");
         parsedlist = campaign.popArrList(parsedlist);
         assertEquals("a", parsedlist.get(0)[0]);
         assertEquals("b", parsedlist.get(0)[1]);
         assertEquals("c", parsedlist.get(0)[2]);  
    }
    
    @Test
    public void checkCSVfileTest() {
    	 ArrayList<String[]> parsedlist = new ArrayList<>();

         allothers campaign = new allothers();
         // READ AND PARSE FILE
    }
}

