package dtu.roborally;

import java.util.ArrayList;

import dtu.roborally.controller.Controller;

public class Game {


    private boolean hasWon;

    private ArrayList<Player> players = new ArrayList<Player>() {
    };

    private static Game game;
    private Board board;
    //instance
    private int numberOfCards = 5;

    private Player player;

    private Controller controller;

    public Game(int numberOfPlayers, int difficulty, Controller controller) {
        this.hasWon=false;
        this.controller=controller;
        //difficulties make the board bigger
        board = new Board(numberOfPlayers, difficulty);

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

    public static Game newGame(Controller observer, int NPlayers, int difficulty) {
        if(game == null) {
            game = new Game(NPlayers, difficulty, observer);
        }
        return game;
    }

    public Board getBoard() {
        return board;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }


    //ADD THINGS
    public void victory(int nameOfPlayer) {
        hasWon = true;
    }

    public static void clearGame() {
        game=null;
    }

    //FIX GAME LOOP!
    public void gameFlow() {
        // number of cards in play


        // this loop says that the rounds of each turn of the player are gonna be the same number as the cards they pick. so the rounds are gonna be 5 since the chosen cards are 5
        for (int round=0; round < 5; round++) {
            // this loop
            for(int playerIndex=0; playerIndex<getNumberOfPlayers(); playerIndex++) {
                // use of card (robot behaves accordingly)
                Player currPlayer = game.getPlayers().get(playerIndex);
                currPlayer.transformCard(currPlayer.getPickedCards().remove(0));
                controller.notifyRobotMove();
            }
        }



        // Check if anyone is at checkpoint
        for (int i = 0; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            Robot robot = players.get(i).getRobot();
            int px = robot.getx();
            int py = robot.gety();

            if (currentPlayer != null) {
                if (robot != null) {
                    px = robot.getx();
                    py = robot.gety();
                }
            }

            // if someone is there, that player gets the winner message
            if (board.getTile(px, py) instanceof CheckPoint) {
                game.victory(i);
                controller.notifyWin(i);
            }
        }
    }
}