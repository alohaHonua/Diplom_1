package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedPriceTest {
  private Burger burger;
  private Ingredient sauce;
  private Ingredient filling;
  private final String name;
  private final float price;

  public BurgerParametrizedPriceTest(String name, float price) {
    this.name = name;
    this.price = price;
  }

  @Before
  public void createNewInstance() {
    sauce = new Ingredient(IngredientType.SAUCE, "vassabi", 35.0f);
    filling = new Ingredient(IngredientType.FILLING, "salmon", 105.5f);
    burger = new Burger();
  }

  @Parameterized.Parameters(name = "{index} : price = {1}")
  public static Object[][] getBunData() {
    return new Object[][] {
            {"brownie-free", 0.0f},
            {"brownie", 700.0f}
    };
  }

  @Test
  public void getPrice() {
    Bun bun = new Bun(name, price);
    burger.setBuns(bun);
    burger.addIngredient(sauce);
    burger.addIngredient(filling);
    float expected = bun.price * 2 + sauce.price + filling.price;
    float actual = burger.getPrice();

    assertEquals("Incorrect burger price", expected, actual, 0);
  }
}