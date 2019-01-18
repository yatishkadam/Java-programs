package homework5;

public class HandTotal12 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal12 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal12(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal12 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal12(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        if (blackJackHelper.checkIfPairs(game.currentHandBeingChecked.showCards())){
            //check for ace or 6 cause of our implementaion
            char dealerShowCard = game.dealer.getFaceUpCard().getRank().getShortName();
            int dealersShownCardRank = blackJackHelper.getDealerColPos(dealerShowCard);
            if (dealersShownCardRank >=7){
                return 2;//hit
            }
            else return 3;//split
        }
        else{
            // only other option is to have a hard hand.
            char dealerShowCard = game.dealer.getFaceUpCard().getRank().getShortName();
            int dealersShownCardRank = blackJackHelper.getDealerColPos(dealerShowCard);
            if (dealersShownCardRank <=3 || dealersShownCardRank >=7){
                return 2;//hit
            }
            return 1;//stand
        }
    }
}
