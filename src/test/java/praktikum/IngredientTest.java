package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private static final String NAME = "Tomato";
    private static final float PRICE = 10f;
    private static final IngredientType TYPE = IngredientType.SAUCE;

    private static final Ingredient INGREDIENT = new Ingredient(TYPE, NAME, PRICE);

    @Test
    @DisplayName("тест геттера для атрибута \"цена\"")
    public void testGetPrice() {
        assertEquals(PRICE, INGREDIENT.getPrice(), 0.001f);
    }

    @Test
    @DisplayName("тест геттера для атрибута \"имя\"")
    public void testGetName() {
        assertEquals(NAME, INGREDIENT.getName());
    }

    @Test
    @DisplayName("тест геттера для атрибута \"тип\"")
    public void testGetType() {
        assertEquals(TYPE, INGREDIENT.getType());
    }
}