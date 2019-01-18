package homework5;

public class HandTotal20 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal20 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal20(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal20 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal20(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        return 1;
    }
}
