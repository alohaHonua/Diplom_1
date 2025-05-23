package edu.praktikum.diploma;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Database;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Mock
    private Database database;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        Bun bun = new Bun("black bun", 100f);
        Mockito.when(database.availableBuns()).thenReturn(Arrays.asList(bun));
    }
    @Test
    public void testGetName() {
        Bun bun = database.availableBuns().get(0);
        assertEquals("Название не совпадает", "black bun", bun.getName());
    }
    @Test
    public void testGetPrice() {
        Bun bun = database.availableBuns().get(0);
        assertEquals(100f, bun.getPrice(), 0);
    }
}
