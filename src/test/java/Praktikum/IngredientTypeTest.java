package Praktikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        // Проверяем, что SAUCE равно SAUCE
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.SAUCE);

        // Проверяем, что FILLING равно FILLING
        Assert.assertEquals(IngredientType.FILLING, IngredientType.FILLING);
    }

    @Test
    public void testIngredientTypeCount() {
        // Проверяем, что количество элементов в IngredientType равно 2
        Assert.assertEquals(2, IngredientType.values().length);
    }

    @Test
    public void testIngredientTypeNames() {
        // Проверяем названия элементов перечисления
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
        Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }
}