import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import praktikum.Bun;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParamBunTest {


        public final String name;
        public final float price;

        public ParamBunTest(String name, float price) {
            this.name = name;
            this.price = price;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"Meat", 100.0f},
                    {"vegetarian", 200.0f},
                    {"Spicy burger", 300.0f}
            });
        }

        @Test
        public void paramBunTest() {
            Bun bun = new Bun(name, price);
            Assert.assertEquals(name, bun.getName());
            Assert.assertEquals(price, bun.getPrice(), 0);
        }
    }



