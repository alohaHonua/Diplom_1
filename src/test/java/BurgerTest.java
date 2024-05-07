import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

   @Mock
   private Bun mockBun;

   @Mock
   private Ingredient mockIngredient1;

   @Mock
   private Ingredient mockIngredient2;

   @Test
   public void testSetBuns() {
      Burger burger = new Burger();
      burger.setBuns(mockBun);
      assertEquals(mockBun, burger.bun);
   }

   @Test
   public void testAddIngredient() {
      Burger burger = new Burger();
      burger.addIngredient(mockIngredient1);
      assertTrue(burger.ingredients.contains(mockIngredient1));
   }

   @Test
   public void testRemoveIngredient() {
      Burger burger = new Burger();
      burger.addIngredient(mockIngredient1);
      burger.removeIngredient(0);
      assertFalse(burger.ingredients.contains(mockIngredient1));
   }

   @Test
   public void testMoveIngredient() {
      Burger burger = new Burger();
      burger.addIngredient(mockIngredient1);
      burger.addIngredient(mockIngredient2);

      burger.moveIngredient(0, 1);

      assertEquals(mockIngredient1, burger.ingredients.get(1));
   }

   @Test
   public void testGetPrice_WithoutIngredients() {
      when(mockBun.getPrice()).thenReturn(2.0f);
      Burger burger = new Burger();
      burger.bun = mockBun;
      assertEquals(4.0f, burger.getPrice(), 0.001);
   }

   @Test
   public void testGetPrice_WithIngredients() {
      when(mockBun.getPrice()).thenReturn(2.0f);
      when(mockIngredient1.getPrice()).thenReturn(1.0f);
      when(mockIngredient2.getPrice()).thenReturn(1.5f);

      Burger burger = new Burger();
      burger.setBuns(mockBun); // Устанавливаем булку
      burger.addIngredient(mockIngredient1);
      burger.addIngredient(mockIngredient2);

      assertEquals(6.5f, burger.getPrice(), 0.001); // Ожидаем 6.5 вместо 8.0
   }

   @Test
   public void testGetReceipt() {
      when(mockBun.getName()).thenReturn("Sesame Bun");
      when(mockBun.getPrice()).thenReturn(2.0f);

      when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
      when(mockIngredient1.getName()).thenReturn("Cheese");
      when(mockIngredient1.getPrice()).thenReturn(1.0f);
      when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
      when(mockIngredient2.getName()).thenReturn("Mayonnaise");
      when(mockIngredient2.getPrice()).thenReturn(0.5f);

      Burger burger = new Burger();
      burger.bun = mockBun;
      burger.ingredients.add(mockIngredient1);
      burger.ingredients.add(mockIngredient2);

      String expectedReceipt = String.join("\n",
              "(==== " + mockBun.getName() + " ====)",
              "= filling " + mockIngredient1.getName() + " =",
              "= sauce " + mockIngredient2.getName() + " =",
              "(==== " + mockBun.getName() + " ====)",
              "",
              "Price: 5,500000");

      String actualReceipt = burger.getReceipt();
      actualReceipt = actualReceipt.substring(0, actualReceipt.lastIndexOf("\n"));

      assertEquals(expectedReceipt, actualReceipt);
   }
}