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

import models.game;
import ninja.Result;
import ninja.Results;
import ninja.Context;

import com.google.inject.Singleton;


@Singleton


public class ApplicationController {

    public Result index() {
        return Results.html();
    }

    public Result acesUp() {
        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }
    //public Result card() {
    //    return Results.html();
    //}
    public Result sendCards(Context context, game myGame) {
       /* if(myGame.action == "deal"){
            myGame.deal();
        }*/

        return Results.json().render(myGame);
    }
    public Result sendCardsGet(){
        game myGame = new game();
        return Results.json().render(myGame);
    }

}
