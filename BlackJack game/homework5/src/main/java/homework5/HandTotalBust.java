package homework5;

public class HandTotalBust implements IState {
    // static variable single_instance of type Singleton
    private static HandTotalBust single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotalBust(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotalBust getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotalBust(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        return -1;//bust
    }

}
