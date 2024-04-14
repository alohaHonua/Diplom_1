package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

public class IngredientTypeTest {

    @Test
    public void checkIngredientTypeEnumValueOfSauce(){
        MatcherAssert.assertThat(IngredientType.valueOf("SAUCE"), notNullValue());
    }

    @Test
    public void checkIngredientTypeEnumValueOfFilling(){
        MatcherAssert.assertThat(IngredientType.valueOf("FILLING"), notNullValue());
    }
}
