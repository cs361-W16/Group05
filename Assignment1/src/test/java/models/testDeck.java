package models;

import org.junit.Test;



        import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;
//This tests the constructor of the deck class, to make sure the deck successfully creates cards


public class testDeck {
    //This tests the constructor of the deck class, to make sure the deck successfully creates cards
    @Test
    public void Deck() {
        deck myDeck = new deck();
        assertTrue(myDeck.numCards() == 52);
        assertTrue(myDeck.getCard(1).getNumber() == 2);
        assertThat(myDeck.getCard(29).getSuit(), containsString("Diamonds"));

    }


    //This tests the dealing functionality of the deck class, as cards should never be dealt twice, and once 52 cards are dealt, the deck should be empty.
    @Test
    public void testDeal() {
        deck myDeck = new deck();
        card myCard = myDeck.dealRandom();
        card otherCard = null;
        for (int i = 0; i < 51; i++) {
            otherCard = myDeck.dealRandom();
            assertNotNull(otherCard);
            assertNotEquals(myCard, otherCard);
        }
        assertSame(myDeck.numCards(), 0);
    }
}