package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
  @Mock
  private Bun bun;
  @Mock
  private Ingredient ingredient;
  @Mock
  private Ingredient sauce;
  @Mock
  private Ingredient filling;
  private Burger burger;

  @Before
  public void setUp() throws Exception {
    burger = new Burger();
  }

  //Мок (от англ. mock — «передразнивать») — это «дублёр» реальной сущности в коде. Он помогает
  //протестировать модуль, не вызывая реальный код.
  @Test
  public void setBuns() {
    burger.setBuns(bun);
    Bun actual = burger.bun;

    assertEquals("Incorrect bun's in burger. Retry, please", bun, actual);
  }

  @Test
  public void addIngredient() {
    burger.addIngredient(ingredient);
    List<Ingredient> expected = List.of(ingredient);
    List<Ingredient> actual = burger.ingredients;

    assertEquals("Incorrect ingredient in the list. Retry, please", expected, actual);
  }

  @Test
  public void removeIngredient() {
    burger.addIngredient(ingredient);
    burger.removeIngredient(0);
    List<Ingredient> actual = burger.ingredients;

    assertEquals("Incorrect ingredient's removal from the list", List.of(), actual);
  }

  @Test
  public void moveIngredient() {
    burger.addIngredient(filling);
    burger.addIngredient(sauce);
    burger.moveIngredient(0, 1);
    Ingredient actual = burger.ingredients.get(1);

    assertEquals("Incorrect ingredient's movement in the list.Retry, please", filling, actual);
  }

  //применение стабов - объекты с заданным состоянием
  @Test
  public void getReceipt() {
    Mockito.when(bun.getName()).thenReturn("brownie");
    Mockito.when(bun.getPrice()).thenReturn(700.0f);
    burger.setBuns(bun);

    Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
    Mockito.when(ingredient.getName()).thenReturn("vassabi");
    Mockito.when(ingredient.getPrice()).thenReturn(65.0f);
    burger.addIngredient(ingredient);

    StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
    List<Ingredient> ingredients = burger.ingredients;

    for (Ingredient ingredient : ingredients) {
      receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(),
              ingredient.getName()));
    }

    receipt.append(String.format("(==== %s ====)%n", bun.getName()));
    receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

    String expected = receipt.toString();
    String actual = burger.getReceipt();

    assertEquals("Incorrect burger receipt", expected, actual);
  }
}