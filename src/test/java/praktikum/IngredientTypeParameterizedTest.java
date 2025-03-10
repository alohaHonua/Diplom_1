package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    
    public IngredientTypeParameterizedTest(IngredientType type, String name, float price) {
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
    public void ingredientConstructorSetsCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента должен быть установлен правильно через конструктор", 
                    type, ingredient.getType());
    }
} 