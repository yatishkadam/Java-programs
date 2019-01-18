package problem1;

import java.util.List;
import java.util.NoSuchElementException;

public class HandIterator {
    private int presentIndex;
    private List<Card> hand;

    HandIterator(List<Card> presentHand){
        presentIndex = 0;
        hand = presentHand;
    }


    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    public boolean hasNext() {
        if (presentIndex < hand.size()){
            return true;
        }
        return false;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    public Card next() throws NoSuchElementException {
        if (hasNext()){
            return hand.get(presentIndex++);
        }
        return null;
    }

}
