package homework5;

/**
 * You can simulate a black jack game using this program
 */
public class BlackJackGameSimulation {

    public static void main(String[] args){
        BlackjackGame game= BlackjackGame.getInstance(0,3);
        game.checkHands();
        game.checkDealer();
        game.checkRewards();
    }
}
