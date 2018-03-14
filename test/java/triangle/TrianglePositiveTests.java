package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TrianglePositiveTests {

    Triangle triangle;
    final int TR_EQUILATERAL = 1; // равносторонний
    final int TR_ISOSCELES = 2;   // равнобедренный
    final int TR_ORDINARY = 4;    // обычный
    final int TR_RECTANGULAR = 8;// прямоугольный

    @DataProvider(name = "CheckTrianglePositiveTests")
    public Object[] CheckTrianglePositiveTests() {
        return new Object[][]
                {
                        {new Double(1), new Double(1.5), new Double(1.5), new Boolean(true)},
                };
    }

    @DataProvider(name = "getSquarePositiveTest")
    public Object[] getSquarePositiveTestsData() {
        return new Object[][]
                {
                        {new Double(2), new Double(2.3), new Double(2.3), new Double(2.071), new Double(0.001)},
                };
    }

    @DataProvider(name = "detectTrianglePositiveTest")
    public Object[] detectTrianglePositiveTestData() {
        return new Object[][]
                {
                        {new Double(3.3), new Double(4.4), new Double(5.5), TR_RECTANGULAR},
                        {new Double(3.3), new Double(5.5), new Double(4.4), TR_RECTANGULAR},
                        {new Double(5.5), new Double(4.4), new Double(3.3), TR_RECTANGULAR},
                        {new Double(3.2), new Double(4.3), new Double(4.3), TR_ISOSCELES},
                        {new Double(4.86), new Double(4.86), new Double(4.86), TR_EQUILATERAL+TR_ISOSCELES},
                        {new Double(3.35), new Double(4.86), new Double(5.63), TR_ORDINARY},
                        {new Double(3.32), new Double(3.32), new Double(Math.sqrt(3.32*3.32 + 3.32*3.32)), TR_ISOSCELES+TR_RECTANGULAR},
                };
    }


    @Test(dataProvider = "CheckTrianglePositiveTests")
    public void CheckTrianglePositiveTest(double a, double b, double c, boolean bool) {
        this.triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.checkTriangle(), bool);
    }

    @Test(dataProvider = "getSquarePositiveTest")
    public void getSquarePositiveTest(double a, double b, double c, double expect_result, double comparison_accuracy) {
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.getSquare(), expect_result, comparison_accuracy);
    }

    @Test(dataProvider = "detectTrianglePositiveTest")
    public void detectTrianglePositiveTest(double a, double b, double c, int expect_result) {
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.detectTriangle(), expect_result, "[Fail with sides of the triangle: a = " + a + ", b = " + b + ", c = " + c + ".]");
    }
    @Test
    public void ConstructorPositiveTest(){
        Assert.fail("[It is impossible to test the constructor 'public Triangle (double a, double b, double c)' because there is no access to the fields of the class 'Triangle'.]");
    }
}
