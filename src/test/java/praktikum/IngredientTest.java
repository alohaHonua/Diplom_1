package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
  private Ingredient ingredient;

  @Before
  public void setUp() throws Exception {
    ingredient = new Ingredient(IngredientType.SAUCE, "vassabi", 65.0f);
  }

  @Test
  public void getPrice() {
    float expected = 65.0f;
    float actual = ingredient.getPrice();

    assertEquals("Incorrect ingredient price", expected, actual, 0);
  }

  @Test
  public void getName() {
    String expected = "vassabi";
    String actual = ingredient.getName();

    assertEquals("Incorrect ingredient name", expected, actual);
  }

}