package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertTrue;
@RunWith(Parameterized.class)
public class DataBaseBunTest {

    private final String bunName;
    private Database database;
    private float price;

    @Before
    public void setUp() {
        database = new Database();
    }

    public DataBaseBunTest(String bunName, float price) {
        this.bunName = bunName;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"black bun", 100}, {"white bun", 200}, {"red bun", 300}
        });
    }

    @Test
    public void testAvailableBunsContainsBunByName() {
        List<Bun> buns = database.availableBuns();
        assertTrue("Buns should contain " + bunName,
                buns.stream().anyMatch(b -> b.getName().equals(bunName) && b.getPrice() == price));
    }

}