import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
    public class IngredientTypeTest {
        private final IngredientType type;
        private final IngredientType name;

        public IngredientTypeTest(IngredientType type, IngredientType name) {
            this.type = type;
            this.name = name;
        }
        @Parameterized.Parameters
        public static Object[][] Up() {
            return new Object[][] {
                    {IngredientType.SAUCE, IngredientType.valueOf("SAUCE")},
                    {IngredientType.FILLING, IngredientType.valueOf("FILLING")}
            };
        }

        @Test
        public void valueOfSauce() {
            assertEquals(type, name);
        }
    }

