package homework.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


/**
 * This is used to test the  UnitTestingHomeworkImpl class.
 *
 * @author yatish
 */
class UnitTestingHomeworkTest {
    UnitTestingHomework testingHomework;

    /**
     * Initialization
     */
    @BeforeEach
    void init(){
        testingHomework = new UnitTestingHomeworkImpl(); // needs to be replaced with the class name.
    }

    /**
     * Checking for a valid case - square of 2;
     */
    @Test
    void sqrValid() {
    int x = 2;
    int expectedVal = x * x;
    assertEquals(expectedVal, testingHomework.sqr(x));
    }

    /**
     * Checking for square of zero
     */
    @Test
    void sqrValidZero() {
        int x = 0;
        int expectedVal = x * x;
        assertEquals(expectedVal, testingHomework.sqr(x));
    }

    /**
     * Checking square of one
     */
    @Test
    void sqrValidPosOne() {
        int x = 1;
        int expectedVal = 1;
        assertEquals(expectedVal, testingHomework.sqr(x));
    }

    /**
     * checking the sqaure of neg one
     */
    @Test
    void sqrValidNegOne() {
        int x = -1;
        int expectedVal = 1;
        assertEquals(expectedVal, testingHomework.sqr(x));
    }

    /**
     * This is used to test the squaring when we give a neg value.
     */
    @Test
    void sqrValidNeg() {
        int x = -2;
        int expectedVal = 4;
        assertEquals(expectedVal, testingHomework.sqr(x));
    }

    /**
     * This is used to test the squaring when we give a neg value.
     */
    @Test
    void sqrValidNegAndPos() {
        int x = -2;
        int posX = 2;
        assertEquals(testingHomework.sqr(posX), testingHomework.sqr(x));
    }

    /**
     * This is used to check the max possible return value of interger before it overflows.
     * So we check for the
     */
    @Test
    void sqrMaxIntPossible() {
        int x = 46340; // as sqr(46340) is less than INTEGER.MAXVALUE so there wont be a overflow. hence we take a number 1 greater than 46340.
        int expectedResult = x * x;
        assertEquals(expectedResult, testingHomework.sqr(x));
    }

    /**
     * This is used to check the max value allowed before overflow
     */
    @Test
    void sqrMinIntPossible() {
        int x = -46340; // as sqr(46340) is less than INTEGER.MAXVALUE so there wont be a overflow. hence we take a number 1 greater than 46340.
        int expectedResult = x * x;
        assertEquals(expectedResult, testingHomework.sqr(x));
    }

    /**
     * This is used to check the
     */
    @Test
    void sqrMaxIntBoundNotPossible() {
        int x = 46341; // as sqr(46340) is less than INTEGER.MAXVALUE so there wont be a overflow. hence we take a number 1 greater than 46340.
        Assertions.assertThrows(RuntimeException.class, () -> testingHomework.sqr(x));
    }

    /**
     * This is used to check the
     */
    @Test
    void sqrMaxIntBoundStandardNotPossible() {
        int x = 46341; // as sqr(46340) is less than INTEGER.MAXVALUE so there wont be a overflow. hence we take a number 1 greater than 46340.
        assertEquals(testingHomework.sqr(x), testingHomework.sqr(-6346));
    }

    /**
     * Check for a vlaue which will over flow and throws an exception.
     */
    @Test
    void sqrMinIntBoundNotPossible() {
        int x = -46341; // as sqr(46340) is less than INTEGER.MAXVALUE so there wont be a overflow. hence we take a number 1 greater than 46340.
        Assertions.assertThrows(RuntimeException.class, () -> testingHomework.sqr(x));
    }

    /**
     * Check for a vlaue which will over flow and return a standard code value
     */
    @Test
    void sqrMinIntBoundStandardPossible() {
        int x = -46344; // as sqr(46340) is less than INTEGER.MAXVALUE so there wont be a overflow. hence we take a number 1 greater than 46340.
        assertEquals(testingHomework.sqr(x), testingHomework.sqr(-46346));
    }

