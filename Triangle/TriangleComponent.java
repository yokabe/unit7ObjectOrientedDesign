import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D.Double;
import javax.swing.JComponent;

public class TriangleComponent extends JComponent
{
    private double currentX;
    private double currentY;
    
    private double prevX;
    private double prevY;
    
    
    public TriangleComponent(double x1, double y1, double x2, double y2)
    {
        
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Line2D.Double line = new Line2D.Double();
    }
}