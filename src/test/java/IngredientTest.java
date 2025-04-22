import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Сальса", 100f},
                {IngredientType.FILLING, "Котлета", 200f},
                {IngredientType.SAUCE, "Кетчуп", 150f},
                {IngredientType.FILLING, "Огурец", 300f}
        });
    }

    @Before
    public void init() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getTypeReturnsCorrectType() {
        assertEquals("Тип ингредиента должен совпадать", type, ingredient.getType());
    }

    @Test
    public void getNameReturnsCorrectName() {
        assertEquals("Название ингредиента должно совпадать", name, ingredient.getName());
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        assertEquals("Цена ингредиента должна совпадать", price, ingredient.getPrice(), 0.0f);
    }
}