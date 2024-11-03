package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void valueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }
}
