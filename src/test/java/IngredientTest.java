import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Тестовые данные {index}: type={0}, name={1}, price={2}")
    public static Object[][] data() {
        return new Object[][] {
                { IngredientType.FILLING, "Lettuce", 2.0f },
                { IngredientType.SAUCE, "Ketchup", 1.5f },
                { IngredientType.FILLING, "Patty", 5.0f },
                { IngredientType.SAUCE, "Mustard", 1.0f }
        };
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(type, ingredient.getType());
    }
}
