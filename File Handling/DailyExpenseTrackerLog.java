// A personal finance app logs daily expenses into a file. Implement using Java File 
// Handling:    Tasks:   (a) List all files in a given 'expenses/' directory and display 
// names with sizes   (b) Write 5 expense records to 'expenses_log.txt':       Format 
// — Date, Category, Amount, Description (one record per line)   (c) Read 
// 'expenses_log.txt' line by line; display in formatted table   (d) Append today's new 
// expense without overwriting existing records   (e) Read file and calculate:         • 
// Total expenditure         • Maximum single expense         • Count of expenses in 
// category "Food"    Use: File, FileWriter (append=true), BufferedReader, 
// PrintWriter, proper exception handling 

import java.io.*;

// Main Class
public class DailyExpenseTrackerLog {

    public static void main(String[] args) {

        try {
            // (a) List files in directory
            File dir = new File("expenses");

            File[] files = dir.listFiles();

            System.out.println("Files in expenses directory:\n");

            if (files != null) {

                for (File f : files) {
                    System.out.println(f.getName() + "  Size: " + f.length() + " bytes");
                }
            }

            // (b) Write expense records
            FileWriter fw = new FileWriter("expenses_log.txt");

            PrintWriter pw = new PrintWriter(fw);

            pw.println("01-May,Food,250,Lunch");
            pw.println("01-May,Travel,80,Bus");
            pw.println("02-May,Food,310,Dinner");
            pw.println("02-May,Shopping,1200,Shirt");
            pw.println("03-May,Food,190,Breakfast");

            pw.close();

            System.out.println("\nExpense records written.");

            // (c) Read and display table
            FileReader fr = new FileReader("expenses_log.txt");

            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\nDate\tCategory\tAmount\tDescription");

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                System.out.println(data[0] + "\t" + data[1] + "\t\t" + data[2] + "\t" + data[3]);
            }

            br.close();

            // (d) Append new expense
            FileWriter fw2 = new FileWriter("expenses_log.txt", true);

            PrintWriter pw2 = new PrintWriter(fw2);

            pw2.println("03-May,Travel,50,Auto");

            pw2.close();

            System.out.println("\nNew expense appended.");

            // (e) Calculate statistics
            FileReader fr2 = new FileReader("expenses_log.txt");

            BufferedReader br2 = new BufferedReader(fr2);

            int total = 0;
            int max = 0;
            int foodCount = 0;

            while ((line = br2.readLine()) != null) {

                String data[] = line.split(",");

                int amount = Integer.parseInt(data[2]);

                total = total + amount;

                if (amount > max) {
                    max = amount;
                }

                if (data[1].equals("Food")) {
                    foodCount++;
                }
            }

            br2.close();

            System.out.println("\nTotal Expenditure = " + total);
            System.out.println("Maximum Expense = " + max);
            System.out.println("Food Expenses Count = " + foodCount);
        }

        catch (FileNotFoundException e) {

            System.out.println("File not found");
        }

        catch (IOException e) {

            System.out.println(e);
        }
    }
}