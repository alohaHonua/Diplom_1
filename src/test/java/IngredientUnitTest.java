import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientUnitTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    private Ingredient testIngredient;

    public IngredientUnitTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        testIngredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Параметры для теста Ingredient: {0}")
    public static Object[][] parameters() {
        return new Object[][]{
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000f},
                {IngredientType.SAUCE, "Соус фирменный Space Sauce", 80f}
        };
    }

    @Test
    public void testGetName() {
        assertEquals("Ошибка: название ингредиента не совпадает", name, testIngredient.name);
    }

    @Test
    public void testGetPrice() {
        assertEquals("Ошибка: цена ингредиента неверна", price, testIngredient.getPrice(), 0);
    }

    @Test
    public void testGetType() {
        assertEquals("Ошибка: тип ингредиента не совпадает", type, testIngredient.getType());
    }
}