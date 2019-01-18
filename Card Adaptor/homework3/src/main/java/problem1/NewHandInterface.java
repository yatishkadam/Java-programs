package problem1;

public interface NewHandInterface extends HandInterface {

    Boolean hasCard(Card cardToFind);
    int occurrencesInHand(Card cardToFind);
    int occurrencesInHand(Rank rankToFind);
}
