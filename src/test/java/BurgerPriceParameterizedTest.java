import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerPriceParameterizedTest {

    private Burger burger;
    private final float bunPrice;
    private final float ingredientPrice;
    private final float expectedPrice;

    public BurgerPriceParameterizedTest(float bunPrice, float ingredientPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{index}: bunPrice={0}, ingredientPrice={1}, expectedPrice={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY}, // Переполнение
                {Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE * 2 + Float.MIN_VALUE}, // Минимальное значение
                {0.0f, 0.0f, 0.0f}, // Нулевая цена
                {2.5f, 5.0f, 2.5f * 2 + 5.0f}, // Обычное значение
                {3.0f, -2.0f, 3.0f * 2 + (-2.0f)} // Отрицательная цена
        });
    }

    @Before
    public void setUp() {
        burger = new Burger();

        Bun bun = new Bun("Булочка", bunPrice);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Фарш", ingredientPrice);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void testPriceCalculation() {
        float actualPrice = burger.getPrice();

        if (Float.isInfinite(expectedPrice)) {
            assertTrue("Ожидалась бесконечность при переполнении", Float.isInfinite(actualPrice));
        } else {
            assertEquals("Цена не совпадает", expectedPrice, actualPrice, 0.0001f);
        }
    }
}
