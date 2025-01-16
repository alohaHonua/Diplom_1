package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunNameTest {

    private final String expectedName;

    public BunNameTest(String expectedName){
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { "" },
                { "A" },
                { null },
                { "Very tasty bun" },
                { "!@#$%^&*()_+ 1234567890-== {}:>?< [];',./'" },
        };
    }

    @Test
    public void checkNameTest(){
        float price = 10f;
        Bun bun = new Bun(expectedName, price);
        assertEquals(expectedName, bun.getName());
    }
}
