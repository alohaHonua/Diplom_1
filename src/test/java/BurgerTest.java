import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient);

        Assert.assertTrue(burger.ingredients.contains(ingredient));
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient);

        Ingredient ingredient_additional = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient_additional);

        burger.moveIngredient(0,1);

        Assert.assertEquals(ingredient,burger.ingredients.get(1));//ЛОГИКА  ПРОВЕРКИ ПЕРЕМЕЩЕНИЯ
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(Config.BUN_PRICE);

        burger.addIngredient(ingredient);
        when(ingredient.getPrice()).thenReturn(Config.INGREDIENT_PRICE);

        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();
        Assert.assertEquals(expectedPrice, burger.getPrice(), Config.DEF_ASSERT_DELTA);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(Config.BUN_PRICE);
        when(bun.getName()).thenReturn(Config.BUN_NAME);

        burger.addIngredient(ingredient);
        when(ingredient.getPrice()).thenReturn(Config.INGREDIENT_PRICE);
        when(ingredient.getName()).thenReturn(Config.INGREDIENT_NAME);
        when(ingredient.getType()).thenReturn(Config.INGREDIENT_TYPE_FILLING);

        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredient));
        Assert.assertEquals(0, burger.ingredients.size());
    }

}
