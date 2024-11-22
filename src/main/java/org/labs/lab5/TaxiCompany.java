package org.labs.lab5;

import java.util.Arrays;
import java.util.Comparator;

class TaxiCompany {
    private final Car[] cars;

    public TaxiCompany(Car[] cars) {
        if (cars == null || cars.length == 0) {
            throw new IllegalArgumentException("Масив автомобілів не може бути порожнім.");
        }
        this.cars = cars;
    }

    public double calculateTotalCost() {
        double sum = 0;
        for (Car car : cars) {
            sum += car.getPrice();
        }
        return sum;
    }

    public void sortCarsByFuelConsumption() {
        Arrays.sort(cars, Comparator.comparingDouble(Car::getFuelConsumption));
    }

    public Car findCarBySpeedRange(int minSpeed, int maxSpeed) {
        return Arrays.stream(cars)
                .filter(car -> car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed)
                .findFirst()
                .orElse(null);
    }

    public void displayCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
