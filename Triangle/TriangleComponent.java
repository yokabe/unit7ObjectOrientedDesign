import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import java.awt.geom.Point2D;
public class TriangleComponent extends JComponent
{
    private double p1X;
    private double p1Y;
    
    private double p2X;
    private double p2Y;
    
    private double p3X;
    private double p3Y;
    
    private Line2D.Double line1;
    private Line2D.Double line2;
    private Line2D.Double line3;
    
    private int click;
    
    public TriangleComponent()
    {
        line1 = new Line2D.Double();
        line2 = new Line2D.Double();
        line3 = new Line2D.Double();
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if (click == 2)
        {
            line1.setLine(p1X, p2X, p1Y, p2Y);
            g2.draw(line1);
        }
        
    }
    
    public void addPoint(double x, double y)
    {
        click++;
        if (click == 1)
        {
            p1X = x;
            p1Y = y;
        }
        else if (click ==2)
        {
            p2X = x;
            p2Y = y;
        }
    }
    
}