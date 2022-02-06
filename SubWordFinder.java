import java.util.*;
import java.io.*;

/**
 * SubWordFinder creates a dictionary from a txt file and determines if/how each word can be split into subwords, prints root and its subwords, number of subwords, and which root words have multiple subword combinations
 * @author 23wallen
 * @version 02/01/2022 - extension
 */
public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary; // jagged list, may have more Rs than Zs
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Constructor for class SubWordFinder, finishes initializing dictionary
     */
    public SubWordFinder() {
        dictionary = new ArrayList<>();
        // 26 empty buckets/arraylists in dict arraylist
        for(int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * populateDictionary uses scanner to add words to ArrayList dictionary from txt file
     */
    public void populateDictionary() {
        try {
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while(in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    // binary search: private boolean...
    // TODO: implement using a binary search

    /**
     * indexOf is a user-defined binary search method
     * @param word the word to be searched for
     * @param bucket the list to be searched in
     * @return int val > 0 if word is in bucket, -1 otherwise
     */
    private int indexOf(String word, ArrayList<String> bucket) {
        int low = 0, high = bucket.size()-1;
        int mid;
        while(low <= high) {
            mid = (low + high)/2;
            if (bucket.get(mid).compareTo(word) == 0)
                return mid;
            else if (bucket.get(mid).compareTo(word) > 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    /**
     * inDictionary uses user-defined indexOf method to determine whether word is in the dictionary
     * @param word The item to be searched for in dictionary
     * @return t/f if word is in dictionary
     */
    @Override
    public boolean inDictionary(String word) {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        /* TODO: To receive full credit, you must delete this usage
        TODO: and implement your own private boolean binarySearch String word) method.
         */

        // return bucket.indexOf(word) != -1;

        return indexOf(word, bucket) >= 0;
    }

    /*
    public ArrayList<String> findShortestWords() {
        ArrayList<String> shorts = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary) {
            for(String word : bucket) {
                if(word.length() == 3)
                    shorts.add(word);
            }
        }
        System.out.println("There are " + shorts.size());
        return shorts;
    }
    */

    /**
     * getSubWords determines which words in each bucket of dictionary
     * are compromised of subwords, adds them to ArrayList subwords
     * @return subwords ArrayList
     */
    @Override
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subwords = new ArrayList<>();
        // how to extract every word out of my dictionary?
        for(ArrayList<String> bucket : dictionary) {
            for (String word : bucket) {
                // for loop
                // extract parts of word
                // test to see if they are indexOf != -1
                // add root word, sub1, sub2 as SubWord object
                for(int i = 3; i < word.length()-2; i++) {
                    String sub1 = word.substring(0, i), sub2 = word.substring(i);
                    if(inDictionary(sub1) && inDictionary(sub2))
                        subwords.add(new SubWord(word, sub1, sub2));
                }
            }
        }
        return subwords;
    }

    /*
    public void printDictionary() {
        for(ArrayList<String> bucket : dictionary) {
            System.out.println(bucket);
        }
        int MAXLEN = dictionary.get(0).size();
        int MAXINDEX = 0;
        for(int i = 1; i < dictionary.size(); i++) {
            if(dictionary.get(i).size() > MAXLEN) {
                MAXLEN = dictionary.get(i).size();
                MAXINDEX = i;
            }
        }
        System.out.println("The longest sublist is at index " + MAXINDEX + " starting with the letter " + alpha.charAt(MAXINDEX));
    }
    */

    /**
     * main entry point for class SubWordFinder
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        ArrayList<SubWord> subs = app.getSubWords();
        for(SubWord temp : subs) {
            System.out.println(temp);
        }
        System.out.println("There are " + subs.size() + " SubWord objects in the file.");

        // Extra: return all the words with multiple subword combinations
        System.out.print("Words in the file with multiple SubWord combinations: ");
        for(int i = 0; i < subs.size()-1; i++) {
            String h = subs.get(i).getRoot(), q = subs.get(i+1).getRoot();
            if(h.equals(q)) {
                System.out.print(h + " ");
            }
        }

        /* System.out.println(subs.get(74));
        System.out.println(subs.get(75));
        String z = subs.get(74).getRoot(), j = subs.get(74+1).getRoot();
        if(z.equals(j)) {
            System.out.println(z);
            System.out.println(j);
        } */

        // app.printDictionary();
        // System.out.println(app.findShortestWords());

        // SubWord thing = new SubWord("baseball", "base", "ball");
        // System.out.println(thing);
    }


    /*
     * findShortestWords finds all the shortest (3-character) words in the dictionary and adds them to an ArrayList
     * @return arrayList of the shortest words
     */

}