    /**
     * The max sqr valid bfore overflow
     *
     * Not that i am checking only upto 2 decimal places. no rounding
     */
    @Test
    void sqrtValidMAX() {
        int x = Integer.MAX_VALUE;
        double expectedVal = 46340.95;   // i am just considering two decimal places without any rounding.
        assertEquals(expectedVal, testingHomework.sqrt(x), 0.01);
    }

    /**
     * min invalid before underflow
     */
    @Test
    void sqrtInValidMin() {
        int x = Integer.MIN_VALUE;
        Assertions.assertThrows(RuntimeException.class, () -> testingHomework.sqrt(x));
    }

    /**
     * checking for a valid sqrt
     */
    @Test
    void sqrtValid() {
        int x = 4;
        assertEquals(2.0,testingHomework.sqrt(x), 0.01);
    }

    /**
     * check for a invalid value
     */
    @Test
    void sqrtInValid() {
        int x = -1;
        Assertions.assertThrows(RuntimeException.class, () -> testingHomework.sqrt(x));
    }

    /**
     * check for a invalid value
     */
    @Test
    void sqrtInValidStandardCheck() {
        int x = -1;
        assertEquals(testingHomework.sqrt(x),testingHomework.sqrt(x));
    }

    /**
     * check for value 0
     */
    @Test
    void sqrtValidZero() {
        int x = 0;
        assertEquals(0.0,testingHomework.sqrt(x), 0.01);
    }

    /**
     * Check for zero
     */
    @Test
    void sqrtValidOne() {
        int x = 1;
        assertEquals(1.0,testingHomework.sqrt(x) , 0.01);
    }


    /**
     * check for factorial of zero
     */
    @Test
    void factorialZero() {
        assertEquals(1, testingHomework.factorial(0));
    }

    /**
     * check for factorial of one
     */
    @Test
    void factorialOne() {
        assertEquals(1, testingHomework.factorial(1));
    }

    /**
     * check for factorial of two
     */
    @Test
    void factorialTwo() {
        assertEquals(2, testingHomework.factorial(2));
    }

    /**
     * check for factorial of three
     */
    @Test
    void factorialThree() {
        assertEquals(6, testingHomework.factorial(3));
    }

    /**
     * check for factorial of when over flow
     */
    @Test
    void factorialOverFlow() {
        Assertions.assertThrows(RuntimeException.class, () -> testingHomework.factorial(13));
        Assertions.assertThrows(RuntimeException.class, () -> testingHomework.factorial(21));
    }


    /**
     * check for factorial of when over flow and returns a standard value
     */
    @Test
    void factorialOverFlowStandardvalue() {
        assertEquals(testingHomework.factorial(13), testingHomework.factorial(21));
    }

    /**
     * check for factorial of when  just under overflow
     * which is 12
     */
    @Test
    void factorialMaxBoundary() {
        assertEquals(479001600, testingHomework.factorial(12));
    }

    /**
     * check for factorial of zero
     */
    @Test
    void factorialNeg() {
        Assertions.assertThrows(RuntimeException.class, () -> testingHomework.factorial(-1));
    }

    /**
     * check for factorial when neg is sent as an arguement
     * In such a case if a standard value is being sent back it should be the same hwne two such neg values are sent
     */
    @Test
    void factorialNegForStandarCode() {
        Assertions.assertEquals(testingHomework.factorial(-4), testingHomework.factorial(-1));
    }

    /**
     * Checking for adding 0 + 0
     */
    @Test
    void testSimpleFunctionXplusYZeroIn() {
        int x = 0;
        int y = 0;
        int sum = 0;
        assertEquals(sum, testingHomework.simpleFunctionXplusY(x,y));
    }

    /**
     * Checking for adding 0 + 0
     */
    @Test
    void testSimpleFunctionXplusYNonZeroIn(){
        int x= 0;
        int y = 1;
        int sum = 1;
        assertEquals(sum, testingHomework.simpleFunctionXplusY(x,y));
    }

