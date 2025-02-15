import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class BurgerTest {
    private Burger burger;
    static Faker faker = new Faker();
    public String nameBun = faker.food().dish();
    public float priceBun  = (float) Math.random();
    public String nameOneIngredient = faker.food().dish();
    public String nameTwoIngredient = faker.food().dish();
    public float priceIngredient  = (float) Math.random();



    @Before
    public void setUp() {
        burger = new Burger();
    }

    public Bun getBunStab() {
        Bun bunStab = Mockito.mock(Bun.class);
        when(bunStab.getName()).thenReturn(nameBun);
        when(bunStab.getPrice()).thenReturn(priceBun);
        return bunStab;
    }

    @Test
    public void checkSetBuns() {
        Bun expectedBun = getBunStab();
        burger.setBuns(expectedBun);
        Assert.assertEquals(expectedBun, burger.bun);

    }

    public Ingredient getOneIngredientStab() {
        Ingredient ingredientStab = mock(Ingredient.class);
        when(ingredientStab.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientStab.getName()).thenReturn(nameOneIngredient);
        when(ingredientStab.getPrice()).thenReturn(priceIngredient);
        return ingredientStab;
    }

    public Ingredient getTwoIngredientStab() {
        Ingredient ingredientStab = mock(Ingredient.class);
        when(ingredientStab.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientStab.getName()).thenReturn(nameTwoIngredient);
        when(ingredientStab.getPrice()).thenReturn(priceIngredient);
        return ingredientStab;
    }

    @Test
    public void checkAddOneAndTwoIngredien() {
        Ingredient expectedOneIngredient= getOneIngredientStab();
        burger.addIngredient(expectedOneIngredient);
        Assert.assertEquals(expectedOneIngredient, burger.ingredients.get(0));
        Ingredient expectedtwoIngredient= getTwoIngredientStab();
        burger.addIngredient(expectedtwoIngredient);
        Assert.assertEquals(expectedtwoIngredient, burger.ingredients.get(1));
    }

    @Test
    public void checkRemoveIngredient() {
        Ingredient expectedOneIngredient= getOneIngredientStab();
        System.out.println(expectedOneIngredient.getType());
        burger.addIngredient(expectedOneIngredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void checkMoveIngredient() {
        Ingredient oneIngredient = getOneIngredientStab();
        Ingredient twoIngredient = getTwoIngredientStab();
        burger.addIngredient(oneIngredient);
        burger.addIngredient(twoIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(oneIngredient.name, burger.ingredients.get(1).name);
    }

    @Test
    public void checkGetPrice() {
        Bun oneBun = getBunStab();
        Ingredient oneIngredient = getOneIngredientStab();
        burger.setBuns(oneBun);
        burger.addIngredient(oneIngredient);
        float actual = burger.getPrice();
        Assert.assertEquals(priceBun * 2 + priceIngredient, actual, 0);
    }

    @Test
    public void checkGetReceipt() {
        Bun oneBun = getBunStab();
        Ingredient oneIngredient = getOneIngredientStab();
        String oneIngredienttype = oneIngredient.getType().toString().toLowerCase();
        String s = String.format("%.6f", priceBun * 2 + priceIngredient);
        burger.setBuns(oneBun);
        burger.addIngredient(oneIngredient);
        String actual = burger.getReceipt();
        String expected = String.format(
                        "(==== "+nameBun+" ====)%n" +
                        "= "+ oneIngredienttype +" "+nameOneIngredient+" =%n" +
                        "(==== "+nameBun+" ====)%n" +
                        "%n" +
                        "Price: "+ s +"%n");
        Assert.assertEquals(expected, actual);
    }

}
