package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandIteratorTest {
    private NewHandInterface hand;
    /**
     * declaring all the constants
     */
    private static final char SPADES ='\u2660';
    private static final char HEART = '\u2665';        // Heart suit
    private char shortNameOfCardForA = 'A' ;
    private int cardRankForAce = 1;
    private char cardSymbol = SPADES;

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

    /**
     * Creating new cards
     */
    private Card cardAce = new Card(shortNameOfCardForA, cardRankForAce, cardSymbol);
    private Card cardTen = new Card(shortNameOfCardForTen, cardRankForTen, cardSymbol);
    private Card cardTwo = new Card(shortNameOfCardForTwo, cardRankForTwo, cardSymbol);
    private Card cardFour = new Card(shortNameOfCardForFour, cardRankForFour, cardSymbol);
    private Card cardSix = new Card(shortNameOfCardForSix, cardRankForSix, cardSymbol);
    private Card cardAceHeart = new Card(shortNameOfCardForA, cardRankForAce, HEART);

    /**
     * Initializing a hand
     */
    @BeforeEach
    void makeHand(){
        hand = new NewHand();
        hand.accept(cardAce);
        hand.accept(cardFour);
        hand.accept(cardTen);
        hand.accept(cardAceHeart);
    }
    @Test
    void hasNext() {
        IHandIterator iterator = new HandIterator(hand.showCards());
        assertTrue(iterator.hasNext());
        while(iterator.hasNext()){
            iterator.next();
        }
        //Check for when it reaches end of list. It should return false
        assertFalse(iterator.hasNext());
        //Check if when the hand given to it is empty it should return false
        IHandIterator iterator1 = new HandIterator((new NewHand().showCards()));
        assertFalse(iterator1.hasNext());
    }

    /**
     * this fuction is used to test the next functionality
     * we create a iterator and checks against the card is they are in the right sequence
     */
    @Test
    void next() {
        IHandIterator iterator = new HandIterator(hand.showCards());
        assertTrue(iterator.hasNext());
        //Check first card
        Card checkCardAgainst = hand.pullCard();
        Card iteratorCard = iterator.next();
        assertEquals(checkCardAgainst.getRank().getPips(), iteratorCard.getRank().getPips());
        assertEquals(checkCardAgainst.getRank().getShortName(), iteratorCard.getRank().getShortName());
        assertEquals(checkCardAgainst.getSuit().getSymbol(), iteratorCard.getSuit().getSymbol());

        //Check second card
        Card checkCardAgainst1 = hand.pullCard();
        Card iteratorCard1 = iterator.next();
        assertEquals(checkCardAgainst1.getRank().getPips(), iteratorCard1.getRank().getPips());
        assertEquals(checkCardAgainst1.getRank().getShortName(), iteratorCard1.getRank().getShortName());
        assertEquals(checkCardAgainst1.getSuit().getSymbol(), iteratorCard1.getSuit().getSymbol());

        //Check Third card
        Card checkCardAgainst2 = hand.pullCard();
        Card iteratorCard2 = iterator.next();
        assertEquals(checkCardAgainst2.getRank().getPips(), iteratorCard2.getRank().getPips());
        assertEquals(checkCardAgainst2.getRank().getShortName(), iteratorCard2.getRank().getShortName());
        assertEquals(checkCardAgainst2.getSuit().getSymbol(), iteratorCard2.getSuit().getSymbol());

        //Check for when it reaches end of list. It should return false
        while(iterator.hasNext()){
            iterator.next();
        }
        assertFalse(iterator.hasNext());
        //Check if when the hand given to it is empty it should return false
        IHandIterator iterator1 = new HandIterator((new NewHand().showCards()));
        assertFalse(iterator1.hasNext());
    }
}