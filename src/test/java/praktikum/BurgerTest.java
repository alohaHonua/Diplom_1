package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientMock;

    @InjectMocks
    private Burger burger;

    @Test
    public void setBun() {
        burger.setBun(bunMock);
        Assert.assertEquals(bunMock, burger.bun);
    }

    @Test
    public void ingredientListBurgerTest() {
        burger.addIngredient(ingredientMock);
        Assert.assertTrue(burger.ingredients.contains(ingredientMock));
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void moveIngredientBurgerTest() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Говяжий метеорит (отбивная)", burger.ingredients.get(1).getName());
    }

    @Test
    public void getPriceBurgerTest() {
        float price = 100;
        when(bunMock.getPrice()).thenReturn(price);
        when(ingredientMock.getPrice()).thenReturn(price);

        burger.setBun(bunMock);
        burger.addIngredient(ingredientMock);

        // Проверяем - цена соответствует ожиданиям (булочка * 2 + ингредиент)
        Assert.assertEquals(price * 2 + price, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceiptBurgerTest() {
        burger.setBun(bunMock);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90));

        String receipt = burger.getReceipt();

        // Проверяем, что строка рецепта содержит название булочки и ингредиентов
        Assert.assertTrue(receipt.contains("Мини-салат Экзо-Плантаго"));
        Assert.assertTrue(receipt.contains("Price"));
        Assert.assertTrue(receipt.contains("Соус Spicy-X"));
    }
}
