package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    
    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
            {IngredientType.SAUCE, "Майонез", 20.0f},
            {IngredientType.SAUCE, "Горчица", 15.0f},
            {IngredientType.FILLING, "Салат", 35.0f},
            {IngredientType.FILLING, "Говяжья котлета", 150.0f}
        };
    }
    
    @Test
    public void ingredientConstructorSetsCorrectName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Имя ингредиента должно быть установлено правильно через конструктор", 
                    name, ingredient.getName());
    }

    @Test
    public void ingredientConstructorSetsCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена ингредиента должна быть установлена правильно через конструктор",
                price, ingredient.getPrice(), 0.001f);
    }
} 