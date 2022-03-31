/**
 * Penny is a Coin2 with value 0.01 and name penny
 * @version Thursday 03/21/2022
 * @author 23wallen
 */
public class Penny extends Coin {

    /**
     * @return the value of this coin as a double
     */
    public double getValue() {
        return 0.01;
    }

    /**
     * @return String version of this coin's name
     */
    public String getName() {
        return "penny";
    }
}
