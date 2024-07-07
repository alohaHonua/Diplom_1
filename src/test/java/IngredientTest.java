import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

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
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 3.5f},
                {IngredientType.SAUCE, "Соус традиционный галактический", 1.30f},
                {IngredientType.FILLING, "Говяжий метеорит", 10.11f}
        });
    }
    @Before
    public void Ingredient() {
        ingredient = new Ingredient(type, name, price);
    }
    @Test
    public void getPrice() {
        float result = ingredient.getPrice();
        Assert.assertEquals(price, result, 0.001);
    }
    @Test
    public void getName() {
        String result = ingredient.getName();
        Assert.assertEquals(name, result);
    }
    @Test
    public void getType() {
        IngredientType result = ingredient.getType();
        Assert.assertEquals(type, result);
    }
}
