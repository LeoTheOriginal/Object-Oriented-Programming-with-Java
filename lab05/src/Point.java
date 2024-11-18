public class Point extends Shape
{
    private double x;
    private double y;

    public Point( double x, double y )
    {
        this.x = x;
        this.y = y;
    }

    public String getName()
    {
        return "Point";
    }

    public double area()
    {
        return 0.0;
    }

    public double volume()
    {
        return 0.0;
    }

    public String toString()
    {
        return "[" + x + ", " + y + "]";
    }
}