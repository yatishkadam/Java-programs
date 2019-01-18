package problem2;


/**
 * This is a Game factory method which is used to create a game.
 *
 * @author yatish
 */
public class GameFactory {

    /**
     * A private constuctor does nothing
     */
     protected GameFactory(){}

    /**
     * This is to create the game. when you create
     * @param deckType - - String - "Vegas", "Standard", "Pinochle", or "Euchre"
     * @param numberOfHands - int - the number of hands for the game.
     * @param numberOfCardsEachHand - int - the number cards each hand will get
     * @return - Game - returns a game which has been initialized and the cards are delt to the hands.
     */
    public static Game createGame(String deckType, int numberOfHands, int numberOfCardsEachHand){
        Game game = new Game(numberOfCardsEachHand);
        game.createDeck(deckType);
        game.setNumberOfHands(numberOfHands);
        game.deal();
        return game;
    }

    /**
     * This is to create the game. when you create
     * @param deckType - - String - "Vegas", "Standard", "Pinochle", or "Euchre"
     * @param numberOfDecks -  int - number of standard decks the vegas deck will contain.
     * @param numberOfHands - int - the number of hands for the game.
     * @param numberOfCardsEachHand - int - the number cards each hand will get
     * @return - Game - returns a game which has been initialized and the cards are delt to the hands.
     */
    public static Game createGame(String deckType, int numberOfDecks,  int numberOfHands, int numberOfCardsEachHand){
        Game game = new Game(numberOfCardsEachHand);
        game.createDeck(deckType, numberOfDecks);
        game.setNumberOfHands(numberOfHands);
        game.deal();
        return game;
    }
}