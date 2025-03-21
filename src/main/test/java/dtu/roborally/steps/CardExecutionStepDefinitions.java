package dtu.roborally.steps;

import dtu.roborally.CardTypes.*;
import dtu.roborally.Game;
import dtu.roborally.Robot;
import dtu.roborally.Card;
import dtu.roborally.controller.Controller;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.java.ja.且つ;


public class CardExecutionStepDefinitions {

    Card card;
    Controller controller;
    Game game = Game.newGame(controller, 1, 1);

    Robot robot = new Robot(0,0,0);


    @Given("^a card$")
    public void aCard() {
        Card card;
    }

    @When("^the card is Rightcard$")
    public void theCardIsRightcard() {
        card = new Rightcard();

    }

    @When("^the card is Leftcard$")
    public void theCardIsLeftcard() {
        card = new Leftcard();

    }

    @When("the card is Movetwo")
    public void theCardIsMovetwo() {
        card = new Move2();

    }

    @When("the card is Moveone card")
    public void theCardIsMoveoneCard() {
        card = new Move1();
    }


    @When("^the card is Ucard$")
    public void theCardIsUcard() {
        card = new Ucard();
    }

    @When("its th players turn")
    public void itsThPlayersTurn() {

    }


    @Then("robot execute card")
    public void robotExecuteCard() {
        if (card instanceof Rightcard) {
            robot.changeCoordinates(0,0,1);
        }
        if (card instanceof Leftcard) {
            robot.changeCoordinates(0,0,3);
        }
        if (card instanceof Move1) {
            robot.changeCoordinates(1,0,0);
        }
        if (card instanceof Move2) {
            robot.changeCoordinates(2,0,0);
        }
        if (card instanceof Ucard) {
            robot.changeCoordinates(0,0,2);
        }
    }



    @Then("the U card is executed")
    public void theUCardIsExecuted() {
        Card card1 = new Ucard();
        card1.executeCard(robot);
    }

    @Then("the Right card is executed")
    public void theRightCardIsExecuted() {
        Card card2 = new Rightcard();
        card2.executeCard(robot);

    }

    @Then("the Left card is executed")
    public void theLeftCardIsExecuted() {
        Card card3 = new Leftcard();
        card3.executeCard(robot);
    }


    @Then("the Movetwo card is executed")
    public void theMovetwoCardIsExecuted() {
        Card card4 = new Move2();
        card4.executeCard(robot);
    }
}
