import praktikum.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


    @RunWith(Parameterized.class)
    public class IngredientTest {
        private final IngredientType type;
        private final String ingredientName;
        private final float ingredientPrice;


        public IngredientTest(IngredientType type, String ingredientName, float ingredientPrice) {
            this.type = type;
            this.ingredientName = ingredientName;
            this.ingredientPrice = ingredientPrice;

        }

        @Parameterized.Parameters
        public static Object[][] data() {
            return new Object[][]{
                    {IngredientType.SAUCE, "Чесночный соус", 12.8f},
                    {IngredientType.FILLING, "Космические перцы", 13.11f}
            };
        }
        @Test
        public void ingredientCreationTest() {
            Ingredient ingredient = new Ingredient(type, ingredientName, ingredientPrice );
            assertEquals("Тип начинки должен быть " + type, type, ingredient.getType());
            assertEquals("Название начинки должно быть " + ingredientName, ingredientName, ingredient.getName());
            assertEquals("Цена начинки должна быть " + ingredientPrice, ingredientPrice, ingredient.getPrice(), 0.001f);
        }

}
