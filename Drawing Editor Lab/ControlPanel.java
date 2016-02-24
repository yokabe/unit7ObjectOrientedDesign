import java.awt.Button;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlPanel extends JPanel
{
    private Button pickColor;
    private Button circle;
    private Button square;
    
    private DrawingPanel canvas;
    
    private JPanel displayColor;
    
    public ControlPanel(DrawingPanel canvas)
    {
        pickColor = new Button("Pick Color");
        circle = new Button("Add Circle");
        square = new Button("Add Square");
        
        ClickListener l = new ClickListener();
        circle.addActionListener(l);
        pickColor.addActionListener(l);
        square.addActionListener(l);
        canvas = canvas;
        
        
        
        displayColor = new JPanel();
        displayColor.setBackground(canvas.getColor());
        add(pickColor);
        add(displayColor);
        add(circle);
        add(square);
        
        
    }
    
    public class ClickListener implements ActionListener
    {
        public ClickListener()
        {
        }
        
        public void actionPerformed(ActionEvent event)
        {
            if (event.getActionCommand().equals("Add Circle"))
            {
                canvas.addCircle();
            }
            else if (event.getActionCommand().equals("Add Square"))
            {
                canvas.addSquare();
            }
            else
            {
                
            }
            
        }
    }
    
}