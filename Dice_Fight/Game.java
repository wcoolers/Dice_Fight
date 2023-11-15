/*
    The Game class inherits from the Fight class (and thus, it inherits from the Register and Start classes too).
    This class sets the stage for main fight logic. 
    It continuosly updates the pane with player details for each round of the fight.

*/

package Dice_Fight;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;



public class Game extends Fight {
    
    protected TextField player1GuessBox = getTextField();
    
    
    
    @Override
    public BorderPane getPane(){
        //fill out the pane with all that is in the Register.java class
        BorderPane pane = super.getPane();
       
        //move from round to round by clicking next button        
        next.setOnAction(e -> {
            
            //update the banner for each round
            roundBar.setText("ROUND " + round + "  ... FIGHT!!!");
           
            
            //check that none of the players has died
            if (player1.getIsAlive() && computer.getIsAlive()){

                //generate a random no between 0 and 1
                int dice = (int)(Math.random()* 2);

               

                //generate a lucky random number between 1 and 6
                int powerBall = 1 + (int)(Math.random()* 6);

                //just for debugging purposes. To know the lucky number
                System.out.println(powerBall);
    
                if (dice == 0){
                        computer.takeHit();
                        gameInfo.setText("Computer has been hit! \nComputer will take a guess...");

                        //remove the textfield if it exits
                        if (player1GuessBox.getParent() != null ){
                            gameContainer.getChildren().remove(player1GuessBox);
                        }

                        //update the heatlh stat display
                        computerBox.getChildren().remove(1);
                        computerBox.getChildren().add(1, generateText("Health Stat: " + computer.getHealth()));

                        //generate a random answer for the computer, since its not human.
                        int compSave = 1 + (int)(Math.random()* 6);
                        
                        

                        if(compSave == powerBall) {
                            computer.powerUp();

                            //update the heatlh stat display
                            computerBox.getChildren().remove(1);
                            computerBox.getChildren().add(1, generateText("Health Stat: " + computer.getHealth()));
                            gameInfo.setText(gameInfo.getText() + "\n\nComputer guessed right and has powered up. \nComputer's health remains  " + 
                                computer.getHealth());

                        } else {
                            gameInfo.setText(gameInfo.getText() + "\n\nComputer failed to power up!\nComputer's health is reduced by 1.");
                                
                               
                            }
                }else { //meaning dice returned 1
                    player1.takeHit();

                    //update the heatlh stat display
                    player1Box.getChildren().remove(1);
                    player1Box.getChildren().add(1, generateText("Health Stat: " + player1.getHealth()));
                    
                    gameInfo.setText("You have been hit.\n\nEnter a number between 1 and 6 " +
                    "\nfor a chance to power up.");

                    //add the textfield only if it doesnt exit already
                    if (player1GuessBox.getParent() == null ){
                            gameContainer.getChildren().add(player1GuessBox);
                            
                    } else {
                        player1GuessBox.clear();
                    }

                    //always clear the textfield before each render
                    
                    
                    

                    //read the user input and check whether it matches the powerBall 
                    player1GuessBox.setOnAction(ef -> {
                        
                        try {

                            //this may throw an exception if user enters letter or some other input value

                            //convert the text input value from String to int
                            int playerSave = (Integer.parseInt(player1GuessBox.getText()));

                            //check to see if the player got the lucky number right
                            if(playerSave == powerBall) {
                                player1.powerUp();
                                gameInfo.setText("\nYou guessed right. \nYou have powered up!!!");
                                
                                 //update the heatlh stat display
                                player1Box.getChildren().remove(1);
                                player1Box.getChildren().add(1, generateText("Health Stat: " + player1.getHealth()));

                                // clear the textfield
                                player1GuessBox.clear();;
                            } else {
                                gameInfo.setText("\nSorry, you didn't guess right.\nYour health is reduced by 1.");

                                
                                //clear the textfield box
                                player1GuessBox.clear();;
                                
                            }
                            //remove the text box from the pane.
                            gameContainer.getChildren().remove(player1GuessBox);

                        } catch (NumberFormatException exception) {
                            
                            gameInfo.setText("You entered a wrong input value. \nPlease enter between 1-6 ");

                        } catch (Exception exception) {
                            
                            gameInfo.setText("You entered a wrong input value. \nPlease enter between 1-6 ");

                        }

                        
                       
    
                    });
                
                    
                }
                //increment round
                round++;

            } else { //display the winner if one of the players is dead
                
                //remove the textfield if it exits
                if (player1GuessBox.getParent() != null ){
                    gameContainer.getChildren().remove(player1GuessBox);
                }


                roundBar.setText("THE END!!!");
                gameInfo.setText(player1.getIsAlive() ? "Computer is Dead.\n\n\nYou won!!!" : "You died .-_-. \n\n\nComputer won!!!" +
                "\nGame Over!!!");

                //diable the next button, since game has ended
                next.setDisable(true);
    
            }


        });
        

        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
