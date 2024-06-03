
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient_1;

    @Mock
    private Ingredient ingredient_2;

    private Burger burger;

    @Test
    public void setBunsTest() {
        burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Бургер без булочек",bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient_1);
        assertTrue("Ингредиент не добавлен", burger.ingredients.contains(ingredient_1));
    }

    @Test
    public void removeIngredientTest() {
        burger = new Burger();
        burger.addIngredient(ingredient_1);
        int number = burger.ingredients.indexOf(ingredient_1);
        burger.removeIngredient(number);

        assertFalse("Ингредиент не удален", burger.ingredients.contains(ingredient_1));
    }

    @Test
    public void moveIngredientTest() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        burger.moveIngredient(0, 1);
        assertEquals("Первый ингредиент не совпадает", ingredient_2, burger.ingredients.get(0));
        assertEquals("Второй ингредиент не совпадает", ingredient_1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient_1.getPrice()).thenReturn(150f);
        Mockito.when(ingredient_2.getPrice()).thenReturn(250f);

        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);

        float expectedPrice = 100f * 2 + 150f + 250f;
        assertEquals("Неверная цена", expectedPrice, burger.getPrice(), 0.01f);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Bun Name");
        Mockito.when(ingredient_1.getName()).thenReturn("ingredient_1");
        Mockito.when(ingredient_1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient_2.getName()).thenReturn("ingredient_2");
        Mockito.when(ingredient_2.getType()).thenReturn(IngredientType.SAUCE);

        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);

        String receipt = burger.getReceipt();
        String expectedReceipt = "(==== Bun Name ====)\r\n= filling ingredient_1 =\r\n= sauce ingredient_2 =\r\n(==== Bun Name ====)\r\n\r\nPrice: 0,000000\r\n";
        assertEquals("Некорректный рецепт", expectedReceipt, receipt);
    }

}
