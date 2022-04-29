/**
 * Class Waypoint establishes the Waypoint object
 * @version 04/29/2022
 * @author 23wallen
 */
public class Waypoint {

    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    /**
     * Waypoint constructor
     * @param t type
     * @param n name
     * @param s state
     * @param ts distance to Springer Mt
     * @param tk distance to Mt Katahdin
     * @param e elevation
     */
    public Waypoint(String t, String n, String s, double ts, double tk, int e) {
        type = t; name = n; state = s;
        toSpringer = ts; toKatahdin = tk;
        elevation = e;
    }

    /**
     * Waypoint copy constructor
     * @param other previously initialized Waypoint
     */
    public Waypoint(Waypoint other) {
        this(other.type, other.name, other.state,
                other.toSpringer, other.toKatahdin, other.elevation);
    }

    /**
     * Empty Waypoint constructor, used for filling empty ArrayList
     */
    public Waypoint() {
    }

    /**
     * Get method for type
     * @return type
     */
    public String getType() { return type; }

    /**
     * Get method for name
     * @return name
     */
    public String getName() { return name; }

    /**
     * Get method for state
     * @return state
     */
    public String getState() { return state; }

    /**
     * Get method for distance to Springer Mt
     * @return distance to Springer Mt
     */
    public double getToSpringer() { return toSpringer; }

    /**
     * Get method for distance to Mt Katahdin
     * @return distance to Mt Katahdin
     */
    public double getToKatahdin() { return toKatahdin; }

    /**
     * Get method for elevation
     * @return elevation
     */
    public int getElevation() { return elevation; }

    /**
     * toString method for Waypoint object
     * @return String consisting of t, n, s, ts, tk, e
     */
    @Override
    public String toString() {
        return type + ", " + name + ", " + state + ", " +
                toSpringer + ", " + toKatahdin + ", " + elevation;

    }
}


/* public int compareTo(Waypoint other){
        Double d1 = this.toKatahdin;
        Double d2 = other.toKatahdin;
        return d1.compareTo(d2);
                //-(this.getName().compareTo(other.getName()));
    } */