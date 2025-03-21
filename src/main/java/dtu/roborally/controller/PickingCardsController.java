package dtu.roborally.controller;

import java.util.ArrayList;

import dtu.roborally.*;
import dtu.roborally.view.ViewPickingCards;
import javafx.stage.Stage;


public class PickingCardsController {
	
	private Controller controller;
	private Stage mainstage;
	private ViewPickingCards viewPickingCards;

	private ArrayList<String> playerIDList;
	private int numberName;
	private Player player;

	public PickingCardsController(Controller controller, Stage mainstage
			, ArrayList<String> playerIDList, int numberName) {
		this.playerIDList = playerIDList;
		this.controller = controller;
		this.mainstage = mainstage;
		this.numberName = numberName;
		player = Game.getGame().getPlayers().get(numberName);
		this.viewPickingCards = new ViewPickingCards(this, player.getCard());
	}


	public void display() {
		mainstage.setScene(viewPickingCards.initialGUI());
	}

	public void addCardInPlay(String card) {
		player.getPickedCards().add(card);
	}

	public void removeCardInPlay(String card) {
		player.getPickedCards().remove(card);
	}

	public void nextPlayer() {
		controller.playersTurn(mainstage, numberName+1);
	}

	public int[] extractPositionX(){
		int[] positionsX = new int[2];
		positionsX[0] = player.getRobot().getx();
		positionsX[1] = player.getRobot().getStartPositionX();
		return positionsX;
	}

	public int[] extractPositionY(){
		int[] positionsY = new int[2];
		positionsY[0] = player.getRobot().gety();
		positionsY[1] = player.getRobot().getStartPositionY();
		return positionsY;
	}


	public ArrayList<String> getPlayerIDList() {
		return playerIDList;
	}
}