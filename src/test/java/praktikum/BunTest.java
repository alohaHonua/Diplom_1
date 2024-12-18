package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
  private Bun bun;

  @Before
  public void setUp() throws Exception {
    bun = new Bun("brownie", 700.0f);
  }

  @Test
  public void getName() {
    String expected = "brownie";
    String actual = bun.getName();

    assertEquals("Incorrect bun name", expected, actual);
  }

  @Test
  public void getPrice() {
    float expected = 700.0f;
    float actual = bun.getPrice();

    assertEquals("Incorrect bun price", expected, actual, 0);
  }
}