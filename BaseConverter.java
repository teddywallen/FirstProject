import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 * BaseConverter opens a data file, reads, converts numbers, prints, writes
 * @version Thursday 11/18/2021
 * @author 23wallen
 */
public class BaseConverter {
    // Constructor for class.
    public BaseConverter() {

    }
    // Convert a String num in fromBase to base-10 int.
    /**
     * strToInt takes a number from base 2 to 16 and converts it to a base-10 int
     * @param num input number (str)
     * @param fromBase base of input number (str)
     * @return converted base-10 int
     */
    public int strToInt(String num, String fromBase) {
        int base = Integer.parseInt(fromBase);
        String alpha = "0123456789ABCDEF";
        int sum = 0, exp = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            sum += alpha.indexOf("" + num.charAt(i)) * Math.pow(base, exp);
            exp++;
        }
        return sum;
    }

    // Convert a base-10 int to a String number of base toBase.

    /**
     * intToStr takes a base-10 int and converts it to a str number of base toBase
     * @param num base-10 int
     * @param toBase desired base of output str number
     * @return str number of base toBase
     */
    public String intToStr(int num, int toBase) {
        String alpha = "0123456789ABCDEF";
        String toNum = "";
        while(num > 0) {
            toNum = alpha.charAt(num % toBase) + toNum;
            num /= toBase;
        }
        if(toNum == "")
            return "0";
        return toNum;
    }




    /**
     * inputConvertPrintWrite opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite() {
        //create a Scanner that opens values10.dat
        // print each line to the screen
        Scanner in = null;
        PrintWriter pw = null;
        JFileChooser j = new JFileChooser();
        System.out.println("Please choose a file to convert.");
        try { // CANNOT put Scanner that opens a file not in a try/catch
            j.showDialog(null,"Convert File");
            j.setVisible(true);
            File filename = j.getSelectedFile();
            in = new Scanner(filename);
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while (in.hasNext()) {
                String[] line = in.nextLine().split("\t");
                // String[] line = {"24A4B56", "13", "6"}
                // items to test: line[1] and line[2]
                /* for(String val : line)
                    System.out.print(val + "\t"); */
                int fromBase = Integer.parseInt(line[1]), toBase = Integer.parseInt(line[2]);
                if(fromBase < 2 || fromBase > 16) {
                    System.out.println("Invalid input base " + fromBase);
                }
                else if(toBase < 2 || toBase > 16) {
                    System.out.println("Invalid output base " + toBase);
                }
                else {
                    /* for (String temp : line) {
                        System.out.print(temp + "\t");
                        pw.print(temp + "\t");
                    } */

                    // print statement to the console
                    System.out.println(line[0] + " base " + line[1] + " = " + intToStr(strToInt(line[0], line[1]), toBase) + " base " + line[2]);
                    pw.println(line[0] + "\t" + line[1] + "\t" + intToStr(strToInt(line[0], line[1]), toBase) + "\t" + line[2]);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(in != null)
            in.close(); // VERY IMPORTANT
        if(pw != null)
            pw.close();
    }

    // Main method for class BaseConverter. Yours should look just like this!
    /**
     * Main method for class BaseConverter
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        // app.inputConvertPrintWrite();
        // System.out.println(app.strToInt("21221201", "3"));
        // System.out.println(app.intToStr(5789324, 16));
        app.inputConvertPrintWrite();
    }
}



/*

algorithm:

open input file
open output stream

read input line by line
test base values
if valid
    write the data line as is back to the output value
else
    do nothing

 */

/*

conversion algorithm:

use a reference String alpha = "0123456789ABCDEF"
WHY???
    *Cuz u can use String.indexOf to get the int value of a digit

declare vars sum = 0, exp = 0
for i len(num)-1 to 0:
    sum+= the ith digit multiplied by fromBase&exp
    exp++
    i--
 */
