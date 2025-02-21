package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class BunTests {


    //  !--- Проверяем метод на запрос названия булки ---!
    @Test
    public void getNameIsSuccessTest() {
        String bunName = "Космическая булка";
        Bun bun = new Bun(bunName, 100f);
        MatcherAssert.assertThat("Неверное название булки",
                bun.getName(),
                equalTo(bunName));
    }


    //  !--- Проверяем метод на запрос цены булки ---!
    @Test
    public void getPriceIsSuccessTest() {
        float bunPrice = 100f;
        Bun bun = new Bun("Космическая булка", bunPrice);
        MatcherAssert.assertThat("Неверная цена булки",
                bun.getPrice(),
                equalTo(bunPrice));
    }

    //  !--- Проверяем метод на запрос нулевой цены булки ---!
    @Test
    public void getZeroPriceIsSuccessTest() {
        float bunPrice = 0f;
        Bun bun = new Bun("Космическая булка", bunPrice);
        MatcherAssert.assertThat("Неверная цена булки",
                bun.getPrice(),
                equalTo(bunPrice));
    }

    //  !--- Проверяем метод на запрос отрицательной цены булки ---!
    @Test
    public void getNegativePriceIsSuccessTest() {
        float bunPrice = -100f;
        Bun bun = new Bun("Космическая булка", bunPrice);
        MatcherAssert.assertThat("Неверная цена булки",
                bun.getPrice(),
                equalTo(bunPrice));
    }

    //  !--- Проверяем метод на запрос дробной цены булки ---!
    @Test
    public void getFractionalPriceIsSuccessTest() {
        float bunPrice = 100.15f;
        Bun bun = new Bun("Космическая булка", bunPrice);
        MatcherAssert.assertThat("Неверная цена булки",
                bun.getPrice(),
                equalTo(bunPrice));
    }
}