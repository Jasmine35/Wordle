

public class Tester
{
    public static void main(String[] args)
    {
        Game game = new Game(6);
        
        Word word = new Word();
        
        word.addLetter(new Letter("p", 0));
        word.addLetter(new Letter("l", 1));
        word.addLetter(new Letter("a", 2));
        word.addLetter(new Letter("c", 3));
        word.addLetter(new Letter("e", 4));
        
        
        System.out.println(game.getRandomWords().indexOf("place"));
        System.out.println(game.isAWord(word));
    }
}
