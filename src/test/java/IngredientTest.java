import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private IngredientType type = IngredientType.SAUCE;
    private String name = "Twister";
    private float price = 20.0f;

    // проверка работы метода getPrice
    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена должна быть равна" + price, price, ingredient.getPrice(), 0.001);
    }

    // проверка работы метода getName
    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Название должно быть равным" + name, name, ingredient.getName());
    }

    // проверка работы метода getType
    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Соус должен быть равным" + type, type, ingredient.getType());
    }
}
