import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamNameTest {

    private final String expectedName;
    private final String name;

    public BunParamNameTest(String expectedName, String name) {
        this.expectedName = expectedName;
        this.name = name;
    }
    
    @Parameterized.Parameters(name = "expectedName = {0}, name = {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Флюоресцентная булка", "Флюоресцентная булка"},
                {"Краторная булка", "Краторная булка"},
                {"", ""},
                {null, null},
                {"Kratornaya bun", "Kratornaya bun"},
                {"a".repeat(1000), "a".repeat(1000)},
                {"Булка123456", "Булка123456"},
                {"@#^%()!?", "@#^%()!?"},
                {"ýąßÝʎր", "ýąßÝʎր"}

        };
    }

    @Test
    public void getNameForBunReturnCorrectNameTest() {
        Bun bun = new Bun(name, 1255);
        String actualName = bun.getName();
        assertEquals("Ожидаемый результат = " + expectedName + ", а должен быть = " + actualName, expectedName, actualName);
    }
}