    /**
     * Checking for adding 4 + 1
     */
    @Test
    void testSimpleFunctionXplusYPOSPOSIn(){
        int x= 4;
        int y = 1;
        int sum = 5;
        assertEquals(sum, testingHomework.simpleFunctionXplusY(x,y));
    }

    /**
     * Checking for adding  one neg and Zero
     */
    @Test
    void testSimpleFunctionXplusYZeroandNegIn(){
        int x= 0;
        int y = -1;
        int sum = -1;
        assertEquals(sum, testingHomework.simpleFunctionXplusY(x,y));
    }

    /**
     * Checking for adding one POS and one NEG
     */
    @Test
    void testSimpleFunctionXplusYPosNegIn(){
        int x= 1;
        int y = -1;
        int sum = 0;
        assertEquals(sum, testingHomework.simpleFunctionXplusY(x,y));
    }

    /**
     * Checking for neg and neg value
     */
    @Test
    void testSimpleFunctionXplusYNegNegIn(){
        int x= -1;
        int y = -1;
        int sum = -2;
        assertEquals(sum, testingHomework.simpleFunctionXplusY(x,y));
        assertEquals(-3, testingHomework.simpleFunctionXplusY(x,sum));
    }

    /**
     * Checking for the MAx Value possible
     */
    @Test
    void testSimpleFunctionXplusYMAXPosZeroIn(){
        int x= Integer.MAX_VALUE;
        int y = 0;
        int sum = Integer.MAX_VALUE;
        assertEquals(sum, testingHomework.simpleFunctionXplusY(x,y));
    }

    /**
     * Checking when the addition overflows
     */
    @Test
    void testSimpleFunctionXplusYMAXPosOneIn(){
        int x= Integer.MAX_VALUE;
        int y = 1;
        Assertions.assertThrows(RuntimeException.class,() -> testingHomework.simpleFunctionXplusY(x, y));
    }

    /**
     * Checking when the addition overflows
     */
    @Test
    void testSimpleFunctionXplusYMAXPosMAxPosIn(){
        int x= Integer.MAX_VALUE;
        Assertions.assertThrows(RuntimeException.class,() -> testingHomework.simpleFunctionXplusY(x, x));
    }
    /**
     * Checking when the addition overflows
     */
    @Test
    void testSimpleFunctionXplusYMAXPosMaxNegIn(){
        int x= Integer.MAX_VALUE;
        int y = Integer.MIN_VALUE;
        assertEquals(-1, testingHomework.simpleFunctionXplusY(x,y));
    }

    /**
     * Checking when the addition overflows
     */
    @Test
    void testSimpleFunctionXplusYNegPosMaxNegIn(){
        int x= Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        assertEquals(0, testingHomework.simpleFunctionXplusY(x,y));
    }


    /**
     * Standard formula to find the sum of n natural numbers
     * @param n -  the max n
     * @return - the sum
     */
    int getSumUp(int n) throws RuntimeException{
        int sum = 0;
        int neum = n * (n+1);
        int denom = 2;
        return neum/denom;
    }


    /**
     * Valid input check
     * @throws RuntimeException
     */
    @Test
    void sumUp2() throws RuntimeException {

        int x = 2;
        int expected = getSumUp(x);
        assertEquals(expected, testingHomework.sumUp(x));
    }

    /**
     * valid input
     * @throws RuntimeException
     */
    @Test
    void sumUp3() throws RuntimeException {

        int x = 3;
        int expected = getSumUp(x);
        assertEquals(expected, testingHomework.sumUp(x));
    }

    /**
     * valid input and a outliar
     * @throws RuntimeException
     */
    @Test
    void sumUp0() throws RuntimeException {

        int x = 0;
        int expected = getSumUp(x);
        assertEquals(expected, testingHomework.sumUp(x));
    }

    /**
     * Valid input for the sumput1
     */
    @Test
    void sumUp1() throws RuntimeException {

        int x = 1;
        int expected = getSumUp(x);
        assertEquals(expected, testingHomework.sumUp(x));
    }

