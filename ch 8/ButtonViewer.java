import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;

public class ButtonViewer
{
    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 100;
    
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JButton button2;
    private JLabel label;
    
    public ButtonViewer()
    {
        frame = new JFrame();
        panel = new JPanel();
        button = new JButton( "A" );
        panel.add( button );
        
        button2 = new JButton("B");
        panel.add(button2);
        
        this.label = new JLabel();
        this.panel.add(this.label);
        
        frame.add(panel);
        
        ClickListener listener = new ClickListener();
        button.addActionListener( listener );
        
        button2.addActionListener( listener );
        
        frame.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible (true );
    }
    
    
    
    public static void main(String[] args)
    {
        ButtonViewer view = new ButtonViewer();
    }
   
    
    
    public class ClickListener implements ActionListener
    {
        private int count;
        private String string;
    
        public ClickListener()
        {
        
        }
    
        public void actionPerformed( ActionEvent event )
        {
            label.setText(event.getActionCommand());
        }
    }  
  }

