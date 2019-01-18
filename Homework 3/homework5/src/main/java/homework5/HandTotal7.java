package homework5;

public class HandTotal7 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal7 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal7(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal7 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal7(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        return 2;//hit
    }
}
