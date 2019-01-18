package homework5;

import problem2.CardInterface;
import problem2.HandInterface;

public interface IDealer extends HandInterface {

    void setFaceUpCard(CardInterface card);
    CardInterface getFaceUpCard();
    void checkDealerAction();
    int getDealerHandTotal();
}
