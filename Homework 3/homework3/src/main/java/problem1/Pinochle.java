package problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * This Class is to represent a Pinochle deck
 *
 * @author yatish
 */
public class Pinochle extends Deck {

    /**
     * This is a hard map variable which tells what kind of cards are present in this deck type.
     */
    private static Map<Character, Integer> deckCards = new HashMap<Character, Integer>();
    static {
        deckCards.put('9',9);
        deckCards.put('T',10);
        deckCards.put('J',0);
        deckCards.put('Q',0);
        deckCards.put('K',0);
        deckCards.put('A',1);
    }


    /**
     * Constructor for the Pinochle deck
     */
    Pinochle(){
       createDeck();
       createDeck();
        this.originalSizeOfDeck = this.deckOfCards.size();
    }

    /**
     * Function to create a deck.
     */
    @Override
    public void createDeck(){
        for (char suit:standardSuits) {
            for (Map.Entry<Character, Integer> item:deckCards.entrySet()) {
                Card card = new Card(item.getKey(),item.getValue(),suit);
                deckOfCards.add(card);
            }
        }
    }
}
