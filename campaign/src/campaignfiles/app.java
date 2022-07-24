package campaignfiles;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.lang.*;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// File file = new File("sample_file_1.csv");
        // System.out.println(file.getAbsolutePath());

        ArrayList<String[]> parsedlist = new ArrayList<>();
        ArrayList<String[]> parsedlist2 = new ArrayList<>();
        ArrayList<String[]> parsedoutput = new ArrayList<>();

        //String file1 = "sample_file_1.csv"; // For hardcoded input
        //String file2 = "sample_file_3.csv"; // For hardcoded input

        allothers campaign = new allothers();
        
        System.out.println("Enter first file name:");
        String file1 = campaign.choosefile();
        System.out.println("Enter second file name:");
        String file2 = campaign.choosefile();
        
    	// READ AND PARSE FILE 1
        parsedlist = campaign.readCSVfiles("testfiles/" + file1);
        parsedlist = campaign.popArrList(parsedlist);
        // READ AND PARSE FILE 2
        parsedlist2 = campaign.readCSVfiles("testfiles/" + file2);
        parsedlist2 = campaign.popArrList(parsedlist2);
        // COMPARE AND OUTPUT FINAL ARRAYLIST
        parsedoutput = campaign.checkCSVfiles(parsedlist, parsedlist2);
        // CREATE AND OUTPUT CSV DIFFERENCE FILE
        campaign.outputCSVfile(parsedoutput);

	}

}
