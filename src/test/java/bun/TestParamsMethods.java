package bun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestParamsMethods {
    public String name;
    public float price;

    public TestParamsMethods(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParamsInit(){
        return new Object[][]{
                {
                        "testBun", 100F
                },
                {
                        "1edsef4v3fqa", -1F
                },
                {
                        "Kek", 0F
                }

        };
    }

    @Test
    public void testConstructor(){
        Bun ingredient = new Bun(name, price);
        assertEquals("Wrong ingredient name", name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001);
    }
}
