/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int points;

  /* your code here - constructor(s) */ 
  public Player()
  {
    //prompt user to type name
    //use a scanner to get user input of name and assign to name
    Scanner sc = new Scanner(System.in);
    System.out.println("Type your name: ");
    name = sc.nextLine();
    System.out.println("Welcome to the game, " + name + "! Have fun!");

    points = 0;
  }

  public Player(String inputName)
  {
    name = inputName;
    System.out.println("Welcome to the game, " + name + "! Have fun!");

    points = 0;
  }

  /* your code here - accessor(s) */ 
  public String getName()
  {
    return name;
  }
  
  public int getPoints()
  {
    return points;
  }
  
  /* your code here - mutator(s) */ 
  public void setName(String inputName)
  {
    name = inputName;
  }

  public void addToPoints(int value)
  {
    points += value;
  }

}