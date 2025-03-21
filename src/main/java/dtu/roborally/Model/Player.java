package dtu.roborally.Model;

import java.util.ArrayList;

import dtu.roborally.CardTypes.*;


public class Player {

    private int playerNumber;
    private String name;
    private static int counter=1;
    private ArrayList<String> card = new ArrayList<>();
    private ArrayList<String> pickedCards = new ArrayList<>();
    private Card doCard;
    private Robot robot;



    //we will use cards inside player
    //player recieves 10 strings from card
    //string to card (if statement)

    public Player() {
        this.playerNumber = counter;
        counter++; //counter = counter +1

    }

    public void setPlayerName(String name) {
        this.name = name;

    }

    //get cards, run cards
    //get robot
    //chosen cards of player
    public void getCards() {
        card.clear();
        Card.shuffle(card);
    }


    public void transformCard(String cardType) {
        if (cardType.equals("Move 1")) {
            doCard = new Card() {
                @Override
                public void executeCard(Robot robot) {

                }
            };
        } else if (cardType.equals("Move 2")) {
            doCard = new Card() {
                @Override
                public void executeCard(Robot robot) {

                }
            };
        } else if (cardType.equals("Right Card")) {
            doCard = new Card() {
                @Override
                public void executeCard(Robot robot) {

                }
            };
        } else if (cardType.equals("Left Card")) {
            doCard = new Card() {
                @Override
                public void executeCard(Robot robot) {

                }
            };
        } else if (cardType.equals("U Card")) {
            doCard = new Card() {
                @Override
                public void executeCard(Robot robot) {

                }
            };
        } else {
            System.out.println("error");
        }

        doCard.executeCard(robot);
    }

    public int getPlayerID() {
        return playerNumber;
    }

    public ArrayList<String> getCard() { return card; }

    public ArrayList<String> getPickedCards() {
        return pickedCards;
    }


    //CHECK I CHANGED THE ARGUMENTS INSIDE GETROBOT FROM NOTHING TO THAT(FOR THE CONTROLLER newRobot TO WORK WITH COORDINATES)
    public Robot getRobot() {
        return robot;
    }

    public void initializeRobot(int x, int y,int ori) {
        robot = new Robot(x, y, ori);
    }

}

