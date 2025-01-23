import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)

public class IngredientTest {

    public IngredientType type;
    public String name;
    public float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { IngredientType.FILLING, "cutlet", 100 },
                { IngredientType.SAUCE, "hot sauce", 150 },
                { IngredientType.SAUCE, "mayonnaise", 80 }
        });
    }

    @Test
    public void testIngredientNotNull() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertNotNull("Ингредиент не должен быть null", ingredient);
    }

    @Test
    public void testIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Название ингредиента должно совпадать", name, ingredient.getName());
    }

    @Test
    public void testIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена ингредиента должна совпадать", price, ingredient.getPrice(), 0);
    }

    @Test
    public void testIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента должен совпадать", type, ingredient.getType());
    }
}