package problem2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test the Game class
 *
 * @author yatish
 */
class GameTest {
    /**
     * Unicode character declaration for the different suits.
     */
    private static final  char SPADES ='\u2660';        // Spades suit
    private static final  char HEART = '\u2665';        // Heart suit
    private static final  char DIMOND = '\u2666';       // Dimond suit
    private static final  char CLUB = '\u2663';         // Club suit

    /**
     * Individual check creation check.
     * Repeating the same procedure as done for Standard Deck class
     *
     */
    @Test
    void createDeckForStandard() {
        String deckType = "Standard";
        int numberOfHands = 4;                       //number of hands in the game
        int numberOfCardsEachHand = 0;              //number of cards in each hand
        Game game = GameFactory.createGame(deckType,numberOfHands,numberOfCardsEachHand);

        List<Card> cardsInDeck = new ArrayList<Card>(game.deck.getCards());
        int standardDeckSize = 52;
        int maxSpadesInDeck = 13;
        int maxHeartInDeck = 13;
        int maxClubsInDeck = 13;
        int maxDimondInDeck = 13;

        int numberOfSpadeCards = 0;
        int numberOfHeartCards = 0;
        int numberOfDimondCards = 0;
        int numberOfClubCards = 0;
        int otherCardsFound = 0;
        for (Card card:cardsInDeck) {
            char suit = card.getSuit().getSymbol();
            switch (suit){
                case SPADES:
                    numberOfSpadeCards +=1;
                    break;
                case HEART:
                    numberOfHeartCards +=1;
                    break;
                case DIMOND:
                    numberOfDimondCards +=1;
                    break;
                case CLUB:
                    numberOfClubCards +=1;
                    break;
                default:
                    otherCardsFound +=1;
                    break;
            }
        }
        assertEquals(cardsInDeck.size(),standardDeckSize);         // max number of cards to be present in the deck
        assertEquals(numberOfSpadeCards,maxSpadesInDeck);        // max number of spade suited cards to be present in the deck
        assertEquals(numberOfHeartCards,maxHeartInDeck);         // max number of heart suited cards to be present in the deck
        assertEquals(numberOfDimondCards,maxDimondInDeck);      // max number of dimond suited cards to be present in the deck
        assertEquals(numberOfClubCards,maxClubsInDeck);          // max number of club suited cards to be present in the deck
        assertEquals(otherCardsFound, 0);
    }

    /**
     * Individual check creation check.
     * Repeating the same procedure as done for Euchre Deck class
     *
     */
    @Test
    void createDeckForEuchre() {
        String deckType = "Euchre";
        int numberOfHands = 4;
        int numberOfCardsEachHand = 0;
        Game game = GameFactory.createGame(deckType,numberOfHands,numberOfCardsEachHand);

        List<Card> cardsInDeck = new ArrayList<Card>(game.deck.getCards());
        int euchreDeckSize = 24;
        int maxSpadesInDeck = 6;
        int maxHeartInDeck = 6;
        int maxClubsInDeck = 6;
        int maxDimondInDeck = 6;


        int numberOfSpadeCards = 0;
        int numberOfHeartCards = 0;
        int numberOfDimondCards = 0;
        int numberOfClubCards = 0;
        int otherCardsFound = 0;

        for (Card card:cardsInDeck) {
            char suit = card.getSuit().getSymbol();
            switch (suit){
                case SPADES:
                    numberOfSpadeCards +=1;
                    break;
                case HEART:
                    numberOfHeartCards +=1;
                    break;
                case DIMOND:
                    numberOfDimondCards +=1;
                    break;
                case CLUB:
                    numberOfClubCards +=1;
                    break;
                default:
                    otherCardsFound +=1;
                    break;
            }
        }
        assertEquals(cardsInDeck.size(),euchreDeckSize);         // max number of cards to be present in the deck
        assertEquals(numberOfSpadeCards,maxSpadesInDeck);        // max number of spade suited cards to be present in the deck
        assertEquals(numberOfHeartCards,maxHeartInDeck);         // max number of heart suited cards to be present in the deck
        assertEquals(numberOfDimondCards,maxDimondInDeck);      // max number of dimond suited cards to be present in the deck
        assertEquals(numberOfClubCards,maxClubsInDeck);          // max number of club suited cards to be present in the deck
        assertEquals(otherCardsFound, 0);
    }

