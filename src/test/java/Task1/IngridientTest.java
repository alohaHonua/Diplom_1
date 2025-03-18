package Task1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngridientTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Spy
    private Ingredient ingredient ;

    @Parameterized.Parameters
    public static Object[] JackShit() {
        Database database = new Database();
        return database.availableIngredients().stream().map(ingredient -> new Object[]{ingredient.getName(), ingredient.getType(), ingredient.getPrice()}).toArray();
    }

    public IngridientTest(String expectedName, IngredientType expectedType, float expectedPrice) {
        this.ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Test
    public void getPrice() {
        ingredient.getPrice();
        Mockito.verify(ingredient).getPrice();
    }
    @Test
    public void getNameTest() {
        ingredient.getName();
        Mockito.verify(ingredient).getName();
    }
    @Test
    public void getTypeTest() {
        ingredient.getType();
        Mockito.verify(ingredient).getType();
    }
}
