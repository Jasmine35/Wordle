import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game
  {
    private int rowsTried;
    private String winningWord;
    private boolean win; 
    private int availableRows;
    private int winningRow;
    private int currentRow;
    private boolean endGame;

    public Game(int rows)
    {
      rowsTried = 0;
      availableRows = rows;
      currentRow = 0;
      int i = (int)(Math.random() * getRandomWords().size());
      winningWord = getRandomWords().get(i);
    }

    public void guessAgain(Word word)
    {
      availableRows--;
      rowsTried++;
      currentRow++;
      if(word.isResult(winningWord))
      {
        win = true;
        winningRow = rowsTried;
      }

      else
      {
        win = false;
      }
    }

    public int getWinningRow()
    {
      return winningRow;
    }
    
    public int getRowsTried()
    {
      return rowsTried;
    }

    
    /* returns -1 if game is lost; returns 0 if game is not done yet; returns 1 if game is won*/
    public int win()
    {
      if(win)
      {
        endGame = true;
        return 1;
      }

      else if(availableRows == 0)
      {
        endGame = true;
        return -1;
      }

      return 0;
    }
    
    public ArrayList<String> getRandomWords()
    {
        ArrayList<String> possibleWords = new ArrayList<String>();
        /*
        String home = System.getProperty("user.home");
        File file = new File(home + File.separator + "Users" + File.separator + "jasmine" + File.separator + "Downloads" + File.separator + "five-letter-words-master" + File.separator + "sgb-words.txt");
        */
        File file = new File("/Users/jasmine/Downloads/five-letter-words-master/sgb-words.txt");
        try
        {
            file.createNewFile();
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        try
        {   
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine())
            {
                possibleWords.add(scan.nextLine());
            }
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        return possibleWords;
    }

    public int getAvailableRows()
    {
      return availableRows;
    }

    public boolean getWin()
    {
      return win;
    }
    
    public String getWinningWord()
    {
        return winningWord;
    }
    
    public int getCurrentRow()
    {
        return currentRow;
    }
    
    public boolean returnEnd()
    {
        return endGame;
    }
    
    public boolean isAWord(Word word)
    {
        String w = "";
        
        for(int i = 0; i < word.getLetters().size(); i++)
        {
            w = w + word.getLetters().get(i).getLetter();
        }
        
        if(getRandomWords().indexOf(w) == -1)
        {
            return false;
        }
        
        else
        {
            return true;
        }
    }

  }