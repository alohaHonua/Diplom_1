import org.junit.After;
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
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient souse;
    @Mock
    Ingredient salad;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient cutlet;

    Burger burger;

    @Before
    public void initIngredients() {
        burger = new Burger();
        burger.addIngredient(cutlet);
        burger.addIngredient(cheese);
        burger.addIngredient(souse);
        burger.addIngredient(salad);

        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булочка R2-D3");
        Mockito.when(bun.getPrice()).thenReturn(988F);

        Mockito.when(cutlet.getName()).thenReturn("Мясо бессмертных молюсков");
        Mockito.when(cutlet.getPrice()).thenReturn(1337F);

        Mockito.when(cheese.getName()).thenReturn("Сыр с астеройдной плесенью");
        Mockito.when(cheese.getPrice()).thenReturn(4142F);

        Mockito.when(salad.getName()).thenReturn("Мини салат Экзо-Плантаго");
        Mockito.when(salad.getPrice()).thenReturn(4400F);

        Mockito.when(souse.getName()).thenReturn("Соус традиционный галактичсекий");
        Mockito.when(souse.getPrice()).thenReturn(15F);

        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cheese.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(salad.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(souse.getType()).thenReturn(IngredientType.SAUCE);
    }

    @After
    public void clearIngredients() {
        burger.ingredients.clear();
        burger.bun = null;
    }

    @Test
    public void selectedBunAddedToBurgerTest() {
        burger.setBuns(bun);
        assertNotNull("Булочка не выбрана", burger.bun);
    }

    @Test
    public void selectedIngredientAddedToBurgerTest() {
        burger.addIngredient(cheese);
        assertEquals("Ингредиент не добавлен", 5, burger.ingredients.size());
    }

    @Test
    public void removedIngredientDeletedFromBurgerTest() {
        burger.removeIngredient(1);
        assertEquals( "Количество ингредиентов должно быть равно 3",3, burger.ingredients.size());
    }

    @Test
    public void movedIngredientShouldChangePositionInBurgerTest() {
        burger.moveIngredient(0,1);
        assertEquals("позиция ингредиента не изменилась", 1, burger.ingredients.indexOf(cutlet));
    }

    @Test
    public void calculatingBurgerPriceTest() {
        burger.setBuns(bun);
        float expectedPrice = (bun.getPrice() * 2) + cutlet.getPrice() + cheese.getPrice() + salad.getPrice() + souse.getPrice();
        assertEquals("цена гамбургера посчитана неверно", burger.getPrice(), expectedPrice, 0);
    }

    @Test
    public void printingReceiptTest(){
        burger.setBuns(bun);
        String expectedReceipt = String.format(
                "(==== %s ====)\n" +
                        "= filling %s =\n" +
                        "= filling %s =\n" +
                        "= sauce %s =\n" +
                        "= filling %s =\n" +
                        "(==== %s ====)\n" +
                        "\n" +
                        "Price: %f\n",
                bun.getName(),
                cutlet.getName(),
                cheese.getName(),
                souse.getName(),
                salad.getName(),
                bun.getName(),
                (bun.getPrice() * 2) + cutlet.getPrice() + cheese.getPrice() + souse.getPrice() + salad.getPrice());
        assertEquals("Чек составлен не верно", expectedReceipt, burger.getReceipt());
    }
}