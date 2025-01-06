package praktikum;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParamsTest {

  private final IngredientType ingredientType;
  private final String name;
  private final float price;

  public IngredientParamsTest(IngredientType ingredientType, String name, float price) {
    this.ingredientType = ingredientType;
    this.name = name;
    this.price = price;
  }

  @Parameterized.Parameters
  public static Object[][] getIngredientData() {
    return new Object[][] {
        { IngredientType.SAUCE, "BBK", 5.0f },
        { IngredientType.FILLING, "Meet", 10.0f }
    };
  }

  @Test
  public void ingredientPriceTest() {
    Ingredient ingredient = new Ingredient(ingredientType, name, price);
    assertThat(ingredient.price, anyOf(is(10.0f), is(5.0f)));

  }

  @Test
  public void ingredientNameTest() {
    Ingredient ingredient = new Ingredient(ingredientType, name, price);
    assertThat(ingredient.name, anyOf(is("BBK"), is("Meet")));
  }

  @Test
  public void ingredientTypeTest() {
    Ingredient ingredient = new Ingredient(ingredientType, name, price);
    assertThat(ingredient.type, anyOf(is(IngredientType.SAUCE), is(IngredientType.FILLING)));
  }

}
