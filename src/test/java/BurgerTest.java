import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient0;

    @Mock
    private Ingredient ingredient1;

    @Before
    public void setUp() {
        burger = new Burger();


        Mockito.when(bun.getName()).thenReturn("Red Bun");
        Mockito.when(bun.getPrice()).thenReturn(300F);


        Mockito.when(ingredient0.getName()).thenReturn("Hot sauce");
        Mockito.when(ingredient0.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient0.getPrice()).thenReturn(100F);

        Mockito.when(ingredient1.getName()).thenReturn("Cutlet");
        Mockito.when(ingredient1.getType()).thenReturn(FILLING);
        Mockito.when(ingredient1.getPrice()).thenReturn(100F);
    }


    @Test
    public void shouldSetBunCorrectly() {
        burger.setBuns(bun);
        assertEquals("Булочка не была добавлена в бургер", bun, burger.bun);
    }


    @Test
    public void shouldAddIngredientToList() {
        burger.addIngredient(ingredient0);
        assertTrue("Ингредиент не был добавлен в список", burger.ingredients.contains(ingredient0));
        assertEquals("После добавления ингредиента размер списка должен быть равен 1", 1, burger.ingredients.size());
    }


    @Test
    public void shouldRemoveIngredientFromList() {
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(1);

        assertFalse("Ингредиент не был удален из списка", burger.ingredients.contains(ingredient1));
        assertEquals("После удаления ингредиента размер списка должен уменьшиться на 1", 1, burger.ingredients.size());
    }


    @Test
    public void shouldCalculateCorrectPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);


        float expectedPrice = 300F * 2 + 100F + 100F;
        assertEquals("Неверная цена бургера: цена должна учитывать булочку и все ингредиенты", expectedPrice, burger.getPrice(), 0);
    }


    @Test
    public void shouldGenerateCorrectReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);

        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                "Red Bun", "sauce", "Hot sauce", "filling", "Cutlet", "Red Bun", 300F * 2 + 100F + 100F);

        assertEquals("Чек не был сгенерирован правильно", expectedReceipt, burger.getReceipt());
    }


    @Test
    public void shouldMoveIngredientCorrectly() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);

        burger.moveIngredient(0, 1);

        assertEquals("Ингредиент не был перемещен корректно", ingredient0, burger.ingredients.get(1));
        assertEquals("Ингредиент с позиции 0 должен быть ingredient1", ingredient1, burger.ingredients.get(0));
    }
}