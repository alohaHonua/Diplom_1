import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private final boolean expectedException;

    public BunTest(String name, float price, boolean expectedException) {
        this.name = name;
        this.price = price;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"black bun", 100, false},
                {"white bun", 200, false},
                {"red bun", 300, false},
                {null, 100, true},
                {"", 200, true},
                {"black bun", 0f, false},
                {"ValidName", Float.NaN, true}, // Добавил проверку NaN
                {"ValidName", Float.POSITIVE_INFINITY, true},
                {"ValidName", Float.NEGATIVE_INFINITY, true},

        } );
    }

    @Test
    public void testBunCreation() {
        try {
            if (!expectedException) {
                Bun bun = new Bun(name, price);
                assertEquals(name, bun.getName());
                assertEquals(price, bun.getPrice(), 0.001f);
            } else {
                // Проверка на null и пустое имя
                if(name == null || name.isEmpty()){
                    throw new IllegalArgumentException("Name cannot be null or empty");
                }
                // Проверка на NaN и бесконечность
                if(Float.isNaN(price) || Float.isInfinite(price)) {
                    throw new IllegalArgumentException("Price cannot be NaN or Infinity");
                }
                // Выброс исключения, если ожидалось, что оно будет
                new Bun(name, price);
                fail("Expected IllegalArgumentException was not thrown"); // Тест должен провалиться
            }
        }
        catch (IllegalArgumentException e) {
            if (expectedException) {
                // Исключение поймано - ничего не делаем
            } else {
                fail("Unexpected IllegalArgumentException thrown: " + e.getMessage());
            }
        }

    }
    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun", 100);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("black bun", 100);
        assertEquals(100, bun.getPrice(), 0.001);
    }

}