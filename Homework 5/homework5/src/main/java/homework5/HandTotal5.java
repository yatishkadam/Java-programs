package homework5;

public class HandTotal5 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal5 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal5(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal5 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal5(game);

        return single_instance;
    }
    @Override
    public int handAction() {
        return 2;//hit
    }
}
