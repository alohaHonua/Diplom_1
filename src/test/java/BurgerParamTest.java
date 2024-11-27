import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParamTest {

    private float bunPrice;
    private float ingredientPrice;
    private float expectedPrice;

    public BurgerParamTest(float bunPrice, float ingredientPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {100, 200, 400},
                {0, 300, 300},
                {250, 0, 500},
                {8.5F, 2.5F, 19.5F},
                {-3, 15, 9},

        };
    }

    @Spy
    Burger burger = new Burger();

    @Test
    public void checkGetPrice() {
        Bun bun = new Bun("name", bunPrice);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sauce", ingredientPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(expectedPrice, burger.getPrice(), 0);

    }
}

