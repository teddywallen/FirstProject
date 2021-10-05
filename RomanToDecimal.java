/**
 * Class RomanToDecimal takes logical roman numeral command line arguments and converts them to decimal numbers or identifies input as invalid or illogical
 * @version 10/04/2021
 * @author 23wallen
 */
public class RomanToDecimal {
    /**
     * Method romanToDecimal converts String roman numeral input to decimal and returns the decimal value
     * @param roman roman numeral input
     * @return returns decimal int
     */
    public static int romanToDecimal(String roman) {
        int decimal = 0;
        roman = roman.toUpperCase();
        for(int i = 0; i < roman.length(); i++) {
            // System.out.println("DEBUG: " + roman.substring(i, i+1).toUpperCase());
            // XOR gate saves time; if value is one letter no need to check for another
            if(roman.substring(i, i+1).equals("I")) {
                decimal += 1;
            }
            else if(roman.substring(i, i+1).equals("V")) {
                decimal += 5;
            }
            else if(roman.substring(i, i+1).equals("X")) {
                decimal += 10;
            }
            else if(roman.substring(i, i+1).equals("L")) {
                decimal += 50;
            }
            else if(roman.substring(i, i+1).equals("C")) {
                decimal += 100;
            }
            else if(roman.substring(i, i+1).equals("D")) {
                decimal += 500;
            }
            else if(roman.substring(i, i+1).equals("M")) {
                decimal += 1000;
            }
            else {
                //the program encountered an invalid character
                return -1;
            }
        }
        if(roman.indexOf("IV") != -1)
            decimal -= 2;
        if(roman.indexOf("IX") != -1)
            decimal -= 2;
        if(roman.indexOf("XL") != -1)
            decimal -= 20;
        if(roman.indexOf("XC") != -1)
            decimal -= 20;
        if(roman.indexOf("CD") != -1)
            decimal -= 200;
        if(roman.indexOf("CM") != -1)
            decimal -= 200;
        return decimal;
    }

    /**
     * Extra: Method isLogical takes decimal input, converts it to a roman numeral string, and returns bool of if it is the same as the original roman numeral input
     * @param temp original roman numeral input
     * @param num decimal input
     * @return returns true or false
     */
    public static boolean isLogical(String temp, int num) {
        // Parts of method borrowed from https://aatul.me/2016/03/28/java-program-to-convert-decimal-number-to-roman-number/
        String[] romanCharacters = { "M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I" };
        int[] romanValues = { 1000, 900, 500, 100, 90, 50, 10, 9, 5, 1 };
        String result = "";

        for (int i = 0; i < romanValues.length; i++) {
            int numberInPlace = num / romanValues[i];
            if (numberInPlace == 0) continue;
            result += numberInPlace == 4 && i > 0? romanCharacters[i] + romanCharacters[i - 1]:
                    new String(new char[numberInPlace]).replace("\0",romanCharacters[i]);
            num = num % romanValues[i];
        }
        //DEBUG: System.out.println("Roman equivalent of " + romanToDecimal(temp) + " is " + result);
        temp = temp.toUpperCase();
        return (result.equals(temp));
    }

    /**
     * Main entry point for class RomanToDecimal
     * @param args command line arguments for Roman numeral input
     */
    public static void main(String[] args) {
        for(String temp : args) {
            int val = romanToDecimal(temp);
            if(val == -1)
                System.out.println("Input: " + temp + " => output: invalid");
            else if(isLogical(temp, val))
                System.out.println("Input: " + temp + " => output: " + val);
            else
                System.out.println("Input: " + temp + " => output: illogical");
        }
    }

}

// bugs: lowercase input, syntax issues, debug statement
/*  invariants: IV/IX -2
    invariants: XL/XC -20
    invariants: CD/CM -200  */
