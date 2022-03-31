/**
 * HalfDollr is a Coin2 with value 0.5 and name half dollar
 * @version Thursday 03/21/2022
 * @author 23wallen
 */
public class HalfDollar extends Coin {

    /**
     * @return the value of this coin as a double
     */
    public double getValue() {
        return 0.5;
    }

    /**
     * @return String version of this coin's name
     */
    public String getName() {
        return "half dollar";
    }
}
