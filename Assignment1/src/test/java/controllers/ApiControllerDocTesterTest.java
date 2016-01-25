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


import models.card;
import models.deck;
import models.game;
import org.junit.Test;

import ninja.NinjaDocTester;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;

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




    @Test
    public void testGameAndPile() {
        game myGame = new game();
        assertSame(myGame.getScore(), 0);
        assertSame(myGame.one.getSize(), 1);
        assertNotNull(myGame.one.getTop());
        assertSame(myGame.remainingCards(), 48); //Because as soon as the game starts, 4 cards are dealt
        myGame.one.removeTop();
        assertNull(myGame.one.getTop());
        myGame.deal();
        assertNotNull(myGame.one.getTop());
        assertSame(myGame.remainingCards(), 44);
    }

    @Test
    public void testRestart(){

        game myGame = new game();
        assertSame(myGame.remainingCards(),48); //4 cards are dealt
        assertSame(myGame.getScore(), 0);
        assertSame(myGame.one.getSize(), 1);
        assertSame(myGame.two.getSize(), 1);
        assertSame(myGame.three.getSize(), 1);
        assertSame(myGame.four.getSize(), 1);
    }
}
