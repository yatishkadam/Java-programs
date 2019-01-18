package problem2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CardAdaptor implements Card {
    /**
     * Unicode character declaration for the different suits.
     */
    private static final  char SPADES ='\u2660';        // Spades suit
    private static final  char HEART = '\u2665';        // Heart suit
    private static final  char DIMOND = '\u2666';       // Dimond suit
    private static final  char CLUB = '\u2663';         // Club suit
    /**
     * Suit Values
     * used to give a specific suit to the card.
     * //    xin, tieQiao, zuanShi, juLeBu; // hearts, spades, diamonds, clubs
     * //    the enum values in the ka class. So we map it to the values.
     */
    private static final Map<Integer, Character> suitValues = new HashMap<Integer, Character>();
    static {
        suitValues.put(1, SPADES);
        suitValues.put(0, HEART);
        suitValues.put(2, DIMOND);
        suitValues.put(3, CLUB);
    }

    /**
     * Suit Values
     * used to give a specific suit to the card.
     * //    xin, tieQiao, zuanShi, juLeBu; // hearts, spades, diamonds, clubs
     * //    the enum values in the ka class. So we map it to the values.
     */
    private static final Map<Character, Integer> suitToInt = new HashMap<>();
    static {
        suitToInt.put(SPADES   ,1);
        suitToInt.put(HEART    ,0);
        suitToInt.put(DIMOND   ,2);
        suitToInt.put(CLUB     ,3);
    }

    /**
     * Private face values given to the cards.
     * used to give a specific weightage to the card to tell how the deck should be ordered.
     */
    private static final Map<String, Character> shortNameOfCards = new HashMap<>();
    static {
        shortNameOfCards.put("TWO",    '2');
        shortNameOfCards.put("THREE",  '3');
        shortNameOfCards.put("FOUR",   '4');
        shortNameOfCards.put("FIVE",   '5');
        shortNameOfCards.put("SIX",    '6');
        shortNameOfCards.put("SEVEN",  '7');
        shortNameOfCards.put("EIGHT",  '8');
        shortNameOfCards.put("NINE",   '9');
        shortNameOfCards.put("TEN",    'T');
        shortNameOfCards.put("JACK",   'J');
        shortNameOfCards.put("KING",   'K');
        shortNameOfCards.put("QUEEN",  'Q');
        shortNameOfCards.put("ACE",    'A');
    }

    /**
     * Holds the card instance
     */
    private Ka cardInstance;

    /**
     * Constructor of a CardAdaptor in this constructor it uses the same as the original card constructor parameters
     * it creates a ka instance from this
     * @param shortNameOfCard - char - a character representing a short name for a card eg k-king , A-ace , t- ten, 2 -two
     * @param cardRank - int - the rank of the card
     * @param cardSymbol - char - unicode chara representing the suits-"Spade" or "Dimond" or  "Club" or "Heart"
     */
    public CardAdaptor(char shortNameOfCard,int cardRank,char cardSymbol){
        int suit = suitToInt.get(cardSymbol);
        this.cardInstance = new kaShiXia(getMappedRankToKa(cardRank), suit);
    }

    /**
     *  Constructor of a CardAdaptor in this constructor it uses the KA as the constructor parameters
     *  it creates a ka instance from this
     * @param cardInstance - Ka - a ka Card
     */
    public CardAdaptor(Ka cardInstance){
        this.cardInstance = new kaShiXia(getMappedRankToKa(cardInstance.getRank()), cardInstance.getSuit());
    }

    /**
     * This function returns a Rank object
     * @return - Rank - Rank object which has the Ka's enum values as its pip value
     */
    public Rank getRank(){
        int cardRank = getMappedRankToEnum(cardInstance.getRank()); // geting Ka rank
        char cardName = shortNameOfCards.get(kaShiXia.KaDengJíEnum.lookupEnumName(cardRank).toString());
        String nameOfCard = kaShiXia.KaDengJíEnum.lookupEnumName(cardRank).toString() + Character.toString(getSuit().getSymbol());
        return new Rank(cardName, nameOfCard, cardRank);
    }

    /**
     * this function returns a suit object
     * @return - suit - suit object
     */
    public Suit getSuit(){
        int suit = cardInstance.getSuit(); // getting Ka suit
        int cardRank = getMappedRankToEnum(cardInstance.getRank());
        String enumVal = kaShiXia.KaDengJíEnum.lookupEnumName(cardRank).toString();
        char cardName = shortNameOfCards.get(enumVal);
        return new Suit(Character.toString(cardName),suitValues.get(suit));
    }

    /**
     * Function to print it out as a String
     * @return- String- eg:- 2 of SPADES
     */
    @Override
    public String toString() {
        return getRank().getShortName() + " of " + getSuit().getSymbol();
    }

    public boolean equals(Object object) {
        if (object instanceof Card) {

            CardAdaptor ka = (CardAdaptor) object;
            return (ka.getRank().getPips() == this.getRank().getPips() && ka.getSuit().getSymbol() == this.getSuit().getSymbol());
        } else
            return super.equals(object);
    }

    /**
     * Overriding the hashcode.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getRank().getPips(), this.getSuit().getSymbol());
    }

    /**
     * This function is used to map the rank to the KA rank allowed
     * @param i - int - unmmaped rank value
     * @return - mapped rank value
     */
    private int getMappedRankToKa(int i){
        return i - 1;
    }

    /**
     * This function is used to map the rank to the KaDengJíEnum allows
     * @param i - int - unmmaped rank value
     * @return - mapped rank value
     */
    private int getMappedRankToEnum(int i){
        return i + 1;
    }
}

