
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Тест", 1.5f);
        Assert.assertEquals("Тест", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Тест", 1.5f);
        Assert.assertEquals(1.5f, bun.getPrice(), 0.0f);
    }

    @Test
    public void testSetName() {
        Bun bun = new Bun("Тест", 1.5f);
        bun.name = "Тест булки";
        Assert.assertEquals("Тест булки", bun.getName());
    }

    @Test
    public void testSetPrice() {
        Bun bun = new Bun("Тест булки", 1.5f);
        bun.price = 2.0f;
        Assert.assertEquals(2.0f, bun.getPrice(), 0.0f);
    }
}
