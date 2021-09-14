/**
 * Class HolyGrail is a simple conversation bot
 * @version 09/15/2021
 * @author 23wallen
 */
import java.util.Scanner;
public class HolyGrail {
    /**
     * Main entry point for class HolyGrail
     * @param args command line arguments, if needed.
     */
    public static void main(String[] args) {
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
        Scanner input = new Scanner(System.in);
        //ask the user their name
        System.out.print("Question 1: What is your name? ");
        //store the input
        String name = input.nextLine();
        //ask the user their quest
        System.out.print("Question 2: What is your quest? ");
        String quest = input.nextLine();
        //ask the user their favorite color
        System.out.print("Question 3: What is your favorite color?");
        String color = input.nextLine();
        //print summary info
        System.out.println("King Arthur says, \"You have to know these things when you're a king, you know.\"");
        System.out.println("Your name is: " + name);
        System.out.println("Your quest is: " + quest);
        System.out.println("Your favorite color is: " + color);
        System.out.println("* end of program *");


    }
}

