package org.labs.lab6;

import java.util.Arrays;
import java.util.List;

import org.labs.lab5.Car;
import org.labs.lab5.Minivan;
import org.labs.lab5.SUV;
import org.labs.lab5.Sedan;

/**
 * Завдання:
 * Створити клас, що описує типізовану колекцію (типом колекції є узагальнений клас з лабораторної роботи №5 -
 * {@link Car}), що реалізує заданий варіантом інтерфейс ({@link java.util.Set}) та має задану внутрішню структуру
 * (Масив із початковою кількістю елементів 15 та збільшенням кількості елементів на 30%).
 * <p>
 * Реалізувати всі методи інтерфейсу, а також створити не менше ніж 3 конструктори
 * (1 – порожній, 2 – в який передається 1 об’єкт узагальненого класу,
 * 3 – в який передається стандартна колекція об’єктів).
 */
public class Lab6 {
    /**
     * Головний метод програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        // Створення об'єктів для колекції
        Sedan car1 = new Sedan("Toyota", "Camry", 7.5, 210, 30000);
        SUV car2 = new SUV("BMW", "X5", 9.5, 240, 60000);
        Sedan car3 = new Sedan("Hyundai", "Elantra", 6.2, 190, 22000);
        Minivan car4 = new Minivan("Honda", "Odyssey", 9.2, 200, 35000);

        // Застосування конструктора 1
        CarSet carSet1 = new CarSet();
        carSet1.add(car1);
        carSet1.add(car2);
        carSet1.add(car3);
        carSet1.add(car4);
        System.out.println("\nCarSet1:");
        for (Car car : carSet1) {
            System.out.println(car);
        }

        // Застосування конструктора 2
        CarSet carSet2 = new CarSet(car1);
        System.out.println("\nCarSet2:");
        for (Car car : carSet2) {
            System.out.println(car);
        }

        // Застосування конструктора 3
        List<Car> carList = Arrays.asList(car1, car2, car3, car4);
        CarSet carSet3 = new CarSet(carList);
        System.out.println("\nCarSet3:");
        for (Car car : carSet3) {
            System.out.println(car);
        }
    }
}
