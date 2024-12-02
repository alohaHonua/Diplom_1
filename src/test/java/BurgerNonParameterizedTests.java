import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class BurgerNonParameterizedTests {
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredientA;
    @Mock
    private Ingredient ingredientB;

    @Before
    public void initBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunSetsPassedBun() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientAddsPassedIngredient() {
        burger.addIngredient(ingredientA);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredientA, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientRemovesSelectedIngredient() {
        burger.addIngredient(ingredientA);
        burger.addIngredient(ingredientB);
        burger.removeIngredient(0);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredientB, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientMovesSelectedIngredient() {
        burger.addIngredient(ingredientA);
        burger.addIngredient(ingredientB);
        burger.moveIngredient(0,1);
        Assert.assertEquals(ingredientB, burger.ingredients.get(0));
        Assert.assertEquals(ingredientA, burger.ingredients.get(1));
    }
}
