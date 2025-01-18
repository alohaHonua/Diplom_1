import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        IngredientType type = IngredientType.FILLING;
        String name = "Говяжий метеорит";
        float price = 3000f;
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceForIngredientReturnCorrectPriceTest() {
        float expectedPrice = 3000f;
        float actualPrice = ingredient.getPrice();
        assertEquals("Ожидаемый результат = " + expectedPrice + ", а должен быть = " + actualPrice, expectedPrice, actualPrice, 0.0001f);
    }

    @Test
    public void getNameForIngredientReturnCorrectNameTest() {
        String expectedName = "Говяжий метеорит";
        String actualName = ingredient.getName();
        assertEquals("Ожидаемый результат = " + expectedName + ", а должен быть = " + actualName, expectedName, actualName);
    }

    @Test
    public void getTypeForIngredientReturnCorrectTypeTest() {
        IngredientType expectedType = IngredientType.FILLING;
        IngredientType actualType = ingredient.getType();
        assertEquals("Ожидаемый результат = " + expectedType + ", а должен быть = " + actualType, expectedType, actualType);
    }
}
