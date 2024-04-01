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
    private IngredientType type;
    private String name;
    private float price;
    private Ingredient ingredient;
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
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE, "Кисло-сладкий", 1.00f},
                {IngredientType.FILLING, "Мясо", 2.00f},
        });
    }

    @Test
    public void testGetPrice() {
        assertEquals("Incorrect price", price, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void testGetName() {
        assertEquals("Incorrect name", name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals("Incorrect type", type, ingredient.getType());
    }
}
