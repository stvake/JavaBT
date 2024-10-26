package org.labs.lab3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Головний клас для демонстрації роботи з масивом об'єктів класу SeaBoat.
 * Створює масив, сортує його за вказаними полями та виконує пошук об'єкта.
 * <p>
 * Реалізація варіанту 3:
 * Визначити клас морський човен, який складається як мінімум з 5-и полів.
 */
public class Lab3 {
    /**
     * Головний метод програми. Створює масив човнів, сортує його за довжиною (зростанням)
     * і за роком побудови (спаданням). Також здійснює пошук заданого об'єкта у масиві.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        SeaBoat[] boats = {
                new SeaBoat("WaveRider", 30, 2015, 41, "Blue"),
                new SeaBoat("SeaHunter", 25, 2020, 35, "Red"),
                new SeaBoat("OceanKing", 35, 2012, 46, "Green"),
                new SeaBoat("Speedy-II", 25, 2022, 50, "Yellow"),
                new SeaBoat("Speedy", 25, 2018, 42, "Yellow"),
                new SeaBoat("Voyager", 40, 2015, 38, "White")
        };

        // Сортування за довжиною за зростанням і за роком побудови за спаданням
        Arrays.sort(
                boats,
                Comparator
                        .comparing(SeaBoat::getLength)
                        .thenComparing(
                                Comparator
                                        .comparing(SeaBoat::getBuiltYear)
                                        .reversed()
                        )
        );

        // Виводимо відсортовані човни
        System.out.println("Sorted boats:");
        for (SeaBoat boat : boats) {
            System.out.println(boat);
        }

        // Пошук заданого човна
        SeaBoat targetBoat = new SeaBoat("Speedy-II", 25, 2022, 50, "Yellow");
        boolean found = Arrays.asList(boats).contains(targetBoat);
        if (found) {
            System.out.println("\nBoat found:\n" + targetBoat);
        } else {
            System.out.println("\nBoat not found.");
        }
    }
}
