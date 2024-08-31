import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.*;
public class IngredientTypeTest {
    @Test
    public void fillingNotNull() {
        assertNotNull("Тест провален:ты забыл указать начинку =(", IngredientType.valueOf("FILLING"));
    }
    @Test
    public void sauceNotNull() {
        assertNotNull("Тест провален:ты забыл указать соус =(", IngredientType.valueOf("SAUCE"));
    }
}
