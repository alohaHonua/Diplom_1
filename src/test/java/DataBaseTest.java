import org.junit.Assert;
import org.junit.Test;
import praktikum.Database;

public class DataBaseTest {
    private final Database database = new Database();

    @Test
    public void availableBunsTest() {
        Assert.assertFalse(database.availableBuns().isEmpty());
    }

    @Test
    public void availableIngredientsTest() {
        Assert.assertFalse(database.availableIngredients().isEmpty());
    }
}