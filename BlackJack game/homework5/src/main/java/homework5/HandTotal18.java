package homework5;

public class HandTotal18 implements IState {
    // static variable single_instance of type Singleton
    private static HandTotal18 single_instance = null;
    BlackjackGame game; // Blackjack game isntance

    /**
     * Constructor for the state
     * @param game- it recieves the game instance
     */
    private HandTotal18(BlackjackGame game){
        this.game = game;
    }

    // static method to create instance of Singleton class
    public static HandTotal18 getInstance(BlackjackGame game)
    {
        if (single_instance == null)
            single_instance = new HandTotal18(game);

        return single_instance;
    }


    @Override
    public int handAction() {
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        char dealerShowCard = game.dealer.getFaceUpCard().getRank().getShortName();
        int dealersShownCardRank = blackJackHelper.getDealerColPos(dealerShowCard);
        if (blackJackHelper.checkIfPairs(game.currentHandBeingChecked.showCards())){
            if (dealersShownCardRank ==7 || dealersShownCardRank==10 || dealersShownCardRank==11){
                return 1;//stand
            }
            else return 3;//split
        }
        else if(blackJackHelper.checkIfSoftHand(game.currentHandBeingChecked.showCards())){
            if (dealersShownCardRank <= 8){
                return 1;//stand
            }
            return 2;//hit
        }
        else{
            // only other option is to have a hard hand.
            return 1;//stand

        }
    }
}
