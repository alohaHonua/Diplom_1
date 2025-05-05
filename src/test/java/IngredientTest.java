import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String expectedName;
    private final float expectedPrice;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String expectedName, float expectedPrice){
        this.type = type;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{index}: Type ingredient={0}, Name=\"{1}\", Price={2}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE, "ketchup", Float.MAX_VALUE}, // Макисмальное значение для цены
                {IngredientType.FILLING, "fish", -Float.MAX_VALUE}, // Минимальное значение для цены
                {IngredientType.FILLING, "", 0.0f}, // Пустое наименование, нулевая цена
                {IngredientType.SAUCE, "$pEc!a|@ $*uce", 9.99f} // Спец символы в наименовании
        });
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, expectedName, expectedPrice);
    }

    @Test
    public void testIngredientGetName(){
        assertEquals("Название ингредиента не совпадает", expectedName, ingredient.getName());
    }

    @Test
    public void testIngredientGetPrice(){
        assertEquals("Цена ингредиента не совпадает", expectedPrice, ingredient.getPrice(), 0.0001f);
    }

    @Test
    public void testIngredientGetType(){
        assertEquals("Тип ингредиента не совпадает", type, ingredient.getType());
    }

}
