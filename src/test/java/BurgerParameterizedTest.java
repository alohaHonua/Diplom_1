import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class BurgerParameterizedTest {
    @Spy
    private Burger burger;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;
    @ParameterizedTest
    @MethodSource("ingredientProvider")
    void testAddIngredientParameterized(Ingredient ingredient, String expectedName, float expectedPrice) {
        burger.addIngredient(ingredient);
        assertEquals(expectedName, burger.ingredients.get(0).getName());
        assertEquals(expectedPrice, burger.ingredients.get(0).getPrice());
    }

    private static Stream<Arguments> ingredientProvider() {
        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getName()).thenReturn("Ketchup");
        when(ingredient1.getPrice()).thenReturn(0.5f);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getName()).thenReturn("Cheese");
        when(ingredient2.getPrice()).thenReturn(1.0f);

        return Stream.of(
                Arguments.of(ingredient1, "Ketchup", 0.5f),
                Arguments.of(ingredient2, "Cheese", 1.0f)
        );
    }
}
