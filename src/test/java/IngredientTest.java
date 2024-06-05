import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType expectedIngredientType = IngredientType.FILLING;
    private String expectedName = "Cheese";
    private float expectedPrice = 100f;


    @Before
    public void setUp () {
        this.ingredient = new Ingredient(expectedIngredientType, expectedName, expectedPrice);
    }

    @Test
    public void getPriceTest() {
        assertEquals("Некорректная цена" ,expectedPrice, ingredient.getPrice(), 0.001);
    }

    @Test
    public void getNameTest() {
        assertEquals("Некорректная наименование" ,expectedName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Некорректный тип ингредиента" ,expectedIngredientType, ingredient.getType());
    }
}
