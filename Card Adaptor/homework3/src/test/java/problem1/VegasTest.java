package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VegasTest {
    /**
     * Unicode character declaration for the different suits.
     */
    private static final  char SPADES ='\u2660';        // Spades suit
    private static final  char HEART = '\u2665';        // Heart suit
    private static final  char DIMOND = '\u2666';       // Dimond suit
    private static final  char CLUB = '\u2663';         // Club suit

    // number of vegas decks to create
    // you can change this and the tests should still run the same.
    private int numberOFVegasDeck = 6;

    private Deck deck;
    private List<Card> cardsInDeck;
    private int vegasDeckSize = 52 * numberOFVegasDeck;
    private int maxSpadesInDeck = 13* numberOFVegasDeck;
    private int maxHeartInDeck = 13* numberOFVegasDeck;
    private int maxClubsInDeck = 13* numberOFVegasDeck;
    private int maxDimondInDeck = 13* numberOFVegasDeck;
    private int maxSameSuitCards = 13* numberOFVegasDeck;
    private int maxNumberOfSameRank = 4* numberOFVegasDeck;

    private int maxNumberOfSameSuitedRank = numberOFVegasDeck;

    /**
     * to create a deck
     */
    @BeforeEach
    void initEuchreDeck(){
        deck = new Vegas(numberOFVegasDeck);
        cardsInDeck = deck.getCards();
    }


    /**
     * this is a test for the constructor. we check if the created deck is the right one.
     * thinking ->
     *              the deck created should have the standard size.
     *              it should have the standard number of cards in each suit.
     *              there shouldnt be any suits apart from the standard defined suits.
     */
    @Test
    void createDeck() {
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
        assertEquals(cardsInDeck.size(),vegasDeckSize);         // max number of cards to be present in the deck
        assertEquals(numberOfSpadeCards,maxSpadesInDeck);        // max number of spade suited cards to be present in the deck
        assertEquals(numberOfHeartCards,maxHeartInDeck);         // max number of heart suited cards to be present in the deck
        assertEquals(numberOfDimondCards,maxDimondInDeck);      // max number of dimond suited cards to be present in the deck
        assertEquals(numberOfClubCards,maxClubsInDeck);          // max number of club suited cards to be present in the deck
        assertEquals(otherCardsFound, 0);                 // If another card suit is found.

        // To check if the cards have the correct number of ranks we can use the sort function defined below.
        // As in an untouched deck there has to a standard number of cards that need to be present.
        // so the sort frunction defined below also checks for this condition.
        this.sortByRank();


        //Check if the cards created are unique
        // we check the number of times it occurs
        Map<String,Integer> mapOfCards = new HashMap<String, Integer>();

        for (Card card: cardsInDeck) {
            String nameOfCard = card.getRank().getName(); // unique identifier shortName + Suite    eg 2S - > 2 and spades
            if (mapOfCards.get(nameOfCard) != null){
                mapOfCards.put(nameOfCard, (mapOfCards.get(nameOfCard) + 1) );
            }
            else{
                mapOfCards.put(nameOfCard,1);
            }
        }

        // check if the values are equal to the max number of occurances

        for(Map.Entry<String, Integer> entry: mapOfCards.entrySet()) {
            int val = entry.getValue();
           assertEquals(val, maxNumberOfSameSuitedRank);
        }
    }

    /**
     * this test method checks if the deck created is of the standard size.
     */
    @Test
    void officialSize() {
        assertEquals(deck.officialSize(), vegasDeckSize);
    }


    /**
     * this tests the getCards method
     * thinking ->
     *             check if the returned type is of a List instance.
     *             then individually check if each of the returned list elements is an instance of a card.
     */
    @Test
    void getCards() {
        assertTrue(deck.getCards() instanceof List<?>);
        for (Card card:deck.getCards()) {
            assertTrue(card instanceof Card);
        }
    }

    /**
     * this tests the shuffle method for a deck
     * Thinking ->
     *            make two copies of the deck.
     *            check first if they are same.( Which will be true).
     *            shuffle the deck using the shuffle method.
     *            check if they are not the same. ( checking if they are the same will throw an error cause they wont be of the same order)
     */
    @Test
    void shuffle() {
        List<Card> unshuffledListOfCards = new ArrayList<Card>(cardsInDeck);
        assertEquals(unshuffledListOfCards,deck.getCards());
        deck.shuffle();
        assertNotEquals(unshuffledListOfCards,deck.getCards());
    }

    /**
     * This tests the sort by suit option for sort.
     * Thinking ->
     *           the standard euchre deck has 24 cards with each suit having the exact 6 cards.
     *           we look through the sorted deck check the suits at position 0 with the next 5 cards. (They have to match!)
     *                                                                       6 with the next 5 cards. and so on.
     *           end of the test the suits will be sorted.
     */
    @Test
    void sortBySuit() {
        //Sorting by suit
        deck.sort("Suit");
        List<Card> sortedListOfCards = new ArrayList<Card>(deck.getCards());
        int i = 0;
        while(i< vegasDeckSize){
            char suitToCheckAgainst = sortedListOfCards.get(i).getSuit().getSymbol();
            i++;
            for (int j = i;j< i+ (maxSameSuitCards-1) ;j++){
                assertEquals(suitToCheckAgainst,sortedListOfCards.get(j).getSuit().getSymbol());
            }
            i+= (maxSameSuitCards-1);
        }
    }

    /**
     * Test to check the sort by rank feature. of the deck.
     * Thinking->
     *              when sorted by rank on the original deck the cards have to be of the same sorted order.
     *              we can check against a list we define of how the sorted order should be and we check against it.
     *              eg:-
     *                  for this deck the first rank should be Ace.
     *                  we check if this is true. the first 4 cards should be this rank. meaning all 4 should be Aces.
     */
    @Test
    void sortByRank(){
        List<Character> orderToBeSortedBy = new ArrayList<Character>();
        orderToBeSortedBy.add('A');
        orderToBeSortedBy.add('2');
        orderToBeSortedBy.add('3');
        orderToBeSortedBy.add('4');
        orderToBeSortedBy.add('5');
        orderToBeSortedBy.add('6');
        orderToBeSortedBy.add('7');
        orderToBeSortedBy.add('8');
        orderToBeSortedBy.add('9');
        orderToBeSortedBy.add('T');
        orderToBeSortedBy.add('J');
        orderToBeSortedBy.add('Q');
        orderToBeSortedBy.add('K');

        //Sorting by Rank
        deck.sort("Rank");

        List<Card> sortedListOfCards = new ArrayList<Card>(deck.getCards());
        int actualIndex = 0;
        int checkCharIndex = 0;
        while (actualIndex < vegasDeckSize){
            char rankToCheckAgainst = orderToBeSortedBy.get(checkCharIndex);
            for (int j = actualIndex; j < actualIndex+maxNumberOfSameRank ; j++){
                assertEquals(rankToCheckAgainst, sortedListOfCards.get(j).getRank().getShortName());
            }
            actualIndex +=maxNumberOfSameRank;
            checkCharIndex +=1;
        }
    }

    @Test
    void sortByBoth(){
        deck.sort("Both");
        List<Card> sortedListOfCards = new ArrayList<Card>(deck.getCards());


        List<Character> orderToBeSortedBy = new ArrayList<Character>();
        orderToBeSortedBy.add('A');
        orderToBeSortedBy.add('2');
        orderToBeSortedBy.add('3');
        orderToBeSortedBy.add('4');
        orderToBeSortedBy.add('5');
        orderToBeSortedBy.add('6');
        orderToBeSortedBy.add('7');
        orderToBeSortedBy.add('8');
        orderToBeSortedBy.add('9');
        orderToBeSortedBy.add('T');
        orderToBeSortedBy.add('J');
        orderToBeSortedBy.add('Q');
        orderToBeSortedBy.add('K');

        List<Character> suitOrder = new ArrayList<Character>();
        suitOrder.add(SPADES);
        suitOrder.add(DIMOND);
        suitOrder.add(HEART);
        suitOrder.add(CLUB);

        int i =0;
        int suitIndex = 0;
        char shortName;
        char suitOfCard;
        char cardOrderToCheck;
        while ( i < vegasDeckSize){
            int indexOfOrder =0;
            char suitToCheck = suitOrder.get(suitIndex);
            for (int j = i ; j < i + maxSameSuitCards;j+= maxNumberOfSameSuitedRank){
                int k=j;

                //internally checking if the rank is ordered ->
                // meaning if 2 decks are present then there should be two cards of the same suit and rank.
                while (k < j+maxNumberOfSameSuitedRank){
                    shortName = sortedListOfCards.get(j).getRank().getShortName();
                    suitOfCard = sortedListOfCards.get(j).getSuit().getSymbol();
                    cardOrderToCheck = orderToBeSortedBy.get(indexOfOrder);

                    assertEquals(suitOfCard, suitToCheck);//check if its of the same suit
                    assertEquals(shortName, cardOrderToCheck);//check if its of the same order
                    k+=1;
                }
                indexOfOrder +=1;
            }
            i+=maxSameSuitCards;
            suitIndex +=1;
        }
    }

    /**
     * this tests the cut method for a deck
     * thinking ->
     *             the deck when cut( at cutpoint) should be different from the original deck.
     *             if the deck is cut again at (sizeOfDeck - cutpoint) it should be the same as the original deck.
     *              eg ;-
     *                      deck ->  AS , 2S, 3S, 4S, 5S, 6S
     *                      cutpoint -> 2
     *                      after cut ->
     *                              3S, 4S, 5S ,6S, AS, 2S
     *                      cutpoint - size (6) - ocutpoint( 2) = 4
     *                      after cut ->
     *                              AS , 2S, 3S, 4S, 5S, 6S
     *                      which is same as the original deck.
     *
     *             make a copy of the orginal deck.
     *             cut the deck.
     *             compare the decks. (will not be the same)
     *
     *             now if we cut the deck again at point (sizeOfDeck - cutpoint)
     *             the deck should go back to the original order.
     *
     */
    @Test
    void cut() {
        List<Card> oListOfCards = new ArrayList<Card>(deck.getCards());

        assertEquals(oListOfCards, deck.getCards());
        int cutPoint = 3;
        deck.cut(cutPoint);
        assertNotEquals(oListOfCards, deck.getCards());

        deck.cut(deck.officialSize() - cutPoint);
        assertEquals(oListOfCards, deck.getCards());
    }

    /**
     * to test the pull card feature of a deck.
     *
     * thinking ->
     *           once a card is pulled .the deck should not contain that card anymore.
     *           in case its made up of more decks. the number of times it occurs should be decreased by 1.
     */
    @Test
    void pullCard() {
        Card cardPulled = deck.getCards().get(0);
        String cardNamePulled = cardPulled.getSuit().getName();
        deck.pullCard();

        // Check if the cards created are unique
        // we check the number of times it occurs
        Map<String,Integer> mapOfCards = new HashMap<String, Integer>();

        for (Card card: cardsInDeck) {
            String nameOfCard = card.getRank().getName(); // unique identifier shortName + Suite    eg 2S - > 2 and spades
            if (mapOfCards.get(nameOfCard) != null){
                mapOfCards.put(nameOfCard, (mapOfCards.get(nameOfCard) + 1) );
            }
            else{
                mapOfCards.put(nameOfCard,1);
            }
        }

        // Now that the card has been pulled the card should have a count of one as the card occurs (1 * decks -1) times.
        // So the hash Map value returned will be one less than the number of decks.
        int valueToCheck = mapOfCards.get(cardNamePulled);
        assertEquals(valueToCheck, (numberOFVegasDeck - 1));

        assertEquals(deck.getCards().size(), (vegasDeckSize -1)); // check if the deck size shrank by 1
    }

    /**
     * To test the emptyDeck method of a deck
     * pull out all the remaining cards in the deck
     * check if it is empty
     */
    @Test
    void emptyDeck() {
        assertFalse(deck.emptyDeck()); // check if a deck is indeed not empty.

        while (!deck.getCards().isEmpty()){
            deck.pullCard();
        }

        assertTrue(deck.emptyDeck()); // check if a deck is indeed empty.
    }


}