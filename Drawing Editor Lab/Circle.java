import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape
{
    
    
    public Circle(Point2D.Double center, double radius, Color color)
    {
       
        super(center, radius, color);
        
    }
    
    public boolean isInside(Point2D.Double point)
    {
        double x = getCenter().getX() - getRadius();
        double y = getCenter().getY() - getRadius();
        double w = getRadius()*2;
        double h = getRadius()*2;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, w, h);
        return circle.contains(point.getX(), point.getY());
    
    }
    
    public void draw(Graphics2D g2, boolean filled)
    {
        double x = getCenter().getX() - getRadius();
        double y = getCenter().getY() - getRadius();
        double w = getRadius()*2;
        double h = getRadius()*2;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, w, h);
        g2.draw(circle);
        if (filled)
        {
            g2.setColor(super.getColor());
            g2.fill(circle);
        }
    }
}