package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParamTest extends BaseParams{
    private final String bunName;
    private final float bunPrice;


    public BurgerParamTest(String bunName, float bunPrice){
        this.bunName = bunName;
        this.bunPrice = bunPrice;

    }

    @Parameterized.Parameters
    public static Object[][] switchBetweenParams(){
        return new Object[][]{
                {"булочка с корицей", 100F},
                {"булочка с кунжутом", 300F},
                {"булочка с бумажкой",999F}
        };
    }

    @Test
    public void checkBunConstructor(){
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), DELTA);
        assertEquals(bunName, bun.getName());
    }
}
