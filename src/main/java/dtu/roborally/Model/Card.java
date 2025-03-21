package dtu.roborally.Model;
import java.util.*;
import java.util.HashMap;
import java.util.Map;


public abstract class Card {
    private static String[] deck = {
            "Right Card", "Right Card", "Right Card", "Right Card",
            "Left Card", "Left Card", "Left Card", "Left Card",
            "Move 1", "Move 1", "Move 1", "Move 1",
            "Move 2", "Move 2", "Move 2",
            "U Card",
    };




    //we want shuffle to communicate with player
    // Method to shuffle the ArrayList and print its elements
    public static void shuffle(ArrayList<String> al) {
        // getting Iterator from arraylist to traverse elements
        List<String> itr = Arrays.asList(deck);

        // Shuffling the ArrayList
        Collections.shuffle(itr);

        // Reinitializing the iterator
        itr.toArray(deck);

        // Printing the elements after shuffling
//        while (itr.hasNext()) {
//            System.out.print(itr.next() + " ");
//        }

        for (int i = 0; i < 9; i++) {
            al.add(deck[i]);
        }

    }



    public abstract void executeCard(Robot robot);


//    public void get9Card() {
//        System.out.println('y');
//    }

    public String[] getCards() {
        return deck;
    }
}
// to make Card abstract
// to make subclasses so that red go away in MovementSteps.java

