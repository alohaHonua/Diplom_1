import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeHasTwoCountTest() {
        int actualCount = IngredientType.values().length;
        assertEquals("Количество типов ингредиентов должно быть равно 2", 2, actualCount);
    }

    @Test
    public void ingredientTypeContainsSauceTest() {
        boolean isSauceInEnum = false;

        for (IngredientType type : IngredientType.values()) {
            if (type == IngredientType.SAUCE) {
                isSauceInEnum = true;
                break;
            }
        }
        assertTrue("Ingredient Type должен содержать SAUCE", isSauceInEnum);
    }

    @Test
    public void ingredientTypeContainsFillingTest() {
        boolean isFillingInEnum = false;

        for (IngredientType type : IngredientType.values()) {
            if (type == IngredientType.SAUCE) {
                isFillingInEnum = true;
                break;
            }
        }
        assertTrue("Ingredient Type должен содержать SAUCE", isFillingInEnum);
    }
}
