import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.IBun;
import praktikum.IIngredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class BurgerTest {

    //Данные, принятые из параметризации, не изменяемы
    private final String initialBunName;
    private final float initialBunPrice;
    private final Object[][] initialIngredientsParameters;
    //Данные, создаваемые перед каждым тестом из данных параметризации, изменяемы во время теста
    private Burger currentBurger;
    private IBun currentBun;
    private List<IIngredient> currentIngredients;


    public BurgerTest(String initialBunName, float initialBunPrice, Object[][] initialIngredientsParameters) {
        this.initialBunName = initialBunName;

        this.initialBunPrice = initialBunPrice;

        this.initialIngredientsParameters = initialIngredientsParameters;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Булочка ржаная", 20f,
                        new Object[][]{{IngredientType.SAUCE, "Кетчуп", 5f},
                                {IngredientType.SAUCE, "Горчица", 10f},
                                {IngredientType.FILLING, "Котлета", 70f},
                                {IngredientType.FILLING, "Сыр", 20f}}
                },
                {"Булочка с кунжутом", 10f,
                        new Object[][]{{IngredientType.SAUCE, "Горчица", 10f},
                                {IngredientType.FILLING, "Колбаса", 50f},
                                {IngredientType.FILLING, "Бекон", 60f}}
                },
                {"Батон", 15f,
                        new Object[][]{{IngredientType.FILLING, "Колбаса", 50f}}
                },
                {"Булочка пшеничная", 8f,
                        new Object[][]{}
                }
        });
    }

    private float getExpectedPrice() {
        float expectedPrice = currentBun.getPrice() * 2;

        for (IIngredient ingredient : currentIngredients) {
            expectedPrice += ingredient.getPrice();
        }
        return expectedPrice;
    }

    private String getExpectedReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", currentBun.getName()));

        for (IIngredient ingredient : currentIngredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", currentBun.getName()));
        receipt.append(String.format("%nPrice: %f%n", getExpectedPrice()));

        return receipt.toString();
    }

    @Before()
    public void init() {
        currentBun = Mockito.mock(IBun.class);
        Mockito.when(currentBun.getName()).thenReturn(initialBunName);
        Mockito.when(currentBun.getPrice()).thenReturn(initialBunPrice);

        currentBurger = new Burger();
        currentBurger.setBuns(currentBun);

        currentIngredients = new ArrayList<>();
        for (Object[] parameters : initialIngredientsParameters) {
            IIngredient ingredient = Mockito.mock(IIngredient.class);
            Mockito.when(ingredient.getType()).thenReturn((IngredientType) parameters[0]);
            Mockito.when(ingredient.getName()).thenReturn((String) parameters[1]);
            Mockito.when(ingredient.getPrice()).thenReturn((float) parameters[2]);

            currentBurger.addIngredient(ingredient);
            currentIngredients.add(ingredient);
        }
    }

    @Test
    public void basicPriceTest() {
        Assert.assertEquals("Стоимость бургера после его создания не соответсвует ожидаемой", getExpectedPrice(), currentBurger.getPrice(), 0f);
    }

    @Test
    public void basicReceiptTest() {
        Assert.assertEquals("Чек после создания бургера не соответствует ожидаемому", getExpectedReceipt(), currentBurger.getReceipt());
    }

    public void changeBun() {
        IBun newBun = Mockito.mock(IBun.class);
        Mockito.when(newBun.getName()).thenReturn("Бесплатная булочка");
        Mockito.when(newBun.getPrice()).thenReturn(0f);

        currentBurger.setBuns(newBun);
        this.currentBun = newBun;
    }

    @Test
    public void changeBunPriceTest() {
        changeBun();
        Assert.assertEquals("Стоимость бургера после изменения булочки не соответсвует ожидаемой", getExpectedPrice(), currentBurger.getPrice(), 0f);
    }

    @Test
    public void changeBunReceiptTest() {
        changeBun();
        Assert.assertEquals("Чек после замены булочки не соответствует ожидаемому", getExpectedReceipt(), currentBurger.getReceipt());
    }

    private void removeIngredient() {
        if (currentIngredients.size() > 0) {
            currentIngredients.remove(0);
            currentBurger.removeIngredient(0);
        }
    }

    @Test
    public void removeIngredientPriceTest() {
        removeIngredient();
        Assert.assertEquals("Стоимость бургера после удаления ингредиента не соответсвует ожидаемой", getExpectedPrice(), currentBurger.getPrice(), 0);
    }

    @Test
    public void removeIngredientReceiptTest() {
        removeIngredient();
        Assert.assertEquals("Чек после удаления ингредиента не соответствует ожидаемому", getExpectedReceipt(), currentBurger.getReceipt());
    }

    private void moveIngredient() {
        if (currentIngredients.size() > 0) {
            currentIngredients.add(0, currentIngredients.remove(currentIngredients.size() - 1));
            currentBurger.moveIngredient(currentIngredients.size() - 1, 0);
        }
    }

    @Test
    public void moveIngredientPriceTest() {
        moveIngredient();
        Assert.assertEquals("Стоимость бургера после перемещения ингредиента не соответсвует ожидаемой", getExpectedPrice(), currentBurger.getPrice(), 0f);
    }

    @Test
    public void moveIngredientReceiptTest() {
        moveIngredient();

        Assert.assertEquals("Чек после перемещения ингредиента не соответствует ожидаемому", getExpectedReceipt(), currentBurger.getReceipt());
    }

    private void addIngredient() {
        IIngredient newIngredient = Mockito.mock(IIngredient.class);
        Mockito.when(newIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(newIngredient.getName()).thenReturn("Салями");

        currentIngredients.add(newIngredient);
        currentBurger.addIngredient(newIngredient);
    }

    @Test
    public void addIngredientPriceTest() {
        addIngredient();
        Assert.assertEquals("Стоимость бургера после удаления ингредиента не соответсвует ожидаемой", getExpectedPrice(), currentBurger.getPrice(), 0f);
    }

    @Test
    public void addIngredientReceiptTest() {
        addIngredient();

        Assert.assertEquals("Чек после удаления ингредиента не соответствует ожидаемому", getExpectedReceipt(), currentBurger.getReceipt());
    }

}
