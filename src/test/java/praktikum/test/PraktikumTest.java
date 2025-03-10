package praktikum.test;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Praktikum;

import static org.junit.Assert.assertTrue;

public class PraktikumTest {

    @Test
    public void testCreateBurgerFromPraktikumClass () {
        String receipt = Praktikum.createBurgerAndGetReceipt();
        Assert.assertNotNull(receipt);

        assertTrue(receipt.contains("black bun"));
        assertTrue(receipt.contains("sour cream"));
        assertTrue(receipt.contains("dinosaur"));
        assertTrue(receipt.contains("cutlet"));
        assertTrue(receipt.contains("black bun"));
    }
}
