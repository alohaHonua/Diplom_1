import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

        private final praktikum.IngredientType IngredientType;
        private final String name;
        private final float price;


        public IngredientTest(IngredientType IngredientType, String name, float price) {
            this.IngredientType = IngredientType;
            this.name = name;
            this.price = price;
        }

        @Parameterized.Parameters
        public static Object[][] getData() {
            return new Object[][]{
                    {SAUCE, Constants.firstsause, Constants.firstsouseprice},
                    {SAUCE, Constants.secondsause, Constants.secondsouseprice},
                    {FILLING, Constants.firstfilling, Constants.firstbunprice},
                    {FILLING, Constants.secondfilling, Constants.secondfillingprice}
            };
        }

        @Test
        public void getPriceTest() {
            Ingredient ingredient = new Ingredient(IngredientType, name, price);
            assertEquals(price, ingredient.getPrice(), 0.1);
        }

        @Test
        public void getNameTest() {
            Ingredient ingredient = new Ingredient(IngredientType, name, price);
            assertEquals(name, ingredient.getName());
        }

        @Test
        public void getTypeTest() {
            Ingredient ingredient = new Ingredient(IngredientType, name, price);
            assertEquals(IngredientType, ingredient.getType());
        }
}
