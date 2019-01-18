package homework5;

/**
 * this is the interface which is used in the states
 * the states i am deciding based on the total of the cards.
 * hard, soft , pair
 *
 * @author yatish.kadam
 */
public interface IHandDecision {

    /**
     * this fucntion is used to perform certain activitites in each of the state.
     * they range from splitting the hand
     * stand
     * surrender
     * hit
     * All these decisions are done and then the hand is added to a final list.
     * @return - decisions
     */
    int dealAction(BlackjackGame game);
}
