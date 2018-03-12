package triangle;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleNegativeTests {

    Triangle triangle;

    private final String MESSAGE1 = "a<=0";
    private final String MESSAGE2 = "b<=0";
    private final String MESSAGE3 = "c<=0";
    private final String MESSAGE4 = "a+b<=c";
    private final String MESSAGE5 = "a+c<=b";
    private final String MESSAGE6 = "b+c<=a";


    @DataProvider(name = "CheckTriangleNegativeTests")
    public Object[] CheckTriangleTestsData() {
        return new Object[][]
                {
                        {new Double(-1), new Double(1.5), new Double(1.5), new Boolean(false), MESSAGE1},
                        {new Double(1), new Double(-1.5), new Double(1.5), new Boolean(false), MESSAGE2},
                        {new Double(1), new Double(1.5), new Double(-1.5), new Boolean(false), MESSAGE3},
                        {new Double(1), new Double(1), new Double(3), new Boolean(false), MESSAGE4},
                        {new Double(1), new Double(3), new Double(1), new Boolean(false), MESSAGE5},
                        {new Double(3), new Double(1), new Double(1), new Boolean(false), MESSAGE6},
                };
    }


    @Test(dataProvider = "CheckTriangleNegativeTests")
    public void CheckTriangleTest(double a, double b, double c, boolean bool, String mes) {
        this.triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.checkTriangle(), bool, "[Fail with sides of the triangle: a = " + a + ", b = " + b + ", c = " + c + ".]");
        Assert.assertEquals(triangle.getMessage(), mes, "[Fail with sides of the triangle: a = " + a + ", b = " + b + ", c = " + c + ".]");
    }

    @Test
    public void CheckTriangleNotNumberTest(){
        Assert.fail("The program doesn't implement the behavior when input side is not a number.");

    }

    @Test
    public void detectTriangleNegativeTest() {

        Assert.fail("The program doesn't implement the behavior when creating nonexistent triangles with zero and negative sides or when input side is not a number.");
    }

    @Test
    public void getSquareNegativeTest(){
        Assert.fail("The program doesn't implement the behavior when calculating the area of nonexistent triangles with zero and negative sides or when input side is not a number.");
    }





}