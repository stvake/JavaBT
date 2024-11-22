package org.labs.lab5;

/**
 * Клас для опису автомобілів типу Позашляховик.
 */
class SUV extends Car {
    /**
     * Конструктор для створення Позашляховика.
     *
     * @param brand марка автомобіля
     * @param model модель автомобіля
     * @param fuelConsumption витрати палива
     * @param maxSpeed максимальна швидкість
     * @param price ціна автомобіля
     */
    public SUV(String brand, String model, double fuelConsumption, int maxSpeed, double price) {
        super(brand, model, fuelConsumption, maxSpeed, price);
    }
}