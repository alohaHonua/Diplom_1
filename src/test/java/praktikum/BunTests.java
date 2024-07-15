package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;

public class BunTests {

    @Test
    public void shouldReturnCorrectName() {
        String expectedName = "bunName";
        Bun testBun = new Bun(expectedName, 100);

        MatcherAssert.assertThat(
                "Название булочки не соответствует ожидаемому",
                testBun.getName(),
                equalTo(expectedName)
        );
    }

    @Test
    public void shouldReturnCorrectPrice() {
        float expectedPrice = 100;
        Bun testBun = new Bun("bunName", expectedPrice);

        MatcherAssert.assertThat(
                "Цена булочки не соответствует ожидаемой",
                testBun.getPrice(),
                equalTo(expectedPrice)
        );
    }
}