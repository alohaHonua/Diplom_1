import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.Test;
import ru.practikum.yandex.IngredientType;

import java.util.Arrays;

public class IngredientTypeTest {

    @Test
    public void IngredientTypeValuesTest() {
        assertSoftly(softly -> {
            IngredientType[] values = IngredientType.values();
            softly.assertThat(values.length).isEqualTo(2);
            softly.assertThat(Arrays.asList(values)).contains(IngredientType.SAUCE);
            softly.assertThat(Arrays.asList(values)).contains(IngredientType.FILLING);
        });
    }

    @Test
    public void ValueOfTest() {
        assertSoftly(softly -> {
            softly.assertThat(IngredientType.valueOf("SAUCE")).isEqualTo(IngredientType.SAUCE);
            softly.assertThat(IngredientType.valueOf("FILLING")).isEqualTo(IngredientType.FILLING);
        });
    }
}
