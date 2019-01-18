package homework5;

import problem2.Hand;

public class HandTotal2 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal2 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal2(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal2 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal2(game);

        return single_instance;
    }
    @Override
    public int handAction() {
        return 3;//split
    }
}
