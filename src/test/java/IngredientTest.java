import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.CsvSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @ParameterizedTest
    @EnumSource(IngredientType.class)
    void testIngredientConstructorAndGetters(IngredientType type) {
        String name = "Test Ingredient";
        float price = 100;

        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "Hot Sauce, 100",
            "Sour Cream, 200",
            "Chili Sauce, 300"
    })
    void testIngredientWithDifferentNamesAndPrices(String name, float price) {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001);
    }

    @Test
    void testIngredientWithZeroPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Free Filling", 0);

        assertEquals(0, ingredient.getPrice(), 0.001);
    }
}