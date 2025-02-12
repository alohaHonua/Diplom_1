import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static final String BUN_NAME = "Флюоресцентная булка R2-D3";
    private static final float BUN_PRICE = 988;
    private static final String SAUSE_NAME = "Соус Spicy-X";
    private static final float SAUSE_PRICE = 80;
    private static final String FILLING_NAME = "Мясо бессмертных моллюсков Protostomia";
    private static final float FILLING_PRICE = 1300;
    private static final float BURGER_PRICE = 4656;
    private static final String RECEIPT_EXPECTED = "(==== Флюоресцентная булка R2-D3 ====)\r\n= filling Мясо бессмертных моллюсков Protostomia =\r\n= sauce Соус Spicy-X =\r\n= filling Мясо бессмертных моллюсков Protostomia =\r\n(==== Флюоресцентная булка R2-D3 ====)\r\n\r\nPrice: 4656,000000\r\n";
    private IngredientType ingredientTypeSauce;
    private IngredientType ingredientTypeFilling;
    private Bun bun;
    private float price;
    private String receipt;

    @Spy
    Burger burger;

    @Test
    public void burgTest() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
        ingredientTypeSauce = IngredientType.SAUCE;
        ingredientTypeFilling = IngredientType.FILLING;
        Ingredient ingredientSauce = new Ingredient(ingredientTypeSauce, SAUSE_NAME, SAUSE_PRICE);
        Ingredient ingredientFilling = new Ingredient(ingredientTypeFilling, FILLING_NAME, FILLING_PRICE);
        // Собираем бургер
        // Добавляем булку
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
        // Добавляем ингредиенты
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientFilling);
        Mockito.verify(burger, Mockito.times(4)).addIngredient(Mockito.any());
        // Удаляем ингредиенты
        burger.removeIngredient(1);
        Mockito.verify(burger).removeIngredient(1);
        // Перемещаем ингредиенты
        burger.moveIngredient(0, 1);
        Mockito.verify(burger).moveIngredient(0,1);
        // Цена бургера
        price = burger.getPrice();
        Mockito.verify(burger,Mockito.times(1)).getPrice();
        Assert.assertEquals(BURGER_PRICE, price, 0);
        // Чек
        receipt = burger.getReceipt();
        Mockito.verify(burger,Mockito.times(1)).getReceipt();
        Assert.assertEquals(RECEIPT_EXPECTED, receipt);
    }
}
