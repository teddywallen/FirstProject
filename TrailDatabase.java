import java.io.File;
import java.util.*;
/**
 * Class TrailDatabase establishes database of apptrailDB.txt values, sorts and prints based on user input
 * @version 04/29/2022
 * @author 23wallen
 */
public class TrailDatabase {

    private ArrayList<Waypoint> database;
    private int searchTerm;
    private boolean asc;

    /**
     * Constructor for class TrailDatabase
     * initializes and populates database
     */
    public TrailDatabase() {
        database = new ArrayList<>();
        populateDatabase();
    }

    /**
     * Imports all data out of the apptrailDB.txt file
     */
    public void populateDatabase() {
        try{
            Scanner n = new Scanner(new File("apptrailDB.txt"));
            while(n.hasNextLine()) {
                String[] line = n.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]),
                        Double.parseDouble(line[6]), Integer.parseInt(line[7])));

            }
            n.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Prompts user for input for category to search by and ascending or descending order
     */
    public void getSearchTerm() {
        System.out.println(
                "+ Menu of search terms to use for sorting waypoints +\n" +
                "\tTY: by type\n" +
                "\tNA: by name\n" +
                        "\tST: by state\n" +
                "\tDS: by distance to Springer\n" +
                "\tDK: by distance to Katahdin\n" +
                "\tEL: by elevation");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your preferred sort by term or 'Q' to quit: ");
        String term = in.nextLine();
        if(term.equals("TY"))
            searchTerm = 1;
        else if(term.toUpperCase().equals("NA"))
            searchTerm = 2;
        else if(term.toUpperCase().equals("ST"))
            searchTerm = 3;
        else if(term.toUpperCase().equals("DS"))
            searchTerm = 4;
        else if(term.toUpperCase().equals("DK"))
            searchTerm = 5;
        else if(term.toUpperCase().equals("EL"))
            searchTerm = 6;
        else
            searchTerm = 0;
        if(searchTerm != 0) {
            System.out.print("Enter 'A' to sort in ascending order or 'D' " +
                    "to sort in descending order: ");
            String order = in.nextLine();
            asc = (order.toUpperCase().equals("A")) ? true : false;
        }
        System.out.println();
    }

    /**
     * Prints database
     */
    public void printDB(){
        for(Waypoint w : database)
            System.out.println(w);
        System.out.println();
    }

    /**
     * Sorts database using MergeSort
     */
    public void sortDB(){
        MergeSort ms = new MergeSort();
        ms.sort(database, searchTerm, asc);
        // Collections.sort(database, new WaypointComparator(searchTerm, asc));
    }

    /**
     * Main entry point for class TrailDatabase
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        System.out.println("*** Welcome to the Appalachian Trail Database ***");
        while(true) {
            db.getSearchTerm();
            if(db.searchTerm == 0) {
                System.out.println("End of program");
                break;
            }
            db.sortDB();
            db.printDB();
        }
    }
}

/* database.add(new Waypoint("FEATURE", "Springer Mt", "GA",
                0, 2174.6, 3782));
        database.add(new Waypoint("FEATURE", "Clingmans Dome", "TN",
                195.3, 1979.3, 6643));
        database.add(new Waypoint("FEATURE", "Mt Katahdin", "ME",
                2174.6, 0, 5268)); */


 /* private void mergeSort(int low, int high) {
        if(low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle); //sort left half
            mergeSort(middle + 1, high); //sort right half
            merge(low, middle, high); // merge
        }
    } */

    /* public void merge(int startIndex, int midIndex, int endIndex, ArrayList<Object> inputArray){

        ArrayList<Object> mergedArray = new ArrayList<>();

        int leftIndex = startIndex;
        int rightIndex = midIndex+1;

        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex).compareTo(inputArray.get(rightIndex))){
                mergedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }else{
                mergedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while(leftIndex<=midIndex){
            mergedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }

        while(rightIndex<=endIndex){
            mergedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while(i<mergedArray.size()){
            inputArray.set(j, mergedArray.get(i++));
            j++;
        }
    } */

// SELECTION SORT
    /* private void selectionSort() {
        WaypointComparator wc = new WaypointComparator(searchTerm, asc);
        Waypoint toSwap;
        int index;
        for(int out = 0; out < database.size(); out++) {
            index=out;
            toSwap=database.get(out);
            for(int in = out+1; in < database.size(); in++) {
                Waypoint temp = database.get(in);
                // is temp the ext value?
                if(wc.compare(temp,toSwap)<0) {
                    toSwap=new Waypoint(temp);
                    index=in;
                }
            }
            //now swap the two values, insertion min/max value at outer for loop spot
            database.set(index, database.get(out));
            database.set(out,toSwap);
        }
    } */