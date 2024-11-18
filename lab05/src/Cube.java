public class Cube extends Square
{
    private final double depth;

    public Cube(double side, double x, double y)
    {
        super(side, x, y);
        this.depth = 3.3;
    }

    public String getName()
    {
        return "Cube";
    }

    public double volume()
    {
        return super.area() * depth;
    }

    public double area()
    {
        return 2 * super.area() + 4 * side * depth;
    }

    public String toString()
    {
        return super.toString() + "; depth = " + depth;
    }
}