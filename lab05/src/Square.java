public class Square extends Point
{
    protected double side;

    public Square(double side, double x, double y)
    {
        super(x, y);
        this.side = side;
    }

    public String getName()
    {
        return "Square";
    }

    public double area()
    {
        return side * side;
    }

    public String toString()
    {
        return "Corner = " + super.toString() + "; side = " + side;
    }
}