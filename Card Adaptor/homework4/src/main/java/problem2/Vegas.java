package problem2;

import java.util.HashMap;
import java.util.Map;

/**
 * This Class is to represent a Vegas deck
 *
 * @author yatish
 */
public class Vegas extends Deck {

    /**
     * This is a hard map variable which tells what kind of cards are present in this deck type.
     */
    private static Map<Character, Integer> deckCards = new HashMap<Character, Integer>();
    static {
        deckCards.put('2',5);
        deckCards.put('3',9);
        deckCards.put('4',13);
        deckCards.put('5',4);
        deckCards.put('6',8);
        deckCards.put('7',12);
        deckCards.put('8',3);
        deckCards.put('9',7);
        deckCards.put('T',11);
        deckCards.put('J',2);
        deckCards.put('Q',6);
        deckCards.put('K',10);
        deckCards.put('A',1);
    }

    /**
     * Constructor for the Vegas deck
     */
    Vegas(int numberOfDecks){
        for (int i = 0; i< numberOfDecks; i++){
            createDeck();
        }
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
