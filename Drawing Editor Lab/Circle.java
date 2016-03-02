import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape
{
    private Ellipse2D.Double circle;
    private DrawingPanel canvas;
    private double rad;
    private Color col;
    
    public Circle(Point2D.Double center, double radius, Color color)
    {
       
        super(center, radius, color);
        this.rad = radius;
        this.col = color;
        double x = getCenter().getX() - getRadius();
        double y = getCenter().getY() - getRadius();
        double w = getRadius()*2;
        double h = getRadius()*2;
        circle = new Ellipse2D.Double(x, y, w, h);
    }
    
    public boolean isInside(Point2D.Double point)
    {
        boolean state = false;
        double x = point.getX();
        double y = point.getY();
        if (x <= getCenter().getX()+rad || x >= getCenter().getX()-rad)
        {
            if (y <= getCenter().getY()+rad || y >= getCenter().getY()-rad)
            {
                state = true;
            }
        }
        return state;
    
    }
    
    public void draw(Graphics2D g2, boolean filled)
    {
        g2.draw(circle);
        if (filled)
        {
            g2.setColor(col);
            g2.fill(circle);
        }
    }
}