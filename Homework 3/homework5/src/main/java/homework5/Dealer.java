package homework5;

import problem2.CardInterface;
import problem2.Hand;

import java.util.HashMap;
import java.util.Map;

public class Dealer extends Hand implements IDealer {

    /**
     * This is map variable which tells what actions the dealer can perform and what is the code value associated with it.
     */
    private static Map<String, Integer> dealerActionMap = new HashMap<>();
    static {
        dealerActionMap.put("Stand", 1);
        dealerActionMap.put("Hit", 2);
    }

    /**
     * Constant value declaration
     */
    private BlackjackGame game;
    private int dealerHandTotal;
    private CardInterface faceUpCard;


    /**
     * Constructor for the dealer
     * @param game - the Blackjack game instance
     */
    public Dealer(BlackjackGame game){
        super();
        this.game = game;
    }

    /**
     * this sets up the face card of the dealer
     * @param card- the card which will be shown to all.
     */
    public void setFaceUpCard(CardInterface card){
        this.faceUpCard = card;
    }

    /**
     * this returns the face card of the dealer
     * @return - CardInterface - returns the face cards of the dealer.
     */
    public CardInterface getFaceUpCard(){
        return this.faceUpCard;
    }


    /**
     * this checks the dealers hand and calculates the value for the dealer.
     */
    public void checkDealerAction(){
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        int dealerTotal = blackJackHelper.checkCardListTotal(this.showCards());
        this.dealerHandTotal = dealerTotal;
        if (this.dealerHandTotal >= 17 && this.dealerHandTotal <= 21){
            this.dealerHandTotal = dealerTotal;
            return;
        }
        while (this.dealerHandTotal<17){
            this.accept(this.game.dealCard());
            this.dealerHandTotal = blackJackHelper.checkCardListTotal(this.showCards());
        }
        this.dealerHandTotal = blackJackHelper.checkCardListTotal(this.showCards());
    }

    /**
     * this fucntion is used to return the dealers hand total.
     * @return - int - the final dealer total.
     */
    public int getDealerHandTotal(){
        return dealerHandTotal;
    }
}
