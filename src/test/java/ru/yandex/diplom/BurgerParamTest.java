package ru.yandex.diplom;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(Parameterized.class)
public class BurgerParamTest {

    @Mock
    private Ingredient ingredients;

    @Mock
    private Bun bun;

    private float ingredientsPrice;

    private float bunPrice;

    private float exPrice;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    public BurgerParamTest(float ingredientsPrice, float bunPrice, float exPrice) {
        this.ingredientsPrice = ingredientsPrice;
        this.bunPrice = bunPrice;
        this.exPrice = exPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {100.0f, 100.0f, 300.0f},
                {200.0f, 100.0f, 400.0f}
        };
    }

    @Test
    public void burgerGetPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredients.getPrice()).thenReturn(ingredientsPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredients);
        Assert.assertEquals(exPrice, burger.getPrice(), 0.1);
    }
}