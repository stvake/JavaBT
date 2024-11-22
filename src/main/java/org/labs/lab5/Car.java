package org.labs.lab5;

/**
 * Абстрактний клас для опису легкових автомобілів.
 */
public abstract class Car {
    private final String brand;
    private final String model;
    private final double fuelConsumption;
    private final int maxSpeed;
    private final double price;

    /**
     * Конструктор для створення автомобіля.
     *
     * @param brand марка автомобіля
     * @param model модель автомобіля
     * @param fuelConsumption витрати палива
     * @param maxSpeed максимальна швидкість
     * @param price ціна автомобіля
     *
     * @throws IllegalArgumentException якщо витрати палива, швидкість чи ціна <= 0
     */
    public Car(String brand, String model, double fuelConsumption, int maxSpeed, double price) {
        if (fuelConsumption <= 0 || maxSpeed <= 0 || price <= 0) {
            throw new IllegalArgumentException("Параметри повинні бути додатними.");
        }
        this.brand = brand;
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    /**
     * Повертає витрати палива автомобіля.
     *
     * @return витрати палива
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Повертає максимальну швидкість автомобіля.
     *
     * @return максимальна швидкість
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Повертає ціну автомобіля.
     *
     * @return ціна автомобіля
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає рядкове представлення автомобіля.
     *
     * @return рядок з описом автомобіля
     */
    @Override
    public String toString() {
        return String.format("%s %s: витрата палива %.2f, максимальна швидкість %d, ціна %.2f",
                brand, model, fuelConsumption, maxSpeed, price);
    }
}

