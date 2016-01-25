package models;

import models.card;
import models.deck;
import java.util.ArrayList;


/**
 * Created by Natha_000 on 1/21/2016.
 */
public class game {
    private int score = 0;
    private deck myDeck;
    public pile one;
    public pile two;
    public pile three;
    public pile four;
    public String action;
    public String details;
    public ArrayList<deck> columns = new ArrayList<deck>(4);
    public deck remaining_deck;
    public deck discard_pile;

    public game(){
        myDeck = new deck();
        one = new pile();
        two = new pile();
        three = new pile();
        four = new pile();

        deal();
    }
    public void deal(){
        one.add(myDeck.dealRandom());
        two.add(myDeck.dealRandom());
        three.add(myDeck.dealRandom());
        four.add(myDeck.dealRandom());
    }


    public int getScore(){
        return score;
    }
    public int remainingCards(){
        return myDeck.numCards();
    }

}