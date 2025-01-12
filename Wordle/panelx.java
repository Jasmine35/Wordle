import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class panelx extends JFrame{
    //Creating a JPanel for the JFrame
        JPanel panel=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4 = new JPanel();
        JLabel label=new JLabel("Pick a difficulty!!");
        JButton button1=new JButton("new game: 4 rows");
        JButton button2 = new JButton("new game: 5 rows");
        JButton button3=new JButton("new game: 6 rows");
    panelx(){
        setTitle("Wordle Statistics");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(100,100,645,470);
        Border br = BorderFactory.createLineBorder(Color.BLACK);
        Container c =getContentPane();
        
        //setting the panel layout as null
        panel.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);


        panel.setBounds(10,10,300,200);
        //Panel 2
        panel2.setBounds(320,10,300,200);
        //Panel 3
        panel3.setBounds(10, 220, 250, 100);
        
        panel4.setBounds(320,220,300,200);
        
        
        //adding the panel to the Container of the JFrame
        c.add(panel);
        c.add(panel2);
        c.add(panel3);
        c.add(panel4);
    }
    
    public void display()
    {
        //adding a label element to the panel
        button3.addActionListener(rows6);
        button2.addActionListener(rows5);
        button1.addActionListener(rows4);
        
        label.setBounds(120,50,200,50);
        button1.setBounds(90,50,200,50);
        button2.setBounds(50,50,200,50);
        button3.setBounds(50,50,200,50);
    
        panel.add(label);
        panel2.add(button1);
        panel3.add(button2);
        panel4.add(button3);
        
        setVisible(true);
    }
    
    
    ActionListener rows4 = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Game game4 = new Game(4);
            Grid grid = new Grid();
            grid.executeGame(game4);
            
            
            display();
        }
    };
    
    ActionListener rows5 = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Game game5 = new Game(5);
            Grid grid = new Grid();
            grid.executeGame(game5);
            
            
            display();
        }
    };
    
    ActionListener rows6 = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Game game6 = new Game(6);
            Grid grid = new Grid();
            grid.executeGame(game6);
            
            display();
        }
    };
}