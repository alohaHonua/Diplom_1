import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)

public class GetBunTest {

    private final String name;
    float price;

    public GetBunTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters(name = "Тестовые данные Bun: {0} ")
    public static Object[][] bunName() {
        return new Object[][]{
                {"black bun"},
                {"green bun"},
                {"sour cream"},
                {""},
                {null},
                {"цельнозерновая булочка"},
                {"red$bun"},
                {"greengreengreengreengreengreengreengreen bunbunbunbunbunbun"},
        };
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        Assert.assertEquals("Название булочки не соответствует переданному", name, actual);
    }
}
