import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;


    //Подготовка булочек
    @Test
    public void setBunsTest() {
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        Assert.assertEquals(bun, testBurger.bun);

    }
    //Добавление ингридиентов
    @Test
    public void addIngredientTest() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(ingredientOne);
        Assert.assertEquals(1, testBurger.ingredients.size());
        Assert.assertEquals(ingredientOne, testBurger.ingredients.get(0));
    }
    //Убрать ингридиент
    @Test
    public void removeIngredientTest() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(ingredientOne);
        testBurger.removeIngredient(0);
        Assert.assertEquals(0, testBurger.ingredients.size());

    }
    //Получить цену бургера с несколькими игнридиентами
    @Test
    public void getPriceSeveralIngredientsBurgerTest() {
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredientOne);
        testBurger.addIngredient(ingredientTwo);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(20F);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(40F);
        Assert.assertEquals(80, testBurger.getPrice(), 0);

    }
    //Получить цену бургера с неск игнридиентами
    @Test
    public void moveIngredientTest() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(ingredientOne);
        testBurger.addIngredient(ingredientTwo);
        testBurger.moveIngredient(0, 1);
        Assert.assertEquals(ingredientOne, testBurger.ingredients.get(1));
        Assert.assertEquals(ingredientTwo, testBurger.ingredients.get(0));

    }

    @Test
    public void getPriceOneIngredientBurgerTest() {
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredientOne);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(20F);
        Assert.assertEquals(40, testBurger.getPrice(), 0);

    }

    @Test
    public void getReceiptOneIngredientBurgerTest() {
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredientOne);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(20F);
        Mockito.when(ingredientOne.getName()).thenReturn("chili sauce");
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);

        Assert.assertEquals(
                String.format("(==== %s ====)%n", testBurger.bun.getName()) +
                        String.format("= %s %s =%n", testBurger.ingredients.get(0).getType().toString().toLowerCase(),
                                testBurger.ingredients.get(0).getName()) +
                        String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("%nPrice: %f%n", testBurger.getPrice()),
                testBurger.getReceipt());

    }

    @Test
    public void getReceiptSeveralIngredientsBurgerTest() {
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredientOne);
        testBurger.addIngredient(ingredientTwo);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(20F);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(100F);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredientOne.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientTwo.getName()).thenReturn("cutlet");
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);

        Assert.assertEquals(
                String.format("(==== %s ====)%n", testBurger.bun.getName()) +
                        String.format("= %s %s =%n", testBurger.ingredients.get(0).getType().toString().toLowerCase(),
                                testBurger.ingredients.get(0).getName()) +
                        String.format("= %s %s =%n", testBurger.ingredients.get(1).getType().toString().toLowerCase(),
                                testBurger.ingredients.get(1).getName()) +
                        String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("%nPrice: %f%n", testBurger.getPrice()),
                testBurger.getReceipt());

    }
}
