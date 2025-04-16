package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Database database = new Database();

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockIngredient;

    @Spy
    Burger spyBurger;

    @Test
    public void getPriceMockitoTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.getPrice();
        Mockito.verify(mockBun).getPrice();
        Mockito.verify(mockIngredient).getPrice();
    }

    @Test
    public void getReceiptSpyTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        spyBurger.setBuns(mockBun);
        spyBurger.addIngredient(ingredient);
        spyBurger.getReceipt();
        Mockito.verify(spyBurger).getPrice();
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        Assert.assertEquals(List.of(ingredient), burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        List<Ingredient> ingredients = database.availableIngredients();
        for (int i = 0; i <= 2; i++) {
            burger.addIngredient(ingredients.get(i));
        }
        List<Ingredient> expectedIngredients = List.of(ingredients.get(1), ingredients.get(0), ingredients.get(2));
        burger.moveIngredient(0, 1);
        Assert.assertEquals(expectedIngredients, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        List<Ingredient> ingredients = database.availableIngredients();
        for (int i = 0; i <= 2; i++) {
            burger.addIngredient(ingredients.get(i));
        }
        List<Ingredient> expectedIngredients = List.of(ingredients.get(0), ingredients.get(2));
        burger.removeIngredient(1);
        Assert.assertEquals(expectedIngredients, burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("black bun", 100);
        Burger burger = new Burger();
        List<Ingredient> ingredients = database.availableIngredients();
        float expectedPrice = bun.getPrice() * 2 + ingredients.get(0).getPrice() + ingredients.get(1).getPrice();
        burger.setBuns(bun);
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
        System.out.println(burger.getReceipt());
    }

    @Test
    public void setBunsTest() {
        Bun bun = database.availableBuns().get(2);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = new Bun("black bun", 100);
        Burger burger = new Burger();
        Ingredient ingredient = database.availableIngredients().get(0);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        expectedReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName()));
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }


}



