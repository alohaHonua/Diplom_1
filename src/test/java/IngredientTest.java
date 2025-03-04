import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class IngredientTest {
    @Mock
    private IngredientType type;

    private Ingredient ingredient;

    @BeforeEach
    void setUp() {
        ingredient = new Ingredient(type, "Test Ingredient", 11);
    }

    @Test
    void testGetPrice() {
        assertEquals(11, ingredient.getPrice());
    }

    @Test
    void testGetName() {
        assertEquals("Test Ingredient", ingredient.getName());
    }

    @Test
    void testGetType() {
        assertEquals(type, ingredient.getType());
    }
}
