import static org.junit.Assert.*;
/**
 * Class RomanToDecimalTest utilizes JUnit testing to test method romanToDecimal
 * @version 10/04/2021
 * @author 23wallen
 */
public class RomanToDecimalTest {
    @org.junit.Test
    /**
     * Method romanToDecimal converts String roman numeral input to decimal and returns the decimal value; this method uses junit testing to test romanToDecimal
     */
    public void romanToDecimal() {
        // 10 valid user input tests
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("xvii"), 17);
        assertEquals(RomanToDecimal.romanToDecimal("mmcmx"), 2910);
        assertEquals(RomanToDecimal.romanToDecimal("mcmxlivi"), 1945);
        assertEquals(RomanToDecimal.romanToDecimal("CDLXXVII"), 477);
        assertEquals(RomanToDecimal.romanToDecimal("lxix"), 69);
        assertEquals(RomanToDecimal.romanToDecimal("DCXCVI"), 696);
        assertEquals(RomanToDecimal.romanToDecimal("MMMMMMCMLXIX"), 6969);
        assertEquals(RomanToDecimal.romanToDecimal("CMXCIX"), 999);
        assertEquals(RomanToDecimal.romanToDecimal("MCCXXXIV"), 1234);
        // 4 logically incorrect user input tests
        assertEquals(RomanToDecimal.romanToDecimal("iviviv"), 16);
        assertEquals(RomanToDecimal.romanToDecimal("cmixix"), 920);
        assertEquals(RomanToDecimal.romanToDecimal("ivxliv"), 50);
        assertEquals(RomanToDecimal.romanToDecimal("XCXLCXC"), 340);
        // 4 invalid user input tests
        assertEquals(RomanToDecimal.romanToDecimal("yourmom"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("cxixyx"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("whattimeisit"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("xviih"), -1);
        // 4 assertNotEquals tests
        assertNotEquals(RomanToDecimal.romanToDecimal("xixixixix"), 8);
        assertNotEquals(RomanToDecimal.romanToDecimal("cxixyx"), 47);
        assertNotEquals(RomanToDecimal.romanToDecimal("whattimeisit"), 83);
        assertNotEquals(RomanToDecimal.romanToDecimal("xviih"), 12);

        //assertEquals(RomanToDecimal.romanToDecimal("your mom"), -1);
        //assertNotEquals(RomanToDecimal.romanToDecimal("Joe"), 20);
    }
}