    /**
     * this is used to cehck when an invalid input is given and a exception is thrown
     * @throws RuntimeException
     */
    @Test
    void sumUpMaxInt() throws RuntimeException {

        int x= 65535;
        Assertions.assertThrows(RuntimeException.class,() -> testingHomework.sumUp(x));
    }


    /**
     * invalid input and returns a standard code value
     * @throws RuntimeException
     */
    @Test
    void sumUpMaxIntStandard() throws RuntimeException {

        int x= 65536;
        assertEquals(testingHomework.sumUp(x), testingHomework.sumUp(80000));
    }

    /**
     * invalid input and a exception happens
     * @throws RuntimeException
     */
    @Test
    void sumUpNeg1() throws RuntimeException {

        int x = -1;
        int expected = getSumUp(x);
        Assertions.assertThrows(RuntimeException.class,() -> testingHomework.sumUp(x));
    }

    /**
     *invalid input and returns a standard value
     */
    @Test
    void sumUpNeg1Standard() throws RuntimeException {

        int x = -1;
        int expected = getSumUp(x);
        assertEquals(testingHomework.sumUp(x), testingHomework.sumUp(-9));
    }

    /**
     * Valid input to the deSpacer
     */
    @Test
    void despacerNoSpaces() {
        String stringToCheck = "TEST";
        assertEquals(stringToCheck, testingHomework.despacer(stringToCheck));
    }

    /**
     * Valid input to the deSpacer
     */
    @Test
    void despacerNoString() {
        String stringToCheck = "     ";
        String expectedVal = " ";
        assertEquals(expectedVal, testingHomework.despacer(stringToCheck));
    }

    /**
     * Valid input to the deSpacer
     */
    @Test
    void despacerEmptyString() {
        String stringToCheck = "";
        String expectedVal = "";
        assertEquals(expectedVal, testingHomework.despacer(stringToCheck));
    }

    /**
     * Valid input to the deSpacer
     */
    @Test
    void despacerSpaceAtEnd() {
        String stringToCheck = "  Test   ";
        String expectedVal = " Test ";
        assertEquals(expectedVal, testingHomework.despacer(stringToCheck));
    }


    /**
     * Valid input to the deSpacer
     */
    @Test
    void despacerSpaceInBetween() {
        String stringToCheck = "  Test   Happy";
        String expectedVal = " Test Happy";
        assertEquals(expectedVal, testingHomework.despacer(stringToCheck));
    }

    /**
     * Valid input to the deSpacer
     */
    @Test
    void despacerSpaceInBetweenAndEnd() {
        String stringToCheck = "  Test   Happy                  ";
        String expectedVal = " Test Happy ";
        assertEquals(expectedVal, testingHomework.despacer(stringToCheck));
    }


    /**
     * Valid input to the deSpacer
     */
    @Test
    void despacerValidStringPassed() {
        String stringToCheck = "Test Happy";
        String expectedVal = "Test Happy";
        assertEquals(expectedVal, testingHomework.despacer(stringToCheck));
    }


    /**
     * Cehck when we send in a null and it thorws a exception
     */
    @Test
    void despacerNullStringPassed1() {
        String stringToCheck = null;
        Assertions.assertThrows(RuntimeException.class,() -> testingHomework.despacer(stringToCheck));
    }

    /**
     * check when we send in null and it returns a null .
     */
    @Test
    void despacerNullStringPassedAndReturnNull() {
        String stringToCheck = null;
        String expectedVal = null;
        assertEquals(expectedVal, testingHomework.despacer(stringToCheck));
    }

    /**
     * check when we send in valid String with special values like a tab new line etc.
     */
    @Test
    void despacerStringPassedwithCorrectValues() {
        String stringToCheck = "Tab \tTab";
        String expectedVal = stringToCheck;
        assertEquals(expectedVal, testingHomework.despacer(stringToCheck));
    }
}