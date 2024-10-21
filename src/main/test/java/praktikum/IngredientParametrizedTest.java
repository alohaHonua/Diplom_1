package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    // метод возвращает массив объектов - набор параметров для тестов.
    // Каждый внутренний массив соответствует одному набору тестовых данных
    @Parameterized.Parameters(name = "{index} : type = {0}")
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "chili", 20.0f},
                {IngredientType.FILLING, "cheese", 15.5f},
                {null, null, 0.0f}
        };
    }

    // Проверяю, правильно ли класс Ingredient возвращает тип ингредиента
    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();

        assertEquals("Incorrect values ingredient type", type, actual);
    }
}