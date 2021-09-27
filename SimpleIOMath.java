import java.util.Scanner;
/**
 * Class SimpleIOMath is a simple conversation bot that records and returns string and numerical user input
 * @version 09/27/2021 - Monday, September 27, 2021
 * @author 23wallen
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;

    private int smallestPrime(int num) {
        for(int i = 2; i <= (int)(Math.sqrt(num))+1; i++) {
            if (num % i == 0)
                return i;
        }
        return num;
    }
    /**
     * Method promptUser requests user inputs and stores input in vars
     */
    public void promptUser() {
        Scanner input = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        name = input.nextLine();
        System.out.print("Question 2: How old are you? ");
        age = input.nextInt();
        System.out.print("Question 3: What is your favorite number? ");
        favNumber = input.nextInt();
    }

    /**
     * Extra: if/else statements depending on value for user input for age/favNumber
     */
    public void myExtra() {
        if (age > 30) {
            System.out.println("Wow. Someone's getting old. Time to retire?");
        } else {
            System.out.println("Looks like you've got a long life ahead of you. Remember, YOLO!");
        }
        if (favNumber != 47) {
            System.out.println("Also, your favorite number is lame. Everyone knows the best number is 47.");
        }
        else {
            System.out.println("Also, congratulations. You picked the best number. Contact 23wallen@da.org for your prize.");
        }
    }

    /**
     * Method printInfo issues print statements and prints/manipulates user input
     */
    public void printInfo() {
        System.out.println("I'm gonna teach you how to sing it out");
        System.out.println("Come on, come on, come on");
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday, you will turn " + (age+1) + ".");
        System.out.println("The first prime factor of " + age + " is: " + smallestPrime(age));
        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + Math.pow(favNumber,2));
    }
    /**
     * Main entry point for class SimpleIOMath
     * @param args command line arguments, if needed.
     */
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
        obj.myExtra();
        System.out.println("* end of program *");
    }
}


// questions: float for squared number?
//use math.pow for squared number

/* Version from HolyGrail.java
public class SimpleIOMath {
    /**
     * Main entry point for class SimpleIOMath
     * @param args command line arguments, if needed.
     *END OF JAVADOC
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        Scanner input = new Scanner(System.in);
        //ask the user their name
        System.out.print("Question 1: What is your name? ");
        //store the input
        String name = input.nextLine();
        //ask the user their quest
        System.out.print("Question 2: How old are you? ");
        int age = input.nextInt();
        //ask the user their favorite color
        System.out.print("Question 3: What is your favorite number? ");
        int number = input.nextInt();
        //print summary info
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday, you will turn " + (age+1));
        System.out.println("The first prime factor of " + age + " is");
        System.out.println("Your favorite number is: " + number);
        System.out.println("Your favorite number squared is: " + (number*number));
        System.out.println("* end of program *");


    }
}

*/
