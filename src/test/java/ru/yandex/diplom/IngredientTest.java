package ru.yandex.diplom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, "Карликодор", 19.9f);
    }

    @Test
    public void shouldReturnTrueGetName() {
        String actualName = ingredient.getName();
        assertEquals("Карликодор", actualName);
    }

    @Test
    public void shouldReturnTrueGetPrice() {
        float expectedPrice = 19.9f;
        float delta = 0.0f;
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, delta);
    }

}