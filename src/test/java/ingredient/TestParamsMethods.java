package ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestParamsMethods {
    public IngredientType type;
    public String name;
    public float price;

    public TestParamsMethods(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParamsInit(){
        return new Object[][]{
                {
                        IngredientType.SAUCE, "sauce", 100F
                },
                {
                        IngredientType.SAUCE, "sauce", -1F
                },
                {
                        IngredientType.FILLING, "filling", 0F
                }

        };
    }

    @Test
    public void testConstructor(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Wrong ingredient type", type, ingredient.getType());
        assertEquals("Wrong ingredient name", name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001);
    }
}
