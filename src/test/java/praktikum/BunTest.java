package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class BunTest {

    @Test
    public void getNameIsSuccess() {
        String bunName = "sweet bun";
        Bun bun = new Bun(bunName, 200);
        MatcherAssert.assertThat("Неверное имя булочки",
                bun.getName(),
                equalTo(bunName));
    }

    @Test
    public void getPriceIsSuccess() {
        float bunPrice = 250;
        Bun bun = new Bun("sweet bun", bunPrice);
        MatcherAssert.assertThat("Неверная цена булочки",
                bun.getPrice(),
                equalTo(bunPrice));
    }
}