import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    private final Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;

        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "Лук", 0.5f},
                {IngredientType.FILLING, "Бекон", 1.0f},
                {IngredientType.SAUCE, "Горчица", 0.5f},
                {IngredientType.SAUCE, "Терияки", 1.5f}
        });
    }

    @Test
    public void testIngredientType() {
        Assert.assertEquals("Тип ингредиента не соответсвует заданному при инициации", this.type, this.ingredient.getType());
    }

    @Test
    public void testIngredientName() {
        Assert.assertEquals("Название ингредиента не соответсвует заданному при инициации", this.name, this.ingredient.getName());
    }

    @Test
    public void testIngredientPrice() {
        Assert.assertEquals("Цена ингредиента не соответсвует заданной при инициации", this.price, this.ingredient.getPrice(), 0.0f);
    }
}
