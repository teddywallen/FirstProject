import java.text.DecimalFormat;
import java.util.Scanner;
/*
To generate better code coverage, continue the program each time by pressing Y and
use a few different cases of valid and invalid input (examples below)
Case 1: 6'1", 150
Case 2: -6'1", -150
Case 3: your, mom
Using each of those while continuing the program should generate 100% code coverage
*/

/**
 * Class BMICalculator takes user input of height (inches) and weight (lbs) and converts it to kg/m^2 to output as BMI
 * @version 11/09/21
 * @author 23wallen
 */
public class BMICalculator {
    /**
     * Method computeBMI converts inches and lbs to metric units and performs the BMI calculation
     * @return returns double BMI value
     */
    public static double computeBMI(int inches, int pounds) {
        // 1 inch == 0.0254 meters
        // 1 pound == 0.454 kg
        if (inches <= 0 || pounds < 0)
            return 0;
        return pounds * .454 / Math.pow(inches * .0254, 2);
    }

    /**
     * Method extractInches converts user String input for height in feet + inches to int inches
     * @param value user String input for height
     * @return returns int inches value
     */
    public static int extractInches(String value) {
        int qtPos = value.indexOf("'");
        int dblQtPos = value.indexOf("\"");
        if(qtPos == -1 || dblQtPos == -1) {
            return -1;
        }
        int ft = Integer.parseInt(value.substring(0,qtPos));
        int in = Integer.parseInt(value.substring(qtPos+1, dblQtPos));
        if(in > 11 || ft < 0 || in < 0)
            return -1;
        return(ft*12 + in);
    }

    /**
     * Main entry point for class BMICalculator
     * Uses a Scanner to prompt the user for info, process the feet/inches conversion, calls the computeBMI method and prints the correct information
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        String cont = "";
        while(true) {
            System.out.print("Enter your height in feet and inches (Ex 6'1\"): ");
            String height = in.nextLine();
            System.out.print("Enter your weight in pounds: ");
            String weight = in.nextLine();
            try {
                String bmi = df.format(computeBMI(extractInches(height), Integer.parseInt(weight)));
                if(Double.parseDouble(bmi) > 0)
                    System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + bmi + " kg/m^2");
                else
                    System.out.println("Invalid input, try again.");
            }
            catch(Exception e) {
                System.out.println("Invalid input, try again.");
            }
            System.out.print("Continue (Y/N): ");
            cont = in.nextLine();
            if(!cont.toLowerCase().equals("y"))
                break;
        }
        System.out.println("End of program");
    }
}

// int weight = in.nextInt();
// in.nextLine();


