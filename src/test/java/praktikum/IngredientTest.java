package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Тест {index}: Тип {0} - Название {1} - Цена {2}")
    public static Object[][]getColor() {
        return new Object[][]{
                {SAUCE, "Русские символы", Float.MIN_VALUE},
                {FILLING, "Русские символы", Float.MAX_VALUE},
                {SAUCE, "LatinLetters", 100.000000000F},
                {FILLING, "", 100.000000000F},
                {SAUCE, null, 100.000000000F},
                {FILLING, "123", 100.000000000F},
                {SAUCE, "%:?", 100.000000000F},
                {FILLING, "Булка", 0.000000000F},
                {SAUCE, "Булка", -100.000000000F},
        };
    }
    @Test
    public void getTypeReturnTrueType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента с ошибкой", type, ingredient.getType());
    }
    @Test
    public void getNameReturnTrueName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Название с ошибкой", name, ingredient.getName());
    }
    @Test
    public void getPriceReturnTruePrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена с ошибкой", price, ingredient.getPrice(), 0);
    }
}
