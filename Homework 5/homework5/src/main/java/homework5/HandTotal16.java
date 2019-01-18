package homework5;

public class HandTotal16 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal16 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal16(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal16 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal16(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        if (blackJackHelper.checkIfPairs(game.currentHandBeingChecked.showCards())){
            return 3;//split
        }
        else if(blackJackHelper.checkIfSoftHand(game.currentHandBeingChecked.showCards())){
            return 2;//hit
        }
        else{
            // only other option is to have a hard hand.
            char dealerShowCard = game.dealer.getFaceUpCard().getRank().getShortName();
            int dealersShownCardRank = blackJackHelper.getDealerColPos(dealerShowCard);
            if (dealersShownCardRank >=7){
                if(dealersShownCardRank==7 || dealersShownCardRank==8){
                    return 2;//hit
                }
                return 4;//surrender
            }
            return 1;//stand
        }
    }
}
