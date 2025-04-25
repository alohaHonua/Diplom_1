package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.*;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class BurgerTest {

    private static Database mockDatabase = Mockito.mock(Database.class);

    private Burger burger;

    static {

        Mockito.when(mockDatabase.availableBuns())
                .thenReturn(List.of(
                        new Bun("black bun", 100),
                        new Bun("white bun", 200),
                        new Bun("red bun", 300)
                ));

        Mockito.when(mockDatabase.availableIngredients())
                .thenReturn(List.of(
                        new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                        new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                        new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
                        new Ingredient(IngredientType.FILLING, "cutlet", 100),
                        new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                        new Ingredient(IngredientType.FILLING, "sausage", 300)
                ));
    }

    @Mock
    private Ingredient mockIngredient;

    @Parameterized.Parameters
    public static Collection burgerDataProvider() {
        List<Bun> buns = mockDatabase.availableBuns();
        Map<IngredientType, List<Ingredient>> ingredientsByType = mockDatabase.availableIngredients()
                .stream()
                .collect(Collectors.groupingBy(Ingredient::getType));

        Object[][] data = new Object[buns.size()][3];
        for (int i = 0; i < buns.size(); i++) {
            Bun bun = buns.get(i);
            List<Ingredient> sauces = ingredientsByType.get(IngredientType.SAUCE);
            List<Ingredient> fillings = ingredientsByType.get(IngredientType.FILLING);
            Ingredient sauce = sauces.get(i);
            Ingredient filling = fillings.get(i);
            data[i] = new Object[]{bun, sauce, filling};
        }
        return Arrays.asList(data);
    }

    private Bun bun;

    private Ingredient sauce;

    private Ingredient filling;

    public BurgerTest(Bun bun, Ingredient sauce, Ingredient filling) {
        this.bun = bun;
        this.sauce = sauce;
        this.filling = filling;
    }

    @Before
    public void init() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
    }

    @Test
    @DisplayName("Добавить ингредиент")
    @Description("Тест добавления ингредиента")
    public void addIngredient() {
        burger.addIngredient(mockIngredient);

        Assert.assertTrue(String.format(
                        "Ингредиент '%s' отсутствует в списке ингредиентов. Ожидалось: true, получено: false",
                        mockIngredient),
                burger.ingredients.contains(mockIngredient));
    }

    @Test
    @DisplayName("Удалить ингредиент")
    @Description("Тест удаления ингредиента")
    public void removeIngredient() {

        Ingredient ingredient = burger.ingredients.get(0);

        burger.removeIngredient(0);

        Assert.assertFalse(String.format(
                        "Ингредиент '%s' всё ещё присутствует в списке ингредиентов после удаления. Ожидалось: false, получено: true",
                        ingredient),
                burger.ingredients.contains(ingredient));
    }

    @Test
    @DisplayName("Переместить ингредиент")
    @Description("Тест смещения/перемещения ингредиента")
    public void moveIngredient() {

        Ingredient ingredient = burger.ingredients.get(0);

        burger.moveIngredient(0, 1);

        Assert.assertTrue(String.format(
                        "Ингредиент '%s' не был перемещён на новую позицию. Ожидалось, что в позиции 1 будет: '%s', получено: '%s'",
                        ingredient, ingredient, burger.ingredients.get(1)),
                burger.ingredients.get(1).equals(ingredient));
    }

    @Test
    @DisplayName("Подсчет цены")
    @Description("Тест подсчета цены получившегося бургера")
    public void getPrice() {
        float expectedPrice = bun.getPrice() * 2 + sauce.getPrice() + filling.getPrice();
        Assert.assertEquals(String.format(
                        "Цена бургера рассчитана неверно. Ожидалось: %.3f, получено: %.3f",
                        expectedPrice, burger.getPrice()),
                expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    @DisplayName("Формирование чека")
    @Description("Тест формирования чека")
    public void getReceipt() {
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        expectedReceipt.append(String.format("= %s %s =%n", sauce.getType().toString().toLowerCase(),
                sauce.getName()));

        expectedReceipt.append(String.format("= %s %s =%n", filling.getType().toString().toLowerCase(),
                filling.getName()));

        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", bun.getPrice() * 2 + sauce.getPrice() + filling.getPrice()));

        Assert.assertEquals(String.format(
                        "Чек бургера сформирован неверно. Ожидаемый результат:%n%s%nПолученный результат:%n%s",
                        expectedReceipt.toString(), burger.getReceipt()),
                expectedReceipt.toString(), burger.getReceipt());
    }
}