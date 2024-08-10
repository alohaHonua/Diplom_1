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
public class IngredientTests {
    private Ingredient ingredient;
    private final String expectedIngredientName;
    private final float expectedIngredientPrice;
    private  final IngredientType expectedIngredientType;

    public IngredientTests(IngredientType expectedIngredientType, String expectedIngredientName, float expectedIngredientPrice) {
        this.expectedIngredientType = expectedIngredientType;
        this.expectedIngredientName = expectedIngredientName;
        this.expectedIngredientPrice = expectedIngredientPrice;
    }

    @Parameterized.Parameters(name = "тип ингредиента: {0}, название ингредиента: {1}, цена ингредиента: {2}")
    public static Object[][] getDataIngredient() {
        return  new Object[][] {
                {SAUCE, "Соус Spicy-X", 90.5F},
                {FILLING, "Говяжий метеорит (отбивная)", 50.5F},
                {SAUCE, "Соус традиционный галактический", 100.5F},
                {FILLING, "Биокотлета из марсианской Магнолии", 250.5F}
        };
    }
    @Before
    public void createObject() {
        ingredient = new Ingredient(expectedIngredientType, expectedIngredientName, expectedIngredientPrice); // Создание ингредиента
    }

    @Test
    public void getPriceTest() {
        float actualIngredientPrice = ingredient.getPrice();
        assertEquals("Неверная цена ингредиента", expectedIngredientPrice, actualIngredientPrice, 0.0001F); // Проверка цены ингредиента
    }
    @Test
    public void getNameTest() {
        String actualIngredientName = ingredient.getName();
        assertEquals("Неверное название ингредиента", expectedIngredientName, actualIngredientName); // Проверка корректного названия ингредиента
    }
    @Test
    public void getTypeTest() {
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals("Неверный тип ингредиента", expectedIngredientType, actualIngredientType); // Проверка корректного типа ингредиента
    }
}
