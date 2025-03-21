package dtu.roborally.Model;

import java.util.ArrayList;

import dtu.roborally.controller.Controller;

public class Game {


    private boolean hasWon;

    private ArrayList<Player> players = new ArrayList<Player>() {
    };

    private static Game game;
    private Board board;
    //instance
    private int numberOfCards =5;

    private Player player;

    public Game(int numberOfPlayers, int difficulty, Controller controller) {
        this.hasWon=false;
        //difficulties make the board bigger
        if(difficulty == 1) {
            board = new Board(numberOfPlayers, difficulty);
        }

        for(int i=0; i<numberOfPlayers; i++) {
            players.add(new Player());

        }
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }

    public static Game getGame() {
        return game;
    }

    public static Game newGame(int difficulty, int numberOfPlayers, Controller controller) {
        return new Game(difficulty, numberOfPlayers,controller);
    }

    public Board getBoard() {
        return board;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }


    //ADD THINGS
    public void victory(int nameOfPlayer) {
        int victoryX = players.get(nameOfPlayer).getRobot().getx();
        int victoryY = players.get(nameOfPlayer).getRobot().gety();
        if (board.getTile(victoryX,victoryY) instanceof CheckPoint) {
            // weee victory
            hasWon = true;

            System.out.println("You won ");


        }
    }

    public static void clearGame() {
        game=null;
    }


    //game loop (loops the gameplay) copy

    //
//    public void gameWalkthrough(){
//
//        while(hasWon)
//        for (int turn=0; turn<numberOfCards;turn++) {
//
//            ArrayList<Integer> order = new ArrayList<>();
//
//            for(int i = 0; i<=player.getPlayerID(); i++ ) {
//
//                if(!p.getCardsInPlay().isEmpty()) {
//                    order.add(p.getCardsInPlay().get(0).getPriority());
//                }else {
//                    order.add(-1);
//                }
//            }
//
//
//        }
//    }

    //FIX GAME LOOP!
    public void gameFlow() {
        // number of cards in play

        int nbOfCards = 0;
        if (game != null) {
            ArrayList<Player> players = game.getPlayers();
            if (!players.isEmpty()) {
                Player firstPlayer = players.get(0);
                if (firstPlayer != null) {
                    ArrayList<String> cardsInPlay = firstPlayer.getPickedCards();
                    nbOfCards = (cardsInPlay != null) ? cardsInPlay.size() : 0;
                }
            }
        }

        // this loop says that the rounds of each turn of the player are gonna be the same number as the cards they pick. so the rounds are gonna be 5 since the chosen cards are 5
        for (int round=0; round < nbOfCards; round++) {
            // this loop
            for(int playerIndex=0; playerIndex<getNumberOfPlayers(); playerIndex++) {
                // use of card (robot behaves accordingly)
                Player currPlayer = game.getPlayers().get(playerIndex);
                currPlayer.transformCard(currPlayer.getPickedCards().remove(0));

                //check if player won
            }
        }
        for (int i = 0; i < players.size(); i++) {
            int px = 0;
            int py = 0;

            if (players != null && i >= 0 && i < players.size()) {
                Player currentPlayer = players.get(i);
                if (currentPlayer != null) {
                    Robot robot = currentPlayer.getRobot();
                    if (robot != null) {
                        px = robot.getx();
                        py = robot.gety();
                    }
                }
            }

            if (board.getTile(px, py) instanceof CheckPoint) {
                game.victory(i);
            }
        }
    }
}