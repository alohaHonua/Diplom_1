import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        assertThat("Неккоректная булочка!", burger.bun, equalTo(bun));
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient1);
        assertTrue("Ингредиент не добавился!", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertFalse("Ингредиент не удалился!", burger.ingredients.contains(ingredient2));
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);

        assertEquals("Ингредиент не переместился!", burger.ingredients.get(1), ingredient1);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(200f);
        Mockito.when(ingredient2.getPrice()).thenReturn(300f);

        assertEquals("Некорректная цена!", 700f, burger.getPrice(), 0.0001f );

    }

    @Test
    public void getReceiptTest(){
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient1.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getPrice()).thenReturn(200f);
        Mockito.when(ingredient2.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getPrice()).thenReturn(100f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                "black bun",
                "filling", "dinosaur",
                "sauce", "hot sauce",
                "black bun",
                2 * 100.0f + 200.0f + 100.0f
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}
