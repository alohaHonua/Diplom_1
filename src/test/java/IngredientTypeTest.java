import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IngredientTypeTest {

    @Test
    public void testSauceType() {
        // ѕровер€ем, что тип SAUCE имеет правильное значение
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testFillingType() {
        // ѕровер€ем, что тип FILLING имеет правильное значение
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void testNumberOfTypes() {
        // ѕровер€ем, что у перечислени€ IngredientType всего 2 значени€
        assertEquals(2, IngredientType.values().length);
    }

    @Test
    public void testContainsSauce() {
        // ѕровер€ем, что перечисление содержит тип SAUCE
        boolean containsSauce = false;
        for (IngredientType type : IngredientType.values()) {
            if (type == IngredientType.SAUCE) {
                containsSauce = true;
                break;
            }
        }
        assertTrue(containsSauce);
    }

    @Test
    public void testContainsFilling() {
        // ѕровер€ем, что перечисление содержит тип FILLING
        boolean containsFilling = false;
        for (IngredientType type : IngredientType.values()) {
            if (type == IngredientType.FILLING) {
                containsFilling = true;
                break;
            }
        }
        assertTrue(containsFilling);
    }
}
