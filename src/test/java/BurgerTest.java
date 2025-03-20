import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    // проверка работы метода setBuns
    @Test
    public void setBunsTest() {
        Bun bun = new Bun("Classic", 10);
        Burger burger = new Burger();
        burger.setBuns(bun);

        assertEquals("Classic", burger.bun.getName());
        assertEquals(10, burger.bun.getPrice(), 0.001);
    }

    // проверка работы метода addIngredient
    @Test
    public void addIngredientTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "Classic", 10);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        assertNotNull("Массив должен иметь ингридиенты", burger.ingredients);
    }

    // проверка работы метода removeIngredient
    @Test
    public void removeIngredientTest() {
        Ingredient ingredientFirst = new Ingredient(SAUCE, "Classic", 10);
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        burger.removeIngredient(0);

        assertEquals("Удаление ингридиента "+ ingredientFirst +"",0, burger.ingredients.size(), 0.0);
    }

    // проверка работы метода moveIngredient
    @Test
    public void moveIngredientTest() {
        Ingredient ingredientFirst = new Ingredient(SAUCE, "Classic", 10);
        Ingredient ingredientSecond = new Ingredient(FILLING, "Zinger", 11);
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0, 1);

        assertEquals("Перемещение ингридиента должно быть с 1 на 0", ingredientSecond, burger.ingredients.get(0));
    }

    // проверка работы метода getPrice
    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(20.0f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingridient = new Ingredient(SAUCE, "Classic", 10.0f);
        burger.addIngredient(ingridient);
        float expected = 20.0f*2 + 10.0f;

        assertEquals("Сумма должна быть равна "+ expected +"", expected, burger.getPrice(), 0.001);
    }

    // проверка работы метода getReceipt
    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getPrice()).thenReturn(20.0f);
        Mockito.when(bun.getName()).thenReturn("Red sauce");
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingridient = new Ingredient(SAUCE, "Classic", 10.0f);
        burger.addIngredient(ingridient);
        System.out.println(burger.getReceipt());
        String expected = "(==== Red sauce ====)\n" + "= sauce Classic =\n" + "(==== Red sauce ====)\n" +
                "\nPrice: 50,000000\n";

        assertEquals(expected, burger.getReceipt());
    }
}
