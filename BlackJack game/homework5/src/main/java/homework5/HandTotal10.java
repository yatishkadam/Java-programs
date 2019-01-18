package homework5;

public class HandTotal10 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal10 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal10(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal10 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal10(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        if(blackJackHelper.checkIfSoftHand(game.currentHandBeingChecked.showCards())){
            return 1;//stand
        }
        return 2;//hit
    }
}
