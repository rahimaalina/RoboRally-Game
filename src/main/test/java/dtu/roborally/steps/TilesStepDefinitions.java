package dtu.roborally.steps;

import dtu.roborally.Tiles;
import dtu.roborally.Robot;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TilesStepDefinitions {

    Tiles tileType;

    int directionTile;
    int directionRobot;



    Robot robot = new Robot(0,0,1);



    @Given("a conveyor belt facing direction")
    public void aConveyorBeltFacingDirection() {
        this.directionTile = directionTile;
        Tiles conveyor1 = new Tiles("Conveyor Belt 1"+directionTile,0);
    }


    @And("A robot is on the tile")
    public void aRobotIsOnTheTile() {
    }


    @When("The round ends")
    public void theRoundEnds() {

    }

    @Then("the conveyor moves the robot")
    public void theConveyorMovesTheRobot() {


    }

    @And("The direction of the robot stays the same")
    public void theDirectionOfTheRobotStaysTheSame() {
    }


}
