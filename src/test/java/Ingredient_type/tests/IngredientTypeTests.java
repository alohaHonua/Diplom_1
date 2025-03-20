package ingredient_type.tests;
import org.junit.Test;
import praktikum.IngredientType;

import static core.Constants.EXPECTED_INGREDIENT_TYPE_FILLING;
import static core.Constants.EXPECTED_INGREDIENT_TYPE_SAUCE;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {

    @Test
    public void testToStringForSauce() {
        assertEquals(String.format("Ожидался тип ингредиента SAUCE, но был получен %s", IngredientType.SAUCE),
                EXPECTED_INGREDIENT_TYPE_SAUCE,
                IngredientType.SAUCE.toString());
    }

    @Test
    public void testToStringForFilling() {
        assertEquals(String.format("Ожидался тип ингредиента FILLING, но был получен %s", IngredientType.FILLING),
                EXPECTED_INGREDIENT_TYPE_FILLING,
                IngredientType.FILLING.toString());
    }
}
