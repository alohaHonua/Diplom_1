package praktikum;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    public String name;
    public float price;

    public Bun(String name, float price) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null.");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
         return price;
    }

}