package datagenerator;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataGenerator {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static String generateBunName() {
        return faker.lorem().characters(10, 15);
    }

    public static String generateTooLongBunName() {
        return faker.lorem().fixedString(1000);
    }

    public static float generateRandomBunPrice() {
        return random.nextFloat() + 300;
    }

    public static float generateMinBunPrice() {
        return Float.MIN_VALUE;
    }

    public static float generateMaxBunPrice() {
        return Float.MAX_VALUE;
    }

    public static float generateNegativeBunPrice() {
        float positivePrice = random.nextFloat();
        return -positivePrice;
    }

    public static float generateMaxNegativeBunPrice() {
        return -Float.MAX_VALUE;
    }

    public static String generateIngredientName() {
        return faker.food().ingredient();
    }

    public static float generateRandomIngredientPrice() {
        return random.nextFloat() + 10;
    }
}
