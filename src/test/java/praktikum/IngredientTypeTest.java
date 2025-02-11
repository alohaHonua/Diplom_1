package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTypeTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] result() {
        return new Object[][]{
                {SAUCE, "Pesto", 1.5F},
                {FILLING, "Tomato", 2.4F}
        };
    }

    // Проверяем, что метод getType() возвращает тип иргридиента
    @Test
    public void getTypeReturnIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }

}