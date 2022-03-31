/**
 * Dollar is a Coin2 with value 1.0 and name dollar
 * @version Thursday 03/21/2022
 * @author 23wallen
 */
public class Dollar extends Coin {

    /**
     * @return the value of this coin as a double
     */
    public double getValue() {
        return 1.0;
    }

    /**
     * @return String version of this coin's name
     */
    public String getName() {
        return "dollar";
    }
}
