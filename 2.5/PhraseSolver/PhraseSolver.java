/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1; 
  private Player player2;
  private Board game;
  private boolean solved; 
  
  /* your code here - constructor(s) */ 
  public PhraseSolver()
  {
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;
    String guess = "";
    Scanner input = new Scanner(System.in);
    boolean correct = false;
    int value = 0;

    while (!solved) 
    {
      //prompt player for guess
      if(currentPlayer ==1)
      {
        System.out.println("Type your guess, " + player1.getName() + ": ");
      }
      else
      {
        System.out.println("Type your guess, " + player2.getName() + ": ");
      }
      //get and check guess
      System.out.println(game.getSolvedPhrase());
      guess = input.nextLine();
      solved = game.isSolved(guess);
      correct = game.guessLetter(guess); 
      value = game.getLetterValue();

      if(correct)//add points
      {
        if(currentPlayer == 1)
        {
          player1.addToPoints(value);
        }
        else
        {
          player2.addToPoints(value);
        }
      }
      else//switch players
      {
        if(currentPlayer == 1)
        {
          currentPlayer = 2;
        }
        else
        {
          currentPlayer = 1;        }
      }     
    } //end of while loop
    System.out.println("The phrase has been solved! \n Scores Are:");
    System.out.println(player1.getName() + ": " + player1.getPoints());
    System.out.println(player2.getName() + ": " + player2.getPoints());

  }
  
}