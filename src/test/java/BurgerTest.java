import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {
    @Spy
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    private final String RECEIPT = "(==== Sesame Bun ====)= sauce Ketchup == filling Cheese =(==== Sesame Bun ====)Price: 5,500000";

    @BeforeEach
    void setUp() {
        burger = new Burger();
        lenient().when(bun.getName()).thenReturn("Sesame Bun");
        lenient().when(bun.getPrice()).thenReturn(2.0f);

        lenient().when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        lenient().when(ingredient1.getName()).thenReturn("Ketchup");
        lenient().when(ingredient1.getPrice()).thenReturn(0.5f);

        lenient().when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        lenient().when(ingredient2.getName()).thenReturn("Cheese");
        lenient().when(ingredient2.getPrice()).thenReturn(1.0f);
    }

    @Test
    void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = (bun.getPrice() * 2) + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals(expectedPrice, burger.getPrice());
    }

    @Test
    void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(RECEIPT, burger.getReceipt().replace("\r", "").replace("\n", ""));
    }
}
