import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class CircleFrame extends JFrame
{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    
   
    
    private int click;
    
    
    private CircleComponent scene;
    
    class MouseClickListener implements MouseListener
    {
        public void mouseClicked(MouseEvent event)
        {
            click++;
            if (click == 1)
            {
                double xC = event.getX();
                double yC = event.getY();
                scene.addPoint(xC, yC);
            }
            else if (click == 2)
            {
                double xH = event.getX();
                double yH = event.getX();
                scene.addPoint(xH, yH);
            }
            else
            {
                click = 0;
            }
        }
        // DO NOTHINGS
        public void mouseReleased(MouseEvent event){}
        public void mousePressed(MouseEvent event){}
        public void mouseEntered(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
        }
    
    
    public CircleFrame()
    {
        scene = new CircleComponent();
        add(scene);
        
        MouseListener listener = new MouseClickListener();
        scene.addMouseListener(listener);
        
        
        
        setSize(WIDTH, HEIGHT);
        
    }
}