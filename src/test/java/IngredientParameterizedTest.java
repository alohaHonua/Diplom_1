import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private IngredientType type;
    private String name;
    private float price;

    private final float DELTA = 0.0f;

    private Ingredient ingredient;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Chicken", 1.3f},
                {IngredientType.FILLING, "Beef", 1.5f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceTest() {
        assertEquals("Цена ингредиента", price, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getNameTest() {
        assertEquals("Наименование ингредиента",name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Тип ингредиента", type, ingredient.getType());
    }

}

