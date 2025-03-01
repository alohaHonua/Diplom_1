package praktikum;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testIngredientType() {

        IngredientType[] values = IngredientType.values();

        assertEquals("В перечислении типов ингредиентов должно быть 2 значения", 2, values.length);

        // Проверяем, что значения совпадают с ожидаемыми
        assertEquals("Первое значение в перечислении типов ингредиентов - соус", IngredientType.SAUCE, values[0]);
        assertEquals("Второе значение в перечислении типов ингредиентов - начинка", IngredientType.FILLING, values[1]);
    }
}