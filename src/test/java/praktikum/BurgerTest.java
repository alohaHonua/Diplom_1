package praktikum;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final IngredientType sauce = IngredientType.SAUCE;
    Burger burger;
    public List<Ingredient> ingredients;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Before
    public void setup(){
        burger = new Burger();
        ingredients = new ArrayList<>();
        ingredients.add(ingredient);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Mockito.times(1);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredients, burger.ingredients);
        Assert.assertEquals(ingredient, ingredients.get(0));
    }

    @Test
    public void removeIngredient() {
        ingredients.remove(0);
        Assert.assertTrue(ingredients.isEmpty());
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void moveIngredient() {
        ingredients.add(ingredient2);
        ingredients.add(1, ingredients.remove(0));
        Assert.assertEquals(ingredient2, ingredients.get(0));
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        Assert.assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void getPrice() {
        ingredients.add(ingredient2);
        float expected = 200 * 2 + 300 + 400;

        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(300F);
        Mockito.when(ingredient2.getPrice()).thenReturn(400F);
        float price = bun.getPrice() * 2;
          for (Ingredient ingredient : ingredients) {
              price += ingredient.getPrice();
          }
        Assert.assertEquals(expected, price, 0.01);
          burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
            Assert.assertEquals(expected, burger.getPrice(), 0.01);
        }


    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("Марсианский пупок");
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getType()).thenReturn(sauce);
        Mockito.when(ingredient.getName()).thenReturn("Cheesy cream");
        Mockito.when(ingredient.getPrice()).thenReturn(300F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", 700F));
        Assert.assertEquals(receipt.toString(), burger.getReceipt());

    }
    @After
    public void cleanList(){
        ingredients.clear();
        burger.ingredients.clear();
    }
}