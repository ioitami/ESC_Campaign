ESC Campaign
------------
**Ng Jowie**
**1005494**
**CI03**

This is an **Eclipse project**, and if you want to view it as such, simply download the entire repo and set **/campaign** as the target project folder.

Before running the program, take note that all .csv files are to be placed in the **campaign/testfiles** folder, as the program finds the .csv files in that directory.

NOTE: This program only allows .csv files to be inputted (.txt files or any other file type that can be read via text editors works as well as long as the data is readable by them). Additionally, the program only works if the two .csv files have the same number of columns.

To run the program, ensure that you are in the **/campaign** folder on your command line, before typing the command:
> java -jar testapp.jar

You will then be prompted to enter the first file name. 
> (E.g sample_file_1.csv)

Finally, you will be prompted to enter the second file name to be compared to.
> (E.g sample_file_3.csv)

If there are no errors, the output file, **output.csv**, will be exported to **campaign/testfiles/output.csv**.

Code files, as well as junit test case files, are found under **campaign/src/campaignfiles**.

> **app.java** contains the main function.

> **allothers.java** contains all the other functions which app.java uses to run.

> **allothersTest.java** contains all the junit test cases for both app.java and allothers.java.
