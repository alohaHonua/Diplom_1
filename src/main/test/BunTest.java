package test;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

public class BunTest {

    private String name;
    private float price;
    Bun bun = new Bun(name, price);

    @Test
    public void getBunName(){
        String actualName = bun.getName();
        Assertions.assertEquals(bun.getName(), actualName);
    }

    @Test
    public void getBunPrice(){
        float actualPrice = bun.getPrice();
        Assertions.assertEquals(bun.getPrice(), actualPrice);
    }
}

//@Test
//public void BunTest(){
  //  String name = "Чизбургер";
  //  float price = 9.2F;
  //  Bun bun = new Bun(name, price);
  //  assertEquals(bun.getName(), name);
   // assertEquals(bun.getPrice(), price);