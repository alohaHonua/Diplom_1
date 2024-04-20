package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;
    @Before
    public void createBurger() {
        burger = new Burger();
    }
    @Test
    public void setBunTest() {
        burger.setBuns(bun);

        assertEquals(bun.getName(), burger.bun.getName());
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());
    }
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());
    }
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient3, burger.ingredients.get(2));
    }
    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        when(bun.getPrice()).thenReturn(100F);
        when(ingredient1.getPrice()).thenReturn(10F);
        when(ingredient2.getPrice()).thenReturn(20F);
        when(ingredient3.getPrice()).thenReturn(30F);

        float expected = (100F * 2) + 10F + 20F + 30F;

        assertEquals(expected, burger.getPrice(), 0);

        Mockito.verify(bun,Mockito.times(1)).getPrice();
        Mockito.verify(bun,Mockito.times(0)).getName();
        Mockito.verify(ingredient1,Mockito.times(0)).getType();
        Mockito.verify(ingredient1,Mockito.times(0)).getName();
        Mockito.verify(ingredient1,Mockito.times(1)).getPrice();
        Mockito.verify(ingredient2,Mockito.times(0)).getType();
        Mockito.verify(ingredient2,Mockito.times(0)).getName();
        Mockito.verify(ingredient2,Mockito.times(1)).getPrice();
        Mockito.verify(ingredient3,Mockito.times(0)).getType();
        Mockito.verify(ingredient3,Mockito.times(0)).getName();
        Mockito.verify(ingredient3,Mockito.times(1)).getPrice();
    }

        @Test
        public void getReceiptTest() {
            burger.setBuns(bun);
            burger.addIngredient(ingredient1);
            burger.addIngredient(ingredient2);
            burger.addIngredient(ingredient3);


            when(bun.getName()).thenReturn("Супер-Булка");
            when(ingredient1.getName()).thenReturn("Сыыырный");
            when(ingredient2.getName()).thenReturn("Котлета");
            when(ingredient3.getName()).thenReturn("Помидорка");
            when(bun.getPrice()).thenReturn(100F);
            when(ingredient1.getPrice()).thenReturn(10F);
            when(ingredient2.getPrice()).thenReturn(20F);
            when(ingredient3.getPrice()).thenReturn(30F);
            when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
            when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
            when(ingredient3.getType()).thenReturn(IngredientType.FILLING);
            //String actual = burger.getReceipt();
            String expected = "(==== Супер-Булка ====)\r\n" +
                    "= sauce Сыыырный =\r\n" +
                    "= filling Котлета =\r\n" +
                    "= filling Помидорка =\r\n" +
                    "(==== Супер-Булка ====)\r\n" +
                    "\r\n" +
                    "Price: 260,000000\r\n";

            assertEquals(expected, burger.getReceipt());
            Mockito.verify(bun,Mockito.times(1)).getPrice();
            Mockito.verify(bun,Mockito.times(2)).getName();
            Mockito.verify(ingredient1,Mockito.times(1)).getType();
            Mockito.verify(ingredient1,Mockito.times(1)).getName();
            Mockito.verify(ingredient1,Mockito.times(1)).getPrice();
            Mockito.verify(ingredient2,Mockito.times(1)).getType();
            Mockito.verify(ingredient2,Mockito.times(1)).getName();
            Mockito.verify(ingredient2,Mockito.times(1)).getPrice();
            Mockito.verify(ingredient3,Mockito.times(1)).getType();
            Mockito.verify(ingredient3,Mockito.times(1)).getName();
            Mockito.verify(ingredient3,Mockito.times(1)).getPrice();
        }

}
