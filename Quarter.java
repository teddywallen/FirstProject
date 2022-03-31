/**
 * Quarter is a Coin2 with value 0.25 and name quarter
 * @version Thursday 03/21/2022
 * @author 23wallen
 */
public class Quarter extends Coin {

    /**
     * @return the value of this coin as a double
     */
    public double getValue() {
        return 0.25;
    }

    /**
     * @return String version of this coin's name
     */
    public String getName() {
        return "quarter";
    }
}
