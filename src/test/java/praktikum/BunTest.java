package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.SoftAssertions;
import java.util.List;

public class BunTest {

    private List<Bun> buns;

    @Before
    public void setUp() {
        // Получаем все булочки из базы данных
        Database database = new Database();
        buns = database.availableBuns();
    }

    @Test
    public void testGetName() {
        SoftAssertions softAssertions = new SoftAssertions();

        // Проверяем название каждой булочки
        softAssertions.assertThat(buns.get(0).getName()).isEqualTo("black bun");
        softAssertions.assertThat(buns.get(1).getName()).isEqualTo("white bun");
        softAssertions.assertThat(buns.get(2).getName()).isEqualTo("red bun");

        // Проверяем все ассерты
        softAssertions.assertAll();
    }

    @Test
    public void testGetPrice() {
        SoftAssertions softAssertions = new SoftAssertions();

        // Проверяем цену каждой булочки
        softAssertions.assertThat(buns.get(0).getPrice()).isEqualTo(100.0f);
        softAssertions.assertThat(buns.get(1).getPrice()).isEqualTo(200.0f);
        softAssertions.assertThat(buns.get(2).getPrice()).isEqualTo(300.0f);

        // Проверяем все ассерты
        softAssertions.assertAll();
    }
}
