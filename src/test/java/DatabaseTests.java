import org.junit.Assert;
import org.junit.Test;
import praktikum.Database;

public class DatabaseTests {
    Database database = new Database();

    @Test
    public void checkBunListSize() {
        Assert.assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void checkIngredientListSize() {
        Assert.assertEquals(6, database.availableIngredients().size());
    }
}
