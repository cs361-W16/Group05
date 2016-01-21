package controllers;


public class card {
        private int number;
        private String suit;

        card(int num, String sui){
            number = num;
            suit = sui;
        }

        public String printSuit(){
            return suit;
        }
}
