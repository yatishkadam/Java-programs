package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal13Test {
    private TestHelperClass testHelperClass;
    private HandTotal13 handTotal;
    private Hand hand76;
    private Hand handA2;
    private Hand hand49;
    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal13.getInstance(testHelperClass.game);
        hand76 = new Hand();
        handA2 = new Hand();
        hand49 = new Hand();

        hand76.accept(testHelperClass.cardSeven);
        hand76.accept(testHelperClass.cardSix);

        handA2.accept(testHelperClass.cardAce);
        handA2.accept(testHelperClass.cardTwo);

        hand49.accept(testHelperClass.cardNine);
        hand49.accept(testHelperClass.cardFour);
    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        game.currentHandBeingChecked = hand76;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() != '1' && dealer.getFaceUpCard().getRank().getPips() >=7){
                assertEquals(2, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(1, handTotal.handAction());
            }
        }

        game.currentHandBeingChecked = handA2;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(2, handTotal.handAction());
        }

        game.currentHandBeingChecked = hand49;

        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() != '1' && dealer.getFaceUpCard().getRank().getPips() >=7){
                assertEquals(2, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(1, handTotal.handAction());
            }
        }
    }
}