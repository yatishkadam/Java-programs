package homework5;

public class HandTotal4 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal4 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal4(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal4 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal4(game);

        return single_instance;
    }
    @Override
    public int handAction() {
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        if (blackJackHelper.checkIfPairs(game.currentHandBeingChecked.showCards())){
            char dealerShowCard = game.dealer.getFaceUpCard().getRank().getShortName();
            int dealersShownCardRank = blackJackHelper.getDealerColPos(dealerShowCard);
            if (dealersShownCardRank >=8){
                return 2;//hit
            }
            else return 3;//split
        }
        return 2;//hit
    }
}
