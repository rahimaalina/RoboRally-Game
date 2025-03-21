package dtu.roborally.steps;
import dtu.roborally.Card;
import dtu.roborally.Player;
import dtu.roborally.controller.Controller;
import dtu.roborally.Game;
import dtu.roborally.Robot;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlayerStepDefs {
    private int playerNumber;
    private String pickedCards;
    private int playerID;
    private Card doCard;
    String cardType;
    Player player = new Player();
    Controller controller = new Controller();
    Robot robot;
    Game game;
    @Given("a player")
    public void aPlayer() {
        Player player1;
    }

    @When("game begins")
    public void gameBegins() {
        Game.newGame(controller,1,1);

    }

    @Then("player gets cards")
    public void playerGetsCards() {
        player.getCards();
    }

    @Then("player picks cards")
    public void playerPicksCards() {
        player.getPickedCards().add(pickedCards);
    }

    @Then("player sets their name")
    public void playerSetsTheirName() {
        player.setPlayerName("Bob");
    }


    @Then("player gets their playerID")
    public void playerGetsTheirPlayerID() {
        player.getPlayerID();
    }

    @When("the player gets the cards")
    public void thePlayerGetsTheCards() {
        player.getCards();
    }

    @Then("the string cards are going to transform to cards")
    public void theStringCardsAreGoingToTransformToCards() {
        cardType = "Move 1";
        player.initializeRobot(0,0,2);
        player.transformCard(cardType);
    }
}