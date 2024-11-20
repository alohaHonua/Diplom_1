package ru.yandex.diplom;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTypeTest {

    @Test
    public void testSauce() {
        IngredientType expectedType = IngredientType.valueOf("SAUCE");
        IngredientType actualType = IngredientType.SAUCE;
        Assert.assertEquals(expectedType, actualType);
    }

    @Test
    public void tesFilling() {
        IngredientType expectedType = IngredientType.valueOf("FILLING");
        IngredientType actualType = IngredientType.FILLING;
        Assert.assertEquals(expectedType, actualType);
    }
}
