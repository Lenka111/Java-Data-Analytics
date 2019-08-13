import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// Elena Voinu: Data Analysis with Java File Processing
class DataAnalytics
{
    public static void main(String args[])
    {
        // declare an object to receive the data
        Scanner scan = new Scanner(System.in);
        // declare an array list to hold the data
        ArrayList<Integer> list;
        list = new ArrayList<Integer>();
        int count = 0;
        int num = 0;
        int val = 0;
        String line = "";

        try
        {
            // create or append to the file
            FileWriter fileOut = new FileWriter("outData.txt");
            BufferedWriter fout = new BufferedWriter(fileOut);

            System.out.println("How many data items?");
            count = scan.nextInt();
            for (int i = 1; i <= count; i++)
            {
                System.out.println("Enter a data value");
                val = scan.nextInt();
                fout.write(val + "\n");
            }
            System.out.println("Thank you ... the data has been recorded!");

            // close the output stream objects
            fout.close();
            fileOut.close();

            scan.close();
            // read the data
            FileReader fileIn = new FileReader("outData.txt");
            BufferedReader fin = new BufferedReader(fileIn);

            while ((line = fin.readLine()) != null)
            {
                num = Integer.parseInt(line);
                list.add(num);
                System.out.println(num);
            }
            System.out.println("Thank you ... the data has been received!");
            fin.close();
            fileIn.close();


            System.out.println("____________________________________");
            //display the unsorted values
            System.out.println("Displaying Unsorted Data...");
            DisplayData(list);

            System.out.println("____________________________________");
            //sort the list and display the result
            BubbleSort(list);
            System.out.println("Displaying Sorted Data...");
            DisplayData(list);

            System.out.println("____________________________________");
            // Display the min and max values
            System.out.println("Min and Max Values:");
            System.out.println("____________________________________");

            MaxMin(list);

            System.out.println("-------------------------------------");
            //display the average value in our list
            Average(list);

            System.out.println("\n-------------------------------------");
            System.out.println("The Perfect Square Values Are: ");
            PerfectSquare(list);


        }
        catch(Exception e)
        {
            // catch an exception if any arises
            System.err.println("Error: " + e.getMessage());
        }
    }// end main



    public static void DisplayData(ArrayList<Integer> num)
    {
        for (int i = 0; i < num.size(); i++)
            System.out.println(num.get(i).toString());
    }



    public static void BubbleSort(ArrayList<Integer> num)
    {
        int j = 0;
        boolean flag = true;  // set the flag to true to begin first pass
        int temp = 0;  // define the holding variable
        while (flag)
        {
            flag = false; //set flag to false awaiting a possible swap
            for (j = 0; j < num.size() - 1; j++)

            {
                if (num.get(j) > num.get(j + 1))
                // for descending sort change to <
                {
                    temp = num.get(j); //swap the elements
                    num.set(j, num.get(j + 1));
                    num.set(j + 1, temp);
                    flag = true; //shows a swap occurred

                }

            }
        }
    }// end bubble sort method


    /*
     * This method returns maximum element/value of the specified collection according
     * to the natural ordering of the elements.
     * */
    public static void MaxMin(ArrayList<Integer> num){

        System.out.println("Min Value Is: " + Collections.min(num) + " Found at Index: " +
                num.indexOf(Collections.min(num)));
        System.out.println("Max Value Is: " + Collections.max(num) + " Found at Index: "+
                num.indexOf(Collections.max(num)));

    }// end method find min/max value


    public static double Average(ArrayList<Integer> num){

       double sum=0, average = 0 ;

        for (int i = 0; i < num.size(); i ++)
        {
            sum +=num.get(i);
            average =  sum/num.size();
        }
        System.out.printf("Average Value Is: %.2f ",average, "\n");
        return average;

    } //end method average


    // find any values in the ArrayList that are perfect squares
    public static void PerfectSquare(ArrayList<Integer> num)
    {
        int i;
        for (i = 0; i < num.size(); i ++) {
            double sqrt = Math.sqrt(num.get(i));
            int x = (int) sqrt;
            if (Math.pow(sqrt, 2) == Math.pow(x, 2)) {
                System.out.println(num.get(i) + " ");
            }
        }


        } // end method perfectSquare


}// end class
