package homework5;

import problem2.Hand;

public class HandTotal3 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal3 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal3(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal3 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal3(game);

        return single_instance;
    }
    @Override
    public int handAction() {
        //Because we know it will always be a of Ace and a two that will give a state 3
        // so we check return soft Hand Decision here
        return 2;//hit
    }
}
