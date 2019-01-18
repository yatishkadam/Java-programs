package homework5;

public class HandTotal9 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal9 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal9(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal9 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal9(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        if(blackJackHelper.checkIfSoftHand(game.currentHandBeingChecked.showCards())){
            return 1;//stand
        }
        else{
            // only other option is to have a hard hand.
            return 2;//hit
        }
    }
}
