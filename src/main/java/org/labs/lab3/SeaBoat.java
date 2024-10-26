package org.labs.lab3;

/**
 * Клас Boat представляє морський човен з основними характеристиками, такими як ім'я, довжина, рік побудови,
 * максимальна швидкість та колір.
 */
public class SeaBoat {
    private final String name;
    private final int length;
    private final int builtYear;
    private final int maxSpeed;
    private final String color;

    /**
     * Конструктор для створення об'єкта морського човна з заданими параметрами.
     *
     * @param name      назва човна
     * @param length    довжина човна
     * @param builtYear рік побудови човна
     * @param maxSpeed  максимальна швидкість човна
     * @param color     колір човна
     */
    public SeaBoat(String name, int length, int builtYear, int maxSpeed, String color) {
        this.name = name;
        this.length = length;
        this.builtYear = builtYear;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    /**
     * Повертає назву човна.
     *
     * @return назва човна
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає довжину човна.
     *
     * @return довжина човна
     */
    public int getLength() {
        return length;
    }

    /**
     * Повертає рік побудови човна.
     *
     * @return рік побудови човна
     */
    public int getBuiltYear() {
        return builtYear;
    }

    /**
     * Повертає максимальну швидкість човна.
     *
     * @return максимальна швидкість човна
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Повертає колір човна.
     *
     * @return колір човна
     */
    public String getColor() {
        return color;
    }

    /**
     * Порівнює об'єкт з іншим об'єктом для перевірки на рівність.
     *
     * @param obj об'єкт, з яким порівнюється поточний човен
     * @return true, якщо об'єкти однакові; false - якщо ні
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SeaBoat)) return false;

        SeaBoat boat = (SeaBoat) obj;

        return length == boat.length &&
                builtYear == boat.builtYear &&
                maxSpeed == boat.maxSpeed &&
                name.equals(boat.name) &&
                color.equals(boat.color);
    }

    /**
     * Повертає рядкове представлення об'єкта човна.
     *
     * @return рядок, що описує човен
     */
    @Override
    public String toString() {
        return "Boat {" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", yearBuilt=" + builtYear +
                ", maxSpeed=" + maxSpeed +
                ", color='" + color + '\'' +
                '}';
    }
}
