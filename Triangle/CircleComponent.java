import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class CircleComponent extends JComponent
{
    private double p1X;
    private double p1Y;
    
    private double p2X;
    private double p2Y;
    
    private double distance;
    
    
    private Ellipse2D.Double circle;
    
    private int click;
    
    public CircleComponent()
    {
        circle = new Ellipse2D.Double();
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if (click == 2)
        {
            double x = p1X + distance/2;
            double y = p1Y + distance/2;
            circle.setFrame(x, y, distance/2, distance/2);
            g2.draw(circle);
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
            distance = Math.sqrt(((p2X - p1X)*(p2X - p1X))+((p2Y - p1Y)*(p2Y - p1Y)));
        }
        else
        {
            click = 0;
        }
        repaint();
    }
    
}