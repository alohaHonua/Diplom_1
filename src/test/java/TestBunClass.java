import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class TestBunClass {

    public final String name;
    public final float price;

    public TestBunClass(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getNameAndGetPrice(){
        return new Object[][]{
                {"Супер бургер", 10.0F}
        };
    }


    @Test
    public void testGetName(){
        Bun bun = new Bun(name, price);
        String expectedResult = bun.getName();
        System.out.println("Ожидаемый результат " + expectedResult);
        String actualResult = name;
        System.out.println("Фактический результат " + actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetPrice(){
        Bun bun = new Bun(name, price);
        float expected = bun.getPrice();
        System.out.println("Ожидаемый результат " + expected);
        float actual = price;
        System.out.println("Фактический результат " + actual);
        Assert.assertEquals(expected, actual, 0);
    }
}
