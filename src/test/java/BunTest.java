import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import praktikum.Bun;

public class BunTest {
    private static final String BUN_NAME = "bulka";
    private static final float BUN_PRICE = 2.5F;


    @Test
    public void priceShouldBeCorrect() {
        Bun bun = new Bun(BUN_NAME, BUN_PRICE);
        Assertions.assertEquals(BUN_PRICE, bun.getPrice());
    }

    @Test
    public void nameShouldBeCorrect() {
        Bun bun = new Bun(BUN_NAME, BUN_PRICE);
        Assertions.assertEquals(BUN_NAME, bun.getName());
    }
}