package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

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

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Кетчуп", 0.52f},
                {IngredientType.FILLING, "Бекон", 115.0f},
                {IngredientType.SAUCE, "Кетчунез", 1.8f}
        };
    }

    //Проверяем, что геттеры возвращают значения, переданные через конструктор Ingredient.
    @Test
    public void returnCorrectIngredientValuesTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента не совпадает", type, ingredient.getType());
        assertEquals("Имя ингредиента не совпадает", name, ingredient.getName());
        assertEquals("Цена ингредиента не совпадает", price, ingredient.getPrice(), 0.001f);
    }
}
