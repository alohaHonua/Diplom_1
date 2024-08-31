
import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertNotNull;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {


    @Test
    public void sauceNotNull() {
        assertNotNull("Отсутствует SAUCE",
                IngredientType.valueOf(String.valueOf(SAUCE)));

    }

    @Test
    public void fillingNotNull() {
        assertNotNull("Отсутствует FILLING",
                IngredientType.valueOf(String.valueOf(FILLING)));

    }

}
