import javax.swing.JFrame;
import java.awt.BorderLayout;

public class DrawingEditor extends JFrame
{
    private DrawingPanel canvas;
    
    private ControlPanel controls;
    
    public DrawingEditor()
    {
        canvas = new DrawingPanel();
        
        controls = new ControlPanel(canvas);
        
        setLayout(new BorderLayout());
        
        add(controls, BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);
        setTitle("Drawing Editor");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static void main(String[] args)
    {
        DrawingEditor ed = new DrawingEditor();
        ed.setVisible(true);
    }
   
}