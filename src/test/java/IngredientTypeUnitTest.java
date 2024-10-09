import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertArrayEquals;

public class IngredientTypeUnitTest {
    @Test
            public void checkIngredientTypeValues(){
    IngredientType[] values = IngredientType.values();
        assertArrayEquals(new IngredientType[]{IngredientType.SAUCE, IngredientType.FILLING}, values);
}
}
