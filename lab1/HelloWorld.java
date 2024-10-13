package lab1;

public class HelloWorld {
    public static void main(String[] args) {

        System.out.println("Hello " + "world!");

        System.out.println("*** Test strings ***");
        Examples.testStrings();

        System.out.println("*** Test numbers ***");
        Examples ob = new Examples();
        System.out.println("" + ob.testNumbers());

        System.out.println("**************************");
        Examples newOb = new Examples();
        System.out.print(ob.equals(newOb));
        System.out.println(" " + ob.equals(newOb));
    }
}

class Examples {
    private float numberOne;

    public static void testStrings() {
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.print(s1.equals(s2));
        System.out.println(" " + s1.equals(s2));

        String s3 = new String("Hello");
        String s4 = new String("Hello");
        System.out.print(s3.equals(s4));
        System.out.println(" " + s3.equals(s4));

        s2 = s2.toUpperCase();
        System.out.print(s1==s2);
        System.out.println(" " + s1.equals(s2));
    }

    public double testNumbers() {
        System.out.println(1 + 2);
        System.out.println("1 + 2 = " + (1 + 2));

        float numberTwo = 4.5f;
        System.out.println("numberOne = " + numberOne);
        System.out.println("numberTwo = " + numberTwo);

        double[] arrayOne = {7.2, 13.6, 21.5, 2};
        double[] arrayTwo = new double[2];
        arrayTwo[0] = 3;

        return Math.min(arrayOne[0], arrayTwo[0]);
    }
}
