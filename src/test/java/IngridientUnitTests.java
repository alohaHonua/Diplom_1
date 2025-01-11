import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class IngridientUnitTests {
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngridientUnitTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "Сыр с астероидной плесенью", 4142},
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88}
        });
    }

    @Test
    public void ingredientGetTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void ingredientGetNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void ingredientGetPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(),0);
    }
}
