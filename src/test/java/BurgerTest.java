import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    private final Burger burger = new Burger();

    @Test
    public void addIngredientAddedIngredientToTheList() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientRemoveIngredientFromList() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientMovedIngredientInList() {
        Ingredient spyIngredient = Mockito.spy(new Ingredient(IngredientType.FILLING,
                "sausage", 300));
        burger.addIngredient(spyIngredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0,1);
        assertEquals(burger.ingredients.get(1), spyIngredient);
    }

    @Test
    public void getPriceReturnFloatPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        assertEquals(500F, burger.getPrice(), 0.0f);
    }
}