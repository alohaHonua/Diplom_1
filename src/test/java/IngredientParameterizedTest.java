import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;

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
        public static Object[][] data() {
            return new Object[][]{
                    {IngredientType.SAUCE, "Ketchup", 50f},
                    {IngredientType.FILLING, "Bacon", 70f},
                    {IngredientType.SAUCE, "Mustard", 30f}
            };
        }

        @Test
        public void testIngredientCreation() {
            Ingredient ingredient = new Ingredient(type, name, price);
            assertEquals(type, ingredient.getType());
            assertEquals(name, ingredient.getName());
            assertEquals(price, ingredient.getPrice(), 0.01);
        }
    }

