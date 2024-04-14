package praktikum;

import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BunTest {
    Faker faker = new Faker();
    private final String name = faker.name().firstName();
    private final float bunPrice = faker.number().numberBetween(10, 500);
    private final Bun bun = new Bun(name, bunPrice);

    @Test
    public void checkGetNameReturnsNameTest(){
        assertEquals("Имя не совпадает",name, bun.getName());
    }

    @Test
    public void checkGetPriceReturnsPriceTest(){
        assertEquals("Цена не совпадает", bunPrice, bun.getPrice(), 0);
    }
}
