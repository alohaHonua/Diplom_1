import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(String name, float price, IngredientType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"hot sauce", 100, SAUCE},
                {"sour cream", 200, SAUCE},
                {"chili sauce", 300, SAUCE},
                {"cutlet", 100, FILLING},
                {"dinosaur", 200, FILLING},
                {"sausage", 300, FILLING}
        };
    }

    @Test
    public void getNameTest () {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest () {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeTest () {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}
