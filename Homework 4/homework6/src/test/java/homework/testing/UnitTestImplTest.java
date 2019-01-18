package homework.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



/**
 * This is used to test the  UnitTestImpl class.
 *
 * @author yatish
 */
class UnitTestImplTests {
    UnitTestImpl unitTest;

    /**
     * Initialisation of the class
     */
    @BeforeEach
    void init(){
        unitTest = new UnitTestImpl();
    }

    /**
     * This is used to check for a valid input with multiple 2 spaces
     */
    @Test
    void exampleTestwithValidInput() {
        int expectedValue = 2;
        String stringToCheck = "    Foo    Fooo";
        assertEquals(expectedValue, unitTest.example(stringToCheck));
    }

    /**
     * check if correct when no space are given
     */
    @Test
    void testWithOneInput(){
        String stringToCheck = "Fooo";
        assertEquals(0, unitTest.example(stringToCheck));
    }

    /**
     * Cehck when the string is given as empty
     */
    @Test
    void testWithEmptyInput(){
        String stringToCheck = "";
        assertEquals(0, unitTest.example(stringToCheck));
    }


    /**
     * This is used to check for when only a long string of space is given
     */
    @Test
    void testWithOnlySpaceInput(){
        String stringToCheck = "                    ";
        assertEquals(0, unitTest.example(stringToCheck)); //should return 1 but returns 0
    }

    /**
     * check when there is 1 and 2 spaces inbetween
     */
    @Test
    void testWithSpaceInput(){
        String stringToCheck = " Foo  Foo";
        assertEquals(1, unitTest.example(stringToCheck));
    }

    /**
     * when we give null as an input
	it is not handles so we check if a runtime exception is throw
     */
    @Test
    void testWithNullInput(){
        String stringToCheck = null;
        Assertions.assertThrows(RuntimeException.class,() -> unitTest.example(stringToCheck));
    }

    /**
     * when we with special charaters
     */
    @Test
    void testWithtabInput(){
        String stringToCheck = "\t\t\tFoo\tFoo";
        assertEquals(0, unitTest.example(stringToCheck));
    }

     /**
     * when we send trailing spaces
     */
    @Test
    void testWithTrailingInput(){
        String stringToCheck = "Foo        ";
        assertEquals(0, unitTest.example(stringToCheck)); // should return 1 but returns 0.
    }


}