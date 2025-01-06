package praktikum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BunTest {

  @Test
  public void bunNameTest() {
    Bun actualBun = new Bun("Name", 10.0f);
    String actualName = actualBun.getName();
    assertEquals("Name", actualName);
  }

  @Test
  public void bunPriceTest() {
    Bun actualBun = new Bun("Name", 10.0f);
    assertEquals(10.0f, actualBun.getPrice(), 0.0f);
  }

  @Test
  public void nullBunTest() {
    Bun actualBun = new Bun(null, 10.0f);
    assertNull(actualBun.getName());
  }

  @Test
  public void emptyBunTest() {
    Bun actualBun = new Bun("", 10.0f);
    assertEquals("", actualBun.getName());
  }

  @Test
  public void symbolBunTest() {
    Bun actualBun = new Bun("$&", 10.0f);
    assertEquals("$&", actualBun.getName());
  }

  @Test
  public void longBunTest() {
    String longText = "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.";
    Bun actualBun = new Bun(longText, 10.0f);
    assertEquals(longText, actualBun.getName());
  }

  @Test
  public void minusPriceBunTest(){
    Bun actualBun = new Bun("Name", -10.0f);
    assertEquals(-10.0f, actualBun.getPrice(),0.02f);
  }

  @Test
  public void zeroPriceBunTest(){
    Bun actualBun = new Bun("Name", 0.0f);
    assertEquals(0.0f, actualBun.getPrice(),0.02f);
  }

  @Test
  public void minimumFloatPriceBunTest(){
    Bun actualBun = new Bun("Name", Float.MIN_VALUE);
    assertEquals(Float.MIN_VALUE, actualBun.getPrice(),0.02f);
  }

  @Test
  public void maximumFloatPriceBunTest(){
    Bun actualBun = new Bun("Name", Float.MAX_VALUE);
    assertEquals(Float.MAX_VALUE, actualBun.getPrice(),0.02f);
  }

}
