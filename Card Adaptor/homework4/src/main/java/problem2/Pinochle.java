package problem2;

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
        deckCards.put('9',7);
        deckCards.put('T',11);
        deckCards.put('J',2);
        deckCards.put('Q',6);
        deckCards.put('K',10);
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
                Card card = new CardAdaptor(item.getKey(),item.getValue(),suit);
                deckOfCards.add(card);
            }
        }
    }
}
