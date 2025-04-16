package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerAddIngredientParamTest {
    private final List<Ingredient> ingredients;
    Burger burger = new Burger();

    public BurgerAddIngredientParamTest(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] dataGen() {
        return new Object[][]{
                {new Database().availableIngredients()},
                {List.of(new Ingredient(IngredientType.SAUCE, "hot sauce", 100))},
                {List.of(new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                        new Ingredient(IngredientType.FILLING, "hot kotleta", 200))}
        };
    }

    @Test
    public void addIngredientTest() {
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        Assert.assertEquals(ingredients, burger.ingredients);
    }

}
