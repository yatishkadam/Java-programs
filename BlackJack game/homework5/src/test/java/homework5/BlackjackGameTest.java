package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import javax.print.attribute.HashAttributeSet;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackGameTest {
    BlackjackGame blackjackGame;
    private TestHelperClass testHelperClass ;
    private Hand handTotal2;
    private Hand handTotal3;
    private Hand handTotal4;
    private Hand handTotal5;
    private Hand handTotal6;
    private Hand handTotal7;
    private Hand handTotal8;
    private Hand handTotal9;
    private Hand handTotal10;
    private Hand handTotal11;
    private Hand handTotal12;
    private Hand handTotal13;
    private Hand handTotal14;
    private Hand handTotal15;
    private Hand handTotal16;
    private Hand handTotal17;
    private Hand handTotal18;
    private Hand handTotal19;
    private Hand handTotal20;
    private Hand handTotal21;

    @BeforeEach
    void initTest(){
        blackjackGame = BlackjackGame.getInstance(2,2);
        testHelperClass = new TestHelperClass();
        handTotal2 = new Hand();
        handTotal3 = new Hand();
        handTotal4 = new Hand();
        handTotal5 = new Hand();
        handTotal6 = new Hand();
        handTotal7 = new Hand();
        handTotal8 = new Hand();
        handTotal9 = new Hand();
        handTotal10 = new Hand();
        handTotal11 = new Hand();
        handTotal12 = new Hand();
        handTotal13 = new Hand();
        handTotal14 = new Hand();
        handTotal15 = new Hand();
        handTotal16 = new Hand();
        handTotal17 = new Hand();
        handTotal18 = new Hand();
        handTotal19 = new Hand();
        handTotal20 = new Hand();
        handTotal21 = new Hand();
        handTotal2.accept(testHelperClass.cardTwo);
        handTotal3.accept(testHelperClass.cardThree);
        handTotal4.accept(testHelperClass.cardFour);
        handTotal5.accept(testHelperClass.cardFive);
        handTotal6.accept(testHelperClass.cardSix);
        handTotal7.accept(testHelperClass.cardSeven);
        handTotal8.accept(testHelperClass.cardEight);
        handTotal9.accept(testHelperClass.cardNine);
        handTotal10.accept(testHelperClass.cardTen);
        handTotal11.accept(testHelperClass.cardNine);
        handTotal11.accept(testHelperClass.cardTwo);
        handTotal12.accept(testHelperClass.cardTen);
        handTotal12.accept(testHelperClass.cardTwo);
        handTotal13.accept(testHelperClass.cardTen);
        handTotal13.accept(testHelperClass.cardThree);
        handTotal14.accept(testHelperClass.cardTen);
        handTotal14.accept(testHelperClass.cardFour);
        handTotal15.accept(testHelperClass.cardTen);
        handTotal15.accept(testHelperClass.cardFive);
        handTotal16.accept(testHelperClass.cardTen);
        handTotal16.accept(testHelperClass.cardSix);
        handTotal17.accept(testHelperClass.cardTen);
        handTotal17.accept(testHelperClass.cardSeven);
        handTotal18.accept(testHelperClass.cardTen);
        handTotal18.accept(testHelperClass.cardEight);
        handTotal19.accept(testHelperClass.cardTen);
        handTotal19.accept(testHelperClass.cardNine);
        handTotal20.accept(testHelperClass.cardTen);
        handTotal20.accept(testHelperClass.cardTen);
        handTotal21.accept(testHelperClass.cardTen);
        handTotal21.accept(testHelperClass.cardNine);
        handTotal21.accept(testHelperClass.cardTwo);
    }


    /**
     * This is used to test the change state.
     * we run all the possibilities and check what happends when the total is of the cards is to a certain number
     * and check the correponding state that it changes to
     */
    @Test
    void changeCurrentState() {
        blackjackGame.currentHandBeingChecked = handTotal2 ;
        blackjackGame.changeCurrentState();
        assertEquals("2",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal3 ;
        blackjackGame.changeCurrentState();
        assertEquals("3",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal4 ;
        blackjackGame.changeCurrentState();
        assertEquals("4",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal5 ;
        blackjackGame.changeCurrentState();
        assertEquals("5",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal6 ;
        blackjackGame.changeCurrentState();
        assertEquals("6",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal7 ;
        blackjackGame.changeCurrentState();
        assertEquals("7",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal8 ;
        blackjackGame.changeCurrentState();
        assertEquals("8",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal9 ;
        blackjackGame.changeCurrentState();
        assertEquals("9",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal10;
        blackjackGame.changeCurrentState();
        assertEquals("10",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal11;
        blackjackGame.changeCurrentState();
        assertEquals("11",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal12;
        blackjackGame.changeCurrentState();
        assertEquals("12",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal13;
        blackjackGame.changeCurrentState();
        assertEquals("13",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal14;
        blackjackGame.changeCurrentState();
        assertEquals("14",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal15;
        blackjackGame.changeCurrentState();
        assertEquals("15",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal16;
        blackjackGame.changeCurrentState();
        assertEquals("16",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal17;
        blackjackGame.changeCurrentState();
        assertEquals("17",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal18;
        blackjackGame.changeCurrentState();
        assertEquals("18",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal19;
        blackjackGame.changeCurrentState();
        assertEquals("19",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal20;
        blackjackGame.changeCurrentState();
        assertEquals("20",blackjackGame.getCurrentState());
        blackjackGame.currentHandBeingChecked = handTotal21;
        blackjackGame.changeCurrentState();
        assertEquals("21",blackjackGame.getCurrentState());
    }

    /**
     * In this test we test the check dealer
     * we cannot assert it to anything as the deck is all shuffled.
     */
    @Test
    void checkDealer() {
        blackjackGame.dealer = testHelperClass.dealer5;//set a dealer and the face card is 5
        blackjackGame.checkDealer();
        blackjackGame.dealer.getDealerHandTotal();
    }

}