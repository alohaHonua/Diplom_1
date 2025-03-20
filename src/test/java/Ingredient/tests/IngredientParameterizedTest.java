package Ingredient.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.expectedType = type;
        this.expectedName = name;
        this.expectedPrice = price;
    }

    @Parameterized.Parameters(name = "Ингридиент {1} тип {0} цена {2}")
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "Кетчуп", 1.5f},
                {IngredientType.FILLING, "Майонез", 2.5f},
                {IngredientType.SAUCE, "Кетчинез", 4f}
        };
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        IngredientType actualIngredientType = ingredient.getType();

        assertEquals("Ожидаемый тип ингридиента неверный", expectedType, actualIngredientType);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        String actualIngredient = ingredient.getName();

        assertEquals("Ожидаемое имя игридиента неверное", expectedName, actualIngredient);
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

        float actualIngredientPrice = ingredient.getPrice();

        assertEquals("Ожидаемая цена ингридиента неверна", expectedPrice, actualIngredientPrice, 0.01f);
    }
}
