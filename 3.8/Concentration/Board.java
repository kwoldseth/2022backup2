/** 
 * A game board of NxM board of tiles.
 * 
 *  @author PLTW
 * @version 2.0
 */

/** 
 * A Board class for concentration
 */
public class Board
{  
  private static String[] tileValues = {"lion", "lion",
                                        "penguin", "penguin",
                                        "dolphin", "dolphin",
                                        "fox", "fox",
                                        "monkey", "monkey",
                                        "turtle", "turtle"}; 
  private Tile[][] gameboard = new Tile[3][4];

   /**  
   * Constructor for the game. Creates the 2D gameboard
   * by populating it with card values
   * 
   */
  public Board()

  {
    int counter=tileValues.length;
    for(int r = 0; r < gameboard.length; r++)
        for(int c = 0; c < gameboard[0].length; c++) 
        {
          int rand = (int)(Math.random()*counter);
          gameboard[r][c] = new Tile(tileValues[rand]);
          tileValues[rand]=tileValues[counter-1];
          counter--;
        }



    /*int counter = 0;
    
    for(int r = 0; r < gameboard.length; r++)
    {
      for(int c = 0; c < gameboard[0].length; c++) 
      {
          gameboard[r][c] = new Tile(tileValues[counter]);   
          counter++;
      }
    }*/
  }




 /** 
   * Returns a string representation of the board, getting the state of
   * each tile. If the tile is showing, displays its value, 
   * otherwise displays it as hidden.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return a string represetation of the board
   */
  public String toString()
  {
    String result = "";
    for(Tile[] row : gameboard)
    {
        for (Tile t : row)
      {
            if(t.isShowingValue())
              result += t.getValue();
            else
              result += t.getHidden();

              result += "\t";
      }
        result += "\n";
    }
    
    return result;
  }

  /** 
   * Determines if the board is full of tiles that have all been matched,
   * indicating the game is over.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return true if all tiles have been matched, false otherwse
   */
  public boolean allTilesMatch()
  {

    for(Tile[] row : gameboard)    
    {
      for(Tile tile : row)
        {
          if (!tile.matched())
            return false;
        }
    }
    return true;
  }

  /** 
   * Sets the tile to show its value (like a playing card face up)
   * 
   * Preconditions:
   *   gameboard is populated with tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row the row value of Tile
   * @param column the column value of Tile
   */
  public void showValue (int row, int column)
  {
    gameboard[row][column].show();
  }  

  /** 
   * Checks if the Tiles in the two locations match.
   * 
   * If Tiles match, show Tiles in matched state and return a "matched" message
   * If Tiles do not match, re-hide Tiles (turn face down).
   * 
   * Preconditions:
   *   gameboard is populated with Tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row1 the row value of Tile 1
   * @param col1 the column value of Tile 1
   * @param row2 the row value of Tile 2
   * @param col2 the column vlue of Tile 2
   * @return a message indicating whether or not a match occured
   */
  public String checkForMatch(int row1, int col1, int row2, int col2)
  {
    
    String msg = "";

  if(gameboard[row1][col1].equals(gameboard[row2][col2]))
      { 
        gameboard[row1][col1].foundMatch();
        gameboard[row2][col2].foundMatch();
        msg = "You got a match!";
      }
     else
     {
      gameboard[row1][col1].hide();
      gameboard[row2][col2].hide();
    }
    
     return msg;
  }

  /** 
   * Checks the provided values fall within the range of the gameboard's dimension
   * and that the tile has not been previously matched
   * 
   * @param rpw the row value of Tile
   * @param col the column value of Tile
   * @return true if row and col fall on the board and the row,col tile is unmatched, false otherwise
   */
  public boolean validateSelection(int row, int col)
  {

    if(row>gameboard.length || row<0 || col <0 || col>gameboard[0].length || gameboard[row][col].matched())
      return false;
    
    return true;
  }

}
