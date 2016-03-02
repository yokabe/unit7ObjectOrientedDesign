import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends Shape
{
    private Rectangle2D.Double square;
    private DrawingPanel canvas;
    private double rad;
    private Color col;
    
    public Square(Point2D.Double center, double radius, Color color)
    {
       
        super(center, radius, color);
        this.rad = radius;
        this.col = color;
        double x = getCenter().getX() - getRadius();
        double y = getCenter().getY() - getRadius();
        double w = getRadius()*2;
        double h = getRadius()*2;
        square = new Rectangle2D.Double(x, y, w, h);
    }
    
    public boolean isInside(Point2D.Double point)
    {
        return square.contains(point.getX(), point.getY());
    
    }
    
    public void draw(Graphics2D g2, boolean filled)
    {
        g2.draw(square);
        if (filled)
        {
            g2.setColor(col);
            g2.fill(square);
        }
    }
}