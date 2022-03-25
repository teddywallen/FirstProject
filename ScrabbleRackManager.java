import java.util.*;
import java.io.*;

/**
 * ScrabbleRackManager creates a random Scrabble tile rack and prints possible playable words
 * @version Friday 03/25/2022
 * @author 23wallen
 */
public class ScrabbleRackManager {
    private ArrayList<ArrayList<String>> dictionary;
    private ArrayList<String> tileRack;
    private String alpha;


    /**
     * class constructor
     * initialize private data
     * build dictionary and tile rack
     */
    public ScrabbleRackManager() {
        // initialize private data vals
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";
        dictionary = new ArrayList<ArrayList<String>>();
        for(int i = 0; i <26 ; i++)
            dictionary.add(new ArrayList<String>());
        // and build dictionary
        buildDictionary();
        buildTileRack();
    }

    private void buildDictionary() {
        try {
            Scanner filein = new Scanner(new File("2019_collins_scrabble.txt"));
            while(filein.hasNext()) {
                String temp = filein.nextLine();
                dictionary.get(alpha.indexOf(temp.charAt(0))).add(temp);
            }
            filein.close();
        }
        catch(Exception e) {
            System.out.println("Error opening file see here: " + e);
        }
    }

    /* private void buildRack() {
        tileRack = new ArrayList<String>();
        ArrayList<String> letters = new ArrayList<String>();
        String[] tiles = {"A", "A", "A", "A", "A", "A", "A", "A", "A", "B", "B", "C", "C", "D", "D", "D", "D", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "F", "F", "G", "G", "G", "H", "H", "I", "I", "I", "I", "I", "I", "I", "I", "I", "J", "K", "L", "L", "L", "L", "M", "M", "N", "N", "N", "N", "N", "N", "O", "O", "O", "O", "O", "O", "O", "P", "P", "Q", "R", "R", "R", "R", "R", "R", "S", "S", "S", "S", "T", "T", "T", "T", "T", "T", "U", "U", "U", "U", "V", "V", "W", "W",
                "X", "Y", "Y", "Z"};
        for (String item : tiles)
            letters.add(item);
        Collections.shuffle(letters);
        for (int i = 0; i < 7; i++) {
            tileRack.add(tiles.remove(tiles[(int) Math.random() * tiles.length]));
        }
    } */

    private void buildTileRack() {
        tileRack = new ArrayList<String>();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        int[] frequencies = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};
        ArrayList<String> allTiles = new ArrayList<>();
        int index = 0;
        for(int count : frequencies) {
            for(int i = 0; i < count; i++) {
                allTiles.add(alpha.substring(index, index+1));
            }
            index++;
        }
        //randomly shuffle
        Collections.shuffle(allTiles);
        // 7 random tiles
        for (int i = 0; i < 7; i++) {
            tileRack.add(allTiles.remove((int)(Math.random()*allTiles.size())));
        }


    }

    /*
    public void showDictionary() {
        for(ArrayList<String> bucket : dictionary)
            System.out.println(bucket);
    }
     */


    /**
     * displays the contents of the player's tile rack
     */
    public void printRack() {
        System.out.println("Letters in the rack: " + tileRack);
    }

    /**
     * builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile rack
     * @return an ArrayList of all playable words
     */
    public ArrayList<String> getPlaylist() {
        ArrayList<String> plays = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary) {
            if(tileRack.contains(""+bucket.get(0).charAt(0)) || tileRack.contains(" "))
                for(int i = 0; i < bucket.size(); i++) {
                    if(isPlayable(bucket.get(i)))
                        plays.add(bucket.get(i));
                }
        }
        return plays;
        // algo
        /* declare and initialize arraylist of playable words
            look at each bucket, does first letter of first word exist in tileRack?
            if yes, look at all words in bucket
            if no skip bucket
            for each word in bucket
                call private isPlayable method
         */
    }

    private boolean isPlayable(String word) {
        ArrayList<String> tileRack2 = new ArrayList<>(tileRack);
        for(int i = 0; i < word.length(); i++) {
            if(!tileRack2.remove(""+word.charAt(i)))
                if(!tileRack2.remove(" "))
                    return false;



        }
        return true;
        // create copy of tileRack
        // iterate thru every letter in word
        // look at java.util.arraylist method remove, what does it return?
        // for each letter in the word, if can't remove from rack, return false
        // if loop runs to completion, return true, tilerack can play word
    }

    /**
     * prints all the playable words based on the letters in the tile rack in column/row format
     * denotes "bingo"s
     */
    public void printMatches() {
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        System.out.println("You can play the following words from the letters in your rack:");
        if(plays.size() == 0)
            System.out.println("Sorry, NO words can be played from those tiles.");
        for(int i = 0; i < plays.size(); i++) {
            String word = plays.get(i);
            if(word.length() == 7) {
                word += "*";
                bingo = true;
            }
            System.out.printf("%-10s", word);
            if((i+1) % 10 == 0)
                System.out.println();
        }
        if(bingo)
            System.out.println("\n* Denotes BINGO");

    }

    /**
     * main method for class ScrabbleRackManager;
     * only 3 command lines in main
     * @param args command line arguments if needed
     */
    public static void main(String[] args) {
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }
}

/*
        int[] distribution = new int[]{9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};
        int[] tiles = new int[100];
        for(int i = 0; i < distribution.length; i++) {
            for(int j = 0; j < i; j++) {
                Array.set(tiles, j, alpha.charAt(i));
            }
        }
        System.out.println(tiles);
        */


/* int[] distribution = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};
        ArrayList<String> tiles = new ArrayList<>();
        for(int i = 0; i < distribution.length; i++) {
            for(int j = 0; j < i; j++) {
                tiles.add( (String) alpha.charAt(i));
            }
        }
        System.out.println(tiles); */