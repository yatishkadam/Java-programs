package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal16Test {

    private TestHelperClass testHelperClass;
    private HandTotal16 handTotal;
    private Hand hand88;
    private Hand hand97;
    private Hand handA5;

    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal16.getInstance(testHelperClass.game);
        hand88 = new Hand();
        hand97 = new Hand();
        handA5 = new Hand();

        hand88.accept(testHelperClass.cardEight);
        hand88.accept(testHelperClass.cardEight);

        hand97.accept(testHelperClass.cardNine);
        hand97.accept(testHelperClass.cardSeven);

        handA5.accept(testHelperClass.cardAce);
        handA5.accept(testHelperClass.cardFive);

    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        game.currentHandBeingChecked = hand97;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() != 1 && dealer.getFaceUpCard().getRank().getPips() >=7){
                if(dealer.getFaceUpCard().getRank().getPips() == 7 || dealer.getFaceUpCard().getRank().getPips() == 8)
                    assertEquals(2, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(1, handTotal.handAction());
            }
        }

        game.currentHandBeingChecked = hand88;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(3, handTotal.handAction());
        }


        game.currentHandBeingChecked = handA5;

        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(2, handTotal.handAction());
        }
    }

}