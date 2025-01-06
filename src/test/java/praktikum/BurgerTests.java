package praktikum;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

  @Mock
  Bun bun;

  @Mock
  Ingredient ingredient;

  @Test
  public void setBunsTest() {
    Burger burger = new Burger();
    burger.setBuns(bun);
  }

  @Test
  public void thenBurgerIngredientsTest() {
    Burger burger = new Burger();

    burger.addIngredient(ingredient);

    List<Ingredient> ingredientList = burger.ingredients;
    assertEquals(1, ingredientList.size());
  }

  @Test
  public void removeIngredientTest() {
    Burger burger = new Burger();
    burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Name", 10.0f));
    burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Name", 10.0f));

    burger.removeIngredient(1);

    assertEquals(1, burger.ingredients.size());
  }

  @Test
  public void moveIngredientTest() {
    Burger burger = new Burger();

    burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Name", 10.0f));
    burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Name", 10.0f));

    burger.moveIngredient(1, 1);
  }

  @Test
  public void thenReturnTwentyTest() {
    Burger burger = new Burger();
    Mockito.when(bun.getPrice()).thenReturn(10.0f);
    burger.setBuns(bun);

    assertEquals(20.0f, burger.getPrice(), 0.0f);
  }


  @Test
  public void getPriceReturnTwentyTwoTest() {
    Burger burger = new Burger();
    burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Name", 2.0f));
    burger.setBuns(new Bun("Name", 10.0f));

    assertEquals(22.0f, burger.getPrice(), 0.0f);
  }

  @Test
  public void getReceiptReturnStringTest() {
    Burger burger = new Burger();
    burger.addIngredient(new Ingredient(IngredientType.SAUCE, "(==== %s ====)%n", 2.0f));
    burger.setBuns(new Bun("(==== %s ====)%n", 10.0f));

    assertEquals("(==== (==== %s ====)%n ====)\n" + "= sauce (==== %s ====)%n =\n" + "(==== (==== %s ====)%n ====)\n"
                     + "\n" + "Price: 22,000000\n", burger.getReceipt());
  }

  @Test
  public void getReceiptPriceTest() {
    Burger burger = new Burger();
    burger.setBuns(new Bun("(==== %s ====)%n", 10.0f));

    assertEquals("(==== (==== %s ====)%n ====)\n(==== (==== %s ====)%n ====)\n\nPrice: 20,000000\n",
                 burger.getReceipt());
  }
}
