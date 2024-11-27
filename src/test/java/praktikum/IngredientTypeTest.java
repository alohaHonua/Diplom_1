package praktikum;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void sauceIsNotNullValue() {
        assertThat(IngredientType.SAUCE, notNullValue());
    }

    @Test
    public void fillingIsIngredientTypeFillingName() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}