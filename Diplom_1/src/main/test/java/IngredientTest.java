import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { IngredientType.FILLING, "Lettuce", 0.50f },
                { IngredientType.FILLING, "Tomato", 0.75f },
                { IngredientType.SAUCE, "Ketchup", 0.25f },
                { IngredientType.SAUCE, "Mustard", 0.30f }
        });
    }

    @Test
    public void testIngredient() {
        // Arrange
        Ingredient ingredient = new Ingredient(type, name, price);

        // Act & Assert
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001);
    }
}
