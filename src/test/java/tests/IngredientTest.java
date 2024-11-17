package tests;

import org.junit.Before;
import org.junit.Test;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testIngredientConstructorSetsFieldsCorrectly() {
        // Используем данные из базы
        Ingredient databaseIngredient = database.availableIngredients().get(0);
        IngredientType expectedType = databaseIngredient.getType();
        String expectedName = databaseIngredient.getName();
        float expectedPrice = databaseIngredient.getPrice();

        // Act
        Ingredient testIngredient = new Ingredient(expectedType, expectedName, expectedPrice);

        // Assert
        assertEquals("Type should be set correctly", expectedType, testIngredient.getType());
        assertEquals("Name should be set correctly", expectedName, testIngredient.getName());
        assertEquals("Price should be set correctly", expectedPrice, testIngredient.getPrice(), 0.0f);
    }

    @Test
    public void testGetNameReturnsCorrectName() {
        // Используем данные из базы
        Ingredient databaseIngredient = database.availableIngredients().get(1);
        String expectedName = databaseIngredient.getName();

        // Создаём новый объект
        Ingredient testIngredient = new Ingredient(databaseIngredient.getType(), expectedName, databaseIngredient.getPrice());

        // Act
        String actualName = testIngredient.getName();

        // Assert
        assertEquals("getName should return the correct name", expectedName, actualName);
    }

    @Test
    public void testGetPriceReturnsCorrectPrice() {
        // Используем данные из базы
        Ingredient databaseIngredient = database.availableIngredients().get(2);
        float expectedPrice = databaseIngredient.getPrice();

        // Создаём новый объект
        Ingredient testIngredient = new Ingredient(databaseIngredient.getType(), databaseIngredient.getName(), expectedPrice);

        // Act
        float actualPrice = testIngredient.getPrice();

        // Assert
        assertEquals("getPrice should return the correct price", expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void testGetTypeReturnsCorrectType() {
        // Используем данные из базы
        Ingredient databaseIngredient = database.availableIngredients().get(3);
        IngredientType expectedType = databaseIngredient.getType();

        // Создаём новый объект
        Ingredient testIngredient = new Ingredient(expectedType, databaseIngredient.getName(), databaseIngredient.getPrice());

        // Act
        IngredientType actualType = testIngredient.getType();

        // Assert
        assertEquals("getType should return the correct type", expectedType, actualType);
    }
}
