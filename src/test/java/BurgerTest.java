import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }


    @Test
    public void checkSetBuns() {
     Bun bun = Mockito.mock(Bun.class);
     burger.setBuns(bun);
     Bun actual = burger.bun;
     assertEquals(bun, actual);

    }

    @Test
    public void checkAddIngredient() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        List<Ingredient> actualIngredients = burger.ingredients;
        List<Ingredient> expectedIngredients = List.of(ingredient);
        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    public void checkRemoveIngredient(){
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> actualIngredients = burger.ingredients;
        assertEquals(0, actualIngredients.size());
    }

    @Test
    public void checkMoveIngredient(){
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn("caramelized onion");
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        burger.moveIngredient(0,1);
        String expectedIngredient = "caramelized onion";
        assertEquals(expectedIngredient, burger.ingredients.get(1).getName());

    }

    @Test
    public void checkGetPrice(){
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        burger.setBuns(bun);
        float expectedPrice = 400F;
        assertEquals(expectedPrice, burger.getPrice(),0);
    }

    @Test
    public void checkGetReceipt(){
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt =
                String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("= %s %s =%n", burger.ingredients.get(0).getType().toString().toLowerCase(),
                                burger.ingredients.get(0).getName()) +
                        String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(expectedReceipt, actualReceipt);

        System.out.println(actualReceipt);
    }


}





