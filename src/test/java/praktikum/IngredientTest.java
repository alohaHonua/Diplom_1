package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Ketchup", 50},
                {IngredientType.FILLING, "Cutlet", 150}
        });
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameReturnsCorrectName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeReturnsCorrectType() {
        assertEquals(type, ingredient.getType());
    }
}
