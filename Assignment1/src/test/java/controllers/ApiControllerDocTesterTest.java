/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;


import org.junit.Test;

import ninja.NinjaDocTester;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ApiControllerDocTesterTest extends NinjaDocTester {
    
    String URL_INDEX = "/";
    String URL_ACES_UP = "/AcesUp";
    
    @Test
    public void testGetIndex() {

        Response response = makeRequest(
                Request.GET().url(
                        testServerUrl().path(URL_INDEX)));

        assertThat(response.payload, containsString("Hello World!"));
        assertThat(response.payload, containsString("BAM!"));
    }

    @Test
    public void testAcesUp() {
        Response response = makeRequest(
                Request.GET().url(
                        testServerUrl().path(URL_ACES_UP)));

        assertThat(response.payload, containsString("Aces Up"));
        assertThat(response.payload, containsString("columnOfCards"));
    }
    //This tests the constructor of the card class, to make sure cards are successfully created
    @Test
    public void testCard(){
        card myCard = new card(1, "Diamond");
        assertThat(myCard.getSuit(), containsString("Diamond"));
        assertSame(myCard.getNumber(), 1);
    }
    //This tests the constructor of the deck class, to make sure the deck successfully creates cards
    @Test
    public void testDeck(){
        deck myDeck = new deck();
        assertSame(myDeck.numCards(), 52);
        assertSame(myDeck.getCard(1).getNumber(), 2);
        assertThat(myDeck.getCard(29).getSuit(), containsString("Diamonds"));

    }
    //This tests the dealing functionality of the deck class, as cards should never be dealt twice.
    @Test
    public void testDeal(){
        deck myDeck = new deck();
        card myCard = myDeck.dealRandom();
        card otherCard = null;
        for(int i = 0; i < 51; i++) {
            otherCard = myDeck.dealRandom();
            assertNotNull(otherCard);
            assertNotEquals(myCard, otherCard);
        }
        assertSame(myDeck.numCards(), 0);
    }



}
