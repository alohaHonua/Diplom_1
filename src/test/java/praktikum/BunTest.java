package praktikum;

import datagenerator.DataGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getValidBunNameTest(){
        String bunName = DataGenerator.generateBunName();
        Bun bun = new Bun(bunName, DataGenerator.generateRandomBunPrice());

        assertEquals( "Невалидное значение для названия булочки",bunName, bun.getName());
    }

    @Test
    public void getValidBunPriceTest() {
        float bunPrice = DataGenerator.generateRandomBunPrice();
        Bun bun = new Bun(DataGenerator.generateBunName(), bunPrice);

        assertEquals("Невалидное значение для цены булочки",bunPrice, bun.getPrice(), 0.0);
    }
}