package testbun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
    public class TestBun {
     private final String name;
     private final float price;


    public TestBun(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunVariants(){
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Test
    public void bunGetNameReturnTest(){
        Bun bun = new Bun(name, price);
        assertThat(bun.getName(), is(name));
    }

    @Test
    public void bunGetPriceReturnTest(){
        Bun bun = new Bun(name, price);
        assertThat(bun.getPrice(), is(price));
    }

}
