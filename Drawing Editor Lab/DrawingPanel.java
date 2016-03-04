import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.util.Random;

public class DrawingPanel extends JPanel
{
    private ArrayList<Shape> shapes;
    private Color currentColor;
    private JColorChooser chooseColor;
    private Point2D.Double point;
    private DrawingPanel panel;
    private int count;
    private Shape activeShape;
    private boolean state;
    private static final double X = 150;
    private static final double Y = 150;
    public DrawingPanel()
    {
        setBackground(Color.WHITE);
        MouseListener mlistener = new MouseClickListener();
        MouseMotionListener zlistener = new MouseClickListener();
        this.addMouseListener(mlistener);
        this.addMouseMotionListener(zlistener);
        
        KeyListener keyListener = new KeyClick();
        currentColor = Color.BLUE;
        
        Random r1 = new Random();
        point = new Point2D.Double(X, Y);
        
        shapes = new ArrayList<Shape>();
    }
    
    class MouseClickListener implements MouseListener, MouseMotionListener
    {
        public void mouseClicked(MouseEvent event)
        {
        }
        // DO NOTHINGS
        public void mouseReleased(MouseEvent event)
        {
            state = true;
            repaint();
        }
        public void mousePressed(MouseEvent event)
        {
            int count = 0;
            if (count ==0)
            {
                double x = event.getX();
                double y = event.getY();
                Point2D.Double a = new Point2D.Double(x, y);
                for (Shape s : shapes)
                {
                    if (s.isInside(a))
                    {
                        activeShape = s;
                        state = true;
                    }   
                }
                state = false;
                repaint();
            }
           
        }
        public void mouseEntered(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
        public void mouseDragged(MouseEvent event)
        {
            if (activeShape != null)
            {
                activeShape.move(event.getX(), event.getY());
                
                repaint();
            }
        }
        public void mouseMoved(MouseEvent event){}
    }
 
    
    class KeyClick implements KeyListener
    {
        public void keyPressed(KeyEvent event)
        {
        }
        public void keyReleased(KeyEvent event){}
        public void keyTyped(KeyEvent event){}
    }
    
    public Color getColor()
    {
        return currentColor;
    }
    
    public void pickColor()
    {
        
        currentColor = JColorChooser.showDialog(this, "Pick a Color", Color.BLUE);
        
    }
    
    public void addCircle()
    {
       
        Circle c = new Circle(point, 50, getColor());
        shapes.add(c);
        count++;
        System.out.println(shapes);
        repaint();
    }
    
    public void addSquare()
    {
        Square s = new Square(point, 50, getColor());
        shapes.add(s);
        count++;    
        System.out.println(shapes);
        repaint();
    }
    
    public Dimension getPreferredSize()
    {
        return getSize();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if ( count != 0)
        {
            for (Shape s : shapes)
            {
                if (s != activeShape)
                {
                    s.draw(g2, true);
                }
                else
                {
                    activeShape.draw(g2, state);
                }
              
            }
        }
        
        
        
    }
}