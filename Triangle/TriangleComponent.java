import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

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
            line1.setLine(p1X, p1Y, p2X, p2Y);
            g2.draw(line1);
        }
        else if (click == 3)
        {
            g2.draw(line1);
            line2.setLine(p2X, p2Y, p3X, p3Y);
            line3.setLine(p1X, p1Y, p3X, p3Y);
            g2.draw(line2);
            g2.draw(line3);
        }
        else
        {
            
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
        else if (click == 3)
        {
            p3X = x;
            p3Y = y;
        }
        else
        {
            click = 0;
        }
        repaint();
    }
    
}