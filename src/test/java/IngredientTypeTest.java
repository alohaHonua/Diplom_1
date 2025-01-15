import io.qameta.allure.Step;
import org.junit.Test;
import praktikum.IngredientType;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class IngredientTypeTest {

    @Test
    @Step("Проверка перечисления IngredientType")
    public void testIngredientType() {
            assertSoftly(softly -> {
            softly.assertThat(IngredientType.values()).hasSize(2);
            softly.assertThat(IngredientType.SAUCE.name()).isEqualTo("SAUCE");
            softly.assertThat(IngredientType.FILLING.name()).isEqualTo("FILLING");
        });
    }
}

