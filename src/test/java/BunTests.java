import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class BunTests {

    private static String name;
    private static float price;
    private static Bun bun;

    public BunTests(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] bunParameters(){
        return new Object[][]{
                {"Кунжутная", 100},
                {"Ржаная", 200},
                {"Пшеничная", 300}
        };
    }

    @Before
    public void setUp(){
        bun = new Bun(name, price);
    }

    @Test
    public void getNameIsCorrect(){
        MatcherAssert.assertThat("Некорректное название булочки", bun.getName(), equalTo(name) );
    }

    @Test
    public void getPrice(){
        MatcherAssert.assertThat("Некорректная цена", bun.getPrice(), equalTo(price) );
    }
}
