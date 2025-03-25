package praktikum;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedIngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final Ingredient ingredient;

    // Конструктор для инициализации параметров
    public ParameterizedIngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    // Набор тестовых данных
    @Parameterized.Parameters(name = "{index}: {0}, {1}, {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Кетчуп", 7f},
                {IngredientType.FILLING, "Ветчина", 20f},
                {IngredientType.SAUCE, "Майонез", 9f},
                {IngredientType.FILLING, "Колбаса", 14f}
        });
    }

    @Test
    public void testGetPrice() {
        // Проверяем, что Цена соответствует ожидаемому значению
        assertEquals(price, ingredient.getPrice(), 0.00001f);
    }

    @Test
    public void testGetName() {
        // Проверяем, что Имя совпадает с ожидаемым
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        // Проверяем, что Тип совпадает с ожидаемым
        assertEquals(type, ingredient.getType());
    }
}
