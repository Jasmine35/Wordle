public class Letter
  {
    private String letter; //one character letter

    private int index; //index of guessed word

    /* precondition: parameter l is length 1*/
    public Letter(String l, int i)
    {
      letter = l;
      index = i;
    }

    public boolean isInWord(String word)
    {
      for(int i = 0; i < word.length(); i++)
        {
          if(word.indexOf(letter) != -1)
          {
            return true;
          }
        }

      return false;
    }

    public boolean isCorrectPosition(String word)
    {
      if(isInWord(word) && (letter.equals(word.substring(index, index + 1))))
      {
        return true;
      }

      return false;
    }

    public int getIndex()
    {
      return index;
    }
    
    public String getLetter()
    {
        return letter;
    }
  }