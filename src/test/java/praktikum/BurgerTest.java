package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    private Burger burger;
    private final static String BUN_NAME = "Булочка";
    private final static String FIRST_INGREDIENT = "Котлета";
    private final static String SECOND_INGREDIENT = "Соус";
    private final static double DELTA = 0.0f;
    private final Ingredient newFirstIngredient = Mockito.mock(Ingredient.class);
    private final Ingredient newSecondIngredient = Mockito.mock(Ingredient.class);

    @Before
    public void beforeBurgerTest() {
        burger = new Burger();
        burger.addIngredient(newFirstIngredient);
    }

    @Test
    public void addIngredientTest() {
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newFirstIngredient);
        assertEquals("Список ингредиентов не совпадает с ожидаемым результатом", listExpected, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(newSecondIngredient);
        burger.removeIngredient(0);
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newSecondIngredient);
        assertEquals("Список ингредиентов не совпадает с ожидаемым результатом", listExpected, burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(newSecondIngredient);
        burger.moveIngredient(1,0);
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newSecondIngredient);
        listExpected.add(newFirstIngredient);
        assertEquals("Список ингредиентов не совпадает с ожидаемым результатом", listExpected, burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        burger.addIngredient(newSecondIngredient);
        Mockito.when(bun.getPrice()).thenReturn((float) 75.25);
        burger.setBuns(bun);
        float expectedPrice = (float) 150.50;
        assertEquals("Цена бургера не совпадает с ожидаемым результатом", expectedPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(newFirstIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(newSecondIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(newFirstIngredient.getName()).thenReturn(FIRST_INGREDIENT);
        Mockito.when(newSecondIngredient.getName()).thenReturn(SECOND_INGREDIENT);
        Mockito.when(newFirstIngredient.getPrice()).thenReturn((float) 200);
        Mockito.when(newSecondIngredient.getPrice()).thenReturn((float) 50);
        burger.addIngredient(newSecondIngredient);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        burger.setBuns(bun);
        String receipt = burger.getReceipt();
        float price = burger.getPrice();
        String strPrice = Float.toString(price);
        String newStrPrice = strPrice.replace(".",",");
        assertTrue("Информация в чеке не совпадает с ожидаемым результатом",
                receipt.contains(BUN_NAME)
                        && receipt.contains(FIRST_INGREDIENT)
                        && receipt.contains(SECOND_INGREDIENT)
                        && receipt.contains(newStrPrice));
    }
}