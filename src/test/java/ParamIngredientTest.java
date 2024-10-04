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
public class ParamIngredientTest {

    public IngredientType type;
    public String name;
    public float price;

    public ParamIngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { IngredientType.FILLING, "Cutlet", 100.0f },
                { IngredientType.SAUCE, "Sauce", 150 },
                { IngredientType.SAUCE, "Mayon naise", 80 }
        });
    }

    // Тест для проверки создания ингредиента
    @Test
    public void testIngredientCreation() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertNotNull("Ингредиент не null", ingredient);
        assertEquals("Название ингредиента верное", name, ingredient.getName());
        assertEquals("Цена ингредиента верна", price, ingredient.getPrice(), 0);
        assertEquals("Тип ингредиента верный", type, ingredient.getType());
    }
}