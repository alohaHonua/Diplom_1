package tests;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeContainsSauceAndFilling() {
        // Проверяем значения перечисления
        IngredientType[] expectedValues = {IngredientType.SAUCE, IngredientType.FILLING};

        // Act
        IngredientType[] actualValues = IngredientType.values();

        // Assert
        assertArrayEquals("IngredientType should contain SAUCE and FILLING", expectedValues, actualValues);
    }

    @Test
    public void testValueOfReturnsCorrectEnum() {
        // Проверяем метод valueOf
        assertEquals("valueOf should return SAUCE for 'SAUCE'", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals("valueOf should return FILLING for 'FILLING'", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfThrowsExceptionForInvalidName() {
        // Проверяем, что valueOf выбрасывает исключение для неверного имени
        IngredientType.valueOf("INVALID");
    }
}
