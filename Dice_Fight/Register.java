package Dice_Fight;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Register extends Application{

    protected Button ready = getButton("Start Game");
    protected Button exit = getButton("Exit Game");

    //create two instances of the Player class
    //initialize player 1 with "Player 1, incase the user did not enter name"
    protected Player player1 = new Player("Player 1");
    protected Player computer = new Player("Computer");
    
    @Override
    public void start(Stage primaryStage){
        
        Scene scene = new Scene(getPane(), 750, 500);
        
        primaryStage.setTitle("DiceFight");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //pane generator which will be used to create the overall layout. Other classes will add nodes to this pane
    public BorderPane getPane(){
        
        BorderPane pane = new BorderPane(); 
        pane.setStyle("-fx-background-color: #00203F");     
        
        
        pane.setPadding(new Insets(15));
        Text welcomeNote = generateText("Welcome!\n\nPlease enter your name.");
        
        HBox paneForButtons = new HBox(10);
        paneForButtons.getChildren().addAll(ready, exit);

        TextField player1NameField = getTextField();
        
        

        //update the player name if provided by the user
        player1NameField.setOnAction(e ->{
            String name = player1NameField.getText();
            player1.setName(name);
        });
        
        //exit the game if the player clicks on exit button
        exit.setOnAction(e -> {
            Platform.exit();
            System.exit(0);
        });
        
        //add the welcome note, the textfield and the buttons into a vertical box with 30px gap. Then add the VBox to the center for the main pane
        pane.setCenter(new VBox(30, welcomeNote, player1NameField, paneForButtons));
        
        return pane;
        
        
    }

    //button generator to get consistent styling for all buttons
    public Button getButton(String text){
        Button btn = new Button(text);
        btn.setStyle("-fx-background-color: #ADEFD1");
        btn.setTextFill(Color.web("#00203F"));
        btn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 


        return btn;
    }

    //Text generator to get consistent sytling for all texts
    public Text generateText(String text){
        Text txt = new Text(text);
        txt.setFill(Color.web("#ADEFD1"));
        txt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       


        return txt;
    }

    //TextField generator to get consistent sytling for all Textfield
    public TextField getTextField(){
        TextField tf = new TextField();
        tf.setStyle("-fx-max-width: 300; -fx-min-height: 35" );
        tf.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 20));

        return tf;
    }
        


}