    /**
     * Individual check creation check.
     * Repeating the same procedure as done for Pinochle Deck class
     *
     */
    @Test
    void createDeckForPinochle() {
        String deckType = "Pinochle";
        int numberOfHands = 4;
        int numberOfCardsEachHand = 0;
        Game game = GameFactory.createGame(deckType,numberOfHands,numberOfCardsEachHand);

        List<Card> cardsInDeck = new ArrayList<Card>(game.deck.getCards());
        int pinochleDeckSize = 48;
        int maxSpadesInDeck = 12;
        int maxHeartInDeck = 12;
        int maxClubsInDeck = 12;
        int maxDimondInDeck = 12;

        int numberOfSpadeCards = 0;
        int numberOfHeartCards = 0;
        int numberOfDimondCards = 0;
        int numberOfClubCards = 0;
        int otherCardsFound = 0;

        for (Card card:cardsInDeck) {
            char suit = card.getSuit().getSymbol();
            switch (suit){
                case SPADES:
                    numberOfSpadeCards +=1;
                    break;
                case HEART:
                    numberOfHeartCards +=1;
                    break;
                case DIMOND:
                    numberOfDimondCards +=1;
                    break;
                case CLUB:
                    numberOfClubCards +=1;
                    break;
                default:
                    otherCardsFound +=1;
                    break;
            }
        }
        assertEquals(cardsInDeck.size(),pinochleDeckSize);         // max number of cards to be present in the deck
        assertEquals(numberOfSpadeCards,maxSpadesInDeck);        // max number of spade suited cards to be present in the deck
        assertEquals(numberOfHeartCards,maxHeartInDeck);         // max number of heart suited cards to be present in the deck
        assertEquals(numberOfDimondCards,maxDimondInDeck);      // max number of dimond suited cards to be present in the deck
        assertEquals(numberOfClubCards,maxClubsInDeck);          // max number of club suited cards to be present in the deck
        assertEquals(otherCardsFound, 0);
    }

    /**
     * Individual check creation check.
     * Repeating the same procedure as done for Vegas Deck class
     *
     */
    @Test
    void createDeckForVegas() {
        String deckType = "Vegas";
        int numberOfHands = 4;
        int numberOfCardsEachHand = 0;
        Game game = GameFactory.createGame(deckType,numberOfHands,numberOfCardsEachHand);
        int numberOFVegasDeck = 6;

        List<Card> cardsInDeck = new ArrayList<Card>(game.deck.getCards());
        int vegasDeckSize = 52 * numberOFVegasDeck;
        int maxSpadesInDeck = 13* numberOFVegasDeck;
        int maxHeartInDeck = 13* numberOFVegasDeck;
        int maxClubsInDeck = 13* numberOFVegasDeck;
        int maxDimondInDeck = 13* numberOFVegasDeck;

        int numberOfSpadeCards = 0;
        int numberOfHeartCards = 0;
        int numberOfDimondCards = 0;
        int numberOfClubCards = 0;
        int otherCardsFound = 0;
        for (Card card:cardsInDeck) {
            char suit = card.getSuit().getSymbol();
            switch (suit){
                case SPADES:
                    numberOfSpadeCards +=1;
                    break;
                case HEART:
                    numberOfHeartCards +=1;
                    break;
                case DIMOND:
                    numberOfDimondCards +=1;
                    break;
                case CLUB:
                    numberOfClubCards +=1;
                    break;
                default:
                    otherCardsFound +=1;
                    break;
            }
        }
        assertEquals(cardsInDeck.size(), vegasDeckSize);         // max number of cards to be present in the deck
        assertEquals(numberOfSpadeCards,maxSpadesInDeck);        // max number of spade suited cards to be present in the deck
        assertEquals(numberOfHeartCards,maxHeartInDeck);         // max number of heart suited cards to be present in the deck
        assertEquals(numberOfDimondCards,maxDimondInDeck);      // max number of dimond suited cards to be present in the deck
        assertEquals(numberOfClubCards,maxClubsInDeck);          // max number of club suited cards to be present in the deck
        assertEquals(otherCardsFound, 0);
    }


