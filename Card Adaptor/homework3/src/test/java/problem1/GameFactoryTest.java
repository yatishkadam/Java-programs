package problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * To test the game factory method.
 *
 * @author yatish
 */
class GameFactoryTest {

    /**
     * Declarations of constants
     */
    private int numberOfHands =3;                       //number of hands in the game
    private int numberOfCardsEachHand = 3;              //number of cards in each hand


    /**
     * this is used to test the creation of the whole game
     * as we have already tested out the game class
     * we need to test out if the returned type has the correct over all variables and methods.
     */
    @Test
    void createGame(){
        String deckTypeStandard = "Standard";       //deck for standard

        Game game = GameFactory.createGame(deckTypeStandard,numberOfHands,numberOfCardsEachHand);
        assertEquals(game.listOfHands.size(), numberOfHands);

        for (Hand hand: game.listOfHands) {
            assertEquals(hand.showCards().size(), numberOfCardsEachHand);
        }
    }

    /**
     * this is used to test the creation of the whole game when the number of decks is passed as a parameter.
     * as we have already tested out the game class
     * we need to test out if the returned type has the correct over all variables and methods.
     */
    @Test
    void createGameNOD(){

        String deckTypeVegas = "Vegas";             //deck for vegas
        int numberOFDecks = 6;                      //number of decks for vegas

        Game game = GameFactory.createGame(deckTypeVegas, numberOFDecks, numberOfHands, numberOfCardsEachHand);
        assertEquals(game.listOfHands.size(), numberOfHands);

        for (Hand hand: game.listOfHands) {
            assertEquals(hand.showCards().size(), numberOfCardsEachHand);
        }
    }

}