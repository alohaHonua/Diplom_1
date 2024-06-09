package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.enums.Ingredients.*;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    IngredientType type;
    String name;
    Float price;
    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "type: \"{0}\", name: \"{1}\" price: {2}")
    public static Object[][] getBuns() {
        return new Object[][]{
                {SAUCE_SPICY.getType(), SAUCE_SPICY.getName(), SAUCE_SPICY.getPrice()},
                {SAUCE_SPACE.getType(), SAUCE_SPACE.getName(), SAUCE_SPACE.getPrice()},
                {FILLING_BEEF.getType(), FILLING_BEEF.getName(), FILLING_BEEF.getPrice()},
                {FILLING_MARS.getType(), FILLING_MARS.getName(), FILLING_MARS.getPrice()},
        };
    }

    @Test
    public void checkBuns() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ошибка в типе ингридиента", type, ingredient.getType());
        assertEquals("Ошибка в имени ингридиента", name, ingredient.getName());
        assertEquals("Ошибка в цене ингридиента", price, ingredient.getPrice(),0);
    }
}
