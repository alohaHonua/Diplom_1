import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DataBaseTest {


    @Mock
    List<Bun> buns;
    @Mock
    List<Ingredient> ingredients;


    @Test
    public void availableBunsReturnsSameListOfBunsTest() {

        //TODO(): Сделать лучше
        Database database = new Database(buns, ingredients);

        Assert.assertEquals(buns, database.availableBuns());

    }

    @Test
    public void availableIngredientsReturnsSameListOfIngredientsTest() {

        //TODO(): Сделать лучше
        Database database = new Database(buns, ingredients);

        Assert.assertEquals(ingredients, database.availableIngredients());

    }

    @Test
    public void defaultDataBaseHasThreeBunsTest() {
        Database database = new Database();

        int expectedAmountOfBuns = 3;

        Assert.assertEquals(database.availableBuns().size(), expectedAmountOfBuns);
    }

    @Test
    public void defaultDataBaseHasSixIngredientsTest() {
        Database database = new Database();

        int expectedAmountOfIngredients = 6;

        Assert.assertEquals(database.availableIngredients().size(), expectedAmountOfIngredients);
    }
}
