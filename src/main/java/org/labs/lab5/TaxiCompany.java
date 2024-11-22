package org.labs.lab5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Клас таксопарку.
 * Містить методи для: рахування вартості таксопарку, сортування автомобілів та пошуку потрібного автомобілю.
 */
class TaxiCompany {
    private final Car[] cars;

    /**
     * Конструктор для створення таксопарку.
     *
     * @param cars масив автомобілів
     * @throws IllegalArgumentException якщо масив порожній або дорівнює null
     */
    public TaxiCompany(Car[] cars) {
        if (cars == null || cars.length == 0) {
            throw new IllegalArgumentException("Масив автомобілів не може бути порожнім.");
        }
        this.cars = cars;
    }

    /**
     * Обчислює загальну вартість автопарку.
     *
     * @return загальна вартість
     */
    public double calculateTotalCost() {
        double sum = 0;
        for (Car car : cars) {
            sum += car.getPrice();
        }
        return sum;
    }

    /**
     * Сортує автомобілі парку за витратами палива у порядку зростання.
     */
    public void sortCarsByFuelConsumption() {
        Arrays.sort(cars, Comparator.comparingDouble(Car::getFuelConsumption));
    }

    /**
     * Знаходить автомобіль у заданому діапазоні швидкостей.
     *
     * @param minSpeed мінімальна швидкість
     * @param maxSpeed максимальна швидкість
     * @return автомобіль, який відповідає діапазону, або null, якщо не знайдено
     */
    public Car findCarBySpeedRange(int minSpeed, int maxSpeed) {
        return Arrays.stream(cars)
                .filter(car -> car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed)
                .findFirst()
                .orElse(null);
    }

    /**
     * Виводить список усіх автомобілів парку.
     */
    public void displayCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
