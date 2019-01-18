package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Card;
import problem2.Hand;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is used to test the helper class.
 * Most of this is already being tested through the other  test cases also But just to show it works we write one test each.
 *
 * @author yatish.kadam
 */
class BlackJackHelperTest {
    /**
     * This is map variable which tells what actions the player can perform and what is the code value associated with it.
     */
    private static Map<String, Integer> playerActionMap = new HashMap<>();
    static {
        playerActionMap.put("Stand", 1);
        playerActionMap.put("Hit", 2);
        playerActionMap.put("Split", 3);
        playerActionMap.put("Surrender", 4);
    }

    private TestHelperClass testHelperClass;
    private Hand hand;
    private Hand pairHand;
    private Hand handA2;
    private Hand hand22;
    /**
     * declaring all the constants
     */
    private static final char SPADES ='\u2660';
    private static final char HEART = '\u2665';        // Heart suit
    private char shortNameOfCardForA = 'A' ;
    private int cardRankForAce = 1;
    private char cardSymbol = SPADES;
    BlackJackHelper blackJackHelper;

    /**
     * declaring all the constants
     */
    private char shortNameOfCardForTen = 'T' ;
    private int cardRankForTen = 10;


    /**
     * declaring all the constants
     */
    private char shortNameOfCardForTwo = '2' ;
    private int cardRankForTwo = 2;

    private char shortNameOfCardForThree = '3' ;
    private int cardRankForThree = 3;

    private char shortNameOfCardForFive = '5' ;
    private int cardRankForFive = 5;
    private char shortNameOfCardForSeven = '7' ;
    private int cardRankForSeven = 7;
    private char shortNameOfCardForEight = '8' ;
    private int cardRankForEight = 8;
    private char shortNameOfCardForNine = '9' ;
    private int cardRankForNine = 9;
    private char shortNameOfCardForKing = 'K' ;
    private int cardRankForKing = 3;


    /**
     * declaring all the constants
     */
    private char shortNameOfCardForFour = '4' ;
    private int cardRankForFour = 4;

    /**
     * declaring all the constants
     */
    private char shortNameOfCardForSix = '6' ;
    private int cardRankForSix = 6;

    BlackjackGame game;
    /**
     * Creating new cards
     */
    private Card cardAce = new Card(shortNameOfCardForA, cardRankForAce, cardSymbol);
    private Card cardAce1 = new Card(shortNameOfCardForA, cardRankForAce, cardSymbol);
    private Card cardAce2 = new Card(shortNameOfCardForA, cardRankForAce, cardSymbol);
    private Card cardTen = new Card(shortNameOfCardForTen, cardRankForTen, cardSymbol);

    private Card cardTwo = new Card(shortNameOfCardForTwo, cardRankForTwo, cardSymbol);
    private Card cardFour = new Card(shortNameOfCardForFour, cardRankForFour, cardSymbol);
    private Card cardSix = new Card(shortNameOfCardForSix, cardRankForSix, cardSymbol);
    private Card cardAceHeart = new Card(shortNameOfCardForA, cardRankForAce, HEART);

    IDealer dealer;


    /**
     * Initializing a hand
     */
    @BeforeEach
    void makeHand(){
        hand = new Hand();
        handA2 = new Hand();
        hand22 = new Hand();
        pairHand = new Hand();
        hand.accept(cardAce);
        hand.accept(cardFour);
        game = BlackjackGame.getInstance(2,2);
        dealer = new Dealer(game);
        dealer.accept(cardAceHeart);
        dealer.setFaceUpCard(cardAce);
        dealer.accept(cardSix);
        blackJackHelper = new BlackJackHelper();
        pairHand.accept(cardAce1);
        pairHand.accept(cardAce2);
        testHelperClass = new TestHelperClass();
        handA2.accept(testHelperClass.cardAce);
        handA2.accept(testHelperClass.cardTwo);

        hand22.accept(testHelperClass.cardTwo);
        hand22.accept(testHelperClass.cardTwo);
    }

    @Test
    void checkCardListTotal() {
        //cards being sent are ace and 4 and as Ace + 4 is less than 21 we consider it as a ace with the value 11
        assertEquals(16, blackJackHelper.checkCardListTotal(hand.showCards()));
    }

    @Test
    void checkIfPairs() {
        assertFalse(blackJackHelper.checkIfPairs(hand.showCards()));
        assertTrue(blackJackHelper.checkIfPairs(pairHand.showCards()));
    }


    @Test
    void checkIfSoftHand() {
        assertTrue(blackJackHelper.checkIfSoftHand(handA2.showCards()));
        assertFalse(blackJackHelper.checkIfSoftHand(hand22.showCards()));
    }
}