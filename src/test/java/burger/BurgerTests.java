package burger;

import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static com.example.Methods.*;
import static org.junit.Assert.assertEquals;

public class BurgerTests {
  String bunName = getName();
  float bunPrice = getPrice();
  String sauce = getSauce();
  float priceSauce = getPriceSauce();
  @Test
  public void setBun() {
    Burger burger = new Burger();
    Bun bun = new Bun(bunName, bunPrice);

    burger.setBuns(bun);

    assertEquals(bun, burger.bun);
  }
  @Test
  public void addIngredient() {
    Burger burger = new Burger();
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, bunName, bunPrice);

    burger.addIngredient(ingredient);

    assertEquals(ingredient, burger.ingredients.get(0));
  }
  @Test
  public void removeIngredient() {
    Burger burger = new Burger();
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, bunName, bunPrice);

    burger.addIngredient(ingredient);
    burger.removeIngredient(0);

    assertEquals(0, burger.ingredients.size());
  }
  @Test
  public void moveIngredient() {
    Burger burger = new Burger();
    Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, bunName, bunPrice);
    Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, bunName, bunPrice);

    burger.addIngredient(ingredient0);
    burger.addIngredient(ingredient1);
    burger.moveIngredient(1, 0);

    assertEquals( ingredient1, burger.ingredients.get(0));
    assertEquals( ingredient0, burger.ingredients.get(1));
  }
  @Test
  public void getReceipt() {
    Bun bun = new Bun(bunName, bunPrice);
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, sauce, priceSauce);
    Burger burger = new Burger();

    burger.setBuns(bun);
    burger.addIngredient(ingredient);
    float burgerPrice = burger.getPrice();

    String expectedReceipt =  String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", bunName,
            IngredientType.FILLING.toString().toLowerCase(), sauce, bunName, burgerPrice);

    assertEquals(expectedReceipt, burger.getReceipt());
  }

}