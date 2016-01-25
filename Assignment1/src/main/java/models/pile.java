package models;

/**
 * Created by Natha_000 on 1/21/2016.
 */
public class pile {
    private card stack[];
    private int size;

    pile(){
        stack = new card[26];
        size = 0;
    }

    public void add(card myCard){
        stack[size] = myCard;
        size++;
    }
    public void removeTop(){
        size--;
    }
    public card getTop(){
        if(size == 0){
            return null;
        }
        return stack[size-1];
    }
    public int getSize(){
        return size;
    }
}
