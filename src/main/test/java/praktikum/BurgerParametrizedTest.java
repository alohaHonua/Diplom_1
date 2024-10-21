package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {
    private Burger burger;
    private Ingredient sauce;
    private Ingredient filling;
    private final String name;
    private final float price;

    public BurgerParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    // Создаю ингредиенты для бургера (соус и начинку) и сам объект бургера
    @Before
    public void createNewInstance() {
        sauce = new Ingredient(IngredientType.SAUCE, "chili", 20.0f);
        filling = new Ingredient(IngredientType.FILLING, "cheese", 15.5f);
        burger = new Burger();
    }

    // Параметризованный метод возвращает массив объектов,
    // содержащий различные комбинации параметров (имя и цена булочек)
    // которые будут использоваться в тестах.
    // Каждый элемент массива будет одним из запусков теста.
    @Parameterized.Parameters(name = "{index} : price = {1}")
    public static Object[][] getBunData() {
        return new Object[][] {
                {"original-free", 0.0f},
                {"original", 200.0f}
        };
    }

    // Создаю объект Bun с заданным именем и ценой
    // Добавляю булочку, соус и начинку в бургер и рассчитываю ожидаемую цену
    // Сравниваю рассчитанную цену с фактической с помощью assertEquals
    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expected = bun.price * 2 + sauce.price + filling.price;
        float actual = burger.getPrice();

        assertEquals("Incorrect values burger price", expected, actual, 0);
    }
}