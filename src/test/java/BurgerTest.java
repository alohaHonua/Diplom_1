import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Bun bun = new Bun("Заварная", 2.49f);
        burger.setBuns(bun);

        Assert.assertEquals("Bun должен быть установлен", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Cheese", 5.0f);
        burger.addIngredient(ingredient);

        Assert.assertEquals("В списке должен быть 1 ингредиент", 1, burger.ingredients.size());
        Assert.assertEquals("Добавленный ингредиент не совпал", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ing1 = new Ingredient(IngredientType.SAUCE, "Ketchup", 2.0f);
        Ingredient ing2 = new Ingredient(IngredientType.FILLING, "Tomato", 1.0f);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);

        burger.removeIngredient(0);

        Assert.assertEquals("Должен остаться 1 ингредиент", 1, burger.ingredients.size());
        Assert.assertEquals("В списке должен остаться ing2", ing2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientTest() {
        Ingredient firstIng = new Ingredient(IngredientType.SAUCE, "Ketchup", 2.0f);
        Ingredient secondIng = new Ingredient(IngredientType.FILLING, "Tomato", 1.0f);
        Ingredient thirdIng = new Ingredient(IngredientType.FILLING, "Cheese", 4.0f);

        burger.addIngredient(firstIng);
        burger.addIngredient(secondIng);
        burger.addIngredient(thirdIng);

        burger.moveIngredient(0, 2);

        Assert.assertEquals("На индексе 0 должен быть ing2", secondIng, burger.ingredients.get(0));
        Assert.assertEquals("На индексе 1 должен быть ing3", thirdIng, burger.ingredients.get(1));
        Assert.assertEquals("На индексе 2 должен быть ing1", firstIng, burger.ingredients.get(2));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bunMock.getPrice()).thenReturn(2.0f);
        Mockito.when(ingredientMock.getPrice()).thenReturn(3.0f);

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);

        float expected = (2.0f * 2) + 3.0f + 3.0f;
        Assert.assertEquals("Цена бургера должна быть 10.0", expected, burger.getPrice(), 0.0f);

        Mockito.verify(bunMock, Mockito.times(1)).getPrice();
        Mockito.verify(ingredientMock, Mockito.times(2)).getPrice();
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bunMock.getName()).thenReturn("Test bun");
        Mockito.when(bunMock.getPrice()).thenReturn(2f);
        Mockito.when(ingredientMock.getName()).thenReturn("HotSauce");
        Mockito.when(ingredientMock.getPrice()).thenReturn(3f);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);

        String actualReceipt = burger.getReceipt();
        float expectedPrice = bunMock.getPrice() + ingredientMock.getPrice() + bunMock.getPrice();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("(==== %s ====)\n", bunMock.getName()));
        sb.append(String.format("= %s %s =\n",ingredientMock.getType().toString().toLowerCase(),ingredientMock.getName()));
        sb.append(String.format("(==== %s ====)\n", bunMock.getName()));
        sb.append(String.format("\nPrice: %f\n", expectedPrice));

        String expectedReceipt = sb.toString();
        String normalizedActual = actualReceipt.replace("\r\n", "\n");
        String normalizedExpected = expectedReceipt.replace("\r\n", "\n");

        Assert.assertEquals("Чек сформирован некорректно", normalizedExpected, normalizedActual);
    }
}
