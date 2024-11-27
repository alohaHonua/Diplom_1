import org.junit.Test;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngredientTypeTest {
    @Test
    public void checkEnumValueTest() {
        assertThat(IngredientType.valueOf("SAUCE"), (notNullValue()));
        assertThat(IngredientType.valueOf("FILLING"), (notNullValue()));
    }
}