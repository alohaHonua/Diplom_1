import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    private Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;

    }

    @Before
    public void initializeIngredient() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Parameterized.Parameters(name = "Тестовые данные для теста Ingredient: {0}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000f},
                {IngredientType.SAUCE, "Соус фирменный Space Sauce", 80f}
        };
    }

    @Test
    public void getNameTest() {
        assertEquals("Ошибка. Должно было передаться название ингридиента", ingredientName, ingredient.name);
    }

    @Test
    public void getPriceTest() {
        assertEquals("Ошибка. Должна была передаться цена ингридиента", ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeTest() {
        assertEquals("Ошибка! Должен был передаться ингредиент", ingredientType, ingredient.getType());
    }
}
