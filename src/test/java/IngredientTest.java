import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest extends TestCase {

    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
                {IngredientType.FILLING, "bobiska", Float.MAX_VALUE},
                {IngredientType.SAUCE, "sosus", Float.MIN_VALUE},
                {null, "Sauce-propal#@", 0}
        };
    }

    @Before
    public void setup() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetPrice() {
        System.out.println("Checking if " + price + " = " + ingredient.getPrice());
        assertEquals(price, ingredient.getPrice());
    }

    @Test
    public void testGetName() {
        System.out.println("Checking if \"" + name + "\" = \"" + ingredient.getName() + "\"");
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        System.out.println("Checking if \"" + type + "\" = \"" + ingredient.getType() + "\"");
        assertEquals(type, ingredient.getType());
    }
}