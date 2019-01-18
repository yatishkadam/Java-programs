package homework5;

import problem2.CardInterface;

/**
 * Simulate a game
 * This will simulate a game
 *
 * @author yatish.kadam
 */
public class GamePlay {
    public static void main(String args []){
        //these are the squence you need to call in.
        BlackjackGame game = new BlackjackGame(2,10);
        game.checkHands();
        game.checkDealer();
        game.checkRewards();
    }
}
