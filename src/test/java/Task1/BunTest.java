package Task1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Database;


@RunWith(Parameterized.class)
public class BunTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Spy
    private Bun bun;

    @Parameterized.Parameters
    public static Object[] Jack() {
        Database database = new Database();

        return database.availableBuns().stream().map(bun -> new Object[]{bun}).toArray();
    }

    public BunTest(Bun bun) {
        this.bun = new Bun(bun.getName(), bun.getPrice());
    }


    @Before
    public void setUp() {
    }
    @Test
    public void getNameTest() {
        bun.getName();
        Mockito.verify(bun).getName();
    }
    @Test
    public void getPriceTest() {
        bun.getPrice();
        Mockito.verify(bun).getPrice();
    }
}