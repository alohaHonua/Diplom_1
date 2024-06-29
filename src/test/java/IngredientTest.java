import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void NewIngredient() {
        ingredient = new Ingredient(IngredientType.SAUCE, "chili", 20.0f);
    }

    @Test
    public void getName() {
        String expected = "chili";
        String actual = ingredient.getName();

        assertEquals("Неверное название ингредиента", expected, actual);
    }

    @Test
    public void getPrice() {
        float expected = 20.0f;
        float actual = ingredient.getPrice();

        assertEquals("Неверная цена ингредиента", expected, actual, 0);
    }

    @Test
    public void getType() {
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();

        assertEquals("Неверное значение тип ингредиента", expected, actual);
    }
}
