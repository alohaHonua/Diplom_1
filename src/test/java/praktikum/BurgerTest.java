package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.enums.Buns;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.enums.Buns.CRATOR_BUN;
import static praktikum.enums.Ingredients.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun = new Bun (Buns.FLU_BUN.getName(), Buns.FLU_BUN.getPrice());
    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3 ;

    @Spy
    Burger burger = new Burger();

    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        assertEquals("Ошибка в создании булки", bun, burger.bun);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        when(bun.getPrice()).thenReturn(CRATOR_BUN.getPrice());
        when(ingredient1.getPrice()).thenReturn(SAUCE_SPICY.getPrice());
        when(ingredient2.getPrice()).thenReturn(FILLING_BEEF.getPrice());
        when(ingredient3.getPrice()).thenReturn(FILLING_MARS.getPrice());

        float expectedPrice = (CRATOR_BUN.getPrice() * 2)
                + SAUCE_SPICY.getPrice()
                + FILLING_BEEF.getPrice()
                + FILLING_MARS.getPrice();

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        when(bun.getName()).thenReturn(CRATOR_BUN.getName());
        when(ingredient1.getName()).thenReturn(SAUCE_SPICY.getName());
        when(ingredient2.getName()).thenReturn(FILLING_BEEF.getName());

        when(bun.getPrice()).thenReturn(CRATOR_BUN.getPrice());
        when(ingredient1.getPrice()).thenReturn(SAUCE_SPICY.getPrice());
        when(ingredient2.getPrice()).thenReturn(FILLING_BEEF.getPrice());

        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        float price = (CRATOR_BUN.getPrice() * 2)
                + SAUCE_SPICY.getPrice()
                + FILLING_BEEF.getPrice();

        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                "= sauce %s =%n" +
                "= filling %s =%n" +
                "(==== %s ====)%n" +
                "%nPrice: %.6f%n",
                CRATOR_BUN.getName(),
                SAUCE_SPICY.getName(),
                FILLING_BEEF.getName(),
                CRATOR_BUN.getName(),
                price
                );

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
