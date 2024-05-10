import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class BunParameterTest {

    private final boolean isTruth;
    private final Bun bun;
    private final String outPutParam;
    private final float outputParam2;

    public BunParameterTest(Bun bun, String outPutParam , float outputParam2, boolean isTruth) {
        this.isTruth = isTruth;
        this.bun = bun;
        this.outPutParam = outPutParam;
        this.outputParam2 = outputParam2;
    }

    @Parameterized.Parameters
    public static Object[][] getBun(){
        return new Object[][]{
                {new Bun ("Bun1",1),"Bun1", 1, true},
                {new Bun ("Bun2",2),"Bun2", 2, true},
                {new Bun ("Bun3",3),"Bun3", 3, true}
        };
    }

    @Test
    public void getBunTest(){
        assertThat(bun.getName().equals(outPutParam),is(isTruth));
        assertThat(bun.getPrice() == outputParam2,is(isTruth));
    }
}