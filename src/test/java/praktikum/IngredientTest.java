package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private final static double DELTA = 0.01;

    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {SAUCE, "Соус Spicy-X", 90.0F},
                {FILLING, "Биокотлета из марсианской Магнолии", 424.0F}
        };
    }

    @Test
    public void getPriceTest() {
        assertEquals("Метод getPrice() должен вернуть правильную цену", price, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getNameTest(){
        assertEquals("Метод getName() должен вернуть правильное имя", name, ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        assertEquals("Метод getType() должен вернуть правильный тип", type, ingredient.getType());
    }
}
