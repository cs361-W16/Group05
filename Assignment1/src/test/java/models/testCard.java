package models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sophia on 1/25/2016.
 */
public class testCard {
    //This tests the constructor of the card class, to make sure cards are successfully created
    @Test
    public void testCard() {
        card myCard = new card(1, "Diamond");
        assertThat(myCard.getSuit(), containsString("Diamond"));
         assertTrue(myCard.getNumber()== 1);
    }
}
