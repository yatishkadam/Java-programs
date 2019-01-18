package problem1;

public class NewHand extends Hand implements NewHandInterface {

    /**
     * Hand constructor
     */
    NewHand(){ super();}

    /**
     * This function is used to find the number of occurrences of a particular card.
     * @param cardToFind - Card - The card to check against.
     * @return - int - the number of times the card occurs in the hand.
     */
    public int occurrencesInHand(Card cardToFind) {
        char presentCardSuit;
        int presentCardRank;
        char suitToFind = cardToFind.getSuit().getSymbol();
        int rankToFind = cardToFind.getRank().getPips();

        int occurrencesCount = 0;

        HandIterator iterator = new HandIterator(this.presentHand);
        while (iterator.hasNext()){
            Card card = iterator.next();
            presentCardSuit = card.getSuit().getSymbol();
            presentCardRank = card.getRank().getPips();

            //Check if the card suit and the rank are same as the card required.
            if ( presentCardSuit == suitToFind && presentCardRank ==  rankToFind) {
                occurrencesCount++;
            }
        }
        return occurrencesCount;
    }


    /**
     * This function is used to find the number of times a rank occurs in the hand.
     * @param rankToFind - Rank - the rank to be found
     * @return - int - the number of times the rank occurs in the hand.
     */
    public int occurrencesInHand(Rank rankToFind) {
       int rankToCheck = rankToFind.getPips();
       char shortNameToCheck = rankToFind.getShortName();

       int rankOfPresentCard;
       char shortNameOfPresentCard;

        int occurrencesCount = 0;
        HandIterator iterator = new HandIterator(this.presentHand);
        while (iterator.hasNext()){
            Card card = iterator.next();
            rankOfPresentCard = card.getRank().getPips();
            shortNameOfPresentCard = card.getRank().getShortName();

            // check if the rank and the short name are equal.
            // we check both cause face value cards have the same pip value given to them.
            if(rankToCheck == rankOfPresentCard && shortNameToCheck == shortNameOfPresentCard){
                occurrencesCount++;
            }
        }
        return occurrencesCount;

    }


    /**
     * This function checks to see if a hand contains the required card
     * @param cardToFind - Card - the card to be found.
     * @return - Boolean - true if the card is present.
     */
    @Override
    public Boolean hasCard(Card cardToFind){

        Boolean isPresent = false;
        int rankToCheck = cardToFind.getRank().getPips();
        char shortNameToCheck = cardToFind.getRank().getShortName();
        char suitToFind = cardToFind.getSuit().getSymbol();
        int rankOfPresentCard;
        char shortNameOfPresentCard;
        char presentCardSuit;

        HandIterator iterator = new HandIterator(this.presentHand);
        while (iterator.hasNext()){
            Card card = iterator.next();

            rankOfPresentCard = card.getRank().getPips();
            shortNameOfPresentCard = card.getRank().getShortName();
            presentCardSuit = card.getSuit().getSymbol();

            // check if the rank, the short name  and the suit are equal.
            // we check all cause face value cards have the same pip value given to them.
            if(rankToCheck == rankOfPresentCard && shortNameToCheck == shortNameOfPresentCard && suitToFind == presentCardSuit){
                isPresent = true;
            }
        }

        return isPresent;
    }

}
