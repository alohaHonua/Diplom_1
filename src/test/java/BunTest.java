import org.junit.Test;
import praktikum.Bun;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void getBunName() {

        // Создан объект класса Bun с ожидаемым именем и ценой
        Bun bun = new Bun(Constants.EXPECTED_BUN_NAME, Constants.EXPECTED_BUN_PRICE);

        // Получено фактическое имя булочки
        String actualBunName = bun.getName();

        // Сравнение ожидаемого и фактического значения имени булочки
        assertEquals(String.format("Ожидание: имя булочки %s", Constants.EXPECTED_BUN_NAME),
                Constants.EXPECTED_BUN_NAME, actualBunName);
    }

    @Test
    public void getBunPrice() {
        Bun bun = new Bun(Constants.EXPECTED_BUN_NAME, Constants.EXPECTED_BUN_PRICE);

        // Получена фактическая цена булочки
        float actualBunPrice = bun.getPrice();

        // Сравнение ожидаемого и фактического значения цены булочки (до двух знаков после запятой)
        assertThat(String.format("Ожидание: цена булочки %.2f", Constants.EXPECTED_BUN_PRICE),
                actualBunPrice, is(Constants.EXPECTED_BUN_PRICE));
    }
}
