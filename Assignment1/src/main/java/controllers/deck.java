package controllers;
import java.util.Random;

/**
 * Created by Natha_000 on 1/21/2016.
 */
public class deck {
    private int numCards;
    private card cardArray[];

                                //This constructor creates a deck of cards in order
    deck(){
        numCards = 52;
        cardArray = new card[52];
        String suit;
        int number;
        for(int i = 1; i < 53; i++){
            if(i < 14) {
                suit = "Spades";
                number = i;
            }
            else if(i < 27) {
                suit = "Clubs";
                number = i - 13;
            }
            else if(i < 40) {
                suit = "Diamonds";
                number = i - 26;
            }
            else {
                suit = "Hearts";
                number = i - 39;
            }
            cardArray[i-1] = new card(number,suit);
        }
    }
                    //This function deals a random card and removes it from the deck
    public card dealRandom(){
        Random rand = new Random();
        int myNum = rand.nextInt(numCards); //Returns value between 0 and numCards -1
        card myCard = getCard(myNum);
        for(int i = myNum; i < numCards - 1; i++)
            cardArray[myNum] = cardArray[myNum + 1];
        numCards--;
        return myCard;
    }

    public card getCard(int num){
        return cardArray[num];
    }

    public int numCards(){
        return numCards;
    }
}
