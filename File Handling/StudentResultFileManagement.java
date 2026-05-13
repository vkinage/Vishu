// A university's exam department manages results using file handling. Implement 
// in Java:    Tasks:   (a) List all .txt files present in a given directory path (e.g., 
// results/) using File class   (b) Write student results to 'results.txt':       Format per 
// line — RollNo, Name, Marks, Grade (compute grade: ≥60=B, ≥75=A, ≥90=O, 
// else F)   (c) Read 'results.txt' line by line using BufferedReader; display formatted 
// result table   (d) Append a new result record to existing file without overwriting   
// (e) Count total number of students who passed (marks ≥ 40) by reading the file    
// Use: File, FileWriter, BufferedWriter, FileReader, BufferedReader, 
// FileNotFoundException handling 

import java.io.*;

// Main Class
public class StudentResultFileManagement {

    // Method to calculate grade
    static String getGrade(int marks) {

        if (marks >= 90)
            return "O";

        else if (marks >= 75)
            return "A";

        else if (marks >= 60)
            return "B";

        else
            return "F";
    }

    public static void main(String[] args) {

        try {
            // (a) List all .txt files

            File dir = new File("results");

            File[] files = dir.listFiles();

            System.out.println("TXT Files:\n");

            if (files != null) {

                for (File f : files) {

                    if (f.getName().endsWith(".txt")) {

                        System.out.println(f.getName());
                    }
                }
            }

            // (b) Write student results
            FileWriter fw = new FileWriter("results.txt");

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("101,Asha,85," + getGrade(85));
            bw.newLine();

            bw.write("102,Raj,72," + getGrade(72));
            bw.newLine();

            bw.write("103,Priya,91," + getGrade(91));
            bw.newLine();

            bw.write("104,Dev,38," + getGrade(38));
            bw.newLine();

            bw.close();

            System.out.println("\nData written successfully.");

            // (c) Read and display file
            FileReader fr = new FileReader("results.txt");

            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\nRoll\tName\tMarks\tGrade");

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                System.out.println(data[0] + "\t" + data[1] + "\t" + data[2] + "\t" + data[3]);
            }

            br.close();

            // (d) Append new record
            FileWriter fw2 = new FileWriter("results.txt", true);

            BufferedWriter bw2 = new BufferedWriter(fw2);

            bw2.write("105,Neha,65," + getGrade(65));
            bw2.newLine();

            bw2.close();

            System.out.println("\nNew record appended.");

            // (e) Count passed students
            FileReader fr2 = new FileReader("results.txt");

            BufferedReader br2 = new BufferedReader(fr2);

            int passCount = 0;

            while ((line = br2.readLine()) != null) {

                String data[] = line.split(",");

                int marks = Integer.parseInt(data[2]);

                if (marks >= 40) {
                    passCount++;
                }
            }

            br2.close();

            System.out.println("\nPassed Students = " + passCount);
        }

        catch (FileNotFoundException e) {

            System.out.println("File not found");
        }

        catch (IOException e) {

            System.out.println(e);
        }
    }
}