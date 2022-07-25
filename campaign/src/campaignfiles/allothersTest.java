package campaignfiles;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.lang.*;

import static org.junit.Assert.*;
import org.junit.*;

public class allothersTest {

    // @Before
    // public void runBeforeEachTest() {
    // System.out.println("setting up");
    // }
    //
    // @After
    // public void runAfterEachTest() {
    // System.out.println("setting down");
    // }

    @Test
    public void ReadCSVfilesTests() {
        allothers campaign = new allothers();

        // FIRST TEST CASE
        ArrayList<String[]> parsedlist = campaign.readCSVfiles("testfiles/input_test_1.csv");
        assertEquals("1", parsedlist.get(0)[0]);
        assertEquals("2", parsedlist.get(0)[1]);
        assertEquals("3", parsedlist.get(0)[2]);
        assertEquals("d", parsedlist.get(2)[0]);
        assertEquals("e", parsedlist.get(2)[1]);
        assertEquals("f", parsedlist.get(2)[2]);
        assertEquals(3, parsedlist.size());
        // SECOND TEST CASE
        ArrayList<String[]> parsedlist2 = campaign.readCSVfiles("testfiles/input_test_3.csv");
        assertEquals("1", parsedlist2.get(0)[0]);
        assertEquals("2", parsedlist2.get(0)[1]);
        assertEquals("3", parsedlist2.get(0)[2]);
        assertEquals("d", parsedlist2.get(2)[0]);
        assertEquals("z", parsedlist2.get(2)[1]);
        assertEquals("f", parsedlist2.get(2)[2]);
        assertEquals(3, parsedlist2.size());
        // THIRD TEST CASE
        ArrayList<String[]> parsedlist3 = campaign.readCSVfiles("testfiles/input_test_2.csv");
        assertEquals("g", parsedlist3.get(3)[0]);
        assertEquals("j", parsedlist3.get(4)[0]);
        assertEquals(5, parsedlist3.size());
    }

    @Test
    public void popArrListTest() {
        allothers campaign = new allothers();

        // FIRST TEST CASE
        ArrayList<String[]> parsedlist = campaign.readCSVfiles("testfiles/input_test_1.csv");
        assertEquals("1", parsedlist.get(0)[0]);
        assertEquals("2", parsedlist.get(0)[1]);
        assertEquals("3", parsedlist.get(0)[2]);

        parsedlist = campaign.popArrList(parsedlist);

        assertEquals("a", parsedlist.get(0)[0]);
        assertEquals("b", parsedlist.get(0)[1]);
        assertEquals("c", parsedlist.get(0)[2]);

        // SECOND TEST CASE
        ArrayList<String[]> parsedlist2 = campaign.readCSVfiles("testfiles/sample_file_1.csv");
        assertEquals("\"Customer ID#\"", parsedlist2.get(0)[0]);
        assertEquals("\"Account No.\"", parsedlist2.get(0)[1]);
        assertEquals("\"Currency\"", parsedlist2.get(0)[2]);
        assertEquals("\"Type\"", parsedlist2.get(0)[3]);
        assertEquals("\"Balance\"", parsedlist2.get(0)[4]);

        parsedlist2 = campaign.popArrList(parsedlist2);
        assertEquals("\"ID1\"", parsedlist2.get(0)[0]);
        assertEquals("\"BOS963211\"", parsedlist2.get(0)[1]);
        assertEquals("\"USD\"", parsedlist2.get(0)[2]);
        assertEquals("\"SAVINGS\"", parsedlist2.get(0)[3]);
        assertEquals("\"962510\"", parsedlist2.get(0)[4]);
    }

    @Test
    public void returnTopBotArrTest() {
        allothers campaign = new allothers();

        // FIRST TEST CASE
        ArrayList<String[]> parsedlist = campaign.readCSVfiles("testfiles/input_test_2.csv");
        ArrayList<String[]> parsedlist2 = campaign.readCSVfiles("testfiles/input_test_3.csv");
        ArrayList<String[]> topList = campaign.returnTopSizeArr(parsedlist, parsedlist2);
        ArrayList<String[]> botList = campaign.returnBotSizeArr(parsedlist, parsedlist2);

        assertTrue(topList == parsedlist);
        assertTrue(botList == parsedlist2);
        assertTrue(parsedlist.size() > parsedlist2.size());
        assertTrue(topList.size() > botList.size());

        // SECOND TEST CASE
        String[] stringarr = { "1", "2" };

        ArrayList<String[]> firstarr = new ArrayList<>();
        ArrayList<String[]> secondarr = new ArrayList<>();

        firstarr.add(stringarr);
        firstarr.add(stringarr);
        firstarr.add(stringarr);
        assertEquals(3, firstarr.size());

        secondarr.add(stringarr);
        assertEquals(1, secondarr.size());

        ArrayList<String[]> topList2 = campaign.returnTopSizeArr(firstarr, secondarr);
        ArrayList<String[]> topList22 = campaign.returnTopSizeArr(secondarr, firstarr);
        ArrayList<String[]> botList2 = campaign.returnBotSizeArr(secondarr, firstarr);
        ArrayList<String[]> botList22 = campaign.returnBotSizeArr(firstarr, secondarr);
        assertTrue(topList2.size() > botList2.size());
        assertTrue(topList22.size() > botList22.size());
        assertTrue(topList22.size() > botList2.size());
        assertTrue(topList2.size() > botList22.size());
    }

    @Test
    public void checkCSVfileTest() {
        allothers campaign = new allothers();
        
        // SECOND TEST CASE
        String[] stringarr1 = { "1", "2", "3" };
        String[] stringarr2 = { "a", "b", "c" };
        String[] stringarr3 = { "d", "e", "f" };
        String[] stringarr4 = { "d", "z", "z" };

        ArrayList<String[]> firstarr = new ArrayList<>();
        ArrayList<String[]> secondarr = new ArrayList<>();

        firstarr.add(stringarr1);
        firstarr.add(stringarr2);
        firstarr.add(stringarr3);
        secondarr.add(stringarr1);
        secondarr.add(stringarr2);
        secondarr.add(stringarr4);

        ArrayList<String[]> outputarr = campaign.checkCSVfiles(firstarr, secondarr);
        assertArrayEquals(stringarr4, outputarr.get(0));
        assertArrayEquals(stringarr3, outputarr.get(1));
    }
}
