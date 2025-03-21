package dtu.roborally.utilities;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;



public class GameScreen extends GridPane{


    public GameScreen(PlayerDetails psp, GameBoardPane btp, Node... extraNode){
        super();

        //sets general layout
        setVgap(20);
        setHgap(30);
        setPadding(new Insets(10, 0, 0, 40));


        Label title = new Label("Board Game: Robo-Rally");
        title.setFont(Font.font("Comic Sans MS", 40));
        add(title, 0, 0, 3, 1);


        //add statusOfPlayersConsole and Board that we have in each view
        add(psp, 3, 1, 1, 3);
        add(btp, 2, 1, 1, 1);


        //handles the potential button and progressbar
        for(Node n: extraNode){
            if(n instanceof Button){
                add(n, 3,4,1,1);
            }
        }

    }
}






