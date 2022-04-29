import java.util.*;
/**
 * Class Waypoint Comparator establishes a comparator for Waypoints by category and ascending or descending order
 * @version 04/29/2022
 * @author 23wallen
 */
public class WaypointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;

    /**
     * WaypointComparator constructor
     * @param c category
     * @param a ascending/descending
     */
    public WaypointComparator(int c, boolean a){
        category = c; asc = a;
    }

    /**
     * WaypointComparator constructor
     * @param c category
     */
    public WaypointComparator(int c){
        category = c;
        asc = true;
    }

    /**
     * WaypointComparator constructor
     */
    public WaypointComparator(){
        category = 4;
        asc = true;
    }


    /**
     * Compare method for different Waypoint categories + ascending/descending order
     * @param one first Waypoint to be compared
     * @param two second Waypoint to be compared
     * @return
     */
    public int compare(Waypoint one, Waypoint two) {
        int diff = 0;
        if(category == 1) //TYPE
            diff = one.getType().compareTo(two.getType());
        if(category == 2) //NAME
            diff = one.getName().compareTo(two.getName());
        if(category == 3) //STATE
            diff = one.getState().compareTo(two.getState());
        if(category == 4) //DTS
        {
            Double d1 = one.getToSpringer();
            Double d2 = two.getToSpringer();
            diff = d1.compareTo(d2);
        }
        if(category == 5) //DTK
        {
            Double d1 = one.getToKatahdin();
            Double d2 = two.getToKatahdin();
            diff = d1.compareTo(d2);
        }
        if(category == 6) //ELEVATION
            diff = one.getElevation()-two.getElevation();

        return (asc) ? diff : -diff;

    }

    // comparator = balance scale, comparable = x is taller than y
    // comparator = two specific objects, comparable is just ability to be compared
    // comparator = noun, an object that takes two things, and comparable is adjective
}
