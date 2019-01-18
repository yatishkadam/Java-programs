package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal14Test {
    private TestHelperClass testHelperClass;
    private HandTotal14 handTotal;
    private Hand hand77;
    private Hand hand68;
    private Hand hand95;
    private Hand handA3;

    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal14.getInstance(testHelperClass.game);
        hand77 = new Hand();
        hand68 = new Hand();
        hand95 = new Hand();
        handA3 = new Hand();

        hand77.accept(testHelperClass.cardSeven);
        hand77.accept(testHelperClass.cardSeven);

        hand68.accept(testHelperClass.cardSix);
        hand68.accept(testHelperClass.cardEight);

        hand95.accept(testHelperClass.cardNine);
        hand95.accept(testHelperClass.cardFive);

        handA3.accept(testHelperClass.cardAce);
        handA3.accept(testHelperClass.cardThree);

    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        game.currentHandBeingChecked = hand77;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() != 1 && dealer.getFaceUpCard().getRank().getPips() >=8){
                assertEquals(2, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(3, handTotal.handAction());
            }
        }

        game.currentHandBeingChecked = hand68;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() != 1 && dealer.getFaceUpCard().getRank().getPips() >=7){
                assertEquals(2, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(1, handTotal.handAction());
            }
        }

        game.currentHandBeingChecked = hand95;

        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() != 1 && dealer.getFaceUpCard().getRank().getPips() >=7){
                assertEquals(2, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(1, handTotal.handAction());
            }
        }


        game.currentHandBeingChecked = handA3;

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