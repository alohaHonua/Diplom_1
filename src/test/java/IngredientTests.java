import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTests {
    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] ingredientParameters() {
        return new Object[][]{
                {IngredientType.FILLING, "cutlet", 100f},
                {IngredientType.FILLING, "dinosaur", 200f},
                {IngredientType.FILLING, "sausage", 300f},
                {IngredientType.SAUCE, "hot sauce", 100f},
                {IngredientType.SAUCE, "sour cream", 200f},
                {IngredientType.SAUCE, "chili sauce", 300f}
        };
    }

    @Test
    public void getPriceTest() {
        assertEquals("Некорректная цена!", price, ingredient.getPrice(), 0.000f);
    }

    @Test
    public void getNameTest() {
        assertEquals("Некорректное имя!", name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Некорректный тип!", type, ingredient.getType());
    }
}