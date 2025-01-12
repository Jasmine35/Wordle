import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.font.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Grid {
  public void executeGame(Game newGame) {
    JTextField[][] grid = new JTextField[newGame.getAvailableRows()][5];
    int maxRows = newGame.getAvailableRows();
    JFrame frame = new JFrame("Wordle");
    frame.setSize(200,600);
    
    Container cp = frame.getContentPane();
    cp.setLayout(new GridLayout(maxRows, 5));
    
    for(int r = 0; r < maxRows; r++)
    {
        for(int c = 0; c < 5; c++)
        {
            grid[r][c] = new JTextField(3);
            Font f = new Font("Sans-Sherif", Font.BOLD, 50);
            grid[r][c].setFont(f);
            grid[r][c].setPreferredSize(new Dimension(200,200));
            grid[r][c].setHorizontalAlignment(JTextField.CENTER);
            cp.add(grid[r][c]);
        }
    }
    
    ActionListener action = new ActionListener()//this action is evoked so when the enter key is pressed, it checks all the words in the text boxes and changes the colors of the boxes
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int r = newGame.getCurrentRow();
            Word newGuess = new Word();
             for(int i = 0; i < 5; i++)
             {
                 String letter = grid[r][i].getText();
                 newGuess.addLetter(new Letter(letter, i));
             }
             
             if(newGame.isAWord(newGuess))
             {
                
            
                newGame.guessAgain(newGuess);
            
                int[] colorAssignments = newGuess.getColorAssignments(newGame.getWinningWord());
                for(int c = 0; c < 5; c++)
                {
                    if(colorAssignments[c] == 1)
                    {
                        grid[r][c].setBackground(Color.GREEN);
                    }
                
                    else if(colorAssignments[c] == 0)
                    {
                        grid[r][c].setBackground(Color.YELLOW);
                    }
                
                
                    else
                    {
                        grid[r][c].setBackground(Color.GRAY);
                    }  
                }
                
                if(r < maxRows)
                {
                    if(newGame.getWin())
                    {
                        reactionWindow reaction = new reactionWindow();
                        reaction.displayWinReaction(r);
                    }
                }
                
                if(r == maxRows - 1)
                {
                    if(newGame.getWin())
                    {
                        reactionWindow reaction = new reactionWindow();
                        reaction.displayWinReaction(r);
                    }
                    else
                    {
                        reactionWindow reaction = new reactionWindow();
                        reaction.displayLoseReaction(newGame.getWinningWord());
                    }
                    return;
                }
            
            
            } 
            
            else
            {
                reactionWindow reaction = new reactionWindow();
                reaction.displayNotAWord();
            }
        
        }
    
    };
        
        for(int i = 0; i < maxRows; i++)
        {
            grid[i][4].addActionListener(action);
        }


    
    frame.pack();
    frame.setVisible(true);
    
  }
  
  
}