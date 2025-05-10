package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;

    @Before
    //создаем бургер
    public void createNewBurger(){
        burger = new Burger();
    }

    @Test
    public void checkGetPrice(){
        burger.setBuns(bun);//добавляем булки в бургер
        when(bun.getPrice()).thenReturn(100F);//присваиваем через мок цену булке
        when(ingredient.getPrice()).thenReturn(20F);//присваиваем через мок цену первому ингредиенту
        when(ingredient1.getPrice()).thenReturn(25.5F);//присваиваем через мок цену второму ингредиенту
        burger.addIngredient(ingredient);//добавляем первый ингредиент в бургер
        burger.addIngredient(ingredient1);//добавляем второй ингредиент в бургер
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice() + ingredient1.getPrice();//ожидаемый прайс бургера
        float actualPrice = burger.getPrice();//фактический прайс бургера
        assertEquals("Ожидаемая цена бургера не совпадает с фактической", expectedPrice, actualPrice, 0);
    }

}
