package Praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTests {

    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    private Ingredient ingredient;

    public IngredientParameterizedTests(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters()
    public static Object[][] dataIngredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88.0f},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337.0f},
                {IngredientType.FILLING, "Сыр с астероидной плесенью", 4142.0f},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @After
    public void tearDown() {
        ingredient = null;
    }

    @Test
    public void checkGetPrice() {
        assertEquals(ingredientPrice, ingredient.getPrice(), 0.01);
    }

    @Test
    public void checkGetName() {
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void checkGetType() {
        assertEquals(ingredientType, ingredient.getType());
    }
}