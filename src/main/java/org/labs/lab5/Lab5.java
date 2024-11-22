package org.labs.lab5;

/**
    Визначити ієрархію легкових автомобілів. Створити таксопарк. Порахувати вартість автопарку.
    Провести сортування автомобілів парку за витратами палива.
    Знайти автомобіль у компанії, що відповідає заданому діапазону швидкості автомобіля.
 */
public class Lab5 {
    /**
     * Головний метод програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        try {
            Car[] cars = {
                    new Sedan("Toyota", "Camry", 7.5, 210, 30000),
                    new SUV("BMW", "X5", 9.5, 240, 60000),
                    new Sedan("Hyundai", "Elantra", 6.2, 190, 22000),
                    new Minivan("Honda", "Odyssey", 9.2, 200, 35000)
            };

            TaxiCompany taxiCompany = new TaxiCompany(cars);

            System.out.println("Усі автомобілі таксопарку:");
            taxiCompany.displayCars();

            System.out.println("\nЗагальна вартість автопарку: " + taxiCompany.calculateTotalCost());

            taxiCompany.sortCarsByFuelConsumption();
            System.out.println("\nАвтомобілі після сортування за витратами палива:");
            taxiCompany.displayCars();

            int minSpeed = 200, maxSpeed = 250;
            Car carInSpeedRange = taxiCompany.findCarBySpeedRange(minSpeed, maxSpeed);
            if (carInSpeedRange != null) {
                System.out.println("\nАвтомобіль у діапазоні швидкостей " + minSpeed + "-" + maxSpeed);
                System.out.println(carInSpeedRange);
            } else {
                System.out.println("\nНемає автомобілів у діапазоні швидкостей " + minSpeed + "-" + maxSpeed);
            }
        } catch (Exception e) {
            System.out.println("Сталася помилка: " + (e.getMessage() == null ? e : e.getMessage()));
        }
    }
}
