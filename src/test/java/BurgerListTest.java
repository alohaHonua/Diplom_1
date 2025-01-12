import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Burger;
import praktikum.Ingredient;

public class BurgerListTest {

    Burger burger = new Burger();

    @Mock
    Ingredient ingredientInd0;

    @Mock
    Ingredient ingredientInd1;

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientInd0);
        Assert.assertTrue("Ингредиент не добавлен", burger.ingredients.contains(ingredientInd0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientInd0);
        burger.removeIngredient(0);
        Assert.assertFalse("Ингредиент не удален", burger.ingredients.contains(ingredientInd0));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientInd0);
        burger.addIngredient(ingredientInd1);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингредиент не перемещен", ingredientInd1, burger.ingredients.get(0));
    }
}




