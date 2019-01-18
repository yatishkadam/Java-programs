package homework5;

import problem2.Card;
import problem2.Hand;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TestHelperClass {
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
    private Hand hand;
    private Hand pairHand;
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
    Card cardAce = new Card(shortNameOfCardForA, cardRankForAce, cardSymbol);
    Card cardAce1 = new Card(shortNameOfCardForA, cardRankForAce, cardSymbol);
    Card cardAce2 = new Card(shortNameOfCardForA, cardRankForAce, cardSymbol);
    Card cardTen = new Card(shortNameOfCardForTen, cardRankForTen, cardSymbol);

    Card cardTwo = new Card(shortNameOfCardForTwo, cardRankForTwo, cardSymbol);
    Card cardThree = new Card(shortNameOfCardForThree, cardRankForThree, cardSymbol);
    Card cardFour = new Card(shortNameOfCardForFour, cardRankForFour, cardSymbol);
    Card cardFive = new Card(shortNameOfCardForFive, cardRankForFive, cardSymbol);
    Card cardSix = new Card(shortNameOfCardForSix, cardRankForSix, cardSymbol);
    Card cardSeven = new Card(shortNameOfCardForSeven, cardRankForSeven, cardSymbol);
    Card cardEight = new Card(shortNameOfCardForEight, cardRankForEight, cardSymbol);
    Card cardNine = new Card(shortNameOfCardForNine, cardRankForNine, cardSymbol);

    Card cardAceHeart = new Card(shortNameOfCardForA, cardRankForAce, HEART);

    IDealer dealerA;
    IDealer dealer2;
    IDealer dealer3;
    IDealer dealer4;
    IDealer dealer5;
    IDealer dealer6;
    IDealer dealer7;
    IDealer dealer8;
    IDealer dealer9;
    IDealer dealer10;
    IDealer dealerk;
    IDealer dealerQ;
    IDealer dealerJ;


    //Because we know that the shown cards of the dealer are of only these poosibilities
    List<String> dealerFaceCardOP = Arrays.asList("2","3","4","5","6","7","8","9","10","A");


    TestHelperClass(){

        game = BlackjackGame.getInstance(2,2);
        game.deal();
        dealerA = new Dealer(game);
        dealerA.accept(cardAce);
        dealerA.setFaceUpCard(cardAce);
        dealerA.accept(cardAce);

        dealer2 = new Dealer(game);
        dealer2.accept(cardTwo);
        dealer2.setFaceUpCard(cardTwo);
        dealer2.accept(cardTwo);

        dealer3 = new Dealer(game);
        dealer3.accept(cardThree);
        dealer3.setFaceUpCard(cardThree);
        dealer3.accept(cardThree);

        dealer4 = new Dealer(game);
        dealer4.accept(cardFour);
        dealer4.setFaceUpCard(cardFour);
        dealer4.accept(cardFour);

        dealer5 = new Dealer(game);
        dealer5.accept(cardFive);
        dealer5.setFaceUpCard(cardFive);
        dealer5.accept(cardFive);

        dealer6 = new Dealer(game);
        dealer6.accept(cardSix);
        dealer6.setFaceUpCard(cardSix);
        dealer6.accept(cardSix);

        dealer7 = new Dealer(game);
        dealer7.accept(cardSeven);
        dealer7.setFaceUpCard(cardSeven);
        dealer7.accept(cardSeven);

        dealer8 = new Dealer(game);
        dealer8.accept(cardEight);
        dealer8.setFaceUpCard(cardEight);
        dealer8.accept(cardEight);

        dealer9 = new Dealer(game);
        dealer9.accept(cardNine);
        dealer9.setFaceUpCard(cardNine);
        dealer9.accept(cardNine);

        dealer10 = new Dealer(game);
        dealer10.accept(cardTen);
        dealer10.setFaceUpCard(cardTen);
        dealer10.accept(cardTen);

        dealerk = new Dealer(game);
        dealerk.accept(cardNine);
        dealerk.setFaceUpCard(cardAce);
        dealerk.accept(cardAce);

        dealerQ = new Dealer(game);
        dealerQ.accept(cardAce);
        dealerQ.setFaceUpCard(cardAce);
        dealerQ.accept(cardAce);

        dealerJ = new Dealer(game);
        dealerJ.accept(cardAce);
        dealerJ.setFaceUpCard(cardAce);
        dealerJ.accept(cardAce);
    }


}
