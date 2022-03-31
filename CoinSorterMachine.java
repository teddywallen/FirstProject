import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CoinSorterMachine sorts through coins from user's input file, summarizes deposit (prints value for each coin and whole file)
 * @version Thursday 03/21/2022
 * @author 23wallen
 */
public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    private int[] count;

    /**
     * initializes coins ArrayList
     */
    public CoinSorterMachine() {
        coins = new ArrayList<Coin>();
        count = new int[6];
    }

    /**
     * uses a Scanner to prompt user for appropriate file, imports coins to ArrayList, handles diabolic values
     */
    public void depositCoins() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of the data file for coin deposit: ");
        String file = in.nextLine();
        System.out.println("Depositing coins...");
        try {
            Scanner filein = new Scanner(new File(file));
            while(filein.hasNext()) {
                String line = filein.nextLine();
                switch (line) {
                    case "1" -> {
                        coins.add(new Penny());
                        count[0]++;
                    }
                    case "5" -> {
                        coins.add(new Nickel());
                        count[1]++;
                    }
                    case "10" -> {
                        coins.add(new Dime());
                        count[2]++;
                    }
                    case "25" -> {
                        coins.add(new Quarter());
                        count[3]++;
                    }
                    case "50" -> {
                        coins.add(new HalfDollar());
                        count[4]++;
                    }
                    case "100" -> {
                        coins.add(new Dollar());
                        count[5]++;
                    }
                    default -> System.out.println("Coin value " + line + " not recognized");

                }
            }
            filein.close();
        }
        catch(Exception e) {
            System.out.println("Error opening file see here: " + e);
        }
    }

    /**
     * Prints deposit summary using a DecimalFormat object
     */
    public void printDepositSummary() {
        DecimalFormat df = new DecimalFormat("$0.00");
        Coin[] coins2 = {new Penny(), new Nickel(), new Dime(), new Quarter(), new HalfDollar(), new Dollar()};
        System.out.println("Summary of deposit:");
        if(coins.isEmpty())
            System.out.println("No valid coin values");
        else
            for(int i = 0; i < count.length; i++) {
                System.out.println("\t" + count[i] + " " + coins2[i].getPluralName() + " " +  df.format(count[i] * coins2[i].getValue()));
            }
        System.out.println("TOTAL DEPOSIT: " + df.format(getTotalValue()));
    }

    /**
     * @return the total value of all Coin objects stored in coins as a double
     */
    public double getTotalValue() {
        double count = 0.0;
        for(Coin p: coins) {
            count+= p.getValue();
        }
        return count;
    }

    /**
     * Main method for class CoinSorterMachine - 3 lines of code
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}