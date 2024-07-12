import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerTest {
    public IngredientType ingredientType;
    public String ingredientName;
    public float ingredientPrice;
    public String bunName;
    public float bunPrice;

    public BurgerTest(IngredientType ingredientType, String ingredientName, float ingredientPrice, String bunName, float bunPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "sichuan sauce", 13.6F, "big bun", 12.4F},
                {IngredientType.FILLING, "black hole cheese", 22.6f, "mega soft bun", 13.7F},
                {IngredientType.SAUCE, "mars barbecue sauce", 18.8f, "strawberry bun", 15.8F},

        };
    }

    @Test
    public void setBunsTest() {
        Bun bun = Mockito.mock(Bun.class); // Mock bun

        Burger testBurger = new Burger();
        Bun testBun = new Bun(bunName, bunPrice);

        System.out.println(testBun.getName());

        testBurger.setBuns(testBun);
        assertSame(testBurger.bun, testBun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);// Mock ingredient

        Burger testBurger = new Burger();
        testBurger.addIngredient(ingredient);

        assertEquals(1, testBurger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = Mockito.mock(Ingredient.class); // Mock ingredient

        ArrayList<Ingredient> array = new ArrayList<>();
        array.add(ingredient);
        Burger testBurger = new Burger();

        testBurger.ingredients = array;
        testBurger.removeIngredient(0);

        assertTrue(testBurger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient = Mockito.mock(Ingredient.class); // Mock ingredient
        Ingredient ingredient1 = Mockito.mock(Ingredient.class); // Mock ingredient1

        Burger testBurger = new Burger();

        ArrayList<Ingredient> expectedArray = new ArrayList<>();
        expectedArray.add(ingredient);
        expectedArray.add(ingredient1);

        ArrayList<Ingredient> actualArray = new ArrayList<>();
        actualArray.add(ingredient);
        actualArray.add(ingredient1);

        testBurger.ingredients = actualArray;

        testBurger.moveIngredient(1,0);

        assertSame(testBurger.ingredients.get(0), expectedArray.get(1));


    }

    @Test // Здесь можно в параметризацию
    public void getPriceTest() {
        Ingredient ingredient = Mockito.mock(Ingredient.class); // Mock ingredient
        Bun bun = Mockito.mock(Bun.class); // Mock bun

        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        float expectedTestPrice = (ingredient.getPrice() + (bun.getPrice() * 2));

        Burger testBurger = new Burger();
        ArrayList<Ingredient> array = new ArrayList<>();
        array.add(ingredient);
        testBurger.ingredients = array;
        testBurger.bun = bun;

        assertEquals(expectedTestPrice, testBurger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Ingredient ingredient = Mockito.mock(Ingredient.class); // Mock ingredient
        Bun bun = Mockito.mock(Bun.class); // Mock bun

        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        String expectedPriceString = String.format("%.6f", ingredient.getPrice() + (bun.getPrice() * 2));
        String expectedIngredientName = ingredient.getName();
        String expectedBunName = bun.getName();
        String expectedIngredientType = ingredient.getType().toString().toLowerCase();

        Burger testBurger = new Burger();
        ArrayList<Ingredient> array = new ArrayList<>();
        array.add(ingredient);
        testBurger.ingredients = array;
        testBurger.bun = bun;

        String expectedString = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %s%n", expectedBunName, expectedIngredientType, expectedIngredientName, expectedBunName, expectedPriceString);

        String actualString = testBurger.getReceipt();

        assertEquals(expectedString, actualString);
    }
}
