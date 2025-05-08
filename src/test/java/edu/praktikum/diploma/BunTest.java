package edu.praktikum.diploma;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;
    private String bunName;
    private float bunPrice;

    @Before
    public void setUp() {
        Faker faker = new Faker();
        bunName = faker.funnyName().name();
        double bunPriceSample = faker.number().randomDouble(2, 100,501);
        bunPrice = (float) (bunPriceSample);
        bun = new Bun(bunName, bunPrice);
    }
    @Test
    public void testGetName() {
        assertEquals("Название не совпадает", bunName, bun.getName());
    }
    @Test
    public void testGetPrice() {
        assertEquals(bunPrice, bun.getPrice(), 0);
    }
}
