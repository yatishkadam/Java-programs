package homework5;

import problem2.Hand;

/**
 * This is the state where the hand is pair
 * it checks if it needs to split or hit a card and changes the state to hard.
 * we add the split hand to the hand list where it will be worked upon later in the list.
 * if it decides to stand the hand is added to the finalised hand which will be used to cal the rewards.
 *
 * @author yatish
 */
class PairIHand {
    //private constuctor
    private PairIHand(){}
    static int pairHandDecision(BlackjackGame game){
        Hand hand1 = new Hand();
        hand1.accept(game.currentHandBeingChecked.showCards().get(0));
        Hand hand2 = new Hand();
        hand2.accept(game.currentHandBeingChecked.showCards().get(0));
        hand1.accept(game.dealCard());
        hand2.accept(game.dealCard());
        game.currentHandBeingChecked = hand1;
        game.listOfHandsInGame.add(hand2);
        return 3;
    }
}
