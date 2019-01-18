package homework5;

import problem2.Card;
import problem2.Game;
import problem2.Hand;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This is a class for Blackjack.
 *
 * @author yatish.kadam
 */
public class BlackjackGame extends Game {
    //Logger
    private static final Logger LOGGER = Logger.getLogger(BlackjackGame.class.getName());

    private static BlackjackGame single_instance = null;
    /**
     * Different states being used
     * the states are being decided on the total of the cards
     * // Split, Hit, Stand, Surrender
     */
    private IState currentState; // the current state.
    private String state;

    /**
     * This is map variable which tells what actions the player can perform and what is the code value associated with it.
     */
    private static Map<String, Integer> playerActionMap = new HashMap<>();
    static {
        playerActionMap.put("Stand", 1);
        playerActionMap.put("Hit", 2);
        playerActionMap.put("Split", 3);
        playerActionMap.put("Surrender", 4);
    }

    // Dealer class
    IDealer dealer;
    // number of hands in each game
    private int numberOfHands;
    List<Hand> listOfHandsInGame;
    Hand currentHandBeingChecked;

    Map<Hand,String> finishedHands = new HashMap<>();
    /**
     * The constructor fo the BlackJackGame when it just used the standards 6 decks for vegas
     * @param numberOfCardInInitHand - number of cards that need to assgined to each of the players at the start
     *                               default will be 2.
     */
    public BlackjackGame(int numberOfCardInInitHand, int numberOfHandsInGame) {
        super(numberOfCardInInitHand = 2);
        dealer = new Dealer(this);
        createDeck("Vegas");
        numberOfHands = numberOfHandsInGame;
        setNumberOfHands(numberOfHands);
        deck.shuffle();
        deal();
        this.listOfHandsInGame = this.listOfHands;
    }

    /**
     * The constructor fo the BlackJackGame in case the user wants to create more number of vegas decks
     * @param numberOfCardInInitHand - number of cards that need to assgined to each of the players at the start
     *                               default will be 2.
     */
    public BlackjackGame(int numberOfCardInInitHand, int numberOfHandsInGame, int numberOdDecks) {
        super(2);
        dealer = new Dealer(this);
        createDeck("Vegas",numberOdDecks);
        numberOfHands = numberOfHandsInGame;
        setNumberOfHands(numberOfHands);
        deck.shuffle();
        this.listOfHandsInGame = this.listOfHands;
    }


    public static BlackjackGame getInstance(int numberOfCardInInitHand, int numberOfHandsInGame){
        if (single_instance == null)
            single_instance = new BlackjackGame(numberOfCardInInitHand,numberOfHandsInGame);

        return single_instance;
    }

    /**
     * this function removes the hand from the current list of hands.
     */
    private void removeHand(){
        this.listOfHandsInGame.remove(0);
    }

    /**
     * This is the deal function which is overridden from the game class.
     */
    @Override
    public void deal(){
        if ( numberOfHands == 0) {
            LOGGER.info("There needs to be more than 0 Players");
        } else {
            //Give cards to dealer
            Card dealerCard1 = dealCard();
            Card dealerCard2 = dealCard();
            dealer.accept(dealerCard1);
            dealer.setFaceUpCard(dealerCard1);
            dealer.accept(dealerCard2);
            //Create hands
            super.deal();
        }
        printAllHands();
    }


    /**
     * This function is used to deal a card.
     * it returns a single card from the deck.
     * @return - Card - returns a card which is pulled from the deck.
     */
    public Card dealCard(){
        return this.deck.pullCard();
    }

    /**
     * This will be used to change the current state of the hand
     */
    void changeCurrentState(){
        BlackJackHelper blackJackHelper = new BlackJackHelper();
        int cardTotal = blackJackHelper.checkCardListTotal(this.currentHandBeingChecked.showCards());
        if (cardTotal > 21){
            state = "homework5.HandTotalBust";
        }
        else {
            state = "homework5."+"HandTotal" + cardTotal;
        }
        try {
            Method instance = Class.forName(state).getMethod("getInstance", BlackjackGame.class);
            instance.setAccessible(true);
            this.currentState = (IState) instance.invoke(null, this);
            state = Integer.toString(cardTotal);
        } catch (Exception e) {
            LOGGER.info(e.toString());
        }
    }

    /**
     * This is used to check the hand and set the state of current play going on
     */
    public void checkHands(){
        while (!this.listOfHandsInGame.isEmpty()){
            currentHandBeingChecked = this.listOfHandsInGame.get(0);
            changeCurrentState();
            dealTohand();
            removeHand();
        }
    }

    /**
     * This function is used to deal with the dealers condtion.
     */
    public void checkDealer(){
        dealer.checkDealerAction();
    }

    /**
     * This is function which changes the state accordingly to run the actions based on the current hand.
     */
    private void dealTohand(){
        int decision = currentState.handAction();
        if (decision  == 1){
            this.finishedHands.put(this.currentHandBeingChecked,state);
        }
        while (decision !=1){
            changeCurrentState();
            decision = currentState.handAction();
            if(decision==2){
                this.currentHandBeingChecked.accept(this.dealCard());
            }
            if (decision == 1){
                this.finishedHands.put(this.currentHandBeingChecked,state);
            }
            if (decision == 3){
                PairIHand.pairHandDecision(this);
            }
            if (decision == 4 || decision == -1){
                decision = 1;
            }
        }

    }

    /**
     * used to print out the wins and loses
     */
    public void checkRewards(){
        printDealersCard();
        for(Map.Entry<Hand,String> entry:this.finishedHands.entrySet()) {
            String stateTotal = entry.getValue();
            int total = Integer.parseInt(stateTotal);
            printHandCard(entry.getKey());
            LOGGER.info("Your Total \t"+ total);
            if (total < dealer.getDealerHandTotal() && dealer.getDealerHandTotal() <=21){
                LOGGER.info("Lose");
            }
            else if (total == dealer.getDealerHandTotal()){
                LOGGER.info("push");
            }
            else{
                LOGGER.info("You win!!!!!!!!!!!! you get 1$");

            }
        }
    }


    /**
     * used to print the dealers cards
     */
    public void printDealersCard(){
        String dealerCards = "Dealer: ";
        for (Card card:this.dealer.showCards()) {
            dealerCards = dealerCards+card.getRank().getName();
        }
        LOGGER.info(Integer.toString(dealer.getDealerHandTotal()));
        LOGGER.info(dealerCards);
    }

    /**
     * used to print individual hands
     * @param hand
     */
    public void printHandCard(Hand hand){
        String cards = "";
        for (Card card:hand.showCards()) {
            cards = cards+ card.getRank().getName();
        }
        LOGGER.info(cards);
    }

    /**
     * used for printing all the hands present in the game
     */
    void printAllHands(){
        for (Hand hand:super.listOfHands) {
            LOGGER.info("__________________________________________________________________________________________");
            printHandCard(hand);
        }
    }

    /**
     * used for testing purpose
     * @return
     */
    String getCurrentState(){
        return this.state;
    }
}
