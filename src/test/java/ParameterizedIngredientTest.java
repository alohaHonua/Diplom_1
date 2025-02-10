import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParameterizedIngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public ParameterizedIngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    //сокращаем кол-во тестов применяя pairwise технику
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "cutlet", 200},
                {IngredientType.SAUCE, "chili sauce", 300}
        };
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.001);
    }
}