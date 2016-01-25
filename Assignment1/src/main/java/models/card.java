package models;


public class card {
    private int number;
    private String suit;

    card(int num, String sui){
        number = num;
        suit = sui;
    }
    public String getSuit(){
        return suit;
    }
    public int getNumber(){
        return number;
    }
}

