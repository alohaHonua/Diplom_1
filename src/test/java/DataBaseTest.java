import org.junit.Assert;
import org.junit.Test;
import praktikum.Database;

public class DataBaseTest {

    @Test
    public void availableBunsHasThreeBunsTest() {
        Database database = new Database();

        Assert.assertEquals(database.availableBuns().size(), 3);
    }

    @Test
    public void availableIngredientsHasSixIngredientsTest() {
        Database database = new Database();

        Assert.assertEquals(database.availableIngredients().size(), 6);
    }
}
