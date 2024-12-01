package com.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {
    String defaultName = "Just sauce";
    IngredientType defaultIngredientType = IngredientType.SAUCE;
    float defaultPrice = 200.0f;

    @Test
    public void testGetPrice() {
        float expectedPrice = 100.0f;
        Ingredient ingredient = new Ingredient(defaultIngredientType, defaultName, expectedPrice);

        float actualPrice = ingredient.getPrice();

        assertEquals(expectedPrice, actualPrice,
                String.format("Ожидается цена %f, а возвращается %f", expectedPrice, actualPrice));
    }

    @Test
    public void testGetName() {
        String expectedName = "ketchup";
        Ingredient ingredient = new Ingredient(defaultIngredientType, expectedName, defaultPrice);

        String actualName = ingredient.getName();

        assertEquals(expectedName, actualName,
                String.format("Ожидается имя %s, а возвращается %s", expectedName, actualName));
    }

    @ParameterizedTest
    @MethodSource("ingredientTypeProvider")
    public void testGetType(IngredientType expectedType) {
        // Arrange
        Ingredient ingredient = new Ingredient(expectedType, defaultName, defaultPrice);

        // Act
        IngredientType actualType = ingredient.getType();

        // Assert
        assertEquals(expectedType, actualType,
                String.format("Ожидается тип %s, а возвращается %s", expectedType, actualType));
    }

    private static Stream<IngredientType> ingredientTypeProvider() {
        return Stream.of(IngredientType.FILLING, IngredientType.SAUCE);
    }
}