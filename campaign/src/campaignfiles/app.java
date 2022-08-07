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

        // String file1 = "sample_file_1.csv"; // For hardcoded input
        // String file2 = "sample_file_3.csv"; // For hardcoded input

        allothers campaign = new allothers();

        System.out.println("Enter first file name:");
        String file1 = campaign.choosefile();
        System.out.println("Enter file name to compare to:");
        String file2 = campaign.choosefile();

        // READ AND PARSE FILE 1
        ArrayList<String[]> parsedlist = campaign.readCSVfiles("testfiles/" + file1);

        // READ AND PARSE FILE 2
        ArrayList<String[]> parsedlist2 = campaign.readCSVfiles("testfiles/" + file2);

        // CHECK IF EACH .CSV HAS SAME NO. OF COLUMNS
        if (campaign.checkNumColumns(parsedlist, parsedlist2) != 1) {
            System.out.println("Files do not have same no. of columns! Exiting Program.");
            System.exit(0);
        }

        parsedlist = campaign.popArrList(parsedlist);
        parsedlist2 = campaign.popArrList(parsedlist2);

        // IF FILE 1 HAS LESS ROWS THAN FILE 2, SWAP PLACES (FOR ALGO TO WORK)
        ArrayList<String[]> topList = campaign.returnTopSizeArr(parsedlist, parsedlist2);
        ArrayList<String[]> botList = campaign.returnBotSizeArr(parsedlist, parsedlist2);

        // COMPARE AND OUTPUT FINAL ARRAYLIST
        ArrayList<String[]> parsedoutput = campaign.checkCSVfiles(topList, botList);
        // CREATE AND OUTPUT CSV DIFFERENCE FILE
        campaign.outputCSVfile(parsedoutput);

    }

}
