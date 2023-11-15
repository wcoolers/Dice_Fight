/*
    The Start class inherits from the Register class, and then clears the main pane, 
    then populates the main pane with player details and a start button.

*/

package Dice_Fight;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Start extends Register {
    
    //create a start button to kickoff the fight
    protected Button startBtn = getButton("Start");
    protected VBox player1Box = new VBox(10);
    protected VBox computerBox = new VBox(10);

   
    
    

    @Override
    public BorderPane getPane(){

        //fill out the pane with all that is in the Register.java class
        BorderPane pane = super.getPane();

        ready.setOnAction(e -> {
            //clean the pane after user clicks start
            pane.getChildren().clear();

            //create vertical containers for two players
            player1Box.setAlignment(Pos.CENTER_LEFT);
            computerBox.setAlignment(Pos.CENTER_LEFT);
            
            
            //add the player details to the player containers
            player1Box.getChildren().addAll(generateText(player1.getName()), generateText("Health Stat: " + player1.getHealth()));
            computerBox.getChildren().addAll(generateText(computer.getName()), generateText("Health Stat: " + computer.getHealth()));

            //create a horizontal banner for holding both player details
            HBox paneForPlayerDetails = new HBox(100);
            paneForPlayerDetails.setSpacing(410);
            paneForPlayerDetails.setPadding(new Insets(0, 0, 30, 0));

            //add the player containers to the banner
            paneForPlayerDetails.getChildren().addAll(player1Box, computerBox);
            
           
           //style the start button                
            startBtn.setPadding(new Insets(5, 30, 5, 30));
            
            //add the player banner and the start button to the pane
            pane.setTop(paneForPlayerDetails);
            pane.setCenter(startBtn);
        });

        return pane;

    }


    
}
