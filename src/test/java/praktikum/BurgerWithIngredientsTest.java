package praktikum;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BurgerWithIngredientsTest {

    private Burger burger;
    private final Faker faker = new Faker();

    private final String ingredientName = faker.funnyName().name();
    private final float ingredientPrice = (float) faker.random().nextDouble();
    private final IngredientType ingredientType;

    public BurgerWithIngredientsTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    Ingredient ingredient;
    Ingredient ingredientForMoving;

    @Before

    public void setUp() {
        burger = new Burger();
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        ingredientForMoving = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }
    @Parameterized.Parameters
    public static Object[][] getIngredientTypeForTests() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }
    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertTrue("Ingredient wasn't added to list", burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        Assert.assertFalse("Ingredient wasn't removed from list", burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientForMoving);
        burger.moveIngredient(1, 0);
        Assert.assertEquals("Ingredient wasn't moved", 0, burger.ingredients.indexOf(ingredientForMoving));
    }

}
