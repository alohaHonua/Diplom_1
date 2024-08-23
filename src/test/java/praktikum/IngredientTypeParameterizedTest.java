package praktikum;

import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {
    IngredientType ingredientType;
    String ingredientTypeString;

    @Parameterized.Parameters
    public static Object[][] ingredientsType() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }

    public IngredientTypeParameterizedTest(IngredientType ingredientType, String ingredientTypeString) {
        this.ingredientType = ingredientType;
        this.ingredientTypeString = ingredientTypeString;
    }

    @Test
    @DisplayName("Проверка перечислений с типами ингредиентов")
    public void contentIngredientType() {
        assertEquals(ingredientType, IngredientType.valueOf(ingredientTypeString));
    }

}
