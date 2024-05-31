import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    public static final String RECEIPT =
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
    public void setBunsShouldBeAddInBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertNotNull("Ошибка. В бургер должна была добавиться булочка", burger.bun);
    }
    @Test
    public void addIngredientShouldBeAddInBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertFalse("Ошибка. В список должен был добавиться ингредиент", burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientShouldBeDeleteFromBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientShouldBeMoveInTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4122));
        burger.moveIngredient(0, 1);
        String expectedResult = "Соус фирменный Space Sauce";
        String actualResult = burger.ingredients.get(0).name;
        assertEquals("Ошибка. Ингредиенты #1 и #2 должны были поменяться местами", expectedResult, actualResult);
    }

    @Test
    public void getPriceBurgerPriceShouldBeReturnedTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(1255F);
        Mockito.when(ingredient.getPrice()).thenReturn(80F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float expectedResult = 2670F;
        assertEquals("Ошибка. Подсчиталась некорректная цена бургера", burger.getPrice(), expectedResult, 0);
    }

    @Test
    public void getReceiptBurgerReceiptShouldBeReturnedTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80));
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        burger.setBuns(bun);
        assertEquals("Ошибка. Чек сформировался некорректно" , RECEIPT, burger.getReceipt());
    }

}