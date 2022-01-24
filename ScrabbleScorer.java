import java.util.*;
import java.io.*;

/**
 * ScrabbleScorer takes user input, determines if it is a valid scrabble word w/ dictionary,and calculates its scrabble score if so
 * @version Monday 01/24/2022
 * @author 23wallen
 */
public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10}; //populate rest of array
    private String alpha;

    /**
     * Constructor for class ScrabbleScorer
     * Initializes dictionary and builds alpha string
     * Calls buildDictionary to import words
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();
    }

    /**f
     * buildDictionary creates a sorted scrabble word dictionary ArrayList from text file
     * Opens data file, reads words into dictionary one line at time, sorts dictionary
     */
    public void buildDictionary() {
        Scanner in = null;
        try {
            in = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while(in.hasNext())
                dictionary.add(in.nextLine().strip());
            in.close();
            Collections.sort(dictionary);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        // use try/catch
        // use a Scanner
        // read data file
        // when file is read into dictionary, close stream
        // call Collections.sort(dictionary)
    }

    /**
     * Javadoc isValidWord takes a word and uses binarySearch to determine if it is in the scrabble dictionary
     * @param word String value
     * @return true if word is in dictionary, false otherwise
     */
    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     * Javadoc getWordScore takes a word, uses the parallel lists alpha and points to determine the Scrabble score of each letter, and returns the sum of the letter scores
     * @param word String value
     * @return int value for the Scrabble score of word
     */
    public int getWordScore(String word) {
        int sum = 0;
        for(int i = 0; i <= word.length()-1; i++) {
            String letter = ""+word.charAt(i);
            int index = alpha.indexOf(letter);
            sum += points[index];
        }
        // parse word one letter at a time -- for loop ""+charAt or substring
        // find index of each letter
        // add the corresponding score/point value from points to a sum value
        return sum; // sum

    }

    /**
     * Javadoc main entry point for class ScrabbleScorer
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String userWord;
        Scanner userIn = new Scanner(System.in);
        try {
            while(true) {
                System.out.print("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();
                if(userWord.equals("0"))
                    break;
                else {
                    // do the program:
                    // is the word in the dictionary
                    if(app.isValidWord(userWord.toUpperCase())) {
                        // print out point value here
                        System.out.println(userWord + " = " + app.getWordScore(userWord.toUpperCase()) + " points");
                    }
                    else {
                        System.out.println(userWord + " is not a valid word in the dictionary");
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Exiting the program thanks for playing");
    }
}

/*
Binary search example:
int[] n = {1,4,6,8,-10,12,19,20};
        ArrayList<Integer> nums = new ArrayList<>(); // take array and make into ArrayList
        for(int i : n)
            nums.add(i);
        Collections.sort(nums);
        System.out.println(Collections.binarySearch(nums, -10));
 */
