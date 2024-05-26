import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertNotNull;

public class IngTypeTest {
        @Test
        public void fillingNotNullTest(){
            assertNotNull("Соуса с таким названием - нет", IngredientType.valueOf("SAUCE"));
        }
        @Test
        public void sauceNotNullTest(){
            assertNotNull("Начинка с таким названием отсутствует", IngredientType.valueOf("FILLING"));
        }

    }



