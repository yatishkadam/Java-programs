package homework5;

public class HandTotal17 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal17 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal17(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal17 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal17(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        if(blackJackHelper.checkIfSoftHand(game.currentHandBeingChecked.showCards())){
            return 2;//hit
        }
        // only other option is to have a hard hand.
        return 1;//stand
    }
}
