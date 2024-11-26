import org.junit.Assert;
import org.junit.Test;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class BurgerListTest {

    Burger burger = new Burger();

    Ingredient ingredientInd0 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    Ingredient ingredientInd1 = new Ingredient(IngredientType.SAUCE, "sour cream", 200);

    @Test

    public void checkAddIngredient() {
        burger.addIngredient(ingredientInd0);
        Assert.assertTrue(burger.ingredients.contains(ingredientInd0));
    }


    @Test

    public void checkRemoveIngredient() {
        burger.addIngredient(ingredientInd0);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredientInd0));
    }

    @Test

    public void checkMoveIngredient() {
        burger.addIngredient(ingredientInd0);
        burger.addIngredient(ingredientInd1);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredientInd1, burger.ingredients.get(0));
    }


}




