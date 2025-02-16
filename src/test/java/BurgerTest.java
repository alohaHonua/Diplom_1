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
    private static final String BUN_NAME = "Флюоресцентная булка R2-D3";
    private static final float BUN_PRICE = 988;
    private static final String SAUSE_NAME = "Соус Spicy-X";
    private static final float SAUSE_PRICE = 80;
    private static final String FILLING_NAME = "Мясо бессмертных моллюсков Protostomia";
    private static final float FILLING_PRICE = 1300;
    private static final float BURGER_PRICE = 4656;
    private static final String RECEIPT_EXPECTED = "(==== Флюоресцентная булка R2-D3 ====)\r\n= filling Мясо бессмертных моллюсков Protostomia =\r\n= sauce Соус Spicy-X =\r\n= filling Мясо бессмертных моллюсков Protostomia =\r\n(==== Флюоресцентная булка R2-D3 ====)\r\n\r\nPrice: 0,000000\r\n";

    private Burger burger;
    private IngredientType ingredientTypeSauce;
    private IngredientType ingredientTypeFilling;
    private float price;
    private String receipt;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredientSauce;
    @Mock
    private Ingredient ingredientFilling;

    @Test
    public void burgerPriceTest() {
        burger = new Burger();
        // Собираем бургер
        // Добавляем булку
        burger.setBuns(bun);
        // Добавляем ингредиенты
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientFilling);
        // Удаляем ингредиенты
        burger.removeIngredient(1);
        // Перемещаем ингредиенты
        burger.moveIngredient(0, 1);
        // Цена бургера
        Mockito.when((bun.getPrice())).thenReturn(BUN_PRICE);
        Mockito.when((ingredientSauce.getPrice())).thenReturn(SAUSE_PRICE);
        Mockito.when((ingredientFilling.getPrice())).thenReturn( FILLING_PRICE);
        price = burger.getPrice();
        Assert.assertEquals("Итоговая цена подсчитана не верно", BURGER_PRICE, price, 0);
        Mockito.verify(bun,Mockito.times(1)).getPrice();
        Mockito.verify(ingredientSauce,Mockito.times(1)).getPrice();
        Mockito.verify(ingredientFilling,Mockito.times(2)).getPrice();
    }

    @Test
    public void burgerReceiptTest() {
        burger = new Burger();
        // Собираем бургер
        // Добавляем булку
        burger.setBuns(bun);
        // Добавляем ингредиенты
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientFilling);
        // Удаляем ингредиенты
        burger.removeIngredient(1);
        // Перемещаем ингредиенты
        burger.moveIngredient(0, 1);
        // Чек
        Mockito.when((bun.getName())).thenReturn(BUN_NAME);
        Mockito.when((ingredientSauce.getType())).thenReturn(IngredientType.SAUCE);
        Mockito.when((ingredientSauce.getName())).thenReturn(SAUSE_NAME);
        Mockito.when((ingredientFilling.getType())).thenReturn(IngredientType.FILLING);
        Mockito.when((ingredientFilling.getName())).thenReturn(FILLING_NAME);
        Assert.assertEquals("Чек не соответствует шаблону", RECEIPT_EXPECTED, burger.getReceipt());
        Mockito.verify(bun,Mockito.times(2)).getName();
        Mockito.verify(ingredientSauce,Mockito.times(1)).getName();
        Mockito.verify(ingredientFilling,Mockito.times(2)).getName();
    }

}
