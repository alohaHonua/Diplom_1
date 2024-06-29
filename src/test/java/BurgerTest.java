import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static String name = "TestName";
    private static float price = 204.7f;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;
    private Burger burger;

    @Before
    public void before() {
        burger = new Burger();
    }

    @Test
    @Description("Проверка установки параметров для булочки")
    public void setBunCheck() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    @Description("Проверка добавления ингридиента")
    public void addIngredientCheck() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    @Description("Проверка удаления ингридиента")
    public void removeIngridientCheck() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    @Description("Проверка перемещения ингридиента")
    public void testMoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, name, price));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, name, price));
        burger.moveIngredient(1, 0);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    @Description("Проверка получения стоимости бургера")
    public void getBurgerPriceCheck() {
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        Mockito.when(bun.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = price * 3;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {

        // заполняем стабы для методов внутри тестируемого метода
        Mockito.when(bun.getName()).thenReturn("original");
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili");
        Mockito.when(ingredient.getPrice()).thenReturn(20.0f);
        burger.addIngredient(ingredient);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        String expected = receipt.toString();
        String actual = burger.getReceipt();

        assertEquals("Неправильный рецепт бургера", expected, actual);
    }
}
