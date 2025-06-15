import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Кетчуп", 0.5f},
                {IngredientType.FILLING, "Сыр", 1.5f},
                {IngredientType.SAUCE, "Барбекю", 0.8f}
        });
    }

    @Test
    public void testIngredientGetters() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals("Тип ингредиента не совпадает", type, ingredient.getType());
        assertEquals("Имя ингредиента не совпадает", name, ingredient.getName());
        assertEquals("Цена ингредиента не совпадает", price, ingredient.getPrice(), 0.001f);
    }
}
