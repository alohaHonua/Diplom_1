package Praktikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeSauce() {
        // Проверяем, что SAUCE равно SAUCE
        Assert.assertEquals(IngredientType.SAUCE, IngredientType.SAUCE);
    }

    @Test
    public void testIngredientTypeFilling() {
        // Проверяем, что FILLING равно FILLING
        Assert.assertEquals(IngredientType.FILLING, IngredientType.FILLING);
    }

    @Test
    public void testIngredientTypeCount() {
        // Проверяем, что количество элементов в IngredientType равно 2
        Assert.assertEquals(2, IngredientType.values().length);
    }

    @Test
    public void testIngredientTypeSauceName() {
        // Проверяем название элемента перечисления SAUCE
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testIngredientTypeFillingName() {
        // Проверяем название элемента перечисления FILLING
        Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }
}