import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTests {
    String name = "Флюоресцентная булка R2-D3";
    float price = 988F;
    Bun bun = new Bun(name, price);

    @Test
    public void getBunName(){
        String actualName = bun.getName();
        assertEquals("Наименование булочки не совпадает: ", actualName, name);
    }
    @Test
    public void getBunPrice(){
        float actualPrice = bun.getPrice();
        assertEquals("Стоимость булочки не совпадает: ", actualPrice, price, 0.05);
    }

}
