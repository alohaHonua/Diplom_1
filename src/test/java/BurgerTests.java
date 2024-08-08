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

    @Test
    public void setBunsInBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertNotNull("Не добавлена булочка", burger.bun);
    }

    @Test
    public void addIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue("Не добавлен ингредиент", burger.ingredients.size() != 0);
    }

    @Test
    public void removeIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4122));
        burger.moveIngredient(0, 1);
        String expectedResult = "Соус фирменный Space Sauce";
        String actualResult = burger.ingredients.get(0).name;
        assertEquals("Не поменялись местами Ингредиент №1 и Ингредиент №2", expectedResult, actualResult);
    }

    @Test
    public void getPriceBurgerTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(1255F);
        Mockito.when(ingredient.getPrice()).thenReturn(80F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float expectedResult = 2670F;
        assertEquals("Несоответствие стоимости бургера", burger.getPrice(), expectedResult, 0);
    }

    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15));
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        burger.setBuns(bun);
        String expectedResult =
                "(==== Краторная булка N-200i ====)"
                        + System.lineSeparator() +
                        "= filling Говяжий метеорит (отбивная) ="
                        + System.lineSeparator() +
                        "= sauce Соус традиционный галактический ="
                        + System.lineSeparator() +
                        "(==== Краторная булка N-200i ====)"
                        + System.lineSeparator() +
                        System.lineSeparator() +
                        "Price: 5525,000000"
                        + System.lineSeparator();
        assertEquals("Неправильно оформлен чек", expectedResult, burger.getReceipt());
    }
}
