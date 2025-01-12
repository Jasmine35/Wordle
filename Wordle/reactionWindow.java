import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Write a description of class reactionWindow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class reactionWindow
{
    
    public String getWinReaction(int row)
    {
        if(row < 3)
        {
            return "Impressive!";
        }
        
        if(row<6)
        {
            return "Great!";
        }
        
        else
        {
            return "Phew!";
        }
    }
    
    public void displayWinReaction(int row)
    {
        JFrame reaction = new JFrame();
        
        JLabel text = new JLabel(getWinReaction(row));
        
        text.setBounds(200, 200, 200, 200);
        text.setHorizontalAlignment(JLabel.CENTER);
        reaction.setBounds(200,200,200,200);
        
        reaction.add(text);
        
        reaction.pack();
        reaction.setVisible(true);
    }
    
    public void displayLoseReaction(String actualWord)
    {
        JFrame reaction = new JFrame();
        
        JLabel text = new JLabel(actualWord);
        
        text.setBounds(200, 200, 200, 200);
        text.setHorizontalAlignment(JLabel.CENTER);
        reaction.setBounds(200,200,200,200);
        
        reaction.add(text);
        
        reaction.pack();
        reaction.setVisible(true);
    }
    
    public void displayNotAWord()
    {
        JFrame reaction = new JFrame();
        
        JLabel text = new JLabel("not a word");
        
        text.setBounds(200, 200, 200, 200);
        text.setHorizontalAlignment(JLabel.CENTER);
        reaction.setBounds(200,200,200,200);
        
        reaction.add(text);
        
        reaction.pack();
        reaction.setVisible(true);
    }
}
