package burger.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static core.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient firstIngredient;

    @Mock
    private Ingredient secondIngredient;

    @Mock
    private Ingredient thirdIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        // Arrange
        burger.setBuns(bun);
        when(bun.getName()).thenReturn(EXPECTED_BUN_NAME);

        // Assert
        assertEquals("Булочка установлена неверно", EXPECTED_BUN_NAME, burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {

        burger.addIngredient(firstIngredient);

        assertEquals("Ожидалось 1 ингредиент в бургере", 1, burger.ingredients.size());
        assertTrue("Ингредиент не был добавлен в бургер", burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void removeIngredientTest() {

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);


        burger.removeIngredient(INDEX_TO_REMOVE);


        assertEquals("Ингредиент не был удалён", 2, burger.ingredients.size());
        assertTrue("Удалён неверный ингредиент",
                burger.ingredients.contains(firstIngredient) &&
                        burger.ingredients.contains(thirdIngredient) &&
                        !burger.ingredients.contains(secondIngredient));
    }

    @Test
    public void moveIngredientTest() {

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        burger.moveIngredient(FROM_INDEX, TO_INDEX);

        assertEquals("Ингредиенты не переместились", secondIngredient, burger.ingredients.get(0));
        assertEquals("Ингредиенты не переместились", firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        when(bun.getPrice()).thenReturn(EXPECTED_BUN_PRICE);
        when(firstIngredient.getPrice()).thenReturn(EXPECTED_FIRST_INGREDIENT_PRICE);
        when(secondIngredient.getPrice()).thenReturn(EXPECTED_SECOND_INGREDIENT_PRICE);
        when(thirdIngredient.getPrice()).thenReturn(EXPECTED_THIRD_INGREDIENT_PRICE);

        float actualPrice = burger.getPrice();

        assertEquals("Неверная цена бургера", EXPECTED_TOTAL_PRICE, actualPrice, 0.01f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);

        when(bun.getName()).thenReturn(EXPECTED_BUN_NAME);
        when(bun.getPrice()).thenReturn(EXPECTED_BUN_PRICE);

        when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(thirdIngredient.getType()).thenReturn(IngredientType.SAUCE);

        when(firstIngredient.getName()).thenReturn(EXPECTED_FIRST_INGREDIENT_NAME);
        when(secondIngredient.getName()).thenReturn(EXPECTED_SECOND_INGREDIENT_NAME);
        when(thirdIngredient.getName()).thenReturn(EXPECTED_THIRD_INGREDIENT_NAME);

        when(firstIngredient.getPrice()).thenReturn(EXPECTED_FIRST_INGREDIENT_PRICE);
        when(secondIngredient.getPrice()).thenReturn(EXPECTED_SECOND_INGREDIENT_PRICE);
        when(thirdIngredient.getPrice()).thenReturn(EXPECTED_THIRD_INGREDIENT_PRICE);

        String expectedReceipt = String.format(
                "(==== %s ====)%s= %s %s =%s= %s %s =%s= %s %s =%s(==== %s ====)%s%nPrice: %.6f%s",
                EXPECTED_BUN_NAME, System.lineSeparator(),
                "filling", EXPECTED_FIRST_INGREDIENT_NAME, System.lineSeparator(),
                "filling", EXPECTED_SECOND_INGREDIENT_NAME, System.lineSeparator(),
                "sauce", EXPECTED_THIRD_INGREDIENT_NAME, System.lineSeparator(),
                EXPECTED_BUN_NAME, System.lineSeparator(), EXPECTED_TOTAL_PRICE, System.lineSeparator()
        );

        String actualReceipt = burger.getReceipt();

        assertEquals("Чек сформирован неверно", expectedReceipt, actualReceipt);
    }
}
