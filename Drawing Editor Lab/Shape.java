import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Shape
{
    private Point2D.Double cent;
    private double rad;
    private Color currColor;
    
    
    public Shape(Point2D.Double center, double radius, Color color)
    {
        cent = center;
        rad = radius;
        currColor = color;
    }
    

    public Color getColor()
    {
        return currColor;
    }
    public Point2D.Double getCenter()
    {
        return cent;
    }
    
    public double getRadius()
    {
        return rad;
    }
    
    public void move(double x, double y)
    {
        cent.setLocation(x, y);
    }
    
    public void setRadius(double r)
    {
        rad = r;
    }
    
    public abstract boolean isInside(Point2D.Double point);
    //     {
        //         boolean state = false;
        //         double x = point.getX();
        //         double y = point.getY();
        //         if (x <= cent.getX()+rad || x >= cent.getX()-rad)
        //         {
            //             if (y <= cent.getY()+rad || y >= cent.getY()-rad)
            //             {
                //                 state = true;
                //             }
                //         }
                //         return state;
                //     }
    
    public abstract void draw(Graphics2D g2, boolean filled);
    
}