import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BanTest  {
    static Faker faker = new Faker();
    public String nameBun = faker.food().dish();
    public float priceBun  = (float) Math.random();
    Bun bun = new Bun(nameBun, priceBun);

    @Test
    public void checkGetName (){
        Assert.assertEquals(nameBun, bun.getName());
    }

    @Test
    public void checkGetPrice (){
        Assert.assertEquals(priceBun, bun.getPrice(),0.05 );

    }
}
