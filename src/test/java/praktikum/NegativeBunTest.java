package praktikum;

import datagenerator.DataGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class NegativeBunTest {

    private final String bunName;
    private final float bunPrice;

    public NegativeBunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Невалидные значения для названия булочки {0}, Невалидные значения для цены булочки {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"", DataGenerator.generateRandomBunPrice()},
                {null, DataGenerator.generateRandomBunPrice()},
                {"12345678", DataGenerator.generateRandomBunPrice()},
                {"{№!@#$%^&*()]", DataGenerator.generateRandomBunPrice()},
                {DataGenerator.generateTooLongBunName(), DataGenerator.generateRandomBunPrice()},

                {DataGenerator.generateBunName(), DataGenerator.generateMinBunPrice()},
                {DataGenerator.generateBunName(), DataGenerator.generateMaxBunPrice()},
                {DataGenerator.generateBunName(), DataGenerator.generateNegativeBunPrice()},
                {DataGenerator.generateBunName(), DataGenerator.generateMaxNegativeBunPrice()}
        };
    }

    @Test
    public void NegativeCreateNonValidBunTest(){
        Bun bun = new Bun(bunName, bunPrice);

        assertNotNull("Невалидные значения для названия булочки или цены булочки", bun);
    }
}
