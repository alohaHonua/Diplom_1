package praktikum;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTests {

    private Bun bun;
    private Ingredient[] ingredients;
    private float expectedPrice;

    public BurgerParameterizedTests(Bun bun, Ingredient[] ingredients, float expectedPrice) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameters(name = "{index}: {0}, Ингредиенты: {1}, Ожидаемая Цена: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // Тестовые данные
                {new Bun("Классическая Булочка", 8f), new Ingredient[]{new Ingredient(IngredientType.SAUCE, "Кетчуп", 3f)}, 19f},
                {new Bun("Сладкая Булочка", 12f), new Ingredient[]{new Ingredient(IngredientType.FILLING, "Ветчина", 7f),
                        new Ingredient(IngredientType.SAUCE, "Майонез", 5f)}, 36f},
                {new Bun("Булочка с тмином", 9f), new Ingredient[]{new Ingredient(IngredientType.FILLING, "Колбаса", 6f),
                        new Ingredient(IngredientType.SAUCE, "Горчица", 4f)}, 28f},
        });
    }


    @Test
    public void testGetPriceWithParams() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        // Проверка цены
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }
}