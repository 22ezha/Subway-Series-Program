/******************************************************************************
Eric Zhang
Comp Sci 3
12/4/2020
Graded Program
*******************************************************************************/
import java.io.*;
public class Main
{
    public static double round (double num) throws IOException
    {
        num *= 1000;
        num = (int)(num + 0.5);
        num /= 1000;
        return num;
    }
    public static double battingAvg (double [][]num, int i) throws IOException
    {
        double hits = num[i][1];
        double atBats = num[i][0];
        double batAvg = hits / atBats;
        batAvg = round(batAvg);
        return batAvg;
    }
    public static double getPer (double [][] num, int i) throws IOException
    {
        DataInputStream reader = new DataInputStream(System.in);
        double atBats = num[i][0];
        double hits = num[i][1];
        double doub = num[i][2];
        double trip = num[i][3];
        double hrs = num[i][4];
        double sing = hits - hrs - doub - trip;
        double bases = (sing + (doub * 2) + (trip * 3) + (hrs * 4));
        double slugper = bases / atBats;
        slugper = round(slugper);
        return slugper;
    }
    public static void team (String name) throws IOException
    {
        
        BufferedReader inFile = new BufferedReader(new FileReader(name + ".txt"));
        PrintWriter outFile = new PrintWriter(new FileWriter(name + "out.txt"));
        double [][] num = new double [9][8];
        String lname;
        String fname;
        double slugper;
        String pos;
        double batavg;
        double avgbat = 0;
        double avgslug = 0;
        String hold;
        for (int i = 0; i <= 8; i++)
        {
            lname = inFile.readLine();
            fname = inFile.readLine();
            pos = inFile.readLine();
            for (int j = 0; j <= 4; j++)
            {
                num[i][j] = Double.parseDouble(inFile.readLine());
            }
            batavg = battingAvg(num, i);
            avgbat = batavg;
            slugper = getPer(num, i);
            avgslug = slugper;
            outFile.println(fname + " " + lname + " - " + pos + "\n" + batavg + "\n" + slugper + "\n");
        }
            avgbat = (avgbat / 9);
            avgslug = (avgslug / 9);
            avgbat = round(avgbat);
            avgslug = round(avgslug);
            hold = name.substring(0,1);
            hold = hold.toUpperCase ( );
            name = name.substring(1);
            name = hold +name;
            System.out.println("\nThe " +name+ " batting average is " + avgbat);
            System.out.println("The " +name+ " slugging percentage is " + avgslug);
       
        inFile.close();
        outFile.close();
    }
    
        public static void main(String[] args) throws IOException
        {
            DataInputStream reader = new DataInputStream(System.in);
            String name;
            name = "mets";
            team(name);
            name = "yankees";
            team(name);
        }
}