package campaignfiles;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.lang.*;

import static org.junit.Assert.*;
import org.junit.*;

public class allothersTest {


    @Test
    public void ReadCSV() {
        ArrayList<String[]> parsedlist = new ArrayList<>();

        allothers campaign = new allothers();
        // READ AND PARSE FILE 1
        int i = campaign.testrun(5);
        assertEquals(i,4);

    }
}
