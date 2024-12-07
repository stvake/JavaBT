package org.labs.lab6;

import java.util.Arrays;
import java.util.List;

import org.labs.lab5.Car;
import org.labs.lab5.Minivan;
import org.labs.lab5.SUV;
import org.labs.lab5.Sedan;

public class Lab6 {
    public static void main(String[] args) {
        Sedan car1 = new Sedan("Toyota", "Camry", 7.5, 210, 30000);
        SUV car2 = new SUV("BMW", "X5", 9.5, 240, 60000);
        Sedan car3 = new Sedan("Hyundai", "Elantra", 6.2, 190, 22000);
        Minivan car4 = new Minivan("Honda", "Odyssey", 9.2, 200, 35000);

        CarSet carSet1 = new CarSet();
        carSet1.add(car1);
        carSet1.add(car2);
        carSet1.add(car3);
        carSet1.add(car4);
        System.out.println("\nCarSet1:");
        for (Car car : carSet1) {
            System.out.println(car);
        }

        CarSet carSet2 = new CarSet(car1);
        System.out.println("\nCarSet2:");
        for (Car car : carSet2) {
            System.out.println(car);
        }

        List<Car> carList = Arrays.asList(car1, car2, car3, car4);
        CarSet carSet3 = new CarSet(carList);
        System.out.println("\nCarSet3:");
        for (Car car : carSet3) {
            System.out.println(car);
        }
    }
}
