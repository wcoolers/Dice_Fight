/*
    The Fight class inherits from the Start class (and thus, it inherits from the Register class too).
    This class sets the stage for the fight. It removes the start button and adds the round banner, the next and exit buttons to the main pane.
    

*/

package Dice_Fight;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Fight extends Start {
    protected int round = 1;
    protected Text roundBar = generateText("ROUND " + round + "  ... FIGHT!!!");
    protected Text gameInfo = generateText("");
    protected Button next = getButton("NEXT");
    protected VBox gameContainer = new VBox(30);

    @Override
    public BorderPane getPane(){
        //fill out the pane with all that is in the Start.java class
        BorderPane pane = super.getPane();

        startBtn.setOnAction(e -> {

            //remove the start button from the pane
            pane.getChildren().remove(startBtn);

            //group the next button and the exit button together
            HBox controlBtns = new HBox(490);
            controlBtns.getChildren().addAll(next, exit);

            gameContainer.setAlignment(Pos.TOP_CENTER);
            
            gameContainer.getChildren().addAll(roundBar, gameInfo);

            pane.setCenter(gameContainer);
            pane.setBottom(controlBtns);


            

        });



        return pane;
    }
    
   
}
