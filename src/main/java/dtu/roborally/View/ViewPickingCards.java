package dtu.roborally.view;

import dtu.roborally.utilities.*;
import dtu.roborally.controller.*;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * view for the PickCard
 */
public class ViewPickingCards {
	private PickingCardsController SCC;
	private GameScreen layout;
	private ArrayList<String> hand;
	private HBox cardsPlayed = new HBox();
	private GameBoardPane btp;

	/**
	 * Constructor that retrieves relevant data
	 * @param SCC (PickCardController)
	 * @param hand (ArrayList<Card>)
	 */
	public ViewPickingCards(PickingCardsController SCC, ArrayList<String> hand) {
		this.SCC = SCC;
		this.hand = hand;
	}

	/**
	 * creates a scene with a grid panel style, with all the cards as info
	 * @return (Scene)
	 */
	public Scene initialGUI() {

		//sets layout
		PlayerDetails PSP = new PlayerDetails(SCC.getPlayerIDList());
		btp = new GameBoardPane();
		layout = new GameScreen(PSP, btp, confirmCardsButton());
		addCardsGUI();

		return new Scene(layout);
	}


	/**
	 * Creates the cards in hand and deck
	 */
	public void addCardsGUI() {

		//hand panel
		TilePane handGUI = new TilePane();
		handGUI.setPrefColumns(4);
		handGUI.setPrefRows(4);
		handGUI.setVgap(24);
		handGUI.setHgap(14);

		//cards in play
		cardsPlayed.setSpacing(64);

		//Loop of the cards in hand and view for all of them
		for (String item : hand) {

			String CardName = item;


			ImageView IV =  ImageHandler.loadFile("src/main/resources/cardImages/" + CardName + ".png", CardName, 140, 90);
			IV.setId(CardName);

			ImageView IVC =  ImageHandler.loadFile("src/main/resources/cardImages/" + CardName + ".png", CardName, 85, 55);
			IV.setId(CardName);

			IV.setOnMouseClicked(value -> {

				if (cardsPlayed.getChildren().size() < 5) {
					handGUI.getChildren().remove(IV);
					cardsPlayed.getChildren().add(IVC);

					SCC.addCardInPlay(item);
				}
			});

			IVC.setOnMouseClicked(value -> {

				cardsPlayed.getChildren().remove(IVC);
				handGUI.getChildren().add(IV);

				SCC.removeCardInPlay(item);
			});

			handGUI.getChildren().add(IV);
		}

		layout.add(handGUI, 1, 1, 1, 3);
		layout.add(cardsPlayed, 2, 3, 1, 3);
		layout.setAlignment(Pos.BASELINE_LEFT);
	}

	/**
	 * Button to confirm cards, will signify that it is the next players turn
	 * @return (Button)
	 */
	public Button confirmCardsButton() {

		Button confirmCardsButton = new Button("CONFIRM CARDS");
		confirmCardsButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
		confirmCardsButton.setStyle("-fx-background-color: #ffbed9; -fx-border-color: #000000; -fx-border-width: 2; -fx-text-fill: #85004d");

		confirmCardsButton.setOnAction(value -> {
			if(!(cardsPlayed.getChildren().size()<5)) {
				SCC.nextPlayer();
			}
		});
		confirmCardsButton.setDefaultButton(true);

		return confirmCardsButton;
	}
}