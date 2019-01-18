package homework5;

public class HandTotal15 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal15 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal15(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal15 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal15(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        // only other option is to have a hard hand.
        char dealerShowCard = game.dealer.getFaceUpCard().getRank().getShortName();
        int dealersShownCardRank = blackJackHelper.getDealerColPos(dealerShowCard);
        if(blackJackHelper.checkIfSoftHand(game.currentHandBeingChecked.showCards())){
            return 2;//hit
        }
        else if (dealersShownCardRank >=7){
            if(dealersShownCardRank!=10){
                return 2;//hit
            }
            return 4;//surrender
        }
        return 1;//stand
    }
}
