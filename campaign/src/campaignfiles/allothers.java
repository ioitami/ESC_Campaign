package campaignfiles;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.lang.*;

public class allothers {

    public String choosefile() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Type now:");

        String filename = myObj.nextLine(); // Read user input

        return filename;
    }

    // READ A CSV FILE AND PARSE IT INTO AN ARRAYLIST OF STRING ARRAYS
    // (ArrayList<String[]>)
    public ArrayList<String[]> readCSVfiles(String arg) {

        ArrayList<String[]> parsedlist = new ArrayList<>();

        // READ AND PARSE FILE
        try (BufferedReader br = new BufferedReader(new FileReader(arg))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                parsedlist.add(line.split(","));
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("Unable to read file or file does not exist. Exiting Program.");
            System.exit(0);
        }

        return parsedlist;
    }

    // REMOVE FIRST ROW OF ARRAYLIST<STRING[]>
    public ArrayList<String[]> popArrList(ArrayList<String[]> parsedlist) {
        if (parsedlist.size() > 0) {
            parsedlist.remove(0);
        } else {
            System.out.println(".csv is empty! Exiting program.");
            System.exit(0);
        }
        return parsedlist;
    }

    // Return the arr with higher num of rows
    public ArrayList<String[]> returnTopSizeArr(ArrayList<String[]> arr1, ArrayList<String[]> arr2) {
        if (arr1.size() < arr2.size()) {
            return arr2;
        } else {
            return arr1;
        }
    }

    // Return the arr with lower num of rows
    public ArrayList<String[]> returnBotSizeArr(ArrayList<String[]> arr1, ArrayList<String[]> arr2) {
        if (arr1.size() < arr2.size()) {
            return arr1;
        } else {
            return arr2;
        }
    }

    public int checkNumColumns(ArrayList<String[]> arr1, ArrayList<String[]> arr2) {
        System.out.println("No. of columns for 1st .csv: " + arr1.get(0).length);
        System.out.println("No. of columns for 2st .csv: " + arr2.get(0).length);
        if (arr1.get(0).length != arr2.get(0).length) {
            return 0;
        } else {
            return 1;
        }

    }

    // COMPARE TWO PARSED ARRAYLIST<STRING[]> AND OUTPUT THE DIFFERENCES INTO A NEW
    // ARRAYLIST<STRING[]>
    public ArrayList<String[]> checkCSVfiles(ArrayList<String[]> arr1, ArrayList<String[]> arr2) {

        ArrayList<String[]> parsedoutput = new ArrayList<>();

        try {
            if (arr1.size() == 0 && arr2.size() != 0) {

                List<String> outputarr = new ArrayList<String>();
                // OUTPUT ALL ROWS OF ARR2
                for (int j = 0; j < arr2.size(); j++) {
                    for (int q = 0; q < arr2.get(j).length; q++) {
                        outputarr.add(arr2.get(j)[q]);
                    }
                    String[] outputarrConvert2 = new String[outputarr.size()];
                    parsedoutput.add(outputarr.toArray(outputarrConvert2));
                }

            } else if (arr1.size() != 0 && arr2.size() == 0) {

                List<String> outputarr = new ArrayList<String>();
                // OUTPUT ALL ROWS OF ARR2
                for (int j = 0; j < arr1.size(); j++) {
                    for (int q = 0; q < arr1.get(j).length; q++) {
                        outputarr.add(arr1.get(j)[q]);
                    }
                    String[] outputarrConvert = new String[outputarr.size()];
                    parsedoutput.add(outputarr.toArray(outputarrConvert));
                }

            }

            // CHECK FIRST ROW MATCH
            for (int i = 0; i < arr1.size(); i++) {
                String id = arr1.get(i)[0];
                List<String> outputarr = new ArrayList<String>();
                List<String> outputarr2 = new ArrayList<String>();

                // FIND MATCHING FIRST COLUMN IN ARR2
                for (int j = 0; j < arr2.size(); j++) {
                    String id2 = arr2.get(j)[0];

                    // If able to find matching id...
                    if (id.equals(id2)) {

                        // CHECK EACH COLUMN
                        for (int k = 1; k < arr1.get(i).length; k++) {
                            String info = arr1.get(i)[k];
                            String info2 = arr2.get(j)[k];

                            // If at least one column not equals to each other, add entire row into
                            // outputarr
                            if (!info.equals(info2)) {

                                // Copy second csv row into outputarr
                                for (int q = 0; q < arr2.get(j).length; q++) {
                                    outputarr2.add(arr2.get(j)[q]);
                                }
                                String[] outputarrConvert2 = new String[outputarr2.size()];
                                parsedoutput.add(outputarr2.toArray(outputarrConvert2));

                                // Copy first csv row into outputarr
                                for (int q = 0; q < arr1.get(i).length; q++) {
                                    outputarr.add(arr1.get(i)[q]);
                                }
                                String[] outputarrConvert = new String[outputarr.size()];
                                parsedoutput.add(outputarr.toArray(outputarrConvert));

                                break;
                            }
                        }
                        break;
                    }
                    // IF UNABLE TO FIND MATCHING ID IN SECOND FILE, ADD INTO OUTPUTARR
                    else if (j == arr2.size() - 1) {

                        for (int q = 0; q < arr1.get(i).length; q++) {
                            outputarr.add(arr1.get(i)[q]);
                        }
                        String[] outputarrConvert = new String[outputarr.size()];
                        parsedoutput.add(outputarr.toArray(outputarrConvert));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error occured in producing .csv output! Exiting now.");
            System.exit(0);
        }

        return parsedoutput;
    }

    // TAKE THE OUTPUT ARRAYLIST<STRING[]> TO BE WRITTREN TO OUTPUT CSV FILE
    public void outputCSVfile(ArrayList<String[]> parsedoutput) {
        // Create CSV file to be outputted
        File output = new File("testfiles/output.csv");

        try {
            FileWriter outputfile = new FileWriter(output);

            // Add data to CSV
            for (int j = 0; j < parsedoutput.size(); j++) {
                for (int k = 0; k < parsedoutput.get(j).length; k++) {
                    outputfile.append(parsedoutput.get(j)[k]);

                    // Add ',' after every input except the last
                    if (k < parsedoutput.get(j).length - 1) {
                        outputfile.append(",");
                    }
                }
                // Add new row after completing each row except the last
                if (j < parsedoutput.size() - 1) {
                    outputfile.append("\n");
                }
            }

            // closing writer connection
            outputfile.flush();
            outputfile.close();
            System.out.println("CSV file is created...");
        } catch (IOException e) {
            System.out.println("Error occured in outputting .csv. Exiting now.");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("CSV No. of Rows: " + parsedoutput.size());
    }
}
