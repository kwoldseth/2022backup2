/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String phrase = "";
  private String solvedPhrase = "";
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board()
  {
    phrase = loadPhrase();
    setLetterValue(); //currentLetterValue is initialized through this method to a random value 
    System.out.println("Phrase: " + phrase); //temp test code
  }
  
  /* your code here - accessor(s) */

  public String getPhrase()
  {
    return phrase;
  }

  public String getSolvedPhrase()
  {
    return solvedPhrase;
  }

  public int getLetterValue()
  {
    return currentLetterValue;
  }

  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

 
/**
 * LOADPHRASE METHOD
 * Loads a phrase from phrases.txt
 * 
 * Precondition: phrase.txt exists and is populated
 * Postcondition: phrase is populated, sovledPhrase is populated with _ and a space for each character in phrase
 * 
 * @return String with the phrase
 */
  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  /**
   * GUESSLETTER METHOD
   * Looks for letter in phrase.
   * 
   * Precondition: phrase and guess exist
   * Postcondition: reassigns solvedPhrase to include guess if it is in phrase
   * @param guess String guess (letter or phrase)
   * @return boolean if guess is in the phrase
   */
  public boolean guessLetter(String guess)
  {
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    
    //loops through each letter of phrase
    for (int i = 0; i < phrase.length(); i++)
    {
      //compares each letter of phrase to the guess
      if (phrase.substring(i, i + 1).equals(guess))
      {
        //if letter equals guess, replaces _ with the letter and sets foundLetter to true
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }
      else
      {
        //if letter does not equal guess, keeps the _ 
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    //reassigns solvedPhrase to be filled in with the guess letter 
    solvedPhrase = newSolvedPhrase;
    //returns true if the letter was in the phrase
    return foundLetter;
  } 
} 