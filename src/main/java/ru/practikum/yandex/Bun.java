package ru.practikum.yandex;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    public String name;
    public float price;

    public Bun(String name, float price) {
        if (name == null || name.isEmpty() || name.length() > 50) {
            throw new IllegalArgumentException("Invalid bun name");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
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

