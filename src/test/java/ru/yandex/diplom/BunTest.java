package ru.yandex.diplom;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Биг мак", 289.0f);
    }

    @Test
    public void shouldReturnTrueGetName() {
        String actualName = bun.getName();
        assertEquals("Биг мак", actualName);
    }

    @Test
    public void shouldReturnTrueGetPrice() {
        float actualPrice = bun.getPrice();
        float expectedPrice = 289.0f;
        float delta = 0.0f;
        assertEquals(expectedPrice, actualPrice, delta);
    }

}