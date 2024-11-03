import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {

    @Test //Проверяем, что конструктор верно присваивает и имя и цену булочке
    public void testConstructorSetNameAndPriceCorrectly(){
        //Создаём объект Bun с тестовыми значениями
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);

        //Проверяем, что название установлено правильно
        assertEquals("Флюоресцентная булка R2-D3", bun.getName());

        //Проверяем, что цена установлена правильно, без погрешности
        assertEquals(988, bun.getPrice(), 0.0f);
    }

    @Test//Проверяем, что название булочки присваевается верно
    public void testGetNameReturnCorrectValue(){
        //Создаем объект bun с тестовым именем булочки
        Bun bun = new Bun("Краторная булка N-200i", 1255);

        //Проверяем, что булочке присвоено верное имя
        assertEquals("Краторная булка N-200i", bun.getName());
    }

    @Test//Проверяем, что цена булочки присвоена верно
    public void testGetPriceReturnCorrectValue(){
        //Создаем объект bun с тестовой ценой булочки
        Bun bun = new Bun("Краторная булка N-200i", 1255);

        //Проверяем, что булочке присвоена верная цена
        assertEquals(1255, bun.getPrice(), 0.0f);
    }
}
