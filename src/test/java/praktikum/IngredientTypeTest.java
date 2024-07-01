package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

public class IngredientTypeTest {

    @Test
    public void sauseExists(){
        MatcherAssert.assertThat(IngredientType.valueOf("SAUCE"), notNullValue());
    }

    @Test
    public void fillingExists(){
        MatcherAssert.assertThat(IngredientType.valueOf("FILLING"), notNullValue());
    }
}
