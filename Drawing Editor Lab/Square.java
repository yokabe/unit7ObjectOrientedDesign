import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends Shape
{
    
    
    public Square(Point2D.Double center, double radius, Color color)
    {
       
        super(center, radius, color);
    
    }
    
    public boolean isInside(Point2D.Double point)
    {
        double x = getCenter().getX() - getRadius();
        double y = getCenter().getY() - getRadius();
        double w = getRadius()*2;
        double h = getRadius()*2;
        Rectangle2D.Double square = new Rectangle2D.Double(x, y, w, h);
        return square.contains(point.getX(), point.getY());
    
    }
    
    public void draw(Graphics2D g2, boolean filled)
    {
        double x = getCenter().getX() - getRadius();
        double y = getCenter().getY() - getRadius();
        double w = getRadius()*2;
        double h = getRadius()*2;
        Rectangle2D.Double square = new Rectangle2D.Double(x, y, w, h);
        DrawingPanel pan = new DrawingPanel();
        
        g2.draw(square);
        if (filled)
        {
            g2.setColor(pan.getColor());
            g2.fill(square);
        }
    }
}