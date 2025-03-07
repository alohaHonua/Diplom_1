package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String name;
    private final float price;
    
    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
            {"Обычная булочка", 50.0f},
            {"Булочка с кунжутом", 75.5f},
            {"Ржаная булочка", 100.0f},
            {"Безглютеновая булочка", 150.0f}
        };
    }
    
    @Test
    public void bunConstructorSetsCorrectName() {
        Bun bun = new Bun(name, price);
        assertEquals("Имя булочки должно быть установлено правильно через конструктор", 
                    name, bun.getName());
    }

    @Test
    public void bunConstructorSetsCorrectPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Цена булочки должна быть установлена правильно",
                price, bun.getPrice(), 0.001f);
    }
} 