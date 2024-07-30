package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerClassTest {
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Test
    public void setBunsTest() {
        // Arrange
        Burger burger = new Burger();
        Bun expectedBun = new Bun("Булочка с маком", 10.0F);

        // Act
        burger.setBuns(expectedBun);

        // Assert
        assertEquals(expectedBun, burger.bun);
    }


    @Test
    public void addIngredientTest() {
        // Arrange
        Burger burger = new Burger();
        Ingredient expectedIngredient = new Ingredient(IngredientType.SAUCE,"Соус чили",1.0F);

        // Act
        burger.addIngredient(expectedIngredient);

        // Assert
        assertTrue(burger.ingredients.contains(expectedIngredient));
    }
    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        when(mockBun.getPrice()).thenReturn(3.0f);
        when(mockIngredient1.getPrice()).thenReturn(1.5f);
        when(mockIngredient2.getPrice()).thenReturn(2.0f);

        float expectedPrice = 3.0f * 2 + 1.5f + 2.0f;
        assertEquals(expectedPrice, burger.getPrice(), TestUtils.DELTA);
    }

    @Test
    public void removeIngredientsTest() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngregientsTest() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        when(mockBun.getName()).thenReturn("мокБулочка");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getName()).thenReturn("Соус соевый");
        when(mockIngredient2.getName()).thenReturn("Васаби");

        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("мокБулочка"));
        assertTrue(receipt.contains("sauce"));
        assertTrue(receipt.contains("filling"));
        assertTrue(receipt.contains("Соус соевый"));
        assertTrue(receipt.contains("Васаби"));
    }
}
