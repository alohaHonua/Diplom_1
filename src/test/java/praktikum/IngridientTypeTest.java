package praktikum;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Test;

public class IngridientTypeTest {

  @Test
  public void sauceTest() {
    assertThat(IngredientType.SAUCE, is(notNullValue()));

  }

  @Test
  public void fillingTest() {
    assertThat(IngredientType.FILLING, is(notNullValue()));
  }

}
