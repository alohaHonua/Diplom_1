package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

public class DatabaseTests {

    // Тест для проверки инициализации базы данных
    @Test
    public void databaseInitializationIsSuccessful() {
        // Создаем экземпляр класса Database
        Database database = new Database();

        // Проверяем количество булочек
        List<Bun> buns = database.availableBuns();
        MatcherAssert.assertThat("Неверное количество булочек", buns.size(), equalTo(3));

        // Проверяем количество ингредиентов
        List<Ingredient> ingredients = database.availableIngredients();
        MatcherAssert.assertThat("Неверное количество ингредиентов", ingredients.size(), equalTo(6));
    }

    // Тест для проверки правильности булочек
    @Test
    public void availableBunsReturnsCorrectBuns() {
        // Создаем экземпляр класса Database
        Database database = new Database();
        List<Bun> buns = database.availableBuns();

        // Проверяем, что имена булочек соответствуют ожидаемым
        MatcherAssert.assertThat("Первая булочка некорректная", buns.get(0).getName(), equalTo("black bun"));
        MatcherAssert.assertThat("Вторая булочка некорректная", buns.get(1).getName(), equalTo("white bun"));
        MatcherAssert.assertThat("Третья булочка некорректная", buns.get(2).getName(), equalTo("red bun"));
    }

    // Тест для проверки правильности ингредиентов
    @Test
    public void availableIngredientsReturnsCorrectIngredients() {
        // Создаем экземпляр класса Database
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();

        // Проверяем, что имена ингредиентов соответствуют ожидаемым
        MatcherAssert.assertThat("Первый ингредиент некорректный", ingredients.get(0).getName(), equalTo("hot sauce"));
        MatcherAssert.assertThat("Второй ингредиент некорректный", ingredients.get(3).getName(), equalTo("cutlet"));
        // Добавьте дополнительные проверки для других ингредиентов.
    }
}
