import praktikum.Bun;
import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void testGetName() {
        // Arrange
        Bun bun = new Bun("Cholesterol", 100);

        // Act
        String name = bun.getName();

        // Assert
        Assert.assertEquals("Cholesterol", name);
    }

    @Test
    public void testGetPrice() {
        // Arrange
        Bun bun = new Bun("Cholesterol", 100);

        // Act
        float price = bun.getPrice();

        // Assert
        Assert.assertEquals(100, price, 0);
    }

    @Test
    public void testBunConstructor() {
        // Arrange
        String expectedName = "Vegan";
        float expectedPrice = 50;

        // Act
        Bun bun = new Bun(expectedName, expectedPrice);

        // Assert
        Assert.assertEquals(expectedName, bun.getName());
        Assert.assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
