import java.util.*;
/**
 * Class MergeSort sorts an ArrayList using a merge sort algorithm
 * @version 04/29/2022
 * @author 23wallen
 */
public class MergeSort {
    private static ArrayList<Waypoint> temp;
    private static WaypointComparator wc;

    /**
     * initializes comparator, temp ArrayList to be filled
     * @param a ArrayList to be sorted
     * @param c category/searchTerm for ArrayList sorting
     * @param d ascending or descending order for Arraylist sorting
     */
    public static void sort(ArrayList<Waypoint> a, int c, boolean d) {
        wc = new WaypointComparator(c, d);
        int n = a.size();
        temp = new ArrayList<>(n);
        for(int i = 0; i<a.size();i++)
            temp.add(new Waypoint());
        recursiveSort(a, 0, n-1);
    }

    /**
     * Splits ArrayList by halves, calls itself recursively, sorts (MergeSort algorithm)
     * @param a ArrayList to be sorted
     * @param from initial index
     * @param to ending index
     */
    public static void recursiveSort(ArrayList<Waypoint> a, int from, int to) {
        //WaypointComparator wc = new WaypointComparator(c, d);
        if(to-from<2){ // compare to to from
            if(to > from && wc.compare(a.get(to), a.get(from)) < 0) { // to > from && a.get(to).compareTo(a.get(from))
                Waypoint aTemp = a.get(to);
                a.set(to, a.get(from));
                a.set(from, aTemp);
            }
        }
        else {
            int middle = (from+to)/2;
            recursiveSort(a, from, middle);
            recursiveSort(a, middle+1, to);
            merge(a, from, middle, to);
        }
    }

    private static void merge(ArrayList<Waypoint> a, int from, int middle, int to)  { //}, int c, boolean d) {
        //WaypointComparator wc = new WaypointComparator(c, d);
        int i = from, j = middle+1, k = from;
        while(i <= middle && j <= to) {
            if(wc.compare(a.get(i), a.get(j)) < 0) { // a.get(i).compareTo(a.get(j))
                temp.set(k, a.get(i));
                i++;
            }
            else {
                temp.set(k,a.get(j));
                j++;
            }
            k++;
        }
        while(i <= middle) {
            temp.set(k, a.get(i));
            i++; k++;
        }
        while(j <= to) {
            temp.set(k, a.get(j));
            j++; k++;
        }
        for(k=from;k<=to;k++){
            a.set(k, temp.get(k));
        }
    }
}
