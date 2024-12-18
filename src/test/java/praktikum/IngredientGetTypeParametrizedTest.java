package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientGetTypeParametrizedTest {
  private final IngredientType type;
  private final String name;
  private final float price;

  public IngredientGetTypeParametrizedTest(IngredientType type, String name, float price) {
    this.type = type;
    this.name = name;
    this.price = price;
  }

  @Parameterized.Parameters(name = "{index} : type = {0}")
  public static Object[][] getIngredientData() {
    return new Object[][] {
            {IngredientType.SAUCE, "vassabi", 65.0f},
            {IngredientType.FILLING, "salmon", 105.5f},
            {null, null, 0.0f}
    };
  }

  @Test
  public void getType() {
    Ingredient ingredient = new Ingredient(type, name, price);
    IngredientType actual = ingredient.getType();

    assertEquals("Incorrect ingredient's type", type, actual);
  }

}