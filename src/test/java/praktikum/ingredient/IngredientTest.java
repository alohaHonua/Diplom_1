package praktikum.ingredient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import praktikum.TestConstants;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final float expectedPrice;

    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price, float expectedPrice) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TestConstants.INGREDIENT1_TYPE, TestConstants.INGREDIENT1_NAME, TestConstants.INGREDIENT1_PRICE, TestConstants.INGREDIENT1_PRICE},
                {TestConstants.INGREDIENT2_TYPE, TestConstants.INGREDIENT2_NAME, TestConstants.INGREDIENT2_PRICE, TestConstants.INGREDIENT2_PRICE},
                {TestConstants.INGREDIENT3_TYPE, TestConstants.INGREDIENT3_NAME, TestConstants.INGREDIENT3_PRICE, TestConstants.INGREDIENT3_PRICE}
        });
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    // Проверка имени ингредиента
    @Test
    public void testGetIngredientName() {
        assertEquals(name, ingredient.getName());
    }

    // Проверка типа ингредиента
    @Test
    public void testGetIngredientType() {
        assertEquals(type, ingredient.getType());
    }

    // Проверка цены ингредиента
    @Test
    public void testGetIngredientPrice() {
        assertEquals(expectedPrice, ingredient.getPrice(), TestConstants.DELTA);
    }
}
