package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    Burger burger;

    @Mock
    private Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;


    @Test
    public void setBunsTest() {
        burger = new Burger();
        bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        assertEquals(bun, burger.getBuns());
    }

    @Test
    public void addIngredientTest() {
        burger = new Burger();
        ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        assertEquals(ingredient, burger.getIngredient());
    }

    @Test
    public void getPriceTest() {
        burger = new Burger();
        bun = new Bun("black bun", 100);
        ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger = new Burger();
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn("dinosaur");
        when(ingredient.getPrice()).thenReturn(200f);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("sour cream");
        when(ingredient2.getPrice()).thenReturn(100f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);


        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
        System.out.println(burger.getReceipt());
        System.out.println(expectedReceipt);
    }

    @Test
    public void removeIngredientTest() {
        burger = new Burger();
        ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        ingredient2 = new Ingredient(IngredientType.SAUCE, "sour cream", 100);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientTest() {
        burger = new Burger();
        ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        ingredient2 = new Ingredient(IngredientType.SAUCE, "sour cream", 100);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }


}
