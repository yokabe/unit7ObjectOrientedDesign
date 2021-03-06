import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class TriangleFrame extends JFrame
{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    
   
    
    private int click;
    
    
    private TriangleComponent scene;
    
    class MouseClickListener implements MouseListener
    {
        public void mouseClicked(MouseEvent event)
        {
            double x = event.getX();
            double y = event.getY();
            scene.addPoint(x, y);
        }
        // DO NOTHINGS
        public void mouseReleased(MouseEvent event){}
        public void mousePressed(MouseEvent event){}
        public void mouseEntered(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
        }
    
    
    public TriangleFrame()
    {
        scene = new TriangleComponent();
        add(scene);
        
        MouseListener listener = new MouseClickListener();
        scene.addMouseListener(listener);
        
        
        
        setSize(WIDTH, HEIGHT);
        
    }
}