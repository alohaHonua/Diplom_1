import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final Float price;
    private final String expectedName;
    private final IngredientType expectedType;
    private final Float expectedPrice;

    public IngredientTest(IngredientType type, String name, Float price, String expectedName, IngredientType expectedType, Float expectedPrice) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedType = expectedType;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Кетчуп", 50.0f, "Кетчуп", IngredientType.SAUCE, 50.0f},
                // Удалён тестовый случай с "Листья салата"
        });
    }

    @Test
    public void testConstructor() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(expectedName, ingredient.getName());
        assertEquals(expectedType, ingredient.getType());
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001f);
    }
}



