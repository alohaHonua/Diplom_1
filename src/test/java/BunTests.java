package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class BunTests {


    //  !--- Проверяем метод на запрос названия булки ---!
    @Test
    public void getNameIsSuccessTest() {
        String bunName = "Космическая булка";
        Bun bun = new Bun(bunName, 100);
        MatcherAssert.assertThat("Неверное название булки",
                bun.getName(),
                equalTo(bunName));
    }


    //  !--- Проверяем метод на запрос цены булки ---!
    @Test
    public void getPriceIsSuccessTest() {
        float bunPrice = 100;
        Bun bun = new Bun("Космическая булка", bunPrice);
        MatcherAssert.assertThat("Неверная цена булки",
                bun.getPrice(),
                equalTo(bunPrice));
    }
}