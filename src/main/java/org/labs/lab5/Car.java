package org.labs.lab5;

public abstract class Car {
    private final String brand;
    private final String model;
    private final double fuelConsumption;
    private final int maxSpeed;
    private final double price;

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

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s %s: витрата палива %.2f, максимальна швидкість %d, ціна %.2f",
                brand, model, fuelConsumption, maxSpeed, price);
    }
}

