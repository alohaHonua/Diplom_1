import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.ingredientType = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getPriceTest() {
        assertEquals("Цена ингредиента не соответствует ожидаемой", price, ingredient.getPrice(),0);
    }

    @Test
    public void getNameTest() {
        assertEquals("Название ингредиента не соответствует ожидаемому", name, ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        assertEquals("Тип ингредиента не соответствует ожидаемому", ingredientType, ingredient.getType());
    }
    }

