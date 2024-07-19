package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)

public class BunTest {
    private final String BUNS_NAME;
    private final float PRICE;

   public BunTest (String bunsName, float bunsPrice) {
       this.BUNS_NAME = bunsName;
       this.PRICE = bunsPrice;
   }

   @Parameterized.Parameters
   public static Object[][] getBuns() {
       return new Object[][] {
               {"black bun", 100},
               {"white bun", 200},
               {"red bun", 300},
       };
   }



   //Проверка получения имени булочки
    @Test
    public void checkGetName() {
        //Создаем булку
        Bun bun = new Bun(BUNS_NAME, PRICE);

        //Проверяем, что при вызове getName получается верное название булочки
        assertEquals("Полученное название булки не совпадает с ожидаемым", BUNS_NAME, bun.getName());

    }

    //Проверка получения цены булочки
    @Test
    public void checkGetPrice() {
        //Создаем булку
        Bun bun = new Bun(BUNS_NAME, PRICE);

        //Проверяем, что при вызове getPrice получается верная стоимость булочки
        assertEquals("Полученная цена булочки не совпадает с ожидаемой", PRICE, bun.getPrice(),0);
    }
}