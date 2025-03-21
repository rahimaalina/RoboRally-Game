package dtu.roborally.view;

import java.util.ArrayList;

import dtu.roborally.controller.*;
import dtu.roborally.utilities.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * View for the starting positions
 */
public class ViewCreateRobo {

    private CreateRoboController SPC;

    private int playerID;
    private GameBoardPane boardGUI;
    private GridPane layout;
    private ArrayList<String> playerNames;
    private String playerName;
    private PlayerDetails playerDetails;

    private Label Label;


    /**
     * Constructor retrieving relevant classes
     * @param SPC (RoboRallyController)
     * @param PlayerID (int)
     * @param PlayerNames (ArrayList<String>)
     */
    public ViewCreateRobo(CreateRoboController SPC, int PlayerID, ArrayList<String> PlayerNames){
    	//layout = new GridPane();
        this.SPC = SPC;
        this.playerID = PlayerID;
        this.playerNames = PlayerNames;
        playerName = PlayerNames.get(PlayerID);

        boardGUI = new GameBoardPane();
        playerDetails = new PlayerDetails(PlayerNames);

        layout = new GameScreen(playerDetails, boardGUI);
        addListeners();
    }

    /**
     *Creates a scene for updated board
     * @return (Scene)
     */
    public Scene initialGUI(){

        layout = new GameScreen(playerDetails, boardGUI);
        addLabel();
        addLabel2();
        return new Scene(layout);

    }

    /**
     * Method for inserting the robot in the starting square
     */
    public void addListeners() {
    	for(int i=0; i<boardGUI.getChildren().size(); i++) {
    		Node node = boardGUI.getChildren().get(i);
    		int x = i% boardGUI.getPrefColumns();
    		int y = (int)Math.floor((i-x)/(double)boardGUI.getPrefColumns());
    		
    		int idx = i;
    		if(node.getId().equals("Start Point")) {
    			node.setOnMouseClicked(value -> {
    				if(((StackPane)boardGUI.getChildren().get(idx)).getChildren().size() < 2){
    					int id = GetPlayerID();
    					SPC.pickingRobot(id, x, y);
    					AddRobotPNG(id, idx);
                        System.out.println("TESTING");
    					
    					SPC.nextPlayer();
    				}
    				
    			});
    		}
    	}
    }

    /**
     * creating label
     */
    public void addLabel(){
        Label = new Label(playerName + ", click on your desired start position");
        Label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 16));
        layout.add(Label, 2, 2, 1, 1);
    }

    public void addLabel2(){
        Label = new Label("                                                          ");
        Label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 16));
        layout.add(Label, 1, 2, 1, 1);
    }

    /**
     * Adds robot image on the start positions
     * @param playerID (int)
     * @param index (int) tile index
     */
    public void AddRobotPNG(int playerID, int index) {
    	ImageView robotImageView = ImageHandler.loadFile("src/main/resources/robotImages/robot"+playerID+".png", "R"+playerID, 50, 50);
		robotImageView.setRotate(90+180);
    	StackPane stack = (StackPane)boardGUI.getChildren().get(index);
    	stack.getChildren().add(robotImageView);

    }

    /**
     * method for getting the player that is choosing his starting position
     * @return (int)
     */
    public int GetPlayerID() {
    	return playerID;
    }

    /**
     * Allows for progression to next player after previous player is done
     * @param nextPlayerID (int)
     */
    public void nextPlayerStart(int nextPlayerID) {
    	playerID = nextPlayerID;
    	playerName = playerNames.get(playerID);
    	addLabel();
        addLabel2();
    }
}
