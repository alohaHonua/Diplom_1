package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    private Burger burger;
//    Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cheese", 10);
//    Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "salad", 7);

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;

    @Before
    public void createNewBurger(){
        burger = new Burger();
    }

    @Test
    public void checkGetPrice(){
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(100F);
        when(ingredient.getPrice()).thenReturn(20F);
        when(ingredient1.getPrice()).thenReturn(25.5F);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
//        burger.addIngredient(ingredient2);
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice() + ingredient1.getPrice();
        float actualPrice = burger.getPrice();
        assertEquals("Ожидаемая цена бургера не совпадает с фактической", expectedPrice, actualPrice, 0);
    }

//    @Test
//    public  void checkGetReceipt(){
//
//        Bun bun = new Bun("Black", 100F);
//        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "BBQ", 45F);
//        burger.setBuns(bun);
//        burger.addIngredient(ingredient);
//
//        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) + String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
//                ingredient.getName()) +
//                String.format("(==== %s ====)%n", bun.getName()) +
//                String.format("%nPrice: %f%n", burger.getPrice());
//        String actualReceipt = burger.getReceipt();
//        assertEquals("Актуальный чек бургера не совпадает с ожидаемым результатом", expectedReceipt, actualReceipt);
//    }

}
