package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    /**
     * Проверка, что перечисление SAUCE содержит правильное имя
     */
    @Test
    public void sauceEnumToStringTest() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    /**
     * Проверка, что перечисление FILLING содержит правильное имя
     */
    @Test
    public void fillingEnumToStringTest() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }

    /**
     * Проверка количества значений в перечислении
     */
    @Test
    public void enumValuesCountTest() {
        assertEquals(2, IngredientType.values().length);
    }

    /**
     * Проверка доступа к значению по индексу
     */
    @Test
    public void enumAccessByIndexTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.values()[0]);
        assertEquals(IngredientType.FILLING, IngredientType.values()[1]);
    }
}
