package homework5;

public class HandTotal19 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal19 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal19(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal19 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal19(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        return 1;//stand

    }
}
