/**
 * Coins2 is an abstract class that defines methods for coins
 * @version Thursday 03/21/2022
 * @author 23wallen
 */
public abstract class Coin {

    /**
     * @return the value of a given coin as a double
     */
    public abstract double getValue();

    /**
     * @return String version of a given coin's name
     */
    public abstract String getName();

    /**
     * @return String version of a given coin's plural name
     */
    public String getPluralName() {
        if(getValue() == 0.01)
            return getName().substring(0, 4) + "ies";
        return getName() + "s";
    }
}
