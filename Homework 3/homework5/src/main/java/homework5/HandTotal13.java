package homework5;

public class HandTotal13 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal13 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal13(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal13 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal13(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        if(blackJackHelper.checkIfSoftHand(game.currentHandBeingChecked.showCards())){
            return 2;//hit
        }
        // only other option is to have a hard hand.
        char dealerShowCard = game.dealer.getFaceUpCard().getRank().getShortName();
        int dealersShownCardRank = blackJackHelper.getDealerColPos(dealerShowCard);
        if (dealersShownCardRank >=7){
            return 2;//hit
        }
        return 1;//stand
    }
}
