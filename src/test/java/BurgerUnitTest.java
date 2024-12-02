import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerUnitTest {

    @Mock
    Bun mockBun;
    @Mock
    Ingredient mockIngredient;

    private static final String EXPECTED_RECEIPT =
            "(==== Краторная булка N-200i ====)"
                    + System.lineSeparator() +
                    "= filling Говяжий метеорит (отбивная) ="
                    + System.lineSeparator() +
                    "= sauce Соус фирменный Space Sauce ="
                    + System.lineSeparator() +
                    "(==== Краторная булка N-200i ====)"
                    + System.lineSeparator() +
                    System.lineSeparator() +
                    "Price: 5590,000000"
                    + System.lineSeparator();

    @Test
    public void shouldAddBunToBurger() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        assertNotNull("Ошибка: булочка не добавлена в бургер", burger.bun);
    }

    @Test
    public void shouldAddIngredientToBurger() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient);
        assertFalse("Ошибка: ингредиент не был добавлен", burger.ingredients.isEmpty());
    }

    @Test
    public void shouldRemoveIngredientFromBurger() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void shouldMoveIngredientPosition() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4122));
        burger.moveIngredient(0, 1);
        String expectedIngredientName = "Соус фирменный Space Sauce";
        String actualIngredientName = burger.ingredients.get(0).name;
        assertEquals("Ошибка: ингредиенты не поменялись местами", expectedIngredientName, actualIngredientName);
    }

    @Test
    public void shouldCalculateBurgerPrice() {
        Burger burger = new Burger();
        Mockito.when(mockBun.getPrice()).thenReturn(1255F);
        Mockito.when(mockIngredient.getPrice()).thenReturn(80F);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);
        float expectedPrice = 2670F;
        assertEquals("Ошибка: неверная цена бургера", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void shouldReturnBurgerReceipt() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80));
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        burger.setBuns(bun);
        assertEquals("Ошибка: чек сформирован некорректно", EXPECTED_RECEIPT, burger.getReceipt());
    }
}