    /**
     * This is to test the creation of the deck when the number of decks is also given as an arguement
     *
     * MAinly used for the creation of the vegas deck
     */
    @Test
    void createDeckForVegasNOD() {
        String deckType = "Vegas";
        int numberOfHands = 4;
        int numberOFVegasDeck = 8;
        int numberOfCardsEachHand = 0;
        Game game = GameFactory.createGame(deckType,numberOFVegasDeck, numberOfHands,numberOfCardsEachHand);

        List<Card> cardsInDeck = new ArrayList<Card>(game.deck.getCards());
        int vegasDeckSize = 52 * numberOFVegasDeck;
        int maxSpadesInDeck = 13* numberOFVegasDeck;
        int maxHeartInDeck = 13* numberOFVegasDeck;
        int maxClubsInDeck = 13* numberOFVegasDeck;
        int maxDimondInDeck = 13* numberOFVegasDeck;

        int numberOfSpadeCards = 0;
        int numberOfHeartCards = 0;
        int numberOfDimondCards = 0;
        int numberOfClubCards = 0;
        int otherCardsFound = 0;
        for (Card card:cardsInDeck) {
            char suit = card.getSuit().getSymbol();
            switch (suit){
                case SPADES:
                    numberOfSpadeCards +=1;
                    break;
                case HEART:
                    numberOfHeartCards +=1;
                    break;
                case DIMOND:
                    numberOfDimondCards +=1;
                    break;
                case CLUB:
                    numberOfClubCards +=1;
                    break;
                default:
                    otherCardsFound +=1;
                    break;
            }
        }
        assertEquals(cardsInDeck.size(), vegasDeckSize);         // max number of cards to be present in the deck
        assertEquals(numberOfSpadeCards,maxSpadesInDeck);        // max number of spade suited cards to be present in the deck
        assertEquals(numberOfHeartCards,maxHeartInDeck);         // max number of heart suited cards to be present in the deck
        assertEquals(numberOfDimondCards,maxDimondInDeck);      // max number of dimond suited cards to be present in the deck
        assertEquals(numberOfClubCards,maxClubsInDeck);          // max number of club suited cards to be present in the deck
        assertEquals(otherCardsFound, 0);
    }

    /**
     * To test the number of hands function
     * when we supply this method to the game.
     * if generates the number of hands to be
     *
     */
    @Test
    void setNumberOfHands() {
        int numberOfHands = 4;
        Game game = new Game(4);
        game.setNumberOfHands(numberOfHands);

        assertEquals(game.listOfHands.size(), numberOfHands);
    }

    /**
     * Test the deal function
     * We check if the number of hands is correct
     * ten we check if each hand is has the right number of cards.
     */
    @Test
    void deal() {
        int numberOfCardsEachHand = 4;
        int numberOfHands = 4;
        Game game = new Game(numberOfCardsEachHand);
        game.createDeck("Standard");
        game.setNumberOfHands(numberOfHands);
        game.deal();

        assertEquals(game.listOfHands.size(), numberOfHands);

        for (Hand eachHand : game.listOfHands) {
            assertEquals(eachHand.showCards().size(), numberOfCardsEachHand);
        }

    }

}