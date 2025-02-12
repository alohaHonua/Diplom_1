import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IngredientTest {
    private final String name;
    private final float price;
    private final IngredientType type;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип ингридиента, название, цена : {0}: {1}: {2}")
    public static Object[][] testsData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус Spicy-X", Float.MAX_VALUE},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", Float.MIN_NORMAL},
                {IngredientType.SAUCE, " ", Float.MIN_VALUE},
                {IngredientType.FILLING, null, -123},
                {null, null, 0}
        };
    }

    @Before
    public void setup() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getTypeWithValidDataTest() {
        assertEquals("Значение Тип ингридиент неверное", type, ingredient.getType());
    }

    @Test
    public void getNameWithValidDataTest() {
        assertEquals("Значение Имя неверное", name, ingredient.getName());
    }

    @Test
    public void getPriceWithValidDataTest() {
        assertEquals("Значение Цена неверное", price, ingredient.getPrice(), 0);
    }

}