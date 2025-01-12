import java.util.ArrayList; 

public class Word
  {
    private ArrayList<Letter> letters; //guessed word
    
    public Word()
    {
        letters = new ArrayList();
    }
    
    public void addLetter(Letter l)
    {
      letters.add(l);
    }
    
    public boolean isResult(String result)
    {
      if(letters.size() != 5)
      {
        return false;
      }
      for(int i = 0; i < letters.size(); i++)
        {
          if(!letters.get(i).isCorrectPosition(result))
          {
            return false;
          }
        }
      return true;
    }
    
    /*returns 1 if the color of the letter in the guessed word is green; 
     * returns 0 if the color of the guessed letter is yellow
     * returns -1 if the color of the guessed letter is grey
     * precondition: the length of the result and the guessed word should be equal */
    public int[] getColorAssignments(String result)
    {
        int[] colors = new int[5];
        for(int i = 0; i < letters.size(); i++)
        {
            if(letters.get(i).isCorrectPosition(result))
            {
                colors[i] = 1;
            }
            
            else if(letters.get(i).isInWord(result))
            {
                colors[i] = 0;
            }
            
            else
            {
                colors[i] = -1;
            }
        }
        
        return colors;
    }

    public ArrayList<Letter> getLetters()
    {
      return letters;
    }
    

  }