package homework5;

import problem2.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the decision making class which is used to decide everything that happens in the game.
 *
 * @author yatish
 */
public class BlackJackHelper {
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

    /**
     * This is a hard map variable which tells what kind of cards are present in this deck type.
     */
    private static Map<Character, Integer> dealerColPosition = new HashMap<Character, Integer>();
    static {
        dealerColPosition.put('2',2);
        dealerColPosition.put('3',3);
        dealerColPosition.put('4',4);
        dealerColPosition.put('5',5);
        dealerColPosition.put('6',6);
        dealerColPosition.put('7',7);
        dealerColPosition.put('8',8);
        dealerColPosition.put('9',9);
        dealerColPosition.put('T',10);
        dealerColPosition.put('J',10);
        dealerColPosition.put('Q',10);
        dealerColPosition.put('K',10);
        dealerColPosition.put('A',11);
    }

    public int getDealerColPos(char cardChar){
        return dealerColPosition.get(cardChar);
    }

    /**
     * this is used to return the rank of the card which is not an ace
     * @param listOfCards - list of cards
     * @return - int - the pip value of the card which is not the ace
     */
    private int getSoftTotal(List<Card> listOfCards){
        for(int index = 0; index < listOfCards.size(); index++) {
            Card c = listOfCards.get(index);
            if(c.getRank().getShortName() != 'A'){
                return c.getRank().getPips();
            }
        }
        return 0;
    }

    /**
     * This function is used to get the total of card list that is sent
     * @param cardList - a list of cards
     * @return - int - returns a total
     */
    public int checkCardListTotal(List<Card> cardList){
        int presentCount = 0;
        boolean ace = false;
        int aceCount = 0;
        for (int index = 0; index < cardList.size();index++){
            Card card = cardList.get(index);
            if (card.getRank().getShortName() == 'A'){
                aceCount+=1;
                ace =true;
            }
            presentCount += card.getRank().getPips();
        }
        if (ace){
            while (aceCount >0){
                presentCount += getAceValue(presentCount);
                aceCount--;
            }
        }
        return presentCount;
    }


    /**
     * This fucntion checks and returns the value that can be used for ace.
     * @param presentCount - the present count
     * @return - int - a possible value for ace
     */
    private int getAceValue(int presentCount){
        if (presentCount+11 <= 21){
            return 11;
        }
        return 1;
    }

    /**
     * This function is used to check if there are pairs in the hand
     * @param hand - List of cards
     * @return - Boolean - True when there is a pair
     */
    public Boolean checkIfPairs(List<Card> hand){
        Card card1 = hand.get(0);
        Card card2 = hand.get(1);
        if (card1.getRank().getPips() == card2.getRank().getPips() && hand.size() < 3){
            return true;
        }
        return false;
    }

    /**
     * This function is used to check if there is an ace present in the deck.
     * @param hand - a list of cards
     * @return - Boolean - true if there is an Ace present
     */
    public Boolean checkIfSoftHand(List<Card> hand){
        Card card1 = hand.get(0);
        Card card2 = hand.get(1);
        if ((card1.getRank().getShortName() == 'A' || card2.getRank().getShortName() == 'A') && hand.size() < 3){
            return true;
        }
        return false;
    }
}
