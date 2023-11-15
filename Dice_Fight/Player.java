package Dice_Fight;


//This is the Player class. The two players in this game are instances of this class.
public class Player{
    //data field - properties
    private String name;
    private int health = 5;
    private boolean isAlive = true;
    
  //constructors
    public Player(String playerName){
        name = playerName;
        
    }
    public Player(String playerName, int newHealth ){
        name = playerName;
        health = newHealth;
    }
  
  //methods
    public void takeHit() {
        if (health > 1) {
            health--;
        }else {
            health = 0;
            die();
        } 
    }
    public void powerUp() {
        health++;
        isAlive = true;
    }
    public void die(){
        isAlive = false;
    }
    //getter and setter methods
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getHealth(){
        return health;
    }
    public boolean getIsAlive(){
        return isAlive;
    }

    @Override
    public String toString(){
        String info = "Player Name: " + 
            getName() + ".\nPlayer Health: " + 
            getHealth(); 
        return info; 


    }


}

