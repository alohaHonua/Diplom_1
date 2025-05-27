import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class DataBaseTests {

    private final Bun bunWithVinaigrette;
    private final Ingredient secretIngredient;
    private final IngredientType ingredientType;
    private Database database ;

    @Parameterized.Parameters
    public static Collection<Object[]> dataTests() {
        return Arrays.asList(new Object[][]{
                {new Bun("white bun", 200), new Ingredient(IngredientType.SAUCE, "hot sauce", 100), IngredientType.SAUCE},
                {new Bun("black bun", 100), new Ingredient(IngredientType.FILLING, "cutlet", 150), IngredientType.FILLING},
                {new Bun("red bun", 300), new Ingredient(IngredientType.FILLING, "sausage", 300), IngredientType.FILLING}
        });
    }

    public DataBaseTests(Bun burgerVinegrette, Ingredient secretIngredient, IngredientType ingredientType) {
        this.bunWithVinaigrette = burgerVinegrette;
        this.secretIngredient = secretIngredient;
        this.ingredientType = ingredientType;
    }

    @Before
    public void setUp() {
        database = Mockito.mock(Database.class);
        when(database.availableBuns()).thenReturn(Arrays.asList(bunWithVinaigrette));
        when(database.availableIngredients()).thenReturn(Arrays.asList(secretIngredient));
    }

    @Test
    public void testAvailableIngredients() {
        List<Ingredient> ingredients = database.availableIngredients();
        Assert.assertEquals(secretIngredient.getName(), ingredients.get(0).getName());
        Assert.assertEquals(secretIngredient.getPrice(), ingredients.get(0).getPrice(), 0.002);
        Assert.assertEquals(ingredientType, ingredients.get(0).getType());
    }

    @Test
    public void testAvailableBuns() {
        List<Bun> buns = database.availableBuns();
        Assert.assertEquals(bunWithVinaigrette.getName(), buns.get(0).getName());
        Assert.assertEquals(bunWithVinaigrette.getPrice(), buns.get(0).getPrice(), 0.002);

    }
}