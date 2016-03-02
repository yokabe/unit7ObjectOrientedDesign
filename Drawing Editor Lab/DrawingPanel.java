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

public class DrawingPanel extends JPanel
{
    private ArrayList<Shape> shapes;
    private Color currentColor;
    private JColorChooser chooseColor;
    private Point2D.Double point;
    private DrawingPanel panel;
    private int count;
    private Shape activeShape;
    
    public DrawingPanel()
    {
        setBackground(Color.WHITE);
        MouseListener mlistener = new MouseClickListener();
        MouseMotionListener molistener = new MouseMotion();
        KeyListener keyListener = new KeyClick();
        currentColor = Color.BLUE;
        point = new Point2D.Double(0, 0);
        
    }
    
    class MouseClickListener implements MouseListener
    {
        public void mouseClicked(MouseEvent event)
        {

        }
        // DO NOTHINGS
        public void mouseReleased(MouseEvent event){}
        public void mousePressed(MouseEvent event){}
        public void mouseEntered(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
    }
    
    class MouseMotion implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent event)
        {
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
        repaint();
    }
    
    public void addSquare()
    {
        Square s = new Square(point, 50, getColor());
        shapes.add(s);
        count++;
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
                s.draw(g2, true);
            }
        }
        
    }
}