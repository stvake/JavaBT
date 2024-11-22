package org.labs.lab5;

/**
 * Клас для опису автомобілів типу Седан.
 */
class Sedan extends Car {
    /**
     * Конструктор для створення Седана.
     *
     * @param brand марка автомобіля
     * @param model модель автомобіля
     * @param fuelConsumption витрати палива
     * @param maxSpeed максимальна швидкість
     * @param price ціна автомобіля
     */
    public Sedan(String brand, String model, double fuelConsumption, int maxSpeed, double price) {
        super(brand, model, fuelConsumption, maxSpeed, price);
    }
}