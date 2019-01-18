package homework5;

public class HandTotal11 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal11 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal11(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal11 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal11(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        // only other option is to have a hard hand.
        return 2;//hit
    }
}
