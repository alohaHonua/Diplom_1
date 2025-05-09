package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {IngredientType.SAUCE, "Кетчуп", 50.0f},
                {IngredientType.FILLING, "Говядина", 200.0f},
                {IngredientType.SAUCE, "Горчица", 0.0f},  // Граничный случай: нулевая цена
                {IngredientType.FILLING, "", 100.0f}      // Граничный случай: пустое название
        };
    }

    // Тест конструктора и геттеров
    @Test
    public void testIngredientCreation() {
        assertEquals("Тип ингредиента должен совпадать", type, ingredient.getType());
        assertEquals("Название ингредиента должно совпадать", name, ingredient.getName());
        assertEquals("Цена ингредиента должна совпадать", price, ingredient.getPrice(), 0.001f);
    }

    // Дополнительный тест на сеттеры (если они появятся в классе)
    @Test
    public void testSettersIfPresent() {
        // Пример теста для гипотетических сеттеров
        Ingredient dummy = new Ingredient(IngredientType.SAUCE, "Чесночный соус", 80.0f);
        assertEquals("Чесночный соус", dummy.getName());
    }
